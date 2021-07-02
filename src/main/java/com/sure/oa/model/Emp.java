package com.sure.oa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sure.oa.base.EmpStatusEnum;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {

    private String e_id;
    private String e_name;
    private String e_sex;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date e_birth;
    private Integer d_id;
    private String d_name;
    private Double e_salary;
    private Integer e_status;
    private String e_remark;
    private String e_photo;

    public String getE_photo() {
        return e_photo;
    }

    public void setE_photo(String e_photo) {
        this.e_photo = e_photo;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_sex() {
        return e_sex;
    }

    public void setE_sex(String e_sex) {
        this.e_sex = e_sex;
    }

    public Date getE_birth() {
        return e_birth;
    }

    public void setE_birth(Date e_birth) {
        this.e_birth = e_birth;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public Double getE_salary() {
        return e_salary;
    }

    public void setE_salary(Double e_salary) {
        this.e_salary = e_salary;
    }

    public Integer getE_status() {
        return e_status;
    }

    public void setE_status(Integer e_status) {
        this.e_status = e_status;
    }

    public String getE_status_name(){
        return EmpStatusEnum.getName(this.e_status);
    }

    public String getE_remark() {
        return e_remark;
    }

    public void setE_remark(String e_remark) {
        this.e_remark = e_remark;
    }
}
