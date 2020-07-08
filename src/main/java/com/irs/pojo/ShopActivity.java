package com.irs.pojo;

public class ShopActivity {
    private Integer aId;

    private String aName;

    private String aPic;

    private Integer aType;

    private Integer aStatus;

    private Integer aNum;

    private String aUrl;

    private String aStarttime;

    private String aEndtime;

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

    public String getaPic() {
        return aPic;
    }

    public void setaPic(String aPic) {
        this.aPic = aPic == null ? null : aPic.trim();
    }

    public Integer getaType() {
        return aType;
    }

    public void setaType(Integer aType) {
        this.aType = aType;
    }

    public Integer getaStatus() {
        return aStatus;
    }

    public void setaStatus(Integer aStatus) {
        this.aStatus = aStatus;
    }

    public Integer getaNum() {
        return aNum;
    }

    public void setaNum(Integer aNum) {
        this.aNum = aNum;
    }

    public String getaUrl() {
        return aUrl;
    }

    public void setaUrl(String aUrl) {
        this.aUrl = aUrl == null ? null : aUrl.trim();
    }

    public String getaStarttime() {
        return aStarttime;
    }

    public void setaStarttime(String aStarttime) {
        this.aStarttime = aStarttime == null ? null : aStarttime.trim();
    }

    public String getaEndtime() {
        return aEndtime;
    }

    public void setaEndtime(String aEndtime) {
        this.aEndtime = aEndtime == null ? null : aEndtime.trim();
    }
}