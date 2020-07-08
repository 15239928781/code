package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.Customer;
import com.irs.service.CustomerService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("customerList")
    public String customerList() {
        return "page/customer/customerList";
    }

    @RequiresPermissions("sys:customer:save")
    @RequestMapping("/addCustomer")
    public String addCustomer() {
        return "page/customer/addCustomer";
    }

    @RequiresPermissions("sys:customer:update")
    @RequestMapping("/editCustomer")
    public String editCustomer(Integer id, Model model) {
        Customer customer=customerService.selCustomerById(id);
        model.addAttribute("customer",customer);
        return "page/customer/editCustomer";
    }

    @RequestMapping("/getCustomerList")
    @RequiresPermissions("sys:customer:list")
    @ResponseBody
    public ResultUtil getCustomerList(Integer page, Integer limit) {
        ResultUtil customer = customerService.getCustomerList(page, limit);
        return customer;
    }

    /**
     * 添加电话
     * @param customer
     * @return
     */
    @SysLog(value="添加客服电话")
    @RequestMapping("/insCustomer")
    @RequiresPermissions("sys:customer:save")
    @ResponseBody
    public ResultUtil insCustomer(Customer customer) {
        try {
            customerService.insCustomer(customer);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }
    /**
     * 更新客服电话
     * @param integralUse
     * @return
     */
    @SysLog(value="更新客服电话")
    @RequestMapping("/updCustomer")
    @RequiresPermissions("sys:customer:update")
    @ResponseBody
    public ResultUtil updCustomer(Customer customer) {
        try {
            customerService.updCustomer(customer);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("更新出错,稍后再试！");
        }
    }



}
