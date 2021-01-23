package com.glx.exception;

import lombok.Getter;

@Getter
public enum CustomCode {
    //成功响应
    SUCCESS(200, "成功"),
    //失败响应
    FAILED(400, "失败"),
    USER_EXIST(403,"用户已存在"),
    USER_NOT_EXIST(403,"用户不存在"),
    NOT_LOGIN(401,"你尚未登录"),
    //参数校验失败响应
    USERNAME_OR_PASSWORD_ERROR(403, "用户名或密码错误");
    private Integer code;
    private String msg;
    CustomCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
