package com.irs.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.irs.pojo.Users;
import com.irs.service.UsersService;
import com.irs.util.Oauth2Token;
import com.irs.util.R;
import com.irs.util.SNSUserInfo;
import com.irs.util.WXAuthUtil;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("front")
@ResponseBody
public class WxLoginController {

	@Autowired
	private UsersService usersService;


	private static  Logger log = LoggerFactory.getLogger(WxLoginController.class);



    /**
     * 向指定URL发送GET方法的请求
     * @param url
     *  发送请求的URL
     * @param param
     *  请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     *
     * 用户同意授权，获取code
     */
    @RequestMapping("/authorize")
    @ResponseBody
    public static R authorize(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
	    System.out.println(1111111111);

        String appid = "wx7500e60816b113c8";
        //本地域名2zz2733705.iok.la APPIDwxd23551988925766c key:0918bf66ed8e01c324270611b107b762
        //String uri ="wftest.zzff.net/wx/weixinLogin";
        String uri = urlEncodeUTF8("http://www.bybart.cn/ssm/front/weixinLogin");
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri="+uri+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
          //  System.out.println();
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line =null;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /*  com.alibaba.fastjson.JSONObject jsonObj= FastJSONUtils.getJSONObject(result);
                String access_token = jsonObj.getString("access_token");
                long expires_in = Long.valueOf(jsonObj.getString("expires_in"));
            */
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println(result);
        return  R.ok(result);
    }

    @RequestMapping("/weixinLogin")
    @ResponseBody
    public void weixinLogin(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		String code= request.getParameter("code");
    //	System.out.println(code);

	  //  System.out.println(1111111111);

        // 用户同意授权后，能获取到code
      //  Map<String, String[]> params = request.getParameterMap();//针对get获取get参数
      //  String[] codes = params.get("code");//拿到code的值
       // String code3 = codes[0];//code
        //String[] states = params.get("state");
        //String state = states[0];//state

        System.out.println("****************code:"+code);
        // 用户同意授权
        if (!"authdeny".equals(code)) {
             // 获取网页授权access_token
            Oauth2Token oauth2Token = getOauth2AccessToken("wx7500e60816b113c8", "53efc09bf87b646b883cb6569f73417c", code);
            //Oauth2Token oauth2Token = getOauth2AccessToken("wxd23551988925766c", "0918bf66ed8e01c324270611b107b762", code);
            System.out.println("***********************************oauth2Token信息："+oauth2Token.toString());
            // 网页授权接口访问凭证
            String accessToken = oauth2Token.getAccessToken();
            // 用户标识
            String openId = oauth2Token.getOpenId();
            // 获取用户信息
            SNSUserInfo snsUserInfo = getSNSUserInfo(accessToken, openId);
            System.out.println("***********************************用户信息unionId："+snsUserInfo.getUnionid()+"***:"+snsUserInfo.getNickname());
            // 设置要传递的参数
            Users users=new Users();
            Date d = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            users.setuCreatetime(sf.format(d));
            users.setuIntroduction(snsUserInfo.getOpenId());
            users.setuName(snsUserInfo.getNickname());
            users.setuImg(snsUserInfo.getHeadImgUrl());
            users.setuSex(String.valueOf(snsUserInfo.getSex()));
			users.setuStatus(1);
          // WxResult result= usersService.selectByUser(users);
           Users users2=usersService.selebyOpenid(users.getuIntroduction());
            HttpSession session = request.getSession();

           if(users2!=null){
                    session.setAttribute("uid",users2.getuId());
            	   response.sendRedirect("http://www.bybart.cn/ssm/index.html#/index/?uId="+users2.getuId());
           }else{
        	   int a = usersService.insetUser(users);
        	   if(a>0){
                   session.setAttribute("uid",users.getuId());
            	   response.sendRedirect("http://www.bybart.cn/ssm/index.html#/index/?uId="+users.getuId());
        	   }
           }
        }
		//return code;
    }


    /**
     * 获取网页授权凭证
     *
     * @param appId 公众账号的唯一标识
     * @param appSecret 公众账号的密钥
     * @param code
     * @return WeixinAouth2Token
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static Oauth2Token getOauth2AccessToken(String appId, String appSecret, String code) throws ClientProtocolException, IOException {
        Oauth2Token wat = null;
        // 拼接请求地址			https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+ appId+ "&secret="+appSecret+"&code="+code+"&grant_type=authorization_code";
//        requestUrl = requestUrl.replace("APPID", appId);
//        requestUrl = requestUrl.replace("SECRET", appSecret);
//        requestUrl = requestUrl.replace("CODE", code);
        // 获取网页授权凭证
        URL getUrl=new URL(requestUrl);
          HttpURLConnection http=(HttpURLConnection)getUrl.openConnection();
          http.setRequestMethod("GET");
          http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
          http.setDoOutput(true);
          http.setDoInput(true);
          http.connect();
          InputStream is = http.getInputStream();
          int size = is.available();
          byte[] b = new byte[size];
          is.read(b);
          String message = new String(b, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(message);
        System.out.println(jsonObject);
        if (null != jsonObject) {
            try {
                wat = new Oauth2Token();
                wat.setAccessToken(jsonObject.getString("access_token"));
                wat.setExpiresIn(jsonObject.getInteger("expires_in"));
                wat.setRefreshToken(jsonObject.getString("refresh_token"));
                wat.setOpenId(jsonObject.getString("openid"));
                wat.setScope(jsonObject.getString("scope"));
            } catch (Exception e) {
                wat = null;
                int errorCode = jsonObject.getInteger("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("获取网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return wat;
    }

    /**
     * 通过网页授权获取用户信息
     *
     * @param accessToken 网页授权接口调用凭证
     * @param openId 用户标识
     * @return SNSUserInfo
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) throws ClientProtocolException, IOException {
        SNSUserInfo snsUserInfo = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        // 通过网页授权获取用户信息
   //     com.alibaba.fastjson.JSONObject jsonObject =  JSON.parseObject(NetUtil.get(requestUrl));
        JSONObject jsonObject = WXAuthUtil.doGetJson(requestUrl);
        if (null != jsonObject) {
            try {
                snsUserInfo = new SNSUserInfo();
                // 用户的标识
                snsUserInfo.setOpenId(jsonObject.getString("openid"));
                // 昵称
                snsUserInfo.setNickname(jsonObject.getString("nickname"));
                // 性别（1是男性，2是女性，0是未知）
                snsUserInfo.setSex(jsonObject.getInteger("sex"));
                // 用户所在国家
                snsUserInfo.setCountry(jsonObject.getString("country"));
                // 用户所在省份
                snsUserInfo.setProvince(jsonObject.getString("province"));
                // 用户所在城市
                snsUserInfo.setCity(jsonObject.getString("city"));
                // 用户头像
                snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
                //用户手机号phoneNumber
               //String phone = jsonObject.getString("phoneNumber");
                // 用户特权信息
                List<String> list = JSON.parseArray(jsonObject.getString("privilege"),String.class);
                snsUserInfo.setPrivilegeList(list);
                //与开放平台共用的唯一标识，只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
                snsUserInfo.setUnionid(jsonObject.getString("unionid"));
            } catch (Exception e) {
                snsUserInfo = null;
                int errorCode = jsonObject.getInteger("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return snsUserInfo;
    }

    /**
     * URL编码（utf-8）
     *
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
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

    public static void main(String[] args) {
        System.out.println(urlEncodeUTF8("http://www.bybart.cn/ssm/front/weixinLogin"));
    }
}