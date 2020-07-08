package com.irs.pojo;

import java.util.List;

public class Subarea {
    private Long sbId;

    private String sbName;

    private Integer sbIsshow;
    private String leName;

    public String getLeName() {
        return leName;
    }

    public void setLeName(String leName) {
        this.leName = leName;
    }

    private List<ShopProduct> shopProductList;

    public List<ShopProduct> getShopProductList() {
        return shopProductList;
    }

    public void setShopProductList(List<ShopProduct> shopProductList) {
        this.shopProductList = shopProductList;
    }

    public Long getSbId() {
        return sbId;
    }

    public void setSbId(Long sbId) {
        this.sbId = sbId;
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName == null ? null : sbName.trim();
    }

    public Integer getSbIsshow() {
        return sbIsshow;
    }

    public void setSbIsshow(Integer sbIsshow) {
        this.sbIsshow = sbIsshow;
    }
}