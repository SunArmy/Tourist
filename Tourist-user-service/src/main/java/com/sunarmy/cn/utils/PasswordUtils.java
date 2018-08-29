package com.sunarmy.cn.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by wb-wsj429645 on 2018/8/27.
 */
public class PasswordUtils {
    /**
     *生成6位salt值
     */
    public static String getSalt(){
        return new SecureRandomNumberGenerator().nextBytes(6).toHex();
    }

    /**
     * 加盐MD5加密生成密码
     * @param salt
     * @param password
     * @return
     */
    public static String encryPassword(String password,String salt){
        String md5 = new SimpleHash("MD5", password, salt, 0).toString();
        String s = new Md5Hash(password, salt).toString();
        System.out.println(md5+"================="+s);
        return new Md5Hash(password,salt).toString();
    }

    public static void main(String[] args) {
        //根据salt和密码生成加密密码
        System.out.println(encryPassword("wang7","123456"));
    }
}
