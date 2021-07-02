package com.sure.oa.func.security.module.impl;

import com.sure.oa.base.UserStatusEnum;
import com.sure.oa.dto.MenuDto;
import com.sure.oa.func.security.module.SecurityModuleDao;
import com.sure.oa.func.security.module.SecurityModuleService;
import com.sure.oa.model.Module;
import com.sure.oa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class) //声明本对象的队友方法都是事务性的，rollbackFor回滚规则，遇到异常则回滚
public class SecurityModuleServiceImpl implements SecurityModuleService {

    @Autowired
    private SecurityModuleDao securityModuleDao;

    @Override
    public List<User> getUserList() {
        return securityModuleDao.findUserList();
    }

    @Override
    public void unuseUser(String u_id) {
        securityModuleDao.changeStatus(u_id, UserStatusEnum.USER_ON.getCode(), UserStatusEnum.USER_OFF.getCode());
    }

    @Override
    public void useUser(String u_id) {
        securityModuleDao.changeStatus(u_id, UserStatusEnum.USER_OFF.getCode(), UserStatusEnum.USER_ON.getCode());
    }

    @Override
    public List<MenuDto> getMenuList() {
        List<MenuDto> menuList = new ArrayList<>();
        List<Module> list = securityModuleDao.findModuleList();
        MenuDto currMenu = null;//当前主菜单
        for (Module module : list) {
            if (currMenu == null || !module.getP_id().equals(currMenu.getMenuId())) {
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

    @Override
    public List<Integer> getUserMenuList(String u_id) {
        return securityModuleDao.findUserModuleIdList(u_id);
    }

    @Override
    public void setModule(String u_id, Integer[] moduleIds) {
        //删除指定用户的所有权限
        securityModuleDao.deleteUserModules(u_id);
        if (moduleIds == null || moduleIds.length == 0) {
            return;
        } else {
            //给指定用户增加权限
            securityModuleDao.insertUserModules(u_id, moduleIds);
        }
    }
}
