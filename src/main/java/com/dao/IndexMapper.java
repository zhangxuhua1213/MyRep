package com.dao;


public interface IndexMapper {
    Integer getTotalRegister(Long id);//总注册数
    Integer getTodayRegisterNums(Long id);//今天注册数
    Integer getTodayChargNums(Long id);//今天充值数
    Integer getYestodayRegisterNums(Long id);//昨天注册数
    Integer getYestodayChargNums(Long id);//昨天充值数
    Integer getWeekRegisterNums(Long id);//本周注册数
    Integer getMonthRegisterNums(Long id);//本月注册数
}
