package com.irs.pojo;

import java.util.List;

public class ShopRollpic {
    private Integer rId;

    private String rName;

    private String rPic;

    private Integer rType;

    private Integer rStatus;

    private List<ShopProduct> plist;

    public List<ShopProduct> getPlist() {

        return plist;
    }

    public void setPlist(List<ShopProduct> plist) {
        this.plist = plist;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrPic() {
        return rPic;
    }

    public void setrPic(String rPic) {
        this.rPic = rPic == null ? null : rPic.trim();
    }

    public Integer getrType() {
        return rType;
    }

    public void setrType(Integer rType) {
        this.rType = rType;
    }

    public Integer getrStatus() {
        return rStatus;
    }

    public void setrStatus(Integer rStatus) {
        this.rStatus = rStatus;
    }
}