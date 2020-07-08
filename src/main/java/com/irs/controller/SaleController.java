package com.irs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zc
 * @create 2019 - 03 - 18
 **/
@RequestMapping("sys")
@Controller
public class SaleController {

    @RequestMapping("saleList")
    public String salelist(){
        return "page/sala/salalist";
    }
}
