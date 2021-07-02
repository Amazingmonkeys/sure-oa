package com.sure.oa.base;

public enum EmpStatusEnum {

    EMP_ON(1, "在职"),
    EMP_UN(0, "未确定"),
    EMP_OFF(2, "已离职");

    private Integer code;
    private String name;

    EmpStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static String getName(Integer code) {
        EmpStatusEnum[] arr = EmpStatusEnum.values();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].code.equals(code)) {
                return arr[i].name;
            }
        }
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }
}