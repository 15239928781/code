package com.irs.service;

import com.irs.pojo.Refund;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

public interface RefundService {
    WxResult addRefund(Refund refund);

    ResultUtil getRefundList(Integer page, Integer limit, Refund search);

    void updateRefundOstatus(Integer id,Integer status);

    void updRefound(Refund refund);

    WxResult updateRefund(Refund refund);
}
