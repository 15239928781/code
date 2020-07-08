package com.irs.pojo;

public class SpikeProduct {
    private Integer spId;

    private Integer sId;

    private Integer pId;

    private String pName;

    private String pOldprice;

    private String pNowprice;

    private Integer spStatus;

    private Integer spNum;

    private String r1;

    private String r2;

    private String pImage;

    private String pDesc;

    private String pCreatetime;

    private String pEndtime;

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpOldprice() {
        return pOldprice;
    }

    public void setpOldprice(String pOldprice) {
        this.pOldprice = pOldprice == null ? null : pOldprice.trim();
    }

    public String getpNowprice() {
        return pNowprice;
    }

    public void setpNowprice(String pNowprice) {
        this.pNowprice = pNowprice == null ? null : pNowprice.trim();
    }

    public Integer getSpStatus() {
        return spStatus;
    }

    public void setSpStatus(Integer spStatus) {
        this.spStatus = spStatus;
    }

    public Integer getSpNum() {
        return spNum;
    }

    public void setSpNum(Integer spNum) {
        this.spNum = spNum;
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

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage == null ? null : pImage.trim();
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc == null ? null : pDesc.trim();
    }

    public String getpCreatetime() {
        return pCreatetime;
    }

    public void setpCreatetime(String pCreatetime) {
        this.pCreatetime = pCreatetime == null ? null : pCreatetime.trim();
    }

    public String getpEndtime() {
        return pEndtime;
    }

    public void setpEndtime(String pEndtime) {
        this.pEndtime = pEndtime == null ? null : pEndtime.trim();
    }
}