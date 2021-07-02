package com.sure.oa.model;

//JavaBean中的属性名称和类型与数据库一致
public class User {
    private String u_id;
    private String u_pwd;
    private Integer u_status;
    private String e_name;
    private String e_photo;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public Integer getU_status() {
        return u_status;
    }

    public void setU_status(Integer u_status) {
        this.u_status = u_status;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_photo() {
        return e_photo;
    }

    public void setE_photo(String e_photo) {
        this.e_photo = e_photo;
    }
}
