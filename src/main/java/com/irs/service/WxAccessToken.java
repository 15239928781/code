package com.irs.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.irs.util.RequestTool;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: vaccine
 * @description: 微信access_token获取
 * @author: huzi
 * @create: 2019-03-29 10:30
 **/
public class WxAccessToken {
    private String appId;
    private String appSecret;
    public String accessToken;
    public WxAccessToken(String appId,String appSecret){
        this.appId=appId;
        this.appSecret=appSecret;

            //从微信服务器获取
            getAccessTokenFromWxServer();
    }

    public void getAccessTokenFromWxServer(){
        String url="https://api.weixin.qq.com/cgi-bin/token";
        Map paramsMap=new HashMap(){{
            put("appid",appId);
            put("secret",appSecret);
            put("grant_type","client_credential");
        }};
        String params= RequestTool.getUrlParamsByMap(paramsMap);
        String res= RequestTool.sendGet(url,params);
        JSONObject resObj= JSON.parseObject(res);
        if(resObj.containsKey("errcode")&&resObj.getInteger("errcode")!=0){
            System.out.println("获取accesstoken_失败,错误信息:"+resObj.getString("errmsg"));

        }else if(resObj.containsKey("access_token")){
            accessToken=resObj.getString("access_token");
        }
    }

}
