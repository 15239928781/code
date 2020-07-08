package com.irs.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.*;
import com.irs.pojo.*;
import com.irs.service.BrowseService;
import com.irs.util.CommonUtils;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.*;

@Service
public class BrowseServiceImpl implements BrowseService {

    @Autowired
    private ShopProductMapper shopProductMapper ;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ShopBrowseMapper browseMapper;
    @Autowired
    private ShopProductMapper productMapper;
    @Autowired
    private LevelMapper levelMapper;

    @Override
    public WxResult addBrowse(ShopBrowse browse) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        browse.setbTime(sdf.format(d));
        try {
            browseMapper.insert(browse);
        } catch (Exception e) {
            return WxResult.build(400, "操作异常！");
        }
        return WxResult.ok();
    }

    @Override
    public ResultUtil getBrowseList(Integer page, Integer limit,Integer btype/*, ShopBrowse search*/) {
        PageHelper.startPage(page,limit);
        //先查询用户浏览的商品
        String time=null;
        if (btype!=null && btype!=-1){
            if (btype.equals(1)){
                time=CommonUtils.todayTime()+"%";
            }else if(btype.equals(2)){
                 time=CommonUtils.monthTime()+"%";
            }else if(btype.equals(3)){
                 time=CommonUtils.yearTime()+"%";
            }
        }
        List<ShopBrowse> browseList;
        if (btype!=null && btype!=-1){
             browseList=browseMapper.getAll(time);
        }else {
            browseList=browseMapper.getAll2();
        }

        List<ShopBrowse> browseList2=new ArrayList<>();
        for (ShopBrowse shopBrowse : browseList) {
            ShopBrowseExample example1=new ShopBrowseExample();
            ShopBrowseExample.Criteria criteria1=example1.createCriteria();
            Integer integer = shopBrowse.getpId();
            if(integer!=null){
                criteria1.andPIdEqualTo(integer);
            }
            long count=browseMapper.countByExample(example1);
            shopBrowse.setpNum(count);
            //根据商品id查询商品名称
            ShopProduct product=productMapper.selectByPrimaryKey(integer);
            if (product!=null){
                shopBrowse.setpName(product.getpName());
                browseList2.add(shopBrowse);
            }
        }
        PageInfo<ShopBrowse> pageInfo = new PageInfo<ShopBrowse>(browseList);
        pageInfo.setSize(limit);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }
    @Override
    public ResultUtil getUserBrowseList(Integer page, Integer limit, Integer bId) {
        PageHelper.startPage(page,limit);
        ShopBrowse shopBrowse = browseMapper.selectByPrimaryKey(bId);

        ShopBrowseExample example1=new ShopBrowseExample();
        ShopBrowseExample.Criteria criteria1=example1.createCriteria();
        criteria1.andPIdEqualTo(shopBrowse.getpId());
        List<ShopBrowse> shopBrowses = browseMapper.selectByExample(example1);

        List<Integer> uIdList = new ArrayList<Integer>();
        for(ShopBrowse shopBrowse2 :shopBrowses){
            Integer integer = shopBrowse2.getuId();
            uIdList.add(integer);
        }
        Set<Integer> set = new HashSet<>();
        set.addAll(uIdList);
        List<Integer> uIdList2 = new ArrayList<Integer>();
        uIdList2.addAll(set);
        UsersExample example12=new UsersExample();
        UsersExample.Criteria criteria12=example12.createCriteria();
        criteria12.andUIdIn(uIdList2);
        List<Users> usersList = usersMapper.selectByExample(example12);
        for(Users users:usersList){
            Level level = levelMapper.selectByPrimaryKey(users.getuLevel());
            String leName = level.getLeName();
            users.setLevelName(leName);
        }

        PageInfo<Users> pageInfo = new PageInfo<Users>(usersList);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }


}
