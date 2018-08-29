package com.sunarmy.cn.datatype;

/**
 * Created by wb-wsj429645 on 2018/8/27.
 */
public enum ResponseType {
    SUCCESS(1,"成功"),
    FAIL(-1,"失败"),
    USER_PASSWORD_INCORRECT(1108, "用户名密码不正确"),
    VERIFICATION_CODE_ERROR(1002, "验证码错误");
    private int code;
    private String msg;


    ResponseType(int i, String msg) {
        this.code=i;
        this.msg=msg;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
