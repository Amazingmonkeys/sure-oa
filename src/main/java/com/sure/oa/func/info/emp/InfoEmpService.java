package com.sure.oa.func.info.emp;

import com.sure.oa.dto.EmpDto;
import com.sure.oa.model.Dep;
import com.sure.oa.model.Emp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface InfoEmpService {

    List<Dep> getDepList();

    List<Emp> getEmpList(EmpDto empDto);

    Map<String, Object> getEmpPageList(EmpDto empDto);

    void addEmp(EmpDto empDto);

    void updateEmp(EmpDto empDto);

    void deleteEmp(String e_id);

    void deleteEmpMulti(String[] e_ids);

    void savePhoto(String e_id, String originalFileName, InputStream inputStream);

    void outPhoto(OutputStream outputStream, String e_id);
}
