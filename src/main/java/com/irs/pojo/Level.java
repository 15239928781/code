package com.irs.pojo;

public class Level {
    private Integer leId;


    private String leName;

    private String r1;

    private String r2;

    private String leDiscount;

    private Integer leMinscore;

    private Integer leMaxscore;

    private Integer status;
    private Integer status2;

    public Integer getStatus2() {
        return status2;
    }

    public void setStatus2(Integer status2) {
        this.status2 = status2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLeId() {
        return leId;
    }

    public void setLeId(Integer leId) {
        this.leId = leId;
    }

    public String getLeName() {
        return leName;
    }

    public void setLeName(String leName) {
        this.leName = leName == null ? null : leName.trim();
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

    public String getLeDiscount() {
        return leDiscount;
    }

    public void setLeDiscount(String leDiscount) {
        this.leDiscount = leDiscount == null ? null : leDiscount.trim();
    }

    public Integer getLeMinscore() {
        return leMinscore;
    }

    public void setLeMinscore(Integer leMinscore) {
        this.leMinscore = leMinscore;
    }

    public Integer getLeMaxscore() {
        return leMaxscore;
    }

    public void setLeMaxscore(Integer leMaxscore) {
        this.leMaxscore = leMaxscore;
    }
}