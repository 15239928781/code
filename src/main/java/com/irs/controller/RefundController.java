package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.Refund;
import com.irs.pojo.Teacher;
import com.irs.service.RefundService;
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
public class RefundController {

    @Autowired
    private RefundService refundService;

    @RequestMapping("/refundList")
    @RequiresPermissions("sys:refund:list")
    public String refundList() {
        return "page/refund/refundList";
    }

    @RequestMapping("getRefundList")
    @RequiresPermissions("sys:refund:list")
    @ResponseBody
    public ResultUtil getRefundList(Integer page, Integer limit, Refund search){
        return refundService.getRefundList(page,limit,search);
    }

    @RequiresPermissions("sys:refund:update")
    @RequestMapping("/editRefound")
    public String editRefound(String userStr,Model model) {
        model.addAttribute("userStr",userStr);
        return "page/refund/editRefound";
    }
    /**
     * 批量删除用户
     * @param userStr
     * @return
     *//*
    @SysLog(value="批量删除用户")
    @RequestMapping("delRefund/{userStr}")
    @RequiresPermissions("sys:refund:delete")
    @ResponseBody
    public ResultUtil delRefund(@PathVariable("userStr")String userStr){
        try {
            refundService.delRefund(userStr);
            return  ResultUtil.ok("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.error("操作失败");
        }
    }

    *//**
     * 根据ID删除用户
     * @param oId
     * @return
     *//*
    @SysLog(value="根据ID删除用户")
    @RequestMapping("delRefundById/{id}")
    @RequiresPermissions("sys:refund:delete")
    @ResponseBody
    public ResultUtil delRefundById(@PathVariable("id")String id){
        try {
            refundService.delRefundById(id);
            return  ResultUtil.ok("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.error("操作失败");
        }
    }
*/
    /**
     * 更新订单状态
     * @return
     */
    @SysLog(value="更新退款状态")
    @RequestMapping("/updateRefundOstatus/{id}/{status}")
    @RequiresPermissions("sys:refund:list")
    @ResponseBody
    public ResultUtil updateRefundOstatus(@PathVariable("id") Integer id,@PathVariable("status") Integer status) {
        try {
            refundService.updateRefundOstatus(id,status);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }

    /**
     * 更新讲师信息
     * @param teacher
     * @return
     */
    @SysLog(value="更新信息")
    @RequestMapping("/updRefound")
    @RequiresPermissions("sys:refund:update")
    @ResponseBody
    public ResultUtil updRefound(Refund refund) {
        try {
            refundService.updRefound(refund);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }
}
