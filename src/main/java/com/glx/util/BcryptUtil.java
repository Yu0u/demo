package com.glx.util;

import cn.hutool.crypto.digest.BCrypt;

public class BcryptUtil {
    public static String encode(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }
    public static boolean match(String password,String encodePassword){
        return BCrypt.checkpw(password,encodePassword);
    }
}
