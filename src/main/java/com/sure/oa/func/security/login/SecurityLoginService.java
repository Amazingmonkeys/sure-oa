package com.sure.oa.func.security.login;

import com.sure.oa.base.CurrUser;

public interface SecurityLoginService {

    CurrUser checkLogin(String u_id, String u_pwd);
}
