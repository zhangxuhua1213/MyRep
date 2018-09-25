package com.entity;

public class Kamilist {
    private Integer id;

    private Integer nums;

    private Integer uid;

    private Integer addtime;

    public Kamilist(Integer id, Integer nums, Integer uid, Integer addtime) {
        this.id = id;
        this.nums = nums;
        this.uid = uid;
        this.addtime = addtime;
    }

    public Kamilist() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }
}