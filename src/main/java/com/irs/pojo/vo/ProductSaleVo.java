package com.irs.pojo.vo;

/**
 * @author zc
 * @create 2019 - 03 - 13
 **/
public class ProductSaleVo {

    private String productname;
    private String productypename;
    private String teachername;
    private String sales;
    private String privace;
    private String time;
    private String createTimeStart;
    private String createTimeEnd;

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

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductypename() {
        return productypename;
    }

    public void setProductypename(String productypename) {
        this.productypename = productypename;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ProductSaleVo{" +
                "productname='" + productname + '\'' +
                ", productypename='" + productypename + '\'' +
                ", teachername='" + teachername + '\'' +
                ", sales='" + sales + '\'' +
                ", privace='" + privace + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
