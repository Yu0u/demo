package com.glx.service;

import com.glx.entity.User;

public interface UserService {
    User checkUser(String username, String password);
    User CreateUser(String username,String password);
    User findByUsername(String username);
}
