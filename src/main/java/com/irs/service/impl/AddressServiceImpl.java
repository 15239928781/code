package com.irs.service.impl;

import com.irs.mapper.ShopAddressMapper;
import com.irs.pojo.ShopAddress;
import com.irs.pojo.ShopAddressExample;
import com.irs.service.AddressService;
import com.irs.util.WxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Address;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private ShopAddressMapper addressMapper;

    @Override
    public WxResult getAddressByUser(int uId) {
        // TODO Auto-generated method stub
        if(uId==0){
            WxResult.fail("您的小可耐走丢了！");
        }
        ShopAddressExample example=new ShopAddressExample();
        example.setOrderByClause("a_status desc");
        ShopAddressExample.Criteria criteria = example.createCriteria();
        criteria.andUIdEqualTo(uId);
        List<ShopAddress> list=addressMapper.selectByExample(example);
        return WxResult.ok(list);
    }

    @Override
    public WxResult addAddress(ShopAddress address) {
        try {
            ShopAddressExample example=new ShopAddressExample();
            ShopAddressExample.Criteria criteria = example.createCriteria();
            criteria.andUIdEqualTo(address.getuId());

            long count=addressMapper.countByExample(example);
            ShopAddressExample example1=new ShopAddressExample();
            ShopAddressExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andUIdEqualTo(address.getuId());
            criteria1.andAStatusEqualTo(1);
            long countdefault=addressMapper.countByExample(example1);
            if(count<=0){
                address.setaStatus(1);
                addressMapper.insertSelective(address);
            }else if(countdefault<=0){
                address.setaStatus(1);
                addressMapper.insertSelective(address);
            }else if(address.getaStatus()==1){
                ShopAddress address1=new ShopAddress();
                address1.setaStatus(0);
                addressMapper.updateByExampleSelective(address1, example);
                addressMapper.insertSelective(address);
            }else{
                addressMapper.insertSelective(address);
            }

        } catch (Exception e) {
            WxResult.fail("请求异常！");
        }
        return WxResult.ok();
    }

    @Override
    public WxResult editAddress(ShopAddress address) {
        try {
            ShopAddress add=addressMapper.selectByPrimaryKey(address.getaId());
            ShopAddressExample example=new ShopAddressExample();
            ShopAddressExample.Criteria criteria = example.createCriteria();
            criteria.andUIdEqualTo(add.getuId());
//			int count=addressMapper.countByExample(example);
            if(address.getaStatus()==1){
                ShopAddress address1=new ShopAddress();
                address1.setaStatus(0);
                addressMapper.updateByExampleSelective(address1, example);
                addressMapper.updateByPrimaryKeySelective(address);
            }else{
                addressMapper.updateByPrimaryKeySelective(address);
            }

        } catch (Exception e) {
            WxResult.fail("请求异常！");
        }
        return WxResult.ok();
    }

    @Override
    public WxResult delAddress(int aId, int aStatus, int uId) {
        try {
            if(aId==0||uId==0){
                WxResult.build(600, "你的小可爱走丢了呢！");
            }
            ShopAddressExample example=new ShopAddressExample();
            ShopAddressExample.Criteria criteria = example.createCriteria();
            criteria.andAIdEqualTo(aId);
            addressMapper.deleteByPrimaryKey(aId);
            if(aStatus==1){
                ShopAddress ad=addressMapper.getFirstAddress(uId);
                ad.getaId();
                if(ad.getaId()!=0){
                    ad.setaStatus(1);
                    addressMapper.updateByPrimaryKeySelective(ad);
                }
            }
        } catch (Exception e) {
            WxResult.fail("请求异常！");
        }
        return WxResult.ok();
    }

    @Override
    public WxResult getDefaultAddress(int uId) {
        ShopAddressExample example=new ShopAddressExample();
        ShopAddressExample.Criteria criteria = example.createCriteria();
        criteria.andUIdEqualTo(uId);
        criteria.andAStatusEqualTo(1);
        return WxResult.ok(addressMapper.selectByExample(example));
    }
}
