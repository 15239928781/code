package com.irs.service;

import com.irs.pojo.ShopAddress;
import com.irs.util.WxResult;

import javax.mail.Address;

public interface AddressService {
    WxResult getAddressByUser(int uId);

    WxResult addAddress(ShopAddress address);

    WxResult editAddress(ShopAddress address);

    WxResult delAddress(int aId, int aStatus, int uId);

    WxResult getDefaultAddress(int uId);
}
