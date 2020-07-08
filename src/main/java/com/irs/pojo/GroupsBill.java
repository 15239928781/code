package com.irs.pojo;

public class GroupsBill {
    private Integer id;

    private String oId;

    private Integer pId;

    private String pName;

    private String gCreatetime;

    private String gEndtime;

    private Integer aValidity;

    private Integer aMember;

    private Integer aCanjia;

    private Integer status;

    private Integer tId;

    private Integer uId;

    private Integer colonel;

    private String r1;

    private String r2;

    private Integer bId;

    private Integer redundant;
    private String uName;
    private String uImg;

    private String pImage;

    private String aNowprices;

    private String aoldprices;

    private String orderNum;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getaNowprices() {
        return aNowprices;
    }

    public void setaNowprices(String aNowprices) {
        this.aNowprices = aNowprices;
    }

    public String getAoldprices() {
        return aoldprices;
    }

    public void setAoldprices(String aoldprices) {
        this.aoldprices = aoldprices;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public Integer getRedundant() {
        return redundant;
    }

    public void setRedundant(Integer redundant) {
        this.redundant = redundant;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId == null ? null : oId.trim();
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

    public String getgCreatetime() {
        return gCreatetime;
    }

    public void setgCreatetime(String gCreatetime) {
        this.gCreatetime = gCreatetime == null ? null : gCreatetime.trim();
    }

    public String getgEndtime() {
        return gEndtime;
    }

    public void setgEndtime(String gEndtime) {
        this.gEndtime = gEndtime == null ? null : gEndtime.trim();
    }

    public Integer getaValidity() {
        return aValidity;
    }

    public void setaValidity(Integer aValidity) {
        this.aValidity = aValidity;
    }

    public Integer getaMember() {
        return aMember;
    }

    public void setaMember(Integer aMember) {
        this.aMember = aMember;
    }

    public Integer getaCanjia() {
        return aCanjia;
    }

    public void setaCanjia(Integer aCanjia) {
        this.aCanjia = aCanjia;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getColonel() {
        return colonel;
    }

    public void setColonel(Integer colonel) {
        this.colonel = colonel;
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

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }
}