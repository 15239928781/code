package com.irs.pojo;

import java.io.Serializable;

/**
 * users
 * @author 
 */
public class Users implements Serializable {


    private Integer uId;

    /**
     * 电话
     */
    private String uTel;

    /**
     * 登录密码
     */
    private String uPassword;

    /**
     * 用户昵称
     */
    private String uName;

    /**
     * 性别1男生0女生2保密
     */
    private String uSex;

    /**
     * 生日
     */
    private String uBirthday;

    /**
     * 用户头像
     */
    private String uImg;

    /**
     * 是否认证
     */
    private Integer uStatus;

    /**
     * 个人简介
     */
    private String uIntroduction;

    /**
     * 积分
     */
    private String r1;

    private Integer uIntegral;

    /**
     * 会员等级
     */
    private Integer uLevel;

    private String levelName;
    private Integer leId;
    private Long sbId;

    private String sbName;

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }

    public Long getSbId() {
        return sbId;
    }

    public void setSbId(Long sbId) {
        this.sbId = sbId;
    }

    public Integer getLeId() {
        return leId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setLeId(Integer leId) {
        this.leId = leId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    /**
     * 微信code
     */
    private String uWxcode;

    /**
     * 我的邀请码
     */
    private String uMyinvitecode;

    /**
     * 真实姓名
     */
    private String uRealname;

    /**
     * 年龄
     */
    private String uLable;

    /**
     * 邀请人邀请码
     */
    private String uInvitecode;

    /**
     * 注册时间
     */
    private String uCreatetime;

    private Integer moth;

    private String sumuser;

    private Integer isBill;

    public Integer getIsBill() {
        return isBill;
    }

    public void setIsBill(Integer isBill) {
        this.isBill = isBill;
    }

    public Integer getMoth() {
        return moth;
    }

    public void setMoth(Integer moth) {
        this.moth = moth;
    }

    public String getSumuser() {
        return sumuser;
    }

    public void setSumuser(String sumuser) {
        this.sumuser = sumuser;
    }

    private static final long serialVersionUID = 1L;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuTel() {
        return uTel;
    }

    public void setuTel(String uTel) {
        this.uTel = uTel;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuBirthday() {
        return uBirthday;
    }

    public void setuBirthday(String uBirthday) {
        this.uBirthday = uBirthday;
    }

    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg;
    }

    public Integer getuStatus() {
        return uStatus;
    }

    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }

    public String getuIntroduction() {
        return uIntroduction;
    }

    public void setuIntroduction(String uIntroduction) {
        this.uIntroduction = uIntroduction;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public Integer getuIntegral() {
        return uIntegral;
    }

    public void setuIntegral(Integer uIntegral) {
        this.uIntegral = uIntegral;
    }

    public Integer getuLevel() {
        return uLevel;
    }

    public void setuLevel(Integer uLevel) {
        this.uLevel = uLevel;
    }

    public String getuWxcode() {
        return uWxcode;
    }

    public void setuWxcode(String uWxcode) {
        this.uWxcode = uWxcode;
    }

    public String getuMyinvitecode() {
        return uMyinvitecode;
    }

    public void setuMyinvitecode(String uMyinvitecode) {
        this.uMyinvitecode = uMyinvitecode;
    }

    public String getuRealname() {
        return uRealname;
    }

    public void setuRealname(String uRealname) {
        this.uRealname = uRealname;
    }

    public String getuLable() {
        return uLable;
    }

    public void setuLable(String uLable) {
        this.uLable = uLable;
    }

    public String getuInvitecode() {
        return uInvitecode;
    }

    public void setuInvitecode(String uInvitecode) {
        this.uInvitecode = uInvitecode;
    }

    public String getuCreatetime() {
        return uCreatetime;
    }

    public void setuCreatetime(String uCreatetime) {
        this.uCreatetime = uCreatetime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Users other = (Users) that;
        return (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getuTel() == null ? other.getuTel() == null : this.getuTel().equals(other.getuTel()))
            && (this.getuPassword() == null ? other.getuPassword() == null : this.getuPassword().equals(other.getuPassword()))
            && (this.getuName() == null ? other.getuName() == null : this.getuName().equals(other.getuName()))
            && (this.getuSex() == null ? other.getuSex() == null : this.getuSex().equals(other.getuSex()))
            && (this.getuBirthday() == null ? other.getuBirthday() == null : this.getuBirthday().equals(other.getuBirthday()))
            && (this.getuImg() == null ? other.getuImg() == null : this.getuImg().equals(other.getuImg()))
            && (this.getuStatus() == null ? other.getuStatus() == null : this.getuStatus().equals(other.getuStatus()))
            && (this.getuIntroduction() == null ? other.getuIntroduction() == null : this.getuIntroduction().equals(other.getuIntroduction()))
            && (this.getR1() == null ? other.getR1() == null : this.getR1().equals(other.getR1()))
            && (this.getuIntegral() == null ? other.getuIntegral() == null : this.getuIntegral().equals(other.getuIntegral()))
            && (this.getuLevel() == null ? other.getuLevel() == null : this.getuLevel().equals(other.getuLevel()))
            && (this.getuWxcode() == null ? other.getuWxcode() == null : this.getuWxcode().equals(other.getuWxcode()))
            && (this.getuMyinvitecode() == null ? other.getuMyinvitecode() == null : this.getuMyinvitecode().equals(other.getuMyinvitecode()))
            && (this.getuRealname() == null ? other.getuRealname() == null : this.getuRealname().equals(other.getuRealname()))
            && (this.getuLable() == null ? other.getuLable() == null : this.getuLable().equals(other.getuLable()))
            && (this.getuInvitecode() == null ? other.getuInvitecode() == null : this.getuInvitecode().equals(other.getuInvitecode()))
            && (this.getuCreatetime() == null ? other.getuCreatetime() == null : this.getuCreatetime().equals(other.getuCreatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getuTel() == null) ? 0 : getuTel().hashCode());
        result = prime * result + ((getuPassword() == null) ? 0 : getuPassword().hashCode());
        result = prime * result + ((getuName() == null) ? 0 : getuName().hashCode());
        result = prime * result + ((getuSex() == null) ? 0 : getuSex().hashCode());
        result = prime * result + ((getuBirthday() == null) ? 0 : getuBirthday().hashCode());
        result = prime * result + ((getuImg() == null) ? 0 : getuImg().hashCode());
        result = prime * result + ((getuStatus() == null) ? 0 : getuStatus().hashCode());
        result = prime * result + ((getuIntroduction() == null) ? 0 : getuIntroduction().hashCode());
        result = prime * result + ((getR1() == null) ? 0 : getR1().hashCode());
        result = prime * result + ((getuIntegral() == null) ? 0 : getuIntegral().hashCode());
        result = prime * result + ((getuLevel() == null) ? 0 : getuLevel().hashCode());
        result = prime * result + ((getuWxcode() == null) ? 0 : getuWxcode().hashCode());
        result = prime * result + ((getuMyinvitecode() == null) ? 0 : getuMyinvitecode().hashCode());
        result = prime * result + ((getuRealname() == null) ? 0 : getuRealname().hashCode());
        result = prime * result + ((getuLable() == null) ? 0 : getuLable().hashCode());
        result = prime * result + ((getuInvitecode() == null) ? 0 : getuInvitecode().hashCode());
        result = prime * result + ((getuCreatetime() == null) ? 0 : getuCreatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uId=").append(uId);
        sb.append(", uTel=").append(uTel);
        sb.append(", uPassword=").append(uPassword);
        sb.append(", uName=").append(uName);
        sb.append(", uSex=").append(uSex);
        sb.append(", uBirthday=").append(uBirthday);
        sb.append(", uImg=").append(uImg);
        sb.append(", uStatus=").append(uStatus);
        sb.append(", uIntroduction=").append(uIntroduction);
        sb.append(", r1=").append(r1);
        sb.append(", uIntegral=").append(uIntegral);
        sb.append(", uLevel=").append(uLevel);
        sb.append(", uWxcode=").append(uWxcode);
        sb.append(", uMyinvitecode=").append(uMyinvitecode);
        sb.append(", uRealname=").append(uRealname);
        sb.append(", uLable=").append(uLable);
        sb.append(", uInvitecode=").append(uInvitecode);
        sb.append(", uCreatetime=").append(uCreatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}