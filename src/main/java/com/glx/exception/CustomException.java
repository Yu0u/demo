package com.glx.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomException extends RuntimeException{
    private Integer code;
    private String message;

    public CustomException(CustomCode c){
        this.code = c.getCode();
        this.message = c.getMsg();
    }


}
