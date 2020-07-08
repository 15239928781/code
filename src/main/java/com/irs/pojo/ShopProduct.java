package com.irs.pojo;

import java.util.List;

public class ShopProduct {
    private Integer pId;

    private String pName;

    private Double pPrice;

    private Double pOldprice;

    private String pImage;

    private String pAddtime;

    private String pDesc;

    private Integer pIshot;

    private Integer pIson;

    private Integer pIscoupon;

    private Integer pIscore;

    private Integer cId;

    private Integer pNum;

    private Integer pStock;

    private Integer pIsfee;

    private Integer pIskill;

    private String pIsgroup;

    private String pRealName;

    private Integer pValidity;

    private Integer pIspc;

    private Integer tId;

    private String url;

    private String Colloction;

    private String sales;

    private String privace;

    private String tName;

    private Double psbPrices;

    private Double psbOldprices;

    private Long sbId;

    private String cName1;

    private Integer pTuijian;

    @Override
    public String toString() {
        return "ShopProduct{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pPrice=" + pPrice +
                ", pOldprice=" + pOldprice +
                ", pImage='" + pImage + '\'' +
                ", pAddtime='" + pAddtime + '\'' +
                ", pDesc='" + pDesc + '\'' +
                ", pIshot=" + pIshot +
                ", pIson=" + pIson +
                ", pIscoupon=" + pIscoupon +
                ", pIscore=" + pIscore +
                ", cId=" + cId +
                ", pNum=" + pNum +
                ", pStock=" + pStock +
                ", pIsfee=" + pIsfee +
                ", pIskill=" + pIskill +
                ", pIsgroup='" + pIsgroup + '\'' +
                ", pRealName='" + pRealName + '\'' +
                ", pValidity=" + pValidity +
                ", pIspc=" + pIspc +
                ", tId=" + tId +
                ", url='" + url + '\'' +
                ", Colloction='" + Colloction + '\'' +
                ", sales='" + sales + '\'' +
                ", privace='" + privace + '\'' +
                ", tName='" + tName + '\'' +
                ", psbPrices=" + psbPrices +
                ", psbOldprices=" + psbOldprices +
                ", sbId=" + sbId +
                ", cName1='" + cName1 + '\'' +
                ", pTuijian=" + pTuijian +
                ", uNameList=" + uNameList +
                ", sbName='" + sbName + '\'' +
                ", cGrade=" + cGrade +
                ", productItems=" + productItems +
                ", fId=" + fId +
                ", createTimeStart='" + createTimeStart + '\'' +
                ", createTimeEnd='" + createTimeEnd + '\'' +
                ", rollImages=" + rollImages +
                ", shopCategory=" + shopCategory +
                ", teacher=" + teacher +
                ", categoryname='" + categoryname + '\'' +
                ", cName='" + cName + '\'' +
                ", uImg='" + uImg + '\'' +
                ", cNum=" + cNum +
                '}';
    }

    public String getpRealName() {
        return pRealName;
    }

    public void setpRealName(String pRealName) {
        this.pRealName = pRealName;
    }

    public Integer getpTuijian() {
        return pTuijian;
    }

    public void setpTuijian(Integer pTuijian) {
        this.pTuijian = pTuijian;
    }

    public String getcName1() {
        return cName1;
    }

    public void setcName1(String cName1) {
        this.cName1 = cName1;
    }

    private List<String> uNameList;
    private String sbName;
    private Integer cGrade;

    public Integer getcGrade() {
        return cGrade;
    }

    public void setcGrade(Integer cGrade) {
        this.cGrade = cGrade;
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }

    public List<String> getuNameList() {
        return uNameList;
    }

    public void setuNameList(List<String> uNameList) {
        this.uNameList = uNameList;
    }
    public Long getSbId() {
        return sbId;
    }

    public void setSbId(Long sbId) {
        this.sbId = sbId;
    }

    public Double getPsbOldprices() {
        return psbOldprices;
    }

    public void setPsbOldprices(Double psbOldprices) {
        this.psbOldprices = psbOldprices;
    }

    public Double getPsbPrices() {
        return psbPrices;
    }

    public void setPsbPrices(Double psbPrices) {
        this.psbPrices = psbPrices;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getPrivace() {
        return privace;
    }

    public void setPrivace(String privace) {
        this.privace = privace;
    }

    private List<ProductItem> productItems;

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    private Integer fId;

    public String getColloction() {
        return Colloction;
    }

    public void setColloction(String colloction) {
        Colloction = colloction;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String createTimeStart;
    private String createTimeEnd;
    List<ShopPicture> rollImages;

    private ShopCategory shopCategory;
    private Teacher teacher;

    private String categoryname;

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public ShopCategory getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(ShopCategory shopCategory) {
        this.shopCategory = shopCategory;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    private String cName;

    private String uImg;

    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg;
    }


    private long cNum;

    public long getcNum() {
        return cNum;
    }

    public void setcNum(long cNum) {
        this.cNum = cNum;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public List<ShopPicture> getRollImages() {
        return rollImages;
    }

    public void setRollImages(List<ShopPicture> rollImages) {
        this.rollImages = rollImages;
    }

    public String getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(String createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public String getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
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

    public Double getpPrice() {
        return pPrice;
    }

    public void setpPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    public Double getpOldprice() {
        return pOldprice;
    }

    public void setpOldprice(Double pOldprice) {
        this.pOldprice = pOldprice;
    }

    public String getpImage() {

        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage == null ? null : pImage.trim();
    }

    public String getpAddtime() {
        return pAddtime;
    }

    public void setpAddtime(String pAddtime) {
        this.pAddtime = pAddtime == null ? null : pAddtime.trim();
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc == null ? null : pDesc.trim();
    }

    public Integer getpIshot() {
        return pIshot;
    }

    public void setpIshot(Integer pIshot) {
        this.pIshot = pIshot;
    }

    public Integer getpIson() {
        return pIson;
    }

    public void setpIson(Integer pIson) {
        this.pIson = pIson;
    }

    public Integer getpIscoupon() {
        return pIscoupon;
    }

    public void setpIscoupon(Integer pIscoupon) {
        this.pIscoupon = pIscoupon;
    }

    public Integer getpIscore() {
        return pIscore;
    }

    public void setpIscore(Integer pIscore) {
        this.pIscore = pIscore;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getpNum() {
        return pNum;
    }

    public void setpNum(Integer pNum) {
        this.pNum = pNum;
    }

    public Integer getpStock() {
        return pStock;
    }

    public void setpStock(Integer pStock) {
        this.pStock = pStock;
    }

    public Integer getpIsfee() {
        return pIsfee;
    }

    public void setpIsfee(Integer pIsfee) {
        this.pIsfee = pIsfee;
    }

    public Integer getpIskill() {
        return pIskill;
    }

    public void setpIskill(Integer pIskill) {
        this.pIskill = pIskill;
    }

    public String getpIsgroup() {
        return pIsgroup;
    }

    public void setpIsgroup(String pIsgroup) {
        this.pIsgroup = pIsgroup;
    }

    public Integer getpValidity() {
        return pValidity;
    }

    public void setpValidity(Integer pValidity) {
        this.pValidity = pValidity;
    }

    public Integer getpIspc() {
        return pIspc;
    }

    public void setpIspc(Integer pIspc) {
        this.pIspc = pIspc;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

}