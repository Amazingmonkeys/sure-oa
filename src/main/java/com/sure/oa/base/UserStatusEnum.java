package com.sure.oa.base;

public enum UserStatusEnum {

    USER_ON(1, "已启用"),
    USER_OFF(0, "已禁用");

    private Integer code;
    private String name;

    private UserStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        UserStatusEnum[] arr = UserStatusEnum.values();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].code.equals(code)) {
                return arr[i].name;
            }
            return null;
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}