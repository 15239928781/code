package com.irs.controller;


import com.irs.pojo.ProductItem;
import com.irs.pojo.ShopOrders;
import com.irs.pojo.ShopProduct;
import com.irs.pojo.ShopProductExample;
import com.irs.pojo.vo.ProductSaleVo;
import com.irs.service.IntegralUseService;
import com.irs.service.OrdersService;
import com.irs.service.ProductService;
import com.irs.service.UsersService;
import com.irs.util.JsonUtils;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("sys/")
public class IndexController {


    @Autowired
    private OrdersService ordersService;
    @Autowired
    private IntegralUseService integralUseService;
    @RequestMapping("/numList")
    public String carouselList() {
        return "page/numList";
    }
    /*
     *获取首页的统计
     */
    @RequestMapping("/getIndex")
    @ResponseBody
    public ResultUtil getIndex(){

        System.out.println("sss");
        return ordersService.getIndex();
    }

    @RequestMapping("/sumTotalByTime")
    @ResponseBody
    public ResultUtil sumTotalByTime(String createTimeStart,String createTimeEnd){
        return ordersService.sumTotalByTime(createTimeStart,createTimeEnd);
    }

    /*
     *请求首页的素材排行
     */
    @RequestMapping("/propaihang")
    @ResponseBody
    public ResultUtil propaihang(Integer page, Integer limit,ProductSaleVo productSaleVo){
       return integralUseService.getpropaihang(page,limit,productSaleVo);
    }

    /*
     * 图表统计
     */
    @RequestMapping("/getTalbymoth")
    @ResponseBody
    public String getTalbymoth(){
        WxResult result  = ordersService.getTalbymoth();
        return JsonUtils.objectToJson(result);
    }

    /*
     *请求首页的素材排行
     */
    @RequestMapping("/propaihang2")
    @ResponseBody
    public ResultUtil propaihang2(Integer oState){
        List<ProductSaleVo> saleVos = integralUseService.getpropaihang2(oState);
        return ResultUtil.ok(saleVos);
    }
}
