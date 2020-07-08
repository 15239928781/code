package com.irs.pojo;

public class ShopCategory {
    private Integer cId;

    private String cName;

    private Integer parentid;

    private String cImage;
    private Integer cSorting;


    public Integer getcSorting() {
        return cSorting;
    }

    public void setcSorting(Integer cSorting) {
        this.cSorting = cSorting;
    }

    @Override
    public String toString() {
        return "ShopCategory{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", parentid=" + parentid +
                ", cImage='" + cImage + '\'' +
                ", pName='" + pName + '\'' +
                ", cIsshow=" + cIsshow +
                ", cGrade=" + cGrade +
                '}';
    }

    public Integer getcGrade() {
        return cGrade;
    }

    public void setcGrade(Integer cGrade) {
        this.cGrade = cGrade;
    }

    private String pName;
    private Integer cIsshow;
    private Integer cGrade;

    public Integer getcIsshow() {
        return cIsshow;
    }

    public void setcIsshow(Integer cIsshow) {
        this.cIsshow = cIsshow;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getcImage() {
        return cImage;
    }

    public void setcImage(String cImage) {
        this.cImage = cImage == null ? null : cImage.trim();
    }


}