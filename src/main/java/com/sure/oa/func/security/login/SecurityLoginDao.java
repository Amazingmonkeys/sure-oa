package com.sure.oa.func.security.login;

import com.sure.oa.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SecurityLoginDao {

    @Select("select u.*, e.e_name, e.e_photo from t_user u join t_emp e on u.u_id = e.e_id where u_id = #{uid} and u_pwd = #{upwd}")
    User findUserByUserIdAndUserPwd(@Param("uid") String u_id, @Param("upwd")String u_pwd);
}
