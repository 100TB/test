package com.example.com.example.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by Kang.Zheng on 2017/11/27.
 */
public class Md5 {

    public static String MD5(String  str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1,md.digest()).toString(16);
        }catch(Exception e){
            throw new RuntimeException(e);
        }


    }
}
