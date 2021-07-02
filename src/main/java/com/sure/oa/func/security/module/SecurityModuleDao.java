package com.sure.oa.func.security.module;

import com.sure.oa.model.Module;
import com.sure.oa.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SecurityModuleDao {

    @Select("select u_id, u_status from t_user")
    List<User> findUserList();

    @Update("update t_user set u_status = #{to} where u_id = #{u_id} and u_status = #{from}")
    void changeStatus(@Param("u_id") String u_id, @Param("from") int from, @Param("to") int to);

    List<Module> findModuleList();

    @Select("select m_id from t_um where u_id = #{u_id}")
    List<Integer> findUserModuleIdList(String u_id);

    @Delete("delete from t_um where u_id = #{u_id}")
    void deleteUserModules(String u_id);

    void insertUserModules(@Param("u_id") String u_id, @Param("moduleIds") Integer[] moduleIds);
}
