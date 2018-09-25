package com.entity;

public class KamiCat {
    private Integer id;

    private String name;

    private Integer score;

    private Integer addtime;

    private Integer month;

    public KamiCat(Integer id, String name, Integer score, Integer addtime, Integer month) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.addtime = addtime;
        this.month = month;
    }

    public KamiCat() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}