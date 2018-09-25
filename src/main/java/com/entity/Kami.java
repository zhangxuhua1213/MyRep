package com.entity;

public class Kami {
    private Integer id;

    private String code;

    private String money;

    private String createtime;

    private Byte status;

    private Byte type;

    private String uptime;

    private Integer touid;

    private Integer cid;

    private Integer month;

    private Integer kid;

    public Kami(Integer id, String code, String money, String createtime, Byte status, Byte type, String uptime, Integer touid, Integer cid, Integer month, Integer kid) {
        this.id = id;
        this.code = code;
        this.money = money;
        this.createtime = createtime;
        this.status = status;
        this.type = type;
        this.uptime = uptime;
        this.touid = touid;
        this.cid = cid;
        this.month = month;
        this.kid = kid;
    }

    public Kami() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime == null ? null : uptime.trim();
    }

    public Integer getTouid() {
        return touid;
    }

    public void setTouid(Integer touid) {
        this.touid = touid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }
}