package com.irs.pojo;

public class ShopRecharge {
    private Integer rId;

    private Double rMoney;

    private String payTime;

    private Integer rtId;

    private Integer uId;

    private String rDesc;

    private String ordernum;

    private String rAddtime;

    private Integer pId;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Double getrMoney() {
        return rMoney;
    }

    public void setrMoney(Double rMoney) {
        this.rMoney = rMoney;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime == null ? null : payTime.trim();
    }

    public Integer getRtId() {
        return rtId;
    }

    public void setRtId(Integer rtId) {
        this.rtId = rtId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getrDesc() {
        return rDesc;
    }

    public void setrDesc(String rDesc) {
        this.rDesc = rDesc == null ? null : rDesc.trim();
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public String getrAddtime() {
        return rAddtime;
    }

    public void setrAddtime(String rAddtime) {
        this.rAddtime = rAddtime == null ? null : rAddtime.trim();
    }
}