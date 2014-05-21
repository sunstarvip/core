package com.darknight.core.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by DarKnight on 14-1-31.
 */
public class PasswordUtil {
    //获得通过MD5加密处理的密码
    public static String getPasswordByMD5(String pwd) {
        // 确定计算方法
        MessageDigest md5Handler = null;
        try {
            md5Handler = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BASE64Encoder base64en = new BASE64Encoder();
        // 加密后的字符串
        String newstr = null;
        try {
            newstr = base64en.encode(md5Handler.digest(pwd.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newstr;
    }
}
