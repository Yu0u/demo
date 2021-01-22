package com.glx.exception;

import com.glx.entity.Response;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Response methodArgumentNotValidException(MethodArgumentNotValidException e){
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return Response.error().message(objectError.getDefaultMessage());
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Response customException(CustomException e){
        return Response.error().code(e.getCode()).message(e.getMessage());
    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Response constraintViolationException(ConstraintViolationException e){
        Iterator<ConstraintViolation<?>> iterator = e.getConstraintViolations().iterator();
        String message = iterator.next().getMessage();
        return Response.error().message(message);
    }

    @ExceptionHandler(UnknownAccountException.class)
    @ResponseBody
    public Response unknownAccountException(UnknownAccountException e){
        return Response.error().message(CustomCode.USER_NOT_EXIST.getMsg()).code(CustomCode.USER_NOT_EXIST.getCode());
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public Response authenticationException(){
        return Response.error().
                code(CustomCode.USERNAME_OR_PASSWORD_ERROR.getCode())
                .message(CustomCode.USERNAME_OR_PASSWORD_ERROR.getMsg());
    }
}
