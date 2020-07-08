package com.irs.pojo;

public class ProductItem {
    private Integer iId;

    private String iName;

    private String iTime;

    private String iDesc;

    private String r1;

    private String r2;

    private Integer pId;

    private String iPic;

    private String pname;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName == null ? null : iName.trim();
    }

    public String getiTime() {
        return iTime;
    }

    public void setiTime(String iTime) {
        this.iTime = iTime == null ? null : iTime.trim();
    }

    public String getiDesc() {
        return iDesc;
    }

    public void setiDesc(String iDesc) {
        this.iDesc = iDesc == null ? null : iDesc.trim();
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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getiPic() {
        return iPic;
    }

    public void setiPic(String iPic) {
        this.iPic = iPic == null ? null : iPic.trim();
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "iId=" + iId +
                ", iName='" + iName + '\'' +
                ", iTime='" + iTime + '\'' +
                ", iDesc='" + iDesc + '\'' +
                ", r1='" + r1 + '\'' +
                ", r2='" + r2 + '\'' +
                ", pId=" + pId +
                ", iPic='" + iPic + '\'' +
                '}';
    }
}