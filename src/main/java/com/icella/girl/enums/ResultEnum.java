package com.icella.girl.enums;

public enum ResultEnum {
    UNKONW_ERROR(-1, "Unknow error"),
    SUCCESS(0, "Sucess"),
    SO_LITTLE(100, "So little"),
    AlSO_LITTLE(101, "Also little");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
