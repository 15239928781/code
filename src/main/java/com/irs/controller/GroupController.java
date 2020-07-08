package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.GroupsProduct;
import com.irs.pojo.ShopProduct;
import com.irs.pojo.Teacher;
import com.irs.service.GroupsProductService;
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
public class GroupController {

    @Autowired
    private GroupsProductService groupsProductService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/groupList")
    public String groupList() {
        return "page/group/GroupList";
    }

    @RequiresPermissions("sys:group:save")
    @RequestMapping("/addGroup")
    public String addGroup(Model model) {
        List<ShopProduct> list=productService.getAll(2);
        model.addAttribute("list",list);
        return "page/group/addGroup";
    }

    @RequiresPermissions("sys:group:update")
    @RequestMapping("/editGroup")
    public String editGroup(Integer id, Model model) {
        GroupsProduct group=groupsProductService.selGroupById(id);
        model.addAttribute("group",group);
        List<ShopProduct> list=productService.getAll(2);
        model.addAttribute("list",list);
        return "page/group/editGroup";
    }

    @RequestMapping("/getGroupList")
    @RequiresPermissions("sys:group:list")
    @ResponseBody
    public ResultUtil getGroupList(Integer page, Integer limit, GroupsProduct product) {
        ResultUtil groupList = groupsProductService.getGroupList(page, limit,product);
        return groupList;
    }

    /**
     * 校验商品是否添加
     * @param pId
     * @return
     */
    @SysLog(value="添加团购商品信息")
    @RequestMapping("/checkPId")
    @RequiresPermissions("sys:group:save")
    @ResponseBody
    public ResultUtil checkPId(Integer pId) {
        try {
           List<GroupsProduct> list= groupsProductService.checkPId(pId);
           if (list.size()>0){
               return new ResultUtil(500,"拼团商品已存在，请重新添加");
           }
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
        return null;
    }

    /**
     * 添加团购商品信息
     * @param product
     * @return
     */
    @SysLog(value="添加团购商品信息")
    @RequestMapping("/insGroup")
    @RequiresPermissions("sys:group:save")
    @ResponseBody
    public ResultUtil insGroup(GroupsProduct product) {
        try {
            int i=groupsProductService.insGroup(product);
            if (i>0){
                return ResultUtil.ok();
            }else {
                return ResultUtil.error("拼团商品已存在");
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
    @RequestMapping("/delGroupById")
    @RequiresPermissions("sys:group:delete")
    @ResponseBody
    public ResultUtil delGroupById(Integer id) {
        try {
            groupsProductService.delGroupById(id);
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
    @RequestMapping("/delGroup")
    @RequiresPermissions("sys:group:delete")
    @ResponseBody
    public ResultUtil delGroup(String carouselStr) {
        try {
            groupsProductService.delGroup(carouselStr);
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
    @RequestMapping("/updGroup")
    @RequiresPermissions("sys:teacher:update")
    @ResponseBody
    public ResultUtil updGroup(GroupsProduct teacher) {
        try {
            groupsProductService.updGroup(teacher);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }
}
