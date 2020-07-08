package com.irs.pojo;

public class Psb {
    private Integer pId;

    private Long sbid;

    private Double psbPrices;

    private Double psbOldprices;

    private Integer psdIsuse;

    private String pName;

    private String sbName;

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Long getSbid() {
        return sbid;
    }

    public void setSbid(Long sbid) {
        this.sbid = sbid;
    }

    public Double getPsbPrices() {
        return psbPrices;
    }

    public void setPsbPrices(Double psbPrices) {
        this.psbPrices = psbPrices;
    }

    public Double getPsbOldprices() {
        return psbOldprices;
    }

    public void setPsbOldprices(Double psbOldprices) {
        this.psbOldprices = psbOldprices;
    }

    public Integer getPsdIsuse() {
        return psdIsuse;
    }

    public void setPsdIsuse(Integer psdIsuse) {
        this.psdIsuse = psdIsuse;
    }
}