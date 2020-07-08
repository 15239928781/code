package com.irs.service;

import com.irs.pojo.GroupsBill;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

import java.util.List;

public interface GroupsBillService {
    WxResult addBill(GroupsBill bill);

    WxResult joinBill(GroupsBill bill);

    ResultUtil getBillList(Integer page, Integer limit, GroupsBill search);

    List<GroupsBill> getBillByStatus();
}
