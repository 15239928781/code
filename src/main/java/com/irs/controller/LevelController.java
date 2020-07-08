package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.Level;
import com.irs.service.LevelService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("level/")
public class LevelController {

    @Autowired
    private LevelService levelService;

    @RequestMapping("/levelList")
    public String carouselList() {
        return "page/level/levelList";
    }

    @RequiresPermissions("level:level:save")
    @RequestMapping("/addLevel")
    public String addCarousel() {
        return "page/level/addLevel";
    }

    @RequiresPermissions("level:level:save")
    @RequestMapping("/editLevel")
    public String editLevel(Integer id, Model model) {
        Level level=levelService.selLevelById(id);
        model.addAttribute("level",level);
        return "page/level/editLevel";
    }

    @RequestMapping("/list")
    @RequiresPermissions("level:level:list")
    @ResponseBody
    public ResultUtil getCarouseList(Integer page, Integer limit) {
        ResultUtil level = levelService.setLevel(page, limit);
        return level;
    }

    /**
     * 添加会员等级信息
     * @param level
     * @return
     */
    @SysLog(value="添加会员等级信息")
    @RequestMapping("/save")
    @RequiresPermissions("level:level:save")
    @ResponseBody
    public ResultUtil insLevel(Level level) {
        try {
            levelService.insLevel(level);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }
    /**
     * 更新会员等级信息
     * @param level
     * @return
     */
    @SysLog(value="更新会员等级信息")
    @RequestMapping("/update")
    @RequiresPermissions("level:level:update")
    @ResponseBody
    public ResultUtil updLevel(Level level) {
        try {
            levelService.updLevel(level);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    /**
     * 删除指定的会员等级
     * @param id
     * @return
     */
    @SysLog(value="删除指定的会员等级")
    @RequestMapping("/delete")
    @RequiresPermissions("level:level:delete")
    @ResponseBody
    public ResultUtil delLevelById(Integer id) {
        try {
            levelService.delLevelById(id);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }

    /**
     * 批量删除会员等级
     * @param carouselStr
     * @return
     */
    @SysLog(value="批量删除会员等级")
    @RequestMapping("/deletes")
    @RequiresPermissions("level:level:delete")
    @ResponseBody
    public ResultUtil delLevel(String carouselStr) {
        try {
            levelService.delLevel(carouselStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    //校验等级名是否存在
    @RequestMapping("checkLevelByleName")
    @ResponseBody
    public ResultUtil checkLevelByleName(String leName){
        Level level = levelService.checkLevelByleName(leName);
        if(level!=null){
            return new ResultUtil(500,"等级名已存在，请重新填写！");
        }
        return new ResultUtil(0);
    }
}
