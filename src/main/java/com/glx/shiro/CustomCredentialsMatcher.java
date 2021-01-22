package com.glx.shiro;


import com.glx.util.BcryptUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String sqlOriginPassword = info.getCredentials().toString();
        return BcryptUtil.match(String.valueOf(usernamePasswordToken.getPassword()),sqlOriginPassword);
    }
}
