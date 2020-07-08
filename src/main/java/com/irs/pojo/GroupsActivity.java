package com.irs.pojo;

public class GroupsActivity {
    private Integer aId;

    private String aName;

    private String aEndtime;

    private String aCeatetime;

    private String aValidity;

    private Integer aMember;

    private String aDesc;

    private Integer aSort;

    private Integer aStatus;

    private Integer aMaxnum;

    private String r1;

    private String r2;

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

    public String getaEndtime() {
        return aEndtime;
    }

    public void setaEndtime(String aEndtime) {
        this.aEndtime = aEndtime == null ? null : aEndtime.trim();
    }

    public String getaCeatetime() {
        return aCeatetime;
    }

    public void setaCeatetime(String aCeatetime) {
        this.aCeatetime = aCeatetime == null ? null : aCeatetime.trim();
    }

    public String getaValidity() {
        return aValidity;
    }

    public void setaValidity(String aValidity) {
        this.aValidity = aValidity == null ? null : aValidity.trim();
    }

    public Integer getaMember() {
        return aMember;
    }

    public void setaMember(Integer aMember) {
        this.aMember = aMember;
    }

    public String getaDesc() {
        return aDesc;
    }

    public void setaDesc(String aDesc) {
        this.aDesc = aDesc == null ? null : aDesc.trim();
    }

    public Integer getaSort() {
        return aSort;
    }

    public void setaSort(Integer aSort) {
        this.aSort = aSort;
    }

    public Integer getaStatus() {
        return aStatus;
    }

    public void setaStatus(Integer aStatus) {
        this.aStatus = aStatus;
    }

    public Integer getaMaxnum() {
        return aMaxnum;
    }

    public void setaMaxnum(Integer aMaxnum) {
        this.aMaxnum = aMaxnum;
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