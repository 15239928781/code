package com.irs.pojo;

public class ShopAddress {
    private Integer aId;

    private String aName;

    private String aTel;

    private String aProvice;

    private String aCity;

    private String aArea;

    private String aAddress;

    private String aLal;

    private Integer uId;

    private Integer aStatus;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }

    public String getaTel() {
        return aTel;
    }

    public void setaTel(String aTel) {
        this.aTel = aTel == null ? null : aTel.trim();
    }

    public String getaProvice() {
        return aProvice;
    }

    public void setaProvice(String aProvice) {
        this.aProvice = aProvice == null ? null : aProvice.trim();
    }

    public String getaCity() {
        return aCity;
    }

    public void setaCity(String aCity) {
        this.aCity = aCity == null ? null : aCity.trim();
    }

    public String getaArea() {
        return aArea;
    }

    public void setaArea(String aArea) {
        this.aArea = aArea == null ? null : aArea.trim();
    }

    public String getaAddress() {
        return aAddress;
    }

    public void setaAddress(String aAddress) {
        this.aAddress = aAddress == null ? null : aAddress.trim();
    }

    public String getaLal() {
        return aLal;
    }

    public void setaLal(String aLal) {
        this.aLal = aLal == null ? null : aLal.trim();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getaStatus() {
        return aStatus;
    }

    public void setaStatus(Integer aStatus) {
        this.aStatus = aStatus;
    }
}