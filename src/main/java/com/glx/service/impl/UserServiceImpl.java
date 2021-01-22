package com.glx.service.impl;

import com.glx.entity.User;
import com.glx.exception.CustomCode;
import com.glx.exception.CustomException;
import com.glx.repository.UserRepository;
import com.glx.service.UserService;
import com.glx.util.BcryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User CreateUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(BcryptUtil.encode(password));
        if (userRepository.findByUsername(username) != null){
            throw new CustomException(CustomCode.USER_EXIST);
        }
        return userRepository.save(user);
    }
}
