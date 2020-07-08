package com.irs.service;

import com.irs.pojo.ShopRecharge;
import com.irs.util.WxResult;

public interface RechargeService {
    WxResult getRechargeByUser(int uId, int type);

    ShopRecharge getRechargeByOrder(String transaction_id);

    WxResult addRecharge(ShopRecharge r);

    ShopRecharge selectByUid(int parseInt, String fileName2,String pId);
}
