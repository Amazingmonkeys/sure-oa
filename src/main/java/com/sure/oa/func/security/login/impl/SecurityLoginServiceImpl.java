package com.sure.oa.func.security.login.impl;

import com.sure.oa.base.CurrUser;
import com.sure.oa.exception.BusinessException;
import com.sure.oa.exception.SysException;
import com.sure.oa.func.security.login.SecurityLoginDao;
import com.sure.oa.func.security.login.SecurityLoginService;
import com.sure.oa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityLoginServiceImpl implements SecurityLoginService {

    @Autowired
    private SecurityLoginDao securityLoginDao;

    @Override
    public CurrUser checkLogin(String u_id, String u_pwd) {

        User user = null;
        try {
            user = securityLoginDao.findUserByUserIdAndUserPwd(u_id,u_pwd);
        } catch (Exception e) {
            throw new SysException("系统错误！",e);
        }
        if(user == null){
            throw new BusinessException("用户名或者密码错误！");
        }
        if(!user.getU_status().equals(1)){
            throw new BusinessException("该用户已被禁用！");
        }
        CurrUser currUser = new CurrUser(user.getU_id(), user.getE_name(), user.getE_photo());
        return currUser;
    }
}
