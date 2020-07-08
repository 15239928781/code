package com.irs.pojo;

import java.util.List;
import java.util.Map;

public class ShopPicture {
    private Integer spId;

    private String images;

    private Integer pId;
private List<ShopPicture> pdf;

    public List<ShopPicture> getPdf() {
        return pdf;
    }

    public void setPdf(List<ShopPicture> pdf) {
        this.pdf = pdf;
    }

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}