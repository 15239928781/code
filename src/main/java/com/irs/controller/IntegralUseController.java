package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.IntegralUse;
import com.irs.pojo.Level;
import com.irs.service.IntegralUseService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("integralUse/")
public class IntegralUseController {

    @Autowired
    private IntegralUseService integralUseService;

    @RequestMapping("/integralUseList")
    public String carouselList() {
        return "page/integralUse/integralUseList";
    }

    @RequiresPermissions("integralUse:integralUse:save")
    @RequestMapping("/addIntegralUse")
    public String addCarousel() {
        return "page/integralUse/addIntegralUse";
    }

    @RequiresPermissions("integralUse:integralUse:update")
    @RequestMapping("/editIntegralUse")
    public String editLevel(Integer id, Model model) {
        IntegralUse integralUse=integralUseService.selLevelById(id);
        model.addAttribute("integralUse",integralUse);
        return "page/integralUse/editIntegralUse";
    }

    @RequestMapping("/list")
    @RequiresPermissions("integralUse:integralUse:list")
    @ResponseBody
    public ResultUtil getIntegralUseList(Integer page, Integer limit) {
        ResultUtil integralUse = integralUseService.getIntegralUseList(page, limit);
        return integralUse;
    }

    /**
     * 添加积分使用规则
     * @param integralUse
     * @return
     */
    @SysLog(value="添加积分使用规则")
    @RequestMapping("/save")
    @RequiresPermissions("integralUse:integralUse:save")
    @ResponseBody
    public ResultUtil insIntegralUse(IntegralUse integralUse) {
        try {
            integralUseService.insIntegralUse(integralUse);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }
    /**
     * 更新积分使用规则
     * @param integralUse
     * @return
     */
    @SysLog(value="更新积分使用规则")
    @RequestMapping("/update")
    @RequiresPermissions("integralUse:integralUse:update")
    @ResponseBody
    public ResultUtil updIntegralUse(IntegralUse integralUse) {
        try {
            integralUseService.updIntegralUse(integralUse);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    /**
     * 删除指定的积分等级
     * @param id
     * @return
     */
    @SysLog(value="删除指定的积分等级")
    @RequestMapping("/delete")
    @RequiresPermissions("integralUse:integralUse:delete")
    @ResponseBody
    public ResultUtil delLevelById(Integer id) {
        try {
            integralUseService.delLevelById(id);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }

    /**
     * 批量删除积分等级
     * @param carouselStr
     * @return
     */
    @SysLog(value="批量删除积分等级")
    @RequestMapping("/deletes")
    @RequiresPermissions("integralUse:integralUse:delete")
    @ResponseBody
    public ResultUtil delIntegralUse(String carouselStr) {
        try {
            integralUseService.delIntegralUse(carouselStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    //校验等级名是否存在
    @RequestMapping("checkIntegralUseByPrices")
    @ResponseBody
    public ResultUtil checkIntegralUseByPrices(String num){
        IntegralUse integralUse = integralUseService.checkIntegralUseByPrices(num);
        if(integralUse!=null){
            return new ResultUtil(500,"积分数量已存在，请重新填写！");
        }
        return new ResultUtil(0);
    }

}
