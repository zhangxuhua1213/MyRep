package com.result;

public class ActiveRecord {
    //SELECT a.id,a.type,CONCAT(b.user_nicename,'(',b.id,')') as user_id,a.kami,a.addtime,b.user_nicename FROM cmf_users_coinrecord a ,cmf_users b
    //where a.daili_id=b.id and b.id=670968;
    private Integer id;
    private String type="兑换卡密";//收支行为
    private String user_id;
    private String kami;
    private Integer addtime;
    private String user_nicename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKami() {
        return kami;
    }

    public void setKami(String kami) {
        this.kami = kami;
    }


    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_nicename() {
        return user_nicename;
    }

    public void setUser_nicename(String user_nicename) {
        this.user_nicename = user_nicename;
    }
}
