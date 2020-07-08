package com.irs.pojo;

import java.util.List;

public class ShopOrders {
    private Integer oId;

    private String oOrdernum;

    private Double total;

    private String ordertime;

    private Integer oState;

    private String uName;

    private String phone;

    private String oAddress;

    private Integer uId;

    private String remark;

    private Boolean oIsshow;

    private Integer dId;

    private Integer oType;

    private Integer id;


    private String money;
    private String createTimeStart;
    private String createTimeEnd;

    private Integer moth;

    private String sumorder;
    private Double yhmoney;

    public Double getYhmoney() {
        return yhmoney;
    }

    public void setYhmoney(Double yhmoney) {
        this.yhmoney = yhmoney;
    }

    public String getSumorder() {
        return sumorder;
    }

    public void setSumorder(String sumorder) {
        this.sumorder = sumorder;
    }

    public Integer getMoth() {
        return moth;
    }

    public void setMoth(Integer moth) {
        this.moth = moth;
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

    private List<ShopOrderitem> list;

    public List<ShopOrderitem> getList() {
        return list;
    }

    public void setList(List<ShopOrderitem> list) {
        this.list = list;
    }
    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getoOrdernum() {
        return oOrdernum;
    }

    public void setoOrdernum(String oOrdernum) {
        this.oOrdernum = oOrdernum == null ? null : oOrdernum.trim();
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime == null ? null : ordertime.trim();
    }

    public Integer getoState() {
        return oState;
    }

    public void setoState(Integer oState) {
        this.oState = oState;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress == null ? null : oAddress.trim();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getoIsshow() {
        return oIsshow;
    }

    public void setoIsshow(Boolean oIsshow) {
        this.oIsshow = oIsshow;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getoType() {
        return oType;
    }

    public void setoType(Integer oType) {
        this.oType = oType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }
}