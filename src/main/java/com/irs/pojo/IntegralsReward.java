package com.irs.pojo;

public class IntegralsReward {
    private Integer rId;

    private String rPrices;

    private Integer rNum;

    private String r1;

    private String r2;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrPrices() {
        return rPrices;
    }

    public void setrPrices(String rPrices) {
        this.rPrices = rPrices == null ? null : rPrices.trim();
    }

    public Integer getrNum() {
        return rNum;
    }

    public void setrNum(Integer rNum) {
        this.rNum = rNum;
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
}