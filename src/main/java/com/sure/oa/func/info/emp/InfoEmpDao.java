package com.sure.oa.func.info.emp;

import com.sure.oa.dto.EmpDto;
import com.sure.oa.model.Dep;
import com.sure.oa.model.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InfoEmpDao {

    @Select("select * from t_dep")
    List<Dep> findDepList();

    List<Emp> findEmpList(EmpDto empDto);

    @Select("select ifnull(convert(substring(max(e_id), 2), unsigned), 0) from t_emp where e_id like 'E%'")
    int findMaxNumOfEmpId();

    @Insert("insert into t_emp(e_id, e_name, e_sex, e_birth, e_salary, d_id, e_remark, e_status) values(#{e_id}, #{e_name}, #{e_sex}, #{e_birth}, #{e_salary}, #{d_id}, #{e_remark}, #{e_status})")
    void insertNewEmp(EmpDto empDto);

    @Update("update t_emp set e_name = #{e_name}, e_sex = #{e_sex}, e_birth = #{e_birth}, e_salary = #{e_salary}, d_id = #{d_id}, e_remark = #{e_remark} where e_id = #{e_id} and e_status = #{e_status}")
    void updateEmpById(EmpDto empDto);

    @Delete("delete from t_emp where e_id = #{e_id} and e_status = #{e_status}")
    void deleteEmpById(@Param("e_id") String e_id, @Param("e_status") Integer e_status);

    void deleteEmpIds(@Param("e_ids") String[] e_ids, @Param("code") Integer code);

    @Update("update t_emp set e_photo = #{fileName} where e_id = #{e_id}")
    void updateEmpPhotoById(@Param("e_id") String e_id, @Param("fileName") String fileName);

    @Select("select e_photo from t_emp where e_id = #{e_id}")
    String findEmpPhotoById(String e_id);
}
