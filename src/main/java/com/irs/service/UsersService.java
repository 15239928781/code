package com.irs.service;

import com.irs.pojo.UserSearch;
import com.irs.pojo.Users;
import com.irs.pojo.UsersSearch;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

import javax.servlet.http.HttpServletRequest;

public interface UsersService {

    //得到用户信息
    public ResultUtil selUsers(Integer page, Integer limit, UserSearch search);

    //批量删除用户
    public void delUsersService(String userStr);

    public void delUserByUid(String uid);

    WxResult getUserById(int uId);

    WxResult editUserInfo(Users user);

    WxResult login(String account, String loginpwd, HttpServletRequest request);

    WxResult register(Users user);

    int insetUser(Users users);

    Users selebyOpenid(String getuIntroduction);

    Users selectByUid(Integer getuId);

    void setvip(String leId, String uId);

    WxResult getUserByIdPC(String token);
}
