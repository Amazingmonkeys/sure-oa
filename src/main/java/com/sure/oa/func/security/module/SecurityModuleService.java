package com.sure.oa.func.security.module;

import com.sure.oa.dto.MenuDto;
import com.sure.oa.model.User;

import java.util.List;

public interface SecurityModuleService {

    List<User> getUserList();

    void unuseUser(String u_id);

    void useUser(String u_id);

    List<MenuDto> getMenuList();

    List<Integer> getUserMenuList(String u_id);

    void setModule(String u_id, Integer[] moduleIds);
}
