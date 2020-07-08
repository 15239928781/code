package com.irs.service.impl;

import com.github.pagehelper.PageInfo;
import com.irs.mapper.CustomerMapper;
import com.irs.pojo.Customer;
import com.irs.pojo.CustomerExample;
import com.irs.service.CustomerService;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer selCustomerById(Integer id) {

        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultUtil getCustomerList(Integer page, Integer limit) {
        CustomerExample example=new CustomerExample();
        example.setOrderByClause("id desc");
        CustomerExample.Criteria criteria=example.createCriteria();
        List<Customer> list=customerMapper.selectByExample(example);
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void insCustomer(Customer customer) {
        customerMapper.insertSelective(customer);
    }

    @Override
    public void updCustomer(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public WxResult getCustomer(Integer type) {
        CustomerExample example=new CustomerExample();
        example.setOrderByClause("id desc");
        CustomerExample.Criteria criteria=example.createCriteria();
        criteria.andTypeEqualTo(type);
        List<Customer> list=customerMapper.selectByExample(example);
        Map map=new HashMap();
        map.put("customer",list.get(0));
        return WxResult.ok(map);
    }
}
