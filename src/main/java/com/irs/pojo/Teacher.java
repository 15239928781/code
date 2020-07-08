package com.irs.pojo;

public class Teacher {
    private Integer tId;

    private String tName;

    private String tPic;

    private String tPosition;

    private String r1;

    private String r2;

    private long tNum;

    private String sumPrices;

    public String getSumPrices() {
        return sumPrices;
    }

    public void setSumPrices(String sumPrices) {
        this.sumPrices = sumPrices;
    }

    public long gettNum() {
        return tNum;
    }

    public void settNum(long tNum) {
        this.tNum = tNum;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettPic() {
        return tPic;
    }

    public void settPic(String tPic) {
        this.tPic = tPic == null ? null : tPic.trim();
    }

    public String gettPosition() {
        return tPosition;
    }

    public void settPosition(String tPosition) {
        this.tPosition = tPosition == null ? null : tPosition.trim();
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
}