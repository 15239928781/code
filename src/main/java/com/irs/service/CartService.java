package com.irs.service;

import com.irs.pojo.ShopCart;
import com.irs.util.WxResult;

import javax.servlet.http.HttpServletRequest;

public interface CartService {
    WxResult getCart(int uId, HttpServletRequest request);

    WxResult addCart(ShopCart cart);

    WxResult deleteCart(String cId);

    WxResult addPassward(int uId,String uIntroduction, String uPassword);
}
