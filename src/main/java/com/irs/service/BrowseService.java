package com.irs.service;

import com.irs.pojo.ShopBrowse;
import com.irs.pojo.ShopOrders;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

public interface BrowseService {
    WxResult addBrowse(ShopBrowse browse);

    ResultUtil getBrowseList(Integer page, Integer limit,Integer btype/*, ShopBrowse search*/);

    ResultUtil getUserBrowseList(Integer page, Integer limit, Integer bId);
}
