package com.glx.controller;

import com.glx.entity.Response;
import com.glx.entity.User;
import com.glx.exception.CustomCode;
import com.glx.service.UserService;
import com.glx.util.BcryptUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Response login(@RequestParam String username,
                          @RequestParam String password){
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            return Response.ok().message("登陆成功");
        }else {
            return Response.ok().message("你已登录，请勿重复登陆");
        }
    }
    @GetMapping("/logout")
    public Response logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            subject.logout();
            return Response.ok().message("注销成功");
        }else{
            return Response.error()
                    .message(CustomCode.NOT_LOGIN.getMsg())
                    .code(CustomCode.NOT_LOGIN.getCode());
        }

    }
    @PostMapping("/register")
    public Response register(@RequestParam String username, @RequestParam String password){
        userService.CreateUser(username,password);
        return Response.ok().message("注册成功");
    }
}
