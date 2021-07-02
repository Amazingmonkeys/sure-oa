package com.sure.oa.func.info.emp.impl;

import com.sure.oa.base.Constants;
import com.sure.oa.base.EmpStatusEnum;
import com.sure.oa.base.QueryAction;
import com.sure.oa.dto.EmpDto;
import com.sure.oa.exception.SysException;
import com.sure.oa.func.info.emp.InfoEmpDao;
import com.sure.oa.func.info.emp.InfoEmpService;
import com.sure.oa.model.Dep;
import com.sure.oa.model.Emp;
import com.sure.oa.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class InfoEmpServiceImpl implements InfoEmpService {

    //工号中去掉字符E和左侧多余的0后形成的当前数字最大值，该值在项目初始化时从数据库中获取，以后以自增方式获取新值
    private int empIdNum;

    @PostConstruct //表示该方法在初始化时执行且只执行一次（由Spring控制）
    public void init() {
        empIdNum = infoEmpDao.findMaxNumOfEmpId();
    }

    private String getNewEmpId() {
        return String.format("E%04d", ++empIdNum);
    }

    @Autowired
    private InfoEmpDao infoEmpDao;

    @Override
    public List<Dep> getDepList() {
        return infoEmpDao.findDepList();
    }

    @Override
    public List<Emp> getEmpList(EmpDto empDto) {
        return infoEmpDao.findEmpList(empDto);
    }

    @Override
    public Map<String, Object> getEmpPageList(EmpDto empDto) {
        //创建接口的匿名实现类对象
        QueryAction<Emp> queryAction = new QueryAction() {
            @Override
            public List query() {
                return infoEmpDao.findEmpList(empDto);
            }
        };
        return Utils.getPage(empDto, new InfoEmpQueryActionImpl(infoEmpDao, empDto));
        //return Utils.getPage(empDto, () -> infoEmpDao.findEmpList(empDto));
    }

    @Override
    public void addEmp(EmpDto empDto) {
        empDto.setE_id(this.getNewEmpId());
        empDto.setE_status(EmpStatusEnum.EMP_UN.getCode());
        infoEmpDao.insertNewEmp(empDto);
    }

    @Override
    public void updateEmp(EmpDto empDto) {
        empDto.setE_status(EmpStatusEnum.EMP_UN.getCode());
        infoEmpDao.updateEmpById(empDto);
    }

    @Override
    public void deleteEmp(String e_id) {
        infoEmpDao.deleteEmpById(e_id, EmpStatusEnum.EMP_UN.getCode());
    }

    @Override
    public void deleteEmpMulti(String[] e_ids) {
        infoEmpDao.deleteEmpIds(e_ids, EmpStatusEnum.EMP_UN.getCode());
    }

    //获取当前时间毫秒数作为文件名称
    private static long fileNameNum = System.currentTimeMillis();

    //获取一个新的文件名数字 synchronized：线程同步
    private static synchronized long getNewFileNameNum() {
        return fileNameNum++;
    }

    @Override
    public void savePhoto(String e_id, String originalFileName, InputStream inputStream) {
        OutputStream outputStream = null;
        try {
            System.out.println("service1");
            /**
             * 1. 自动获取文件名称
             */
            String fileName = null;
            //对于原始名称从后向前搜索第一个字符“.”的位置
            int idx = originalFileName.lastIndexOf(".");
            if (idx < 0) {
                fileName = getNewEmpId();
            } else {
                String fileType = originalFileName.substring(idx + 1);
                fileName = getNewEmpId() + "." + fileType;
            }
            System.out.println("service2");
            /**
             * 2. 保存文件数据
             */
            //如果路径不存在则创建文件夹，如果父目录不存在也会自动创建
            File dir = new File(Constants.DIR_PHOTO);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //构造新的文件位置 File：文件位置（路径）
            File photoFilePath = new File(Constants.DIR_PHOTO, fileName);
            //构造输出流，用于将文件数据写出至文件中
            outputStream = new FileOutputStream(photoFilePath);
            //使用输入流读数据，同时使用输出流写数据
            byte[] b = new byte[1024 * 1024]; //定义1M的缓冲区
            int len = -1; //每次通过输入流读取并放入缓冲区的字节数
            while ((len = inputStream.read(b)) != -1) { //read方法返回-1表示文件已读取完毕
                outputStream.write(b, 0, len);
            }
            outputStream.flush(); //清空输出流
            System.out.println("service3");
            /**
             * 3. 将文件名称存储在数据库中
             */
            infoEmpDao.updateEmpPhotoById(e_id, fileName);
        } catch (IOException e) {
            throw new SysException(e);
        } finally {
            try {
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void outPhoto(OutputStream outputStream, String e_id) {
        InputStream inputStream = null;
        try {
            /**
             * 1. 根据工号从数据库中查询图片名称
             */
            String photoName = infoEmpDao.findEmpPhotoById(e_id);
            /**
             * 2. 构建读取图片的输入流
             */
            File photoFile = new File(Constants.DIR_PHOTO, photoName);
            inputStream = new FileInputStream(photoFile);
            /**
             * 3. 图片的输出
             */
            //使用输出流写数据
            byte[] b = new byte[1024 * 1024]; //定义1M的缓冲区
            int len = -1; //每次通过输入流读取并放入缓冲区的字节数
            while ((len = inputStream.read(b)) != -1) { //read方法返回-1表示文件已读取完毕
                outputStream.write(b, 0, len);
            }
            outputStream.flush(); //清空输出流
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
