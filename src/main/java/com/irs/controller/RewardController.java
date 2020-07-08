package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.IntegralUse;
import com.irs.pojo.IntegralsReward;
import com.irs.service.RewardService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("reward/")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @RequestMapping("/rewardList")
    public String rewardList() {
        return "page/reward/rewardList";
    }

    @RequiresPermissions("reward:reward:save")
    @RequestMapping("/addReward")
    public String addReward() {
        return "page/reward/addReward";
    }

    @RequiresPermissions("reward:reward:update")
    @RequestMapping("/editReward")
    public String editReward(Integer id, Model model) {
        IntegralsReward reward=rewardService.selLevelById(id);
        model.addAttribute("reward",reward);
        return "page/reward/editReward";
    }

    @RequestMapping("/list")
    @RequiresPermissions("reward:reward:list")
    @ResponseBody
    public ResultUtil getRewardList(Integer page, Integer limit) {
        ResultUtil reward = rewardService.getRewardList(page, limit);
        return reward;
    }

    /**
     * 添加积分奖励规则
     * @param reward
     * @return
     */
    @SysLog(value="添加积分奖励规则")
    @RequestMapping("/save")
    @RequiresPermissions("reward:reward:save")
    @ResponseBody
    public ResultUtil insReward(IntegralsReward reward) {
        try {
            rewardService.insReward(reward);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }
    /**
     * 更新积分奖励规则
     * @param reward
     * @return
     */
    @SysLog(value="更新积分奖励规则")
    @RequestMapping("/update")
    @RequiresPermissions("reward:reward:update")
    @ResponseBody
    public ResultUtil updReward(IntegralsReward reward) {
        try {
            rewardService.updReward(reward);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    /**
     * 删除指定的积分奖励
     * @param id
     * @return
     */
    @SysLog(value="删除指定的积分奖励")
    @RequestMapping("/delete")
    @RequiresPermissions("reward:reward:delete")
    @ResponseBody
    public ResultUtil delLevelById(Integer id) {
        try {
            rewardService.delLevelById(id);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }

    /**
     * 批量删除积分奖励
     * @param carouselStr
     * @return
     */
    @SysLog(value="批量删除积分奖励")
    @RequestMapping("/deletes")
    @RequiresPermissions("reward:reward:delete")
    @ResponseBody
    public ResultUtil delReward(String carouselStr) {
        try {
            rewardService.delReward(carouselStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    //校验等级名是否存在
    @RequestMapping("checkRewardByPrices")
    @ResponseBody
    public ResultUtil checkRewardByPrices(String prices){
        IntegralsReward reward = rewardService.checkRewardByPrices(prices);
        if(reward!=null){
            return new ResultUtil(500,"积分奖励中的价格已存在，请重新填写！");
        }
        return new ResultUtil(0);
    }
}
