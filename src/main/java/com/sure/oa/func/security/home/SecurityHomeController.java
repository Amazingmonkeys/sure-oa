package com.sure.oa.func.security.home;

import com.sure.oa.base.Constants;
import com.sure.oa.base.CurrUser;
import com.sure.oa.base.Result;
import com.sure.oa.dto.MenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/security/home")
public class SecurityHomeController {

    @Autowired
    private SecurityHomeService securityHomeService;

    @GetMapping("/menus")
    public List<MenuDto> userMenuList(HttpSession session){
        CurrUser currUser = (CurrUser) session.getAttribute(Constants.SESSION_ATTR_CURRUSER);
        return securityHomeService.getUserMenuList(currUser.getUserId());
    }

    @DeleteMapping("/deleteCurrUser")
    public Result deleteCurrUser(HttpSession session){
        session.removeAttribute(Constants.SESSION_ATTR_CURRUSER);
        return Result.success("您已成功退出系统！");
    }

    @GetMapping("/getCurrUser")
    public CurrUser getCurrUser(HttpSession session){
        return (CurrUser) session.getAttribute(Constants.SESSION_ATTR_CURRUSER);
    }
}
