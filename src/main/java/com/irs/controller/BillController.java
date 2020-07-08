package com.irs.controller;

import com.irs.pojo.GroupsBill;
import com.irs.service.GroupsBillService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys/")
public class BillController {

    @Autowired
    private GroupsBillService billService;

    @RequestMapping("billList")
    @RequiresPermissions("sys:bill:list")
    public String userList(){
        return "page/bill/billList";
    }

    @RequestMapping("getBillList")
    @RequiresPermissions("sys:bill:list")
    @ResponseBody
    public ResultUtil getBillList(Integer page, Integer limit, GroupsBill search){
        return billService.getBillList(page,limit,search);
    }
}
