package com.sure.oa.func.security.home;

import com.sure.oa.dto.MenuDto;

import java.util.List;

public interface SecurityHomeService {

    List<MenuDto> getUserMenuList(String userId);
}
