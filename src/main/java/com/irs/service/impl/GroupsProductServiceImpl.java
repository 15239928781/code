package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.*;
import com.irs.pojo.*;
import com.irs.service.GroupsProductService;
import com.irs.util.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GroupsProductServiceImpl implements GroupsProductService {

    @Autowired
    private GroupsProductMapper groupsProductMapper;

    @Autowired
    private ShopProductMapper productMapper;

    @Autowired
    private GroupsBillMapper billMapper;

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public WxResult getGroupProductList(HttpServletRequest request,int page,int limit) {
        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort()+"/ssm/file/showPic?fileName=";
        String saveUrl2=request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort()+"/ssm";
        //获取当前时间
        String time= CommonUtils.nowtime();
        PageHelper.startPage(page,limit);
        GroupsProductExample example=new GroupsProductExample();
        example.setOrderByClause("id desc");
        GroupsProductExample.Criteria criteria=example.createCriteria();
        criteria.andPEndtimeGreaterThanOrEqualTo(time);
        List<GroupsProduct> list=groupsProductMapper.selectByExample(example);
        for (GroupsProduct groupsProduct : list) {
            groupsProduct.setpImage(saveUrl+groupsProduct.getpImage());
            ShopProduct product=productMapper.selectByPrimaryKey(groupsProduct.getpId());
            if (product!=null){
                groupsProduct.setcId(product.getcId());
            }

            if (groupsProduct.getpDesc()!=null){
                String newStr= HtmlUtils.replaceHtmlTag(groupsProduct.getpDesc(),"img", "src", "src=\""+saveUrl2+"", "\"");
                groupsProduct.setpDesc(newStr);
            }
        }
        return WxResult.ok(list);
    }

    @Override
    public WxResult getGroupProductByPId(HttpServletRequest request, GroupsProduct product) {
        Map map=new HashMap();
        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort()+"/ssm";
        GroupsProduct product1=groupsProductMapper.selectByPrimaryKey(product.getId());
        product1.setpDesc(product.getpDesc());
        product1.setpImage(product.getpImage());
        map.put("product",product1);
        //根据商品id查看拼团状态
        GroupsBillExample example=new GroupsBillExample();
        String nowtime=CommonUtils.nowtime();
        GroupsBillExample.Criteria criteria1=example.createCriteria();
        criteria1.andGEndtimeLessThanOrEqualTo(nowtime);
        GroupsBill bill=new GroupsBill();
        bill.setStatus(3);
        billMapper.updateByExampleSelective(bill,example);
        GroupsBillExample example2=new GroupsBillExample();
        GroupsBillExample.Criteria criteria=example2.createCriteria();
        criteria.andPIdEqualTo(product.getpId());
        criteria.andColonelEqualTo(1);
       // criteria.andGEndtimeLessThan(nowtime);
        criteria.andStatusEqualTo(1);
        long count=billMapper.countByExample(example2);
        map.put("count",count);
        List<GroupsBill> billList=billMapper.selectByExample(example2);
        for (GroupsBill groupsBill : billList) {
                groupsBill.setRedundant(groupsBill.getaMember()-groupsBill.getaCanjia());
                Users users=usersMapper.selectByPrimaryKey(groupsBill.getuId());
                if (users!=null){
                    groupsBill.setuName(users.getuName());
                    groupsBill.setuImg(users.getuImg());
                }
        }
        map.put("billList",billList);
        return WxResult.ok(map);
    }

    @Override
    public GroupsProduct selGroupById(Integer id) {
        return groupsProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultUtil getGroupList(Integer page, Integer limit, GroupsProduct product) {
        PageHelper.startPage(page, limit);
        GroupsProductExample example=new GroupsProductExample();
        example.setOrderByClause("id desc");
        GroupsProductExample.Criteria criteria=example.createCriteria();
        if (product.getpName()!=null && !"".equals(product.getpName())){
            criteria.andPNameLike("%"+product.getpName()+"%");
        }
        if(product.getaStatus()!=null && product.getaStatus()!=-1){
            criteria.andAStatusEqualTo(product.getaStatus());
        }
        List<GroupsProduct> list=groupsProductMapper.selectByExample(example);
        for (GroupsProduct groupsProduct:list){
            //注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
            SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //加上时间
            //必须捕获异常
            try {
                Date end=sDateFormat.parse(groupsProduct.getpEndtime());
                Date start=sDateFormat.parse(groupsProduct.getpCreatetime());
                if (compareDate(start,end, DateUtil.getDate())) {
                    groupsProduct.setaStatus(2);
                } else if (end.getTime()<DateUtil.getDate().getTime()) {
                    groupsProduct.setaStatus(3);
                } else if (start.getTime()>DateUtil.getDate().getTime()){
                    groupsProduct.setaStatus(1);
                }
            } catch(ParseException px) {
                px.printStackTrace();
            }
        }
        PageInfo<GroupsProduct> pageInfo=new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    // 判断时间是否在时间段内
    public static boolean compareDate(Date start, Date end, Date date) {
        if (date.getTime() >= start.getTime() && date.getTime() <= end.getTime()) {
            return true;
        }
        return false;
    }

    @Override
    public int insGroup(GroupsProduct product) {
        String nowtime=CommonUtils.nowtime();
        GroupsProductExample example=new GroupsProductExample();
        example.setOrderByClause("id desc");
        GroupsProductExample.Criteria criteria=example.createCriteria();
        criteria.andPIdEqualTo(product.getpId());
        criteria.andPEndtimeGreaterThanOrEqualTo(nowtime);
        List<GroupsProduct> productList=groupsProductMapper.selectByExample(example);
        if (productList.size()>0){
            return 0;
        }

        ShopProduct shopProduct=productMapper.selectByPrimaryKey(product.getpId());
        product.setpName(shopProduct.getpName());
        product.setaOldprice(String.valueOf(shopProduct.getpOldprice()));
        product.setpImage(shopProduct.getpImage());
        product.setpDesc(shopProduct.getpDesc());
        product.setcId(shopProduct.getcId());

        if( product.getpCreatetime().compareTo(nowtime)<0){
            product.setaStatus(2);
        }else {
            product.setaStatus(1);
        }
        groupsProductMapper.insertSelective(product);
        return 1;
    }

    @Override
    public void delGroupById(Integer id) {
        groupsProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delGroup(String carouselStr) {
        if(!StringUtils.isBlank(carouselStr)){
            String[] ids=carouselStr.split(",");
            for (String id : ids) {
                groupsProductMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public void updGroup(GroupsProduct product) {
        String nowtime=CommonUtils.nowtime();
        if( product.getpCreatetime().compareTo(nowtime)<0){
            product.setaStatus(2);
        }
        groupsProductMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public List<GroupsProduct> checkPId(Integer pId) {
        GroupsProductExample example=new GroupsProductExample();
        example.setOrderByClause("id desc");
        GroupsProductExample.Criteria criteria=example.createCriteria();
        criteria.andPIdEqualTo(pId);
        return groupsProductMapper.selectByExample(example);
    }

    @Override
    public WxResult groupIndex(Integer id, HttpServletRequest request) {
        try {
            Map map=new HashMap();
            List<Users> usersList=new ArrayList<>();
            //根据团单id找出团长
            GroupsBill bill=billMapper.selectByPrimaryKey(id);
            Users users=usersMapper.selectByPrimaryKey(bill.getuId());
            if(users!=null){
                users.setIsBill(1);
                usersList.add(users);
            }
            //根据团单id查找团员
            GroupsBillExample example=new GroupsBillExample();
            GroupsBillExample.Criteria criteria=example.createCriteria();
            criteria.andTIdEqualTo(id);
            List<GroupsBill> billList=billMapper.selectByExample(example);
            List<Integer> uIds=new ArrayList<>();
            for (GroupsBill groupsBill : billList) {
                uIds.add(groupsBill.getuId());
            }
            if(uIds.size()>0){
                UsersExample example1=new UsersExample();
                UsersExample.Criteria criteria1=example1.createCriteria();
                criteria1.andUIdIn(uIds);
                List<Users> usersList1=usersMapper.selectByExample(example1);
                for (Users users1 : usersList1) {
                    users1.setIsBill(0);
                    usersList.add(users1);
                }
            }

            //参团人员
            map.put("usersList",usersList);
            String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                    request.getServerPort()+"/ssm/file/showPic?fileName=";
            //拼团商品主键id查找拼团内容
            GroupsProduct product=groupsProductMapper.selectByPrimaryKey(bill.getbId());
            product.setpImage(saveUrl+product.getpImage());
            map.put("product",product);
            return WxResult.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return WxResult.fail("操作失败");
        }
    }
}
