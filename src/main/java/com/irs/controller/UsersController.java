package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.UserSearch;
import com.irs.pojo.UsersSearch;
import com.irs.service.UsersService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("users/")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("usersList")
    @RequiresPermissions("users:users:list")
    public String userList(){
        return "page/users/usersList";
    }

    @RequestMapping("setVipLevel/{uId}")
    //@RequiresPermissions("users:users:list")
    public String setVipLevel(@PathVariable("uId")String uId, Model model){
        model.addAttribute("uId",uId);
        return "page/users/vip2";
    }
    @RequestMapping("setvip/{leId}/{uId}")
    //@RequiresPermissions("users:users:list")
    public ResultUtil setvip(@PathVariable("leId")String leId,@PathVariable("uId")String uId){
        usersService.setvip(leId,uId);
        try {
            usersService.setvip(leId,uId);
            return  ResultUtil.ok("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.error("操作失败");
        }
    }


    @RequestMapping("getUsersList")
    @RequiresPermissions("users:users:list")
    @ResponseBody
    public ResultUtil getUserList(Integer page, Integer limit, UserSearch search){
        return usersService.selUsers(page,limit,search);

    }

    /**
     * 批量删除用户
     * @param userStr
     * @return
     */
    @SysLog(value="批量删除用户")
    @RequestMapping("delUser/{userStr}")
    @RequiresPermissions("users:users:delete")
    @ResponseBody
    public ResultUtil delUsers(@PathVariable("userStr")String userStr){
        try {
            usersService.delUsersService(userStr);
            return  ResultUtil.ok("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.error("操作失败");
        }
    }

    /**
     * 根据ID删除用户
     * @param uid
     * @return
     */
    @SysLog(value="根据ID删除用户")
    @RequestMapping("delUsersByUid/{uid}")
    @RequiresPermissions("users:users:delete")
    @ResponseBody
    public ResultUtil delUserByUid(@PathVariable("uid")String uid){
        try {
            usersService.delUserByUid(uid);
            return  ResultUtil.ok("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.error("操作失败");
        }
    }

}
