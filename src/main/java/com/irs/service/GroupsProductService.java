package com.irs.service;

import com.irs.pojo.GroupsProduct;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface GroupsProductService {
    WxResult getGroupProductList(HttpServletRequest request,int page,int limit);

    WxResult getGroupProductByPId(HttpServletRequest request, GroupsProduct product);

    GroupsProduct selGroupById(Integer id);

    ResultUtil getGroupList(Integer page, Integer limit, GroupsProduct product);

    int insGroup(GroupsProduct product);

    void delGroupById(Integer id);

    void delGroup(String carouselStr);

    void updGroup(GroupsProduct teacher);

    List<GroupsProduct> checkPId(Integer pId);

    WxResult groupIndex(Integer id, HttpServletRequest request);
}
