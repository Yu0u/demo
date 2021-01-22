package com.glx.entity;

import com.glx.exception.CustomCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private boolean success;
    private Integer code;
    private String message;
    private Object data;
    private Response(){

    }

    public static Response ok(){
        Response response = new Response();
        response.setSuccess(true);
        response.setCode(CustomCode.SUCCESS.getCode());
        response.setMessage(CustomCode.SUCCESS.getMsg());
        return response;
    }

    public static Response error(){
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(CustomCode.FAILED.getCode());
        response.setMessage(CustomCode.FAILED.getMsg());
        return response;
    }

    public Response success(boolean flag){
        this.setSuccess(flag);
        return this;
    }

    public Response code(Integer code){
        this.setCode(code);
        return this;
    }

    public Response message(String message){
        this.setMessage(message);
        return this;
    }

    public Response data(Object data){
        this.setData(data);
        return this;
    }

}
