package com.irs.service.impl;

import com.irs.mapper.*;
import com.irs.pojo.*;
import com.irs.service.RechargeService;
import com.irs.util.WxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    private ShopRechargeMapper rechargeMapper;

    @Autowired
    private ShopProductMapper productMapper;

    @Autowired
    private ShopOrderitemMapper orderitemMapper;

    @Autowired
    private ShopOrdersMapper ordersMapper;

    @Autowired
    private ProductItemMapper productItemMapper;

    @Override
    public WxResult getRechargeByUser(int uId, int type) {
        try {
            ShopRechargeExample example=new ShopRechargeExample();
            ShopRechargeExample.Criteria criteria = example.createCriteria();
            criteria.andUIdEqualTo(uId);
            if(type!=0){
                criteria.andRtIdEqualTo(type);
            }

            return WxResult.ok(rechargeMapper.selectByExample(example));
        } catch (Exception e) {
            return WxResult.fail("操作失败！");
        }
    }

    @Override
    public ShopRecharge getRechargeByOrder(String transaction_id) {
        ShopRechargeExample example=new ShopRechargeExample();
        example.createCriteria().andOrdernumEqualTo(transaction_id);
        List<ShopRecharge> list=rechargeMapper.selectByExample(example);

        return list.get(0);
    }

    @Override
    public WxResult addRecharge(ShopRecharge recharge) {
        try {
            Date d = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		sf.format(d);
//			recharge.s
            recharge.setrAddtime(sf.format(d));
            rechargeMapper.insertSelective(recharge);
        } catch (Exception e) {
            return WxResult.fail("操作失败");
        }
        return WxResult.ok();
    }

    @Override
    public ShopRecharge selectByUid(int parseInt, String fileName2,String pId) {
        ShopRecharge recharge=new ShopRecharge();
        //根据文件名查找pId 101
        ShopProductExample example= new ShopProductExample();
        ShopProductExample.Criteria criteria2=example.createCriteria();

        criteria2.andPIsgroupLike("%"+fileName2+"%");
        List<ShopProduct> productList=productMapper.selectByExample(example);



        if (productList.size()==1){
            recharge.setpId(productList.get(0).getpId());
            //根据用户id查看订单
            ShopRechargeExample example1=new ShopRechargeExample();
            example1.or().andUIdEqualTo(parseInt);
            List<String> ordernums=new ArrayList<>();
            List<ShopRecharge> rechargeList=rechargeMapper.selectByExample(example1);
            for (ShopRecharge shopRecharge : rechargeList) {
                ordernums.add(shopRecharge.getOrdernum());
            }
            if (ordernums.size()==0){
                return null;
            }
            //根据订单编号查找订单id

            ShopOrdersExample example3=new ShopOrdersExample();
            ShopOrdersExample.Criteria criteria3=example3.createCriteria();
            criteria3.andOOrdernumIn(ordernums);
            List<Integer> orderIds=new ArrayList<>();
            List<ShopOrders> ordersList=ordersMapper.selectByExample(example3);
            for (ShopOrders orders : ordersList) {
                orderIds.add(orders.getoId());
            }
            ShopOrderitemExample example2=new ShopOrderitemExample();
            ShopOrderitemExample.Criteria criteria=example2.createCriteria();
            criteria.andOIdIn(orderIds);
            List<ShopOrderitem> orderitemList=orderitemMapper.selectByExample(example2);
            for (ShopOrderitem orderitem:orderitemList){
                if(orderitem.getpId().equals(recharge.getpId())){
                    return recharge;
                }
            }

        }

        return null;
    }
}
