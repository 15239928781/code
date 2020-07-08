package com.irs.pojo;

public class IntegralUse {
    private Integer iuId;

    private Integer iuNum;

    private String iuPrice;

    private String r1;

    private String r2;

    private Integer dId;

    public Integer getIuId() {
        return iuId;
    }

    public void setIuId(Integer iuId) {
        this.iuId = iuId;
    }

    public Integer getIuNum() {
        return iuNum;
    }

    public void setIuNum(Integer iuNum) {
        this.iuNum = iuNum;
    }

    public String getIuPrice() {
        return iuPrice;
    }

    public void setIuPrice(String iuPrice) {
        this.iuPrice = iuPrice == null ? null : iuPrice.trim();
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1 == null ? null : r1.trim();
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2 == null ? null : r2.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}