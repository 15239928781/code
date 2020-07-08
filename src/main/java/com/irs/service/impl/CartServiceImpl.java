package com.irs.service.impl;

import com.irs.mapper.ShopCartMapper;
import com.irs.mapper.ShopCategoryMapper;
import com.irs.mapper.TbUsersMapper;
import com.irs.mapper.UsersMapper;
import com.irs.pojo.*;
import com.irs.service.CartService;
import com.irs.util.WxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ShopCartMapper cartMapper;

    @Autowired
    private UsersMapper usersMapper;
    @Override
    public WxResult getCart(int uId, HttpServletRequest request) {
        if(uId==0){
            WxResult.build(400, "参数不能为空！");
        }

        List<ShopCart> list=cartMapper.getCartByUid(uId);
        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort()+"/ssm/file/showPic?fileName=";
        for (ShopCart shopCart : list) {
            shopCart.setpImage(saveUrl+shopCart.getpImage());
        }
        return WxResult.ok(list);
    }

    @Override
    public WxResult addCart(ShopCart cart) {
        Date d = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            ShopCartExample example=new ShopCartExample();
            ShopCartExample.Criteria criteria = example.createCriteria();
            criteria.andPIdEqualTo(cart.getpId());
            criteria.andUIdEqualTo(cart.getuId());
            List<ShopCart> clist= cartMapper.selectByExample(example);
            if(clist!=null&&clist.size()>0){
                int s= clist.get(0).getNum();
                cart.setNum(cart.getNum()+clist.get(0).getNum());
                cart.setEdittime(sf.format(d));
                cartMapper.updateByExampleSelective(cart, example);
            }else{
                cart.setAddtime(sf.format(d));
                cartMapper.insertSelective(cart);
            }

        } catch (Exception e) {
            return	WxResult.build(400, "请求异常！");
        }
        return WxResult.build(200, "成功！");
    }

    @Override
    public WxResult deleteCart(String cId) {
        cartMapper.deleteByPrimaryKey(Integer.valueOf(cId));
        return WxResult.build(200, "删除成功！");
    }

    @Override
    public WxResult addPassward(int uId,String uRealname, String uPassword) {


        Users tbUsers = usersMapper.selectByPrimaryKey(uId);
        if(!uRealname.equals("")&&!uPassword.equals("")){
            UsersExample usersExample = new UsersExample();
            UsersExample.Criteria criteria = usersExample.createCriteria();
            criteria.andURealnameEqualTo(uRealname);
            List<Users> users = usersMapper.selectByExample(usersExample);
            if (users != null && users.size() > 0) {
                return  WxResult.build(500,"账号已经存在");
            }else{
                tbUsers.setuRealname(uRealname);
                tbUsers.setuPassword(uPassword);
                usersMapper.updateByPrimaryKey(tbUsers);
                return WxResult.build(200,"更新成功",uRealname);
            }



        }else if(!uRealname.equals("")&&uPassword.equals("")){
            UsersExample usersExample = new UsersExample();
            UsersExample.Criteria criteria = usersExample.createCriteria();
            criteria.andURealnameEqualTo(uRealname);
            List<Users> users = usersMapper.selectByExample(usersExample);
            if (users != null && users.size() > 0) {
                return  WxResult.build(500,"账号已经存在");
            }else{
                tbUsers.setuRealname(uRealname);
                //tbUsers.setuPassword(uPassword);
                usersMapper.updateByPrimaryKey(tbUsers);
                return WxResult.build(200,"更新成功",uRealname);
            }
        }else if(!uPassword.equals("")&&uRealname.equals("")){
            //tbUsers.setuIntroduction(uIntroduction);
            tbUsers.setuPassword(uPassword);
            usersMapper.updateByPrimaryKey(tbUsers);
            return WxResult.ok();
        }else {
            return WxResult.fail("请输入数据");
        }


    }

}
