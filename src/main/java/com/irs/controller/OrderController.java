package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.ShopOrderitem;
import com.irs.pojo.ShopOrders;
import com.irs.service.OrdersService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys/")
public class OrderController {

    @Autowired
    private OrdersService ordersService;


    @RequestMapping("/orderList")
    @RequiresPermissions("sys:order:list")
    public String orderList() {
        return "page/order/orderList";
    }

    @RequestMapping("getOrdersList")
    @RequiresPermissions("sys:order:list")
    @ResponseBody
    public ResultUtil getOrdersList(Integer page, Integer limit, ShopOrders search){
        return ordersService.getOrdersList(page,limit,search);
    }

    @RequestMapping("/orderItemList")
    @RequiresPermissions("sys:order:list")
    public String orderItemList(Model model,Integer oId) {
        model.addAttribute("oId",oId);
        return "page/order/orderItemList";
    }

    /**
     * 批量删除用户
     * @param userStr
     * @return
     */
    @SysLog(value="批量删除用户")
    @RequestMapping("delOrders/{userStr}")
    @RequiresPermissions("sys:order:delete")
    @ResponseBody
    public ResultUtil delOrders(@PathVariable("userStr")String userStr){
        try {
            ordersService.delOrders(userStr);
            return  ResultUtil.ok("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.error("操作失败");
        }
    }

    /**
     * 根据ID删除用户
     * @param oId
     * @return
     */
    @SysLog(value="根据ID删除用户")
    @RequestMapping("delOrderByOid/{oId}")
    @RequiresPermissions("sys:order:delete")
    @ResponseBody
    public ResultUtil delOrderByOid(@PathVariable("oId")String oId){
        try {
            ordersService.delOrderByOid(oId);
            return  ResultUtil.ok("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.error("操作失败");
        }
    }

    /**
     * 更新订单状态
     * @return
     */
    @SysLog(value="更新订单状态")
    @RequestMapping("/update/{id}/{status}")
    @RequiresPermissions("sys:order:list")
    @ResponseBody
    public ResultUtil updCarouselStatusById(@PathVariable("id") Integer id,@PathVariable("status") Integer status) {
        try {
            ordersService.updateOStatus(String.valueOf(id));
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }

    @RequestMapping("getOrderItemList")
    @RequiresPermissions("sys:order:list")
    @ResponseBody
    public ResultUtil getOrderItemList(Integer page, Integer limit, ShopOrderitem search){
        return ordersService.getOrderItemList(page,limit,search);
    }

    /**
     * 批量删除用户
     * @param userStr
     * @return
     */
    @SysLog(value="批量删除用户")
    @RequestMapping("delOrderItem/{userStr}")
    @RequiresPermissions("sys:order:delete")
    @ResponseBody
    public ResultUtil delOrderItem(@PathVariable("userStr")String userStr){
        try {
            ordersService.delOrderItem(userStr);
            return  ResultUtil.ok("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.error("操作失败");
        }
    }

    /**
     * 根据ID删除用户
     * @param oId
     * @return
     */
    @SysLog(value="根据ID删除用户")
    @RequestMapping("delOrderItemByOid/{oId}")
    @RequiresPermissions("sys:order:delete")
    @ResponseBody
    public ResultUtil delOrderItemByOid(@PathVariable("oId")String oId){
        try {
            ordersService.delOrderItemByOid(oId);
            return  ResultUtil.ok("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.error("操作失败");
        }
    }


}
