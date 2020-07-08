package com.irs.controller;
import com.irs.pojo.ShopOrders;
import com.irs.service.BrowseService;
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
@RequestMapping("sys")
public class CountsController {

    @Autowired
    private BrowseService browseService;

    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/getBrowseUserList")
    //@RequiresPermissions("sys:browse:list")
    public String getBrowseUserList(Integer bId, Model model) {
        model.addAttribute("bId",bId);
        return "page/browse/userBrowseList";
    }
    @RequestMapping("getUserBrowseList/{bId}")
    @ResponseBody
    public ResultUtil getUserBrowseList(Integer page, Integer limit, @PathVariable("bId") Integer bId/*,ShopBrowse search*/){
        return browseService.getUserBrowseList(page,limit,bId/*,search*/);
    }

    @RequestMapping("/browseList")
    @RequiresPermissions("sys:browse:list")
    public String browseList() {
        return "page/browse/browseList";
    }

    @RequestMapping("getBrowseList")
    @RequiresPermissions("sys:browse:list")
    @ResponseBody
    public ResultUtil getBrowseList(Integer page, Integer limit, Integer btype/*,ShopBrowse search*/){
        return browseService.getBrowseList(page,limit,btype/*,search*/);
    }
    /**
     * 根据老师的销量排行
     */
    @RequestMapping("getTeacherNumList")
    @RequiresPermissions("sys:teacherNum:list")
    @ResponseBody
    public ResultUtil getTeacherNumList(Integer page, Integer limit,ShopOrders orders){
        return ordersService.getTeacherNumList(page,limit,orders);
    }
    @RequestMapping("/teacherNumList")
    @RequiresPermissions("sys:teacherNum:list")
    public String teacherNumList() {
        return "page/browse/teacherNumList";
    }
}
