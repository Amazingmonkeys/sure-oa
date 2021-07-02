package com.sure.oa.func.security.home;

import com.sure.oa.model.Module;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SecurityHomeDao {

    List<Module> findUserModuleList(String u_id);
}
