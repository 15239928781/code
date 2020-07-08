package com.irs.pojo;

public class GroupsProduct {
    private Integer id;

    private Integer pId;

    private Integer aId;

    private String pName;

    private String aOldprice;

    private String aNowprice;

    private Integer aNum;

    private String r1;

    private String r2;

    private Integer aStatus;

    private String pImage;

    private String pDesc;

    private String pCreatetime;

    private String pEndtime;

    private Integer pValidity;

    private Integer pMember;

    private Integer aMaxnum;

    private Integer cId;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getaOldprice() {
        return aOldprice;
    }

    public void setaOldprice(String aOldprice) {
        this.aOldprice = aOldprice == null ? null : aOldprice.trim();
    }

    public String getaNowprice() {
        return aNowprice;
    }

    public void setaNowprice(String aNowprice) {
        this.aNowprice = aNowprice == null ? null : aNowprice.trim();
    }

    public Integer getaNum() {
        return aNum;
    }

    public void setaNum(Integer aNum) {
        this.aNum = aNum;
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

    public Integer getaStatus() {
        return aStatus;
    }

    public void setaStatus(Integer aStatus) {
        this.aStatus = aStatus;
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

    public Integer getpValidity() {
        return pValidity;
    }

    public void setpValidity(Integer pValidity) {
        this.pValidity = pValidity;
    }

    public Integer getpMember() {
        return pMember;
    }

    public void setpMember(Integer pMember) {
        this.pMember = pMember;
    }

    public Integer getaMaxnum() {
        return aMaxnum;
    }

    public void setaMaxnum(Integer aMaxnum) {
        this.aMaxnum = aMaxnum;
    }
}