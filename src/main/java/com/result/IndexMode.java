package com.result;

public class IndexMode {
    private Integer totalRegister;
    private Integer todayRegisterNums;//注册
    private Integer todayChargNums;//充值
    private Integer yestodayRegisterNums;
    private Integer yestodayChargNums;
    private Integer weekRegisterNums;
    private Integer monthRegisterNums;
    public IndexMode(){}
    public IndexMode(Integer totalRegister, Integer todayRegisterNums, Integer todayChargNums, Integer yestodayRegisterNums, Integer yestodayChargNums, Integer weekRegisterNums, Integer monthRegisterNums) {
        this.totalRegister = totalRegister;
        this.todayRegisterNums = todayRegisterNums;
        this.todayChargNums = todayChargNums;
        this.yestodayRegisterNums = yestodayRegisterNums;
        this.yestodayChargNums = yestodayChargNums;
        this.weekRegisterNums = weekRegisterNums;
        this.monthRegisterNums = monthRegisterNums;
    }

    public Integer getTotalRegister() {
        return totalRegister;
    }

    public void setTotalRegister(Integer totalRegister) {
        this.totalRegister = totalRegister;
    }

    public Integer getTodayRegisterNums() {
        return todayRegisterNums;
    }

    public void setTodayRegisterNums(Integer todayRegisterNums) {
        this.todayRegisterNums = todayRegisterNums;
    }

    public Integer getTodayChargNums() {
        return todayChargNums;
    }

    public void setTodayChargNums(Integer todayChargNums) {
        this.todayChargNums = todayChargNums;
    }

    public Integer getYestodayRegisterNums() {
        return yestodayRegisterNums;
    }

    public void setYestodayRegisterNums(Integer yestodayRegisterNums) {
        this.yestodayRegisterNums = yestodayRegisterNums;
    }

    public Integer getYestodayChargNums() {
        return yestodayChargNums;
    }

    public void setYestodayChargNums(Integer yestodayChargNums) {
        this.yestodayChargNums = yestodayChargNums;
    }

    public Integer getWeekRegisterNums() {
        return weekRegisterNums;
    }

    public void setWeekRegisterNums(Integer weekRegisterNums) {
        this.weekRegisterNums = weekRegisterNums;
    }

    public Integer getMonthRegisterNums() {
        return monthRegisterNums;
    }

    public void setMonthRegisterNums(Integer monthRegisterNums) {
        this.monthRegisterNums = monthRegisterNums;
    }
}
