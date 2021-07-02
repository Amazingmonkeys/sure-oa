package com.sure.oa.func.security.login;


import com.sure.oa.base.Constants;
import com.sure.oa.base.CurrUser;
import com.sure.oa.base.Result;
import com.sure.oa.exception.BusinessException;
import com.sure.oa.exception.SysException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/security/login")
public class SecurityLoginController {

    @Autowired
    private SecurityLoginService securityLoginService;

    //@RequestMapping("")
    @PostMapping("")//只能接收post请求
    public Result login(String u_id, String u_pwd, HttpSession session){//接收以form-data方式传参的post请求和以查询字符串方式传参的GET请求

        try {
            CurrUser currUser = securityLoginService.checkLogin(u_id,u_pwd);
            //登录成功，将当前用户放入session中
            session.setAttribute(Constants.SESSION_ATTR_CURRUSER, currUser);
            return Result.success("登录成功！");
        } catch (BusinessException e) {
            return Result.fail(e.getMessage());
        } catch (SysException e) {
            e.printStackTrace();
            return Result.fail("系统升级中.......");
        }
    }
}
