package com.sure.oa.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sure.oa.base.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EmpDto extends PageParam {

    private String e_id;
    private String e_name;
    private String e_sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date e_birth;
    private Integer d_id;
    private String d_name;
    private Double e_salary;
    private Integer e_status;
    private String e_remark;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date e_birth_start;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date e_birth_end;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Double e_sal_start;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Double e_sal_end;

    public Date getE_birth_start() {
        return e_birth_start;
    }

    public void setE_birth_start(Date e_birth_start) {
        this.e_birth_start = e_birth_start;
    }

    public Date getE_birth_end() {
        return e_birth_end;
    }

    public void setE_birth_end(Date e_birth_end) {
        this.e_birth_end = e_birth_end;
    }

    public Double getE_sal_start() {
        return e_sal_start;
    }

    public void setE_sal_start(Double e_sal_start) {
        this.e_sal_start = e_sal_start;
    }

    public Double getE_sal_end() {
        return e_sal_end;
    }

    public void setE_sal_end(Double e_sal_end) {
        this.e_sal_end = e_sal_end;
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

    public String getE_remark() {
        return e_remark;
    }

    public void setE_remark(String e_remark) {
        this.e_remark = e_remark;
    }

    @Override
    public String toString() {
        //将对象变为JSON
        try {
            String jsonStr = new ObjectMapper().writeValueAsString(this);
            return jsonStr;
        } catch (Exception e) {
            return "EmpDto{" +
                    "e_id='" + e_id + '\'' +
                    ", e_name='" + e_name + '\'' +
                    ", e_sex='" + e_sex + '\'' +
                    ", e_birth=" + e_birth +
                    ", d_id=" + d_id +
                    ", d_name='" + d_name + '\'' +
                    ", e_salary=" + e_salary +
                    ", e_status=" + e_status +
                    ", e_remark='" + e_remark + '\'' +
                    ", e_birth_start=" + e_birth_start +
                    ", e_birth_end=" + e_birth_end +
                    ", e_sal_start=" + e_sal_start +
                    ", e_sal_end=" + e_sal_end +
                    '}';
        }
    }
}
