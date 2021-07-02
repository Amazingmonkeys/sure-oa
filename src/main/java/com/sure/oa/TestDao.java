package com.sure.oa;

import com.sure.oa.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //说明这是个映射器组件（MyBatis中将DAO组件称为映射器），并受Spring管理
public interface TestDao {

    @Select("select * from t_user") //这个注解和SQL语句可以自动使下面的方法实现访问数据库
    public List<User> findUserList();
}
