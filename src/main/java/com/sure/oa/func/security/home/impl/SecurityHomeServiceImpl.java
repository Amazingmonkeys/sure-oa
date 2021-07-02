package com.sure.oa.func.security.home.impl;


import com.sure.oa.dto.MenuDto;
import com.sure.oa.func.security.home.SecurityHomeDao;
import com.sure.oa.func.security.home.SecurityHomeService;
import com.sure.oa.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityHomeServiceImpl implements SecurityHomeService {

    @Autowired
    private SecurityHomeDao securityHomeDao;

    //将查询到的菜单数据封装为树状结构
    @Override
    public List<MenuDto> getUserMenuList(String userId) {

        List<MenuDto> menuList = new ArrayList<>();
        List<Module> list = securityHomeDao.findUserModuleList(userId);
        MenuDto currMenu = null;//当前主菜单
        for(Module module : list){
            if(currMenu == null || !module.getP_id().equals(currMenu.getMenuId())){
                currMenu = new MenuDto();
                menuList.add(currMenu);
                currMenu.setMenuId(module.getP_id());
                currMenu.setMenuName(module.getP_name());
                currMenu.setSubMenus(new ArrayList<>());
            }
            MenuDto subMenu = new MenuDto();
            subMenu.setMenuId(module.getM_id());
            subMenu.setMenuName(module.getM_name());
            subMenu.setMenuUrl(module.getM_url());
            currMenu.getSubMenus().add(subMenu);
        }
        return menuList;
    }
}
