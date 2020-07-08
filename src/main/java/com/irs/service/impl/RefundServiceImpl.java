package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.RefundMapper;
import com.irs.mapper.ShopOrdersMapper;
import com.irs.mapper.UsersMapper;
import com.irs.pojo.Refund;
import com.irs.pojo.RefundExample;
import com.irs.pojo.ShopOrders;
import com.irs.pojo.Users;
import com.irs.service.RefundService;
import com.irs.util.CommonUtils;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RefundServiceImpl implements RefundService {

    @Autowired
    private RefundMapper refundMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private ShopOrdersMapper ordersMapper;

    @Override
    public WxResult addRefund(Refund refund) {
        Users users=usersMapper.selectByPrimaryKey(refund.getuId());
        refund.setuName(users.getuName());
        refund.setuTel(users.getuTel());
        refund.setR1(CommonUtils.nowtime());
        refund.setStatus("1");
       /* ShopOrders orders=ordersMapper.selectByPrimaryKey(refund.getOrderId());
        orders.setoState(5);
        ordersMapper.updateByPrimaryKeySelective(orders);*/
       Map map=new HashMap();
       int a=refundMapper.insertSelective(refund);
       map.put("id",refund.getId());
        return WxResult.ok(map);
    }

    @Override
    public ResultUtil getRefundList(Integer page, Integer limit, Refund search) {
        PageHelper.startPage(page,limit);
        RefundExample example=new RefundExample();
        example.setOrderByClause("id desc");
        RefundExample.Criteria criteria=example.createCriteria();
        if (search.getuTel()!=null && !"".equals(search.getuTel())){
            criteria.andUTelLike("%"+search.getuTel()+"%");
        }
        if (search.getStatus()!=null && !search.getStatus().equals("-1")){
            criteria.andStatusEqualTo(search.getStatus());
        }
        if(search.getCreateTimeStart()!=null && !"".equals(search.getCreateTimeStart())){
            criteria.andR1GreaterThanOrEqualTo(search.getCreateTimeStart());
        }
        if(search.getCreateTimeEnd()!=null && !"".equals(search.getCreateTimeEnd())){
            criteria.andR1LessThanOrEqualTo(search.getCreateTimeEnd());
        }
        List<Refund> list=refundMapper.selectByExample(example);
        for (Refund refund : list) {
            ShopOrders orders=ordersMapper.selectByPrimaryKey(refund.getOrderId());
            if (orders != null) {
                refund.setoStatus(orders.getoState());
            }
        }
        PageInfo<Refund> pageInfo=new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void updateRefundOstatus(Integer id,Integer status) {
        Refund refund=refundMapper.selectByPrimaryKey(id);
        refund.setStatus(status.toString());
        refundMapper.updateByPrimaryKeySelective(refund);
    }

    @Override
    public void updRefound(Refund refund) {
        String userStr=refund.getUserStr();
        List<Integer> rids=new ArrayList<>();
        if(!StringUtils.isBlank(userStr)){
            String[] ids=userStr.split(",");
            for (String id : ids) {
               rids.add(Integer.valueOf(id));
            }
        }
        RefundExample refundExample=new RefundExample();
        RefundExample.Criteria criteria=refundExample.createCriteria();
        criteria.andIdIn(rids);
        refundMapper.updateByExampleSelective(refund,refundExample);
    }

    @Override
    public WxResult updateRefund(Refund refund) {
        Refund existRefund=refundMapper.selectByPrimaryKey(refund.getId());
        existRefund.setuName(refund.getuName());
        existRefund.setuTel(refund.getuTel());
        existRefund.setNum(refund.getNum());
        existRefund.setuAddress(refund.getuAddress());
        return WxResult.ok(refundMapper.updateByPrimaryKeySelective(existRefund));
    }
}
