package com.irs.service;

import com.irs.pojo.Customer;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

public interface CustomerService {
    Customer selCustomerById(Integer id);

    ResultUtil getCustomerList(Integer page, Integer limit);

    void insCustomer(Customer customer);

    void updCustomer(Customer customer);

    WxResult getCustomer(Integer type);
}
