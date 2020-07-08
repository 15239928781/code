package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.GroupsBillMapper;
import com.irs.mapper.GroupsProductMapper;
import com.irs.mapper.ShopOrdersMapper;
import com.irs.mapper.UsersMapper;
import com.irs.pojo.*;
import com.irs.service.GroupsBillService;
import com.irs.util.CommonUtils;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupsBillServiceImpl implements GroupsBillService {

    @Autowired
    private GroupsBillMapper billMapper;

    @Autowired
    private GroupsProductMapper productMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private ShopOrdersMapper ordersMapper;

    @Override
    public WxResult addBill(GroupsBill bill) {
        //查看是否重复开团
        GroupsBillExample example2=new GroupsBillExample();
        GroupsBillExample.Criteria criteria2=example2.createCriteria();
        criteria2.andUIdEqualTo(bill.getuId());
        criteria2.andBIdEqualTo(bill.getbId());
        List<GroupsBill> bills=billMapper.selectByExample(example2);
        if (bills.size()>0){
            return WxResult.fail("不可重复开团哦！");
        }
        Map map=new HashMap();
        //根据bid查看拼团商品有效期
        GroupsProduct product=productMapper.selectByPrimaryKey(bill.getbId());
        if (bill.getaValidity()>product.getaMaxnum()){
            return WxResult.fail("每人仅限购"+product.getaMaxnum()+"");
        }
        String nowtime= CommonUtils.nowtime();
        bill.setgCreatetime(nowtime);
        //有效期后的时间
        if (product!=null){
            bill.setgEndtime(CommonUtils.aftertime(product.getpValidity()));
            bill.setaMember(product.getpMember());
            bill.setaCanjia(1);
            bill.setStatus(1);
            bill.setColonel(1);
            //根据订单编号查找订单id
            ShopOrdersExample example=new ShopOrdersExample();
            ShopOrdersExample.Criteria criteria=example.createCriteria();
            criteria.andOOrdernumEqualTo(bill.getOrderNum());
            List<ShopOrders> ordersList=ordersMapper.selectByExample(example);
            bill.setoId(ordersList.get(0).getoId().toString());
            billMapper.insertSelective(bill);

            /*GroupsBill product1=new GroupsBill();
            product1.setpImage(bill.getpImage());
            product1.setpName(bill.getpName());
            product1.setaValidity(bill.getaValidity()); //购买数量
            product1.setaNowprices(bill.getaNowprices()); //现价
            product1.setAoldprices(bill.getAoldprices()); //原价
            Users users=usersMapper.selectByPrimaryKey(bill.getuId());
            product1.setuImg(users.getuImg());
            product1.setbId(bill.getbId());
            map.put("product",product1);*/
            map.put("Id",bill.getId());
            return WxResult.ok(map);
        }

        return WxResult.fail("操作失败");
    }

    @Override
    public WxResult joinBill(GroupsBill bill) {
        //校验重复参团
        GroupsBillExample example2=new GroupsBillExample();
        GroupsBillExample.Criteria criteria2=example2.createCriteria();
        criteria2.andUIdEqualTo(bill.getuId());
        criteria2.andTIdEqualTo(bill.gettId());
        List<GroupsBill> bills=billMapper.selectByExample(example2);
        if (bills.size()>0){
            return WxResult.fail("不可重复参团哦!");
        }
        //根据团长开团的id查看相关信息
        GroupsBill groupsBill=billMapper.selectByPrimaryKey(bill.gettId());
        GroupsBill group=new GroupsBill();
        group.setpId(groupsBill.getpId());
        group.setpName(groupsBill.getpName());
        group.setgCreatetime(CommonUtils.nowtime());
        group.setgEndtime(groupsBill.getgEndtime());
        group.setaValidity(bill.getaValidity());//购买数量
        group.setaMember(groupsBill.getaMember());
        group.setaCanjia(groupsBill.getaCanjia()+1);
        groupsBill.setColonel(groupsBill.getaCanjia()+1);
        //判断参加人数是否与拼团人数相等
        if(groupsBill.getaMember().equals(groupsBill.getaCanjia())){
            //拼团成功,订单改为待发货状态
            group.setStatus(2);
            groupsBill.setStatus(2);
            billMapper.updateByPrimaryKeySelective(groupsBill);
            //通过团长的id查询开团信息，从而查找到订单改变订单状态
            GroupsBillExample example=new GroupsBillExample();
            GroupsBillExample.Criteria criteria=example.createCriteria();
            criteria.andTIdEqualTo(bill.gettId());
            //更新r1状态
            GroupsBill bill2=new GroupsBill();
            bill2.setR1("1");
            billMapper.updateByExampleSelective(bill2,example);
            //查看订单id
            List<GroupsBill> list=billMapper.selectByExample(example);
            List<Integer> oIds=new ArrayList<>();
            for (GroupsBill groupsBill1 : list) {
                oIds.add(Integer.valueOf(groupsBill1.getoId()));
            }
            ShopOrdersExample ordersExample=new ShopOrdersExample();
            ShopOrdersExample.Criteria criteria1=ordersExample.createCriteria();
            criteria1.andOIdIn(oIds);
            ShopOrders orders=new ShopOrders();
            orders.setoState(2);
            ordersMapper.updateByExampleSelective(orders,ordersExample);
            //将团单id的r1状态改为1
            GroupsBill bill1=billMapper.selectByPrimaryKey(bill.gettId());
            bill1.setR1("1");
            billMapper.updateByPrimaryKeySelective(bill1);

        }
        groupsBill.setaCanjia(groupsBill.getaCanjia()+1);
        billMapper.updateByPrimaryKeySelective(groupsBill);
        group.setStatus(1);
        group.settId(groupsBill.getId());
        group.setuId(bill.getuId());//用户id
        group.setColonel(0);
        group.setbId(bill.getbId());
        //根据订单编号查询订单id
        ShopOrdersExample example=new ShopOrdersExample();
        ShopOrdersExample.Criteria criteria=example.createCriteria();
        criteria.andOOrdernumEqualTo(bill.getOrderNum());
        List<ShopOrders> ordersList=ordersMapper.selectByExample(example);
        group.setoId(ordersList.get(0).getoId().toString());
        billMapper.insertSelective(group);
        Map map=new HashMap();
        map.put("Id",bill.gettId());
        return WxResult.ok(map);
    }

    @Override
    public ResultUtil getBillList(Integer page, Integer limit, GroupsBill search) {
        PageHelper.startPage(page, limit);
        GroupsBillExample example=new GroupsBillExample();
        example.setOrderByClause("id desc");
        GroupsBillExample.Criteria criteria=example.createCriteria();
        criteria.andTIdEqualTo(0);
        if (search.getId()!=null){
            criteria.andIdEqualTo(search.getId());
        }
        if (search.getgCreatetime()!=null && !"".equals(search.getgCreatetime())){
            criteria.andGCreatetimeGreaterThanOrEqualTo(search.getgCreatetime());
        }
        if (search.getgEndtime()!=null && !"".equals(search.getgEndtime())){
            criteria.andGCreatetimeLessThanOrEqualTo(search.getgEndtime());
        }
        List<GroupsBill> list=billMapper.selectByExample(example);
        PageInfo<GroupsBill> pageInfo=new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public List<GroupsBill> getBillByStatus() {
        GroupsBillExample example=new GroupsBillExample();
        GroupsBillExample.Criteria criteria=example.createCriteria();
        criteria.andGEndtimeGreaterThanOrEqualTo(CommonUtils.nowtime());
        //若参加人数和拼团人数相等时状态改为拼团成功，若参加人数小于拼团人数状态改为正在拼团
        List<GroupsBill> billList=billMapper.selectByExample(example);
        for (GroupsBill bill : billList) {
            if(bill.getaMember().equals(bill.getaCanjia())) {
                bill.setStatus(2);
                billMapper.updateByPrimaryKeySelective(bill);
            }else if(bill.getaMember().compareTo(bill.getaCanjia())>0){
                if(!bill.getStatus().equals(1)){
                    bill.setStatus(1);
                    billMapper.updateByPrimaryKeySelective(bill);
                }
            }
        }
        GroupsBillExample example1=new GroupsBillExample();
        GroupsBillExample.Criteria criteria1=example1.createCriteria();
        criteria1.andGEndtimeLessThanOrEqualTo(CommonUtils.nowtime());
        criteria1.andStatusEqualTo(4);
        return billMapper.selectByExample(example1);
    }


}
