package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.ProductItem;
import com.irs.pojo.ShopCategory;
import com.irs.pojo.ShopProduct;
import com.irs.pojo.Teacher;
import com.irs.service.ProductItemService;
import com.irs.service.ProductService;
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
public class ProductItemController {

    @Autowired
    private ProductItemService productItemService;

    @Autowired
    private ProductService productService;

    //获取课程列表
    @RequestMapping("/pItemList")
    public String pItemList(Integer pId,Model model) {
        List<ShopProduct> list=productService.getAll(0);
        model.addAttribute("list",list);
        model.addAttribute("pId",pId);
        return "page/pItem/pItemList";
    }

    @RequiresPermissions("sys:product:save")
    @RequestMapping("/addPItem")
    public String addCategory(Integer pId,Model model) {
        List<ShopProduct> list=productService.getAll(0);
        model.addAttribute("list",list);
        model.addAttribute("pId",pId);
        return "page/pItem/addPItem";
    }

    @RequiresPermissions("sys:product:update")
    @RequestMapping("/editPItem")
    public String editPItem(Integer id, Model model) {
        ProductItem productItem=productItemService.selPItemById(id);
        model.addAttribute("productItem",productItem);
        //课题名
        List<ShopProduct> list=productService.getAll(0);
        model.addAttribute("list",list);
        return "page/pItem/editPItem";
    }

    @RequestMapping("/getPItemList")
    @RequiresPermissions("sys:product:list")
    @ResponseBody
    public ResultUtil getPItemList(Integer page, Integer limit, ProductItem search) {
        ResultUtil productItem = productItemService.getPItemList(page, limit,search);
        return productItem;
    }

    /**
     * 添加讲师信息
     * @param productItem
     * @return
     */
    @SysLog(value="添加课程信息")
    @RequestMapping("/insPItem")
    @RequiresPermissions("sys:product:save")
    @ResponseBody
    public ResultUtil insPItem(ProductItem productItem) {
        System.out.println(productItem.toString());
        try {
            productItemService.insPItem(productItem);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }


    /**
     * 删除指定的课程信息
     * @param id
     * @return
     */
    @SysLog(value="删除指定的课程信息")
    @RequestMapping("/delPItemById")
    @RequiresPermissions("sys:product:delete")
    @ResponseBody
    public ResultUtil delPItemById(Integer id) {
        try {
            productItemService.delPItemById(id);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }

    /**
     * 批量删除课程信息
     * @param carouselStr
     * @return
     */
    @SysLog(value="批量删除课程信息")
    @RequestMapping("/delPItem")
    @RequiresPermissions("sys:product:delete")
    @ResponseBody
    public ResultUtil delPItem(String carouselStr) {
        try {
            productItemService.delPItem(carouselStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    /**
     * 更新课程信息
     * @param productItem
     * @return
     */
    @SysLog(value="更新课程信息")
    @RequestMapping("/updPItem")
    @RequiresPermissions("sys:teacher:update")
    @ResponseBody
    public ResultUtil updPItem(ProductItem productItem) {
        System.out.println(productItem.toString()+"********************************************************************************");
        try {
            productItemService.updPItem(productItem);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }
}
