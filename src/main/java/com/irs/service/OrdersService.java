package com.irs.service;

import com.irs.pojo.ShopOrderitem;
import com.irs.pojo.ShopOrders;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface OrdersService {
    WxResult addOrderByCart(int uId, String cidlist);

    WxResult getOrederByOid(int oId, HttpServletRequest request);

    WxResult addOrderSimple(int pId, int uId, int type,int count,int sbId);

    WxResult addOrderAddress(int oId, int aId);

    WxResult getOrderByUser(int uId, int oState, HttpServletRequest request);

    ShopOrders selOrderById(Integer id);

    ResultUtil getOrdersList(Integer page, Integer limit, ShopOrders search);

    void delOrders(String userStr);

    void delOrderByOid(String oId);

    void updateOStatus(String oId);

    ResultUtil getOrderItemList(Integer page, Integer limit, ShopOrderitem search);

    void delOrderItem(String userStr);

    void delOrderItemByOid(String oId);

    WxResult updateOrderStatus(ShopOrders orders);

    WxResult delOrder(int oId);

    ResultUtil getIndex();

    WxResult getproductbyuid(int uid, int start, int length,HttpServletRequest request);

    WxResult getTalbymoth();

    ShopOrders selectByOrderNum(String out_trade_no);

    ResultUtil getTeacherNumList(Integer page, Integer limit,ShopOrders orders);

    ResultUtil sumTotalByTime(String createTimeStart, String createTimeEnd);

    List<ShopOrderitem> selectByOrderId(Integer getoId);

    String selMoneyByOrdernum(String prices, String ordernum);

    String selMoneyByOrdernum2(String ordernum);
}
