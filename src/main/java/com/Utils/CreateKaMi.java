package com.Utils;


import java.util.Random;

public class CreateKaMi {
    static String str="QWERTYUIOPASDFGHJKLZXCVBNM1234567890qwertyuiopasdfghjklzxcvbnm";
    static int len=str.length();
    public static String create(){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<len; ++i){
            //产生0-61的数字
            int number=random.nextInt(len-1);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString().substring(26,36);
    }

    public static void main(String[] args) {
        System.out.println(CreateKaMi.create());
    }


}
