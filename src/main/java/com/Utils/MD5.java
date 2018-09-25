package com.Utils;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.nio.cs.UnicodeEncoder;

import java.io.UnsupportedEncodingException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }



        /**判断用户密码是否正确
         * @param newpasswd  用户输入的密码
         * @param oldpasswd  数据库中存储的密码－－用户密码的摘要
         * @return
         * @throws NoSuchAlgorithmException
         * @throws UnsupportedEncodingException
         */
    public static boolean Checkpassword(String newpasswd,String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        if(EncoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception{
        final String fixstr="rCt52pF2cnnKNB3Hkp";//固定字符串
        final String result="###";
        System.out.println(result+MD5.EncoderByMd5(MD5.EncoderByMd5(fixstr+"222")));
    }
}