package com.irs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zc
 * @create 2019 - 03 - 15
 *
 * 微信支付接口
 **/
@Controller
public class WxpayController {

    @RequestMapping("wxpay")
    public String wxpay(
            HttpServletRequest request,
            @RequestParam(value="uId",defaultValue="0")String uid,
            @RequestParam(value="pId",defaultValue="0")String pid,
            @RequestParam(value = "price",defaultValue = "0")String price,
            @RequestParam(value = "token",defaultValue = "0")String token){


        return "";
    }
}
