package com.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Users {
    private Long id;

    private String userLogin;

    private String userPass;

    private String userNicename;

    private String userEmail;

    private String userUrl;

    private String avatar;

    private String avatarThumb;

    private Short sex;

    private String birthday;

    private String signature;

    private String lastLoginIp;

    private Date lastLoginTime;

    private Date createTime;

    private String userActivationKey;

    private Integer userStatus;

    private Integer score;

    private Short userType;

    private BigDecimal coin;

    private String mobile;

    private String token;

    private Integer expiretime;

    private String weixin;

    private Integer consumption;

    private BigDecimal votes;

    private BigDecimal votestotal;

    private String province;

    private String city;

    private Boolean isrecommend;

    private String openid;

    private String loginType;

    private Boolean iszombie;

    private Boolean isrecord;

    private Boolean iszombiep;

    private Boolean issuper;

    private Boolean ishot;

    private Boolean isauth;

    private Integer bonusDay;

    private Integer bonusTime;

    private Integer freeViewingTime;

    private Integer memberValidity;

    private String invitationCode;

    private Integer familyId;

    private String familyName;

    private String inviter;

    private BigDecimal disVotes;

    private Integer souquanNums;

    private Integer noShare;

    private Integer monthcardNums;

    private Integer isAuth;

    private String agentRatio;

    private Integer dailiId;

    private String dailiQq;

    private String yuekaUrl;

    private String jikaUrl;

    private String niankaUrl;

    private String zhongshenkaUrl;

    private String dailiFree;

    private Integer huiyuanNum;

    public Users(Long id, String userLogin, String userPass, String userNicename, String userEmail, String userUrl, String avatar, String avatarThumb, Short sex, String birthday, String signature, String lastLoginIp, Date lastLoginTime, Date createTime, String userActivationKey, Integer userStatus, Integer score, Short userType, BigDecimal coin, String mobile, String token, Integer expiretime, String weixin, Integer consumption, BigDecimal votes, BigDecimal votestotal, String province, String city, Boolean isrecommend, String openid, String loginType, Boolean iszombie, Boolean isrecord, Boolean iszombiep, Boolean issuper, Boolean ishot, Boolean isauth, Integer bonusDay, Integer bonusTime, Integer freeViewingTime, Integer memberValidity, String invitationCode, Integer familyId, String familyName, String inviter, BigDecimal disVotes, Integer souquanNums, Integer noShare, Integer monthcardNums, Integer isAuth, String agentRatio, Integer dailiId, String dailiQq, String yuekaUrl, String jikaUrl, String niankaUrl, String zhongshenkaUrl, String dailiFree) {
        this.id = id;
        this.userLogin = userLogin;
        this.userPass = userPass;
        this.userNicename = userNicename;
        this.userEmail = userEmail;
        this.userUrl = userUrl;
        this.avatar = avatar;
        this.avatarThumb = avatarThumb;
        this.sex = sex;
        this.birthday = birthday;
        this.signature = signature;
        this.lastLoginIp = lastLoginIp;
        this.lastLoginTime = lastLoginTime;
        this.createTime = createTime;
        this.userActivationKey = userActivationKey;
        this.userStatus = userStatus;
        this.score = score;
        this.userType = userType;
        this.coin = coin;
        this.mobile = mobile;
        this.token = token;
        this.expiretime = expiretime;
        this.weixin = weixin;
        this.consumption = consumption;
        this.votes = votes;
        this.votestotal = votestotal;
        this.province = province;
        this.city = city;
        this.isrecommend = isrecommend;
        this.openid = openid;
        this.loginType = loginType;
        this.iszombie = iszombie;
        this.isrecord = isrecord;
        this.iszombiep = iszombiep;
        this.issuper = issuper;
        this.ishot = ishot;
        this.isauth = isauth;
        this.bonusDay = bonusDay;
        this.bonusTime = bonusTime;
        this.freeViewingTime = freeViewingTime;
        this.memberValidity = memberValidity;
        this.invitationCode = invitationCode;
        this.familyId = familyId;
        this.familyName = familyName;
        this.inviter = inviter;
        this.disVotes = disVotes;
        this.souquanNums = souquanNums;
        this.noShare = noShare;
        this.monthcardNums = monthcardNums;
        this.isAuth = isAuth;
        this.agentRatio = agentRatio;
        this.dailiId = dailiId;
        this.dailiQq = dailiQq;
        this.yuekaUrl = yuekaUrl;
        this.jikaUrl = jikaUrl;
        this.niankaUrl = niankaUrl;
        this.zhongshenkaUrl = zhongshenkaUrl;
        this.dailiFree = dailiFree;
    }

    public Integer getHuiyuanNum() {
        return huiyuanNum;
    }

    public void setHuiyuanNum(Integer huiyuanNum) {
        this.huiyuanNum = huiyuanNum;
    }

    public Users() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin == null ? null : userLogin.trim();
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    public String getUserNicename() {
        return userNicename;
    }

    public void setUserNicename(String userNicename) {
        this.userNicename = userNicename == null ? null : userNicename.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl == null ? null : userUrl.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getAvatarThumb() {
        return avatarThumb;
    }

    public void setAvatarThumb(String avatarThumb) {
        this.avatarThumb = avatarThumb == null ? null : avatarThumb.trim();
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserActivationKey() {
        return userActivationKey;
    }

    public void setUserActivationKey(String userActivationKey) {
        this.userActivationKey = userActivationKey == null ? null : userActivationKey.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Short getUserType() {
        return userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }

    public BigDecimal getCoin() {
        return coin;
    }

    public void setCoin(BigDecimal coin) {
        this.coin = coin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Integer getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Integer expiretime) {
        this.expiretime = expiretime;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    public Integer getConsumption() {
        return consumption;
    }

    public void setConsumption(Integer consumption) {
        this.consumption = consumption;
    }

    public BigDecimal getVotes() {
        return votes;
    }

    public void setVotes(BigDecimal votes) {
        this.votes = votes;
    }

    public BigDecimal getVotestotal() {
        return votestotal;
    }

    public void setVotestotal(BigDecimal votestotal) {
        this.votestotal = votestotal;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Boolean getIsrecommend() {
        return isrecommend;
    }

    public void setIsrecommend(Boolean isrecommend) {
        this.isrecommend = isrecommend;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType == null ? null : loginType.trim();
    }

    public Boolean getIszombie() {
        return iszombie;
    }

    public void setIszombie(Boolean iszombie) {
        this.iszombie = iszombie;
    }

    public Boolean getIsrecord() {
        return isrecord;
    }

    public void setIsrecord(Boolean isrecord) {
        this.isrecord = isrecord;
    }

    public Boolean getIszombiep() {
        return iszombiep;
    }

    public void setIszombiep(Boolean iszombiep) {
        this.iszombiep = iszombiep;
    }

    public Boolean getIssuper() {
        return issuper;
    }

    public void setIssuper(Boolean issuper) {
        this.issuper = issuper;
    }

    public Boolean getIshot() {
        return ishot;
    }

    public void setIshot(Boolean ishot) {
        this.ishot = ishot;
    }

    public Boolean getIsauth() {
        return isauth;
    }

    public void setIsauth(Boolean isauth) {
        this.isauth = isauth;
    }

    public Integer getBonusDay() {
        return bonusDay;
    }

    public void setBonusDay(Integer bonusDay) {
        this.bonusDay = bonusDay;
    }

    public Integer getBonusTime() {
        return bonusTime;
    }

    public void setBonusTime(Integer bonusTime) {
        this.bonusTime = bonusTime;
    }

    public Integer getFreeViewingTime() {
        return freeViewingTime;
    }

    public void setFreeViewingTime(Integer freeViewingTime) {
        this.freeViewingTime = freeViewingTime;
    }

    public Integer getMemberValidity() {
        return memberValidity;
    }

    public void setMemberValidity(Integer memberValidity) {
        this.memberValidity = memberValidity;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName == null ? null : familyName.trim();
    }

    public String getInviter() {
        return inviter;
    }

    public void setInviter(String inviter) {
        this.inviter = inviter == null ? null : inviter.trim();
    }

    public BigDecimal getDisVotes() {
        return disVotes;
    }

    public void setDisVotes(BigDecimal disVotes) {
        this.disVotes = disVotes;
    }

    public Integer getSouquanNums() {
        return souquanNums;
    }

    public void setSouquanNums(Integer souquanNums) {
        this.souquanNums = souquanNums;
    }

    public Integer getNoShare() {
        return noShare;
    }

    public void setNoShare(Integer noShare) {
        this.noShare = noShare;
    }

    public Integer getMonthcardNums() {
        return monthcardNums;
    }

    public void setMonthcardNums(Integer monthcardNums) {
        this.monthcardNums = monthcardNums;
    }

    public Integer getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Integer isAuth) {
        this.isAuth = isAuth;
    }

    public String getAgentRatio() {
        return agentRatio;
    }

    public void setAgentRatio(String agentRatio) {
        this.agentRatio = agentRatio == null ? null : agentRatio.trim();
    }

    public Integer getDailiId() {
        return dailiId;
    }

    public void setDailiId(Integer dailiId) {
        this.dailiId = dailiId;
    }

    public String getDailiQq() {
        return dailiQq;
    }

    public void setDailiQq(String dailiQq) {
        this.dailiQq = dailiQq == null ? null : dailiQq.trim();
    }

    public String getYuekaUrl() {
        return yuekaUrl;
    }

    public void setYuekaUrl(String yuekaUrl) {
        this.yuekaUrl = yuekaUrl == null ? null : yuekaUrl.trim();
    }

    public String getJikaUrl() {
        return jikaUrl;
    }

    public void setJikaUrl(String jikaUrl) {
        this.jikaUrl = jikaUrl == null ? null : jikaUrl.trim();
    }

    public String getNiankaUrl() {
        return niankaUrl;
    }

    public void setNiankaUrl(String niankaUrl) {
        this.niankaUrl = niankaUrl == null ? null : niankaUrl.trim();
    }

    public String getZhongshenkaUrl() {
        return zhongshenkaUrl;
    }

    public void setZhongshenkaUrl(String zhongshenkaUrl) {
        this.zhongshenkaUrl = zhongshenkaUrl == null ? null : zhongshenkaUrl.trim();
    }

    public String getDailiFree() {
        return dailiFree;
    }

    public void setDailiFree(String dailiFree) {
        this.dailiFree = dailiFree == null ? null : dailiFree.trim();
    }
}