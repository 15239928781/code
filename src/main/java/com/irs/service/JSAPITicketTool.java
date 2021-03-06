package com.irs.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.irs.util.RequestTool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: vaccine
 * @description: js_api工具
 * @author: huzi
 * @create: 2019-04-02 17:35
 **/
public class JSAPITicketTool {
    public String jsApiTicket;
    public JSAPITicketTool(String appid,String accessToken){
            getJsApiTicketFromWxServer(appid,accessToken);
    }
    public void getJsApiTicketFromWxServer(String appid,String accessToken){
        String url="https://api.weixin.qq.com/cgi-bin/ticket/getticket";
        String param="access_token="+accessToken+"&type=jsapi";
        String res=RequestTool.sendGet(url,param);
        JSONObject resObj= JSON.parseObject(res);
        if(resObj.containsKey("errcode")&&resObj.getInteger("errcode")!=0){
            System.out.println("获取jsApiTicket失败,错误信息:"+resObj.getString("errmsg"));

        }else if(resObj.containsKey("ticket")){
            jsApiTicket=resObj.getString("ticket");
        }
    }
    public static Map<String, String> sign(String url,String jsapi_ticket) {
        Map<String, String> ret = new HashMap<String, String>();
        //这里的jsapi_ticket是获取的jsapi_ticket。
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;
        // System.out.println(string1);

        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
