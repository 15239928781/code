package com.irs.pojo;

import java.io.Serializable;

/**
 * integrals
 * @author 
 */
public class Integrals implements Serializable {
    private Integer iId;

    /**
     * 1增0减
     */
    private Integer iType;

    /**
     * 交易时间
     */
    private String iAddtime;

    /**
     * 积分数量
     */
    private Integer iNum;

    /**
     * 是否过期1是0否
     */
    private Integer iStatus;

    private Integer uId;

    private String r1;

    private String r2;

    private String iEndtime;

    /**
     * 积分类型id（datas）
     */
    private Integer dId;

    /**
     * 店铺id
     */
    private Integer sId;

    private static final long serialVersionUID = 1L;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public Integer getiType() {
        return iType;
    }

    public void setiType(Integer iType) {
        this.iType = iType;
    }

    public String getiAddtime() {
        return iAddtime;
    }

    public void setiAddtime(String iAddtime) {
        this.iAddtime = iAddtime;
    }

    public Integer getiNum() {
        return iNum;
    }

    public void setiNum(Integer iNum) {
        this.iNum = iNum;
    }

    public Integer getiStatus() {
        return iStatus;
    }

    public void setiStatus(Integer iStatus) {
        this.iStatus = iStatus;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getiEndtime() {
        return iEndtime;
    }

    public void setiEndtime(String iEndtime) {
        this.iEndtime = iEndtime;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
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
        Integrals other = (Integrals) that;
        return (this.getiId() == null ? other.getiId() == null : this.getiId().equals(other.getiId()))
            && (this.getiType() == null ? other.getiType() == null : this.getiType().equals(other.getiType()))
            && (this.getiAddtime() == null ? other.getiAddtime() == null : this.getiAddtime().equals(other.getiAddtime()))
            && (this.getiNum() == null ? other.getiNum() == null : this.getiNum().equals(other.getiNum()))
            && (this.getiStatus() == null ? other.getiStatus() == null : this.getiStatus().equals(other.getiStatus()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getR1() == null ? other.getR1() == null : this.getR1().equals(other.getR1()))
            && (this.getR2() == null ? other.getR2() == null : this.getR2().equals(other.getR2()))
            && (this.getiEndtime() == null ? other.getiEndtime() == null : this.getiEndtime().equals(other.getiEndtime()))
            && (this.getdId() == null ? other.getdId() == null : this.getdId().equals(other.getdId()))
            && (this.getsId() == null ? other.getsId() == null : this.getsId().equals(other.getsId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getiId() == null) ? 0 : getiId().hashCode());
        result = prime * result + ((getiType() == null) ? 0 : getiType().hashCode());
        result = prime * result + ((getiAddtime() == null) ? 0 : getiAddtime().hashCode());
        result = prime * result + ((getiNum() == null) ? 0 : getiNum().hashCode());
        result = prime * result + ((getiStatus() == null) ? 0 : getiStatus().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getR1() == null) ? 0 : getR1().hashCode());
        result = prime * result + ((getR2() == null) ? 0 : getR2().hashCode());
        result = prime * result + ((getiEndtime() == null) ? 0 : getiEndtime().hashCode());
        result = prime * result + ((getdId() == null) ? 0 : getdId().hashCode());
        result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", iId=").append(iId);
        sb.append(", iType=").append(iType);
        sb.append(", iAddtime=").append(iAddtime);
        sb.append(", iNum=").append(iNum);
        sb.append(", iStatus=").append(iStatus);
        sb.append(", uId=").append(uId);
        sb.append(", r1=").append(r1);
        sb.append(", r2=").append(r2);
        sb.append(", iEndtime=").append(iEndtime);
        sb.append(", dId=").append(dId);
        sb.append(", sId=").append(sId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}