package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.GroupsProduct;
import com.irs.pojo.ShopProduct;
import com.irs.pojo.SpikeProduct;
import com.irs.service.ProductService;
import com.irs.service.SpikeService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("sys/")
public class SpikeController {

    @Autowired
    private SpikeService spikeService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/spikeList")
    public String spikeList() {
        return "page/spike/SpikeList";
    }

    @RequiresPermissions("sys:spike:save")
    @RequestMapping("/addSpike")
    public String addSpike(Model model) {
        List<ShopProduct> list=productService.getAll(1);
        model.addAttribute("list",list);
        return "page/spike/addSpike";
    }

    @RequiresPermissions("sys:spike:update")
    @RequestMapping("/editSpike")
    public String editSpike(Integer id, Model model) {
        SpikeProduct spike=spikeService.selSpikeById(id);
        model.addAttribute("spike",spike);
        List<ShopProduct> list=productService.getAll(1);
        model.addAttribute("list",list);
        return "page/spike/editSpike";
    }

    @RequestMapping("/getSpikeList")
    @RequiresPermissions("sys:spike:list")
    @ResponseBody
    public ResultUtil getSpikeList(Integer page, Integer limit, SpikeProduct product) {
        ResultUtil spikeList = spikeService.getSpikeList(page, limit,product);
        return spikeList;
    }


    /**
     * 添加团购商品信息
     * @param product
     * @return
     */
    @SysLog(value="添加团购商品信息")
    @RequestMapping("/insSpike")
    @RequiresPermissions("sys:spike:save")
    @ResponseBody
    public ResultUtil insSpike(SpikeProduct product) {
        try {
            int i=spikeService.insSpike(product);
            if (i>0){
                return ResultUtil.ok();
            }else {
                return ResultUtil.error("秒杀商品已存在");
            }

        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }


    /**
     * 删除指定的商品团购信息
     * @param id
     * @return
     */
    @SysLog(value="删除指定的商品团购信息")
    @RequestMapping("/delSpikeById")
    @RequiresPermissions("sys:spike:delete")
    @ResponseBody
    public ResultUtil delSpikeById(Integer id) {
        try {
            spikeService.delSpikeById(id);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }

    /**
     * 批量删除讲师信息
     * @param carouselStr
     * @return
     */
    @SysLog(value="批量删除讲师信息")
    @RequestMapping("/delSpike")
    @RequiresPermissions("sys:spike:delete")
    @ResponseBody
    public ResultUtil delSpike(String carouselStr) {
        try {
            spikeService.delSpike(carouselStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    /**
     * 更新讲师信息
     * @param teacher
     * @return
     */
    @SysLog(value="更新讲师信息")
    @RequestMapping("/updSpike")
    @RequiresPermissions("sys:spike:update")
    @ResponseBody
    public ResultUtil updSpike(SpikeProduct teacher) {
        try {
            spikeService.updSpike(teacher);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }
}
