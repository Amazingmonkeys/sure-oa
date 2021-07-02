package com.sure.oa.func.info.emp;

import com.sure.oa.base.Result;
import com.sure.oa.dto.EmpDto;
import com.sure.oa.model.Dep;
import com.sure.oa.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("info/emp")
public class InfoEmpController {

    @Autowired
    private InfoEmpService infoEmpService;

    @GetMapping("/dep")
    public List<Dep> depList(){
        return infoEmpService.getDepList();
    }

    /*@GetMapping("")
    public List<Emp> empList(EmpDto empDto){ //这里页面提交的参数被自动封装到EmpDto对象中，参数名与属性名一致
        return infoEmpService.getEmpList(empDto);
    }*/

    @GetMapping("")
    public Map<String, Object> empList(EmpDto empDto){ //这里页面提交的参数被自动封装到EmpDto对象中，参数名与属性名一致
        return infoEmpService.getEmpPageList(empDto);
    }

    @PostMapping("")
    //@RequestBody用于接收payload格式的数据（JSON）
    public Result empAdd(@RequestBody EmpDto empDto){
        infoEmpService.addEmp(empDto);
        return Result.success("新增员工成功！工号为：" + empDto.getE_id());
    }

    @PutMapping("")
    //@RequestBody用于接收payload格式的数据（JSON）
    public Result empEdit(@RequestBody EmpDto empDto){
        infoEmpService.updateEmp(empDto);
        return Result.success("修改员工成功！");
    }

    @DeleteMapping("/{e_id}")
    public Result empDelete(@PathVariable String e_id){
        infoEmpService.deleteEmp(e_id);
        return Result.success("删除员工成功！");
    }

    @DeleteMapping("")
    public Result empDeleteMulti(@RequestBody String[] e_ids){
        infoEmpService.deleteEmpMulti(e_ids);
        return Result.success("删除员工成功！");
    }

    @PostMapping("/photo")
    @ResponseBody
    //MultipartFile是Spring中的文件数据类型
    public Result uploadPhoto(@RequestParam("e_id") String e_id, @RequestParam("file") MultipartFile file){
        try {
            System.out.println("controller1");
            //得到一个读取上传数据的输入流
            InputStream inputStream = file.getInputStream();
            //获取上传文件的原始名称
            String originalFileName = file.getOriginalFilename();
            //获取文件类型（如：image/jpg, image/jpeg等）
            //String contentType = file.getContentType();
            //System.out.println("controller2");
            infoEmpService.savePhoto(e_id, originalFileName, inputStream);
            return Result.success("上传成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("上传失败！");
        }
    }

    @GetMapping("/photo")
    //OutputStream表示服务器向浏览器输出数据的输出流，由服务器自动给定
    public void getPhoto(OutputStream outputStream, String e_id){
        infoEmpService.outPhoto(outputStream, e_id);
    }
}
