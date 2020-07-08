package com.irs.controller.PayApi;

import com.alibaba.fastjson.JSONObject;
import com.irs.mapper.UsersMapper;
import com.irs.mapper.LevelMapper;
import com.irs.pojo.*;
import com.irs.service.*;
import com.irs.util.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.dom4j.DocumentHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.security.KeyStore;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


//import com.alipay.api.internal.util.StringUtils;

/**
 * @author zc
 * @create 2019 - 03 - 16
 * 支付成功后处理controller
 **/
@RequestMapping("front")
@Controller
public class PayController {

    @Autowired
    private UsersService userService;

    @Autowired
    private RechargeService rechargeService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductService productService;

    @Autowired
    private RewardService rewardService;

    @Autowired
    private LevelMapper levelMapper;

    @Autowired
    protected UsersMapper usersMapper;


    /**
     * 微信回调
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/getOrderPayInfo")
    @ResponseBody
    public synchronized String getOrderPayInfo(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {

        String result;// 返回给微信的处理结果
        String inputLine;
        String notityXml = "";
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 微信给返回的东西
        try {
            while ((inputLine = request.getReader().readLine()) != null) {
                notityXml += inputLine;
            }
            request.getReader().close();
        } catch (Exception e) {
            e.printStackTrace();
            result = setXml("fail", "xml获取失败");
        }
		/*
		 * if (StringUtils.isEmpty(notityXml)) { result = setXml("fail", "xml为空"); }
		 */
        Map<String, String> map = new HashMap<String, String>();
        InputStream in = new ByteArrayInputStream(notityXml.getBytes());
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(in);
        } catch (DocumentException e) {

            e.printStackTrace();
        }
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        @SuppressWarnings("unchecked")
        List<Element> elementList = root.elements();
        for (Element element : elementList) {
            map.put(element.getName(), element.getText());
        }

        String paySign = map.get("sign");
        map.remove("sign");
        // 解析各种数据
        // 除去数组中的空值和签名参数

        Map<String, String> sPara = PayUtil.paraFilter(map);
        String prestr = PayUtil.createLinkString(sPara); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串

        String attach = (String) map.get("attach");// 商家数据包

        String key = "&key=" + ""; // 商户支付密钥
        // MD5运算生成签名
        String mysign = PayUtil.sign(prestr, key, "utf-8").toUpperCase();

        //验证签名
        if (paySign.equals(mysign)) {
            String transaction_id = (String) map.get("transaction_id");// 交易流水号

            ShopRecharge list = rechargeService.getRechargeByOrder(transaction_id);
            if (list != null ) {
                result = setXml("SUCCESS", "OK");

                return result;
            }

            String total_fee = (String) map.get("total_fee");// 金额
            String trade_type = (String) map.get("trade_type");// 支付方式
            String out_trade_no = (String) map.get("out_trade_no");// 订单号

            double money = Double.parseDouble(total_fee);
            money = money / 100;
//	            BigDecimal bd = new BigDecimal(money);
            //根据orderId查找用户id
            ShopOrders orders=ordersService.selOrderById(Integer.valueOf(out_trade_no));
            ShopRecharge r=new ShopRecharge();
            r.setRtId(1);
//        	Date d = new Date();
            r.setuId(orders.getuId());
            r.setrMoney(money);
            r.setrDesc("微信支付");
            r.setRtId(1);
            r.setOrdernum(out_trade_no);
            rechargeService.addRecharge(r);
            result = setXml("SUCCESS", "OK");

            return result;
        } else {
            result = setXml("fail", "签名错误");

            return result;
        }


    }


//	    @RequestMapping(value = "/checkPaySuccess.action", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
//	    @ResponseBody
//	    public String checkPaySuccess(String price, String orderId, HttpServletResponse response) {
//
//	        WxResult result = rechargeRecordService.checkPaySuccess(price, orderId);
//	        response.addHeader("Access-Control-Allow-Origin", "*");
//	        return JsonUtils.objectToJson(result);
//	    }

    // 通过xml 发给微信消息
    public static String setXml(String return_code, String return_msg) {
        return "<xml><return_code><![CDATA[" + return_code + "]]>" + "</return_code><return_msg><![CDATA[" + return_msg
                + "]]></return_msg></xml>";
    }

    @RequestMapping(value="payorders", method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String orders(HttpServletRequest request,
                         @RequestParam("code")String code,
                         @RequestParam("prices")String prices,
                         @RequestParam("ordernum") String ordernum,
                         @RequestParam(value="status",defaultValue="0")int status,
                         HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        String appid="wx7500e60816b113c8";
        String secret="53efc09bf87b646b883cb6569f73417c";
        String mchId="1516361731";
        String mch_secret ="henandezhantianxiaxinxikeji12345";
        try {
            //页面获取openId接口
            String getopenid_url = "https://api.weixin.qq.com/sns/oauth2/access_token";
            String  param= "appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
            //向微信服务器发送get请求获取openIdStr
            String openIdStr = HttpRequest.sendGet(getopenid_url, param);
            JSONObject json = JSONObject.parseObject(openIdStr);//转成Json格式
            String openId = json.getString("openid");//获取openId
            //String openId=null;
            SortedMap<Object, Object> paraMap = new TreeMap<Object, Object>();
            String ip = SystemUtils.getIpAddr(request);
            String today = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());


//			String openId ="offK61ZNg66aBjn8tkIg1SI1EL98";
//			System.out.println(openId);
            //拼接统一下单地址参数
//			prices=String.valueOf(Double.parseDouble(prices)*100);

            String prices4=null;
            if(status==0){//0不是分区
                prices4= ordersService.selMoneyByOrdernum(prices,ordernum);

            }else{
                prices4=ordersService.selMoneyByOrdernum2(ordernum);
            }

            BigDecimal b4 = new BigDecimal(prices4);
            BigDecimal b5 = new BigDecimal(100);
            double b6= b4.multiply(b5).doubleValue();
            String prices3 = new DecimalFormat("0").format(b6);
            System.out.println("=======================================1到9折=0prices3="+prices3);
            String code1 = PayUtil.createCode(4);
            String times = PayUtil.getSecondTimestampTwo(new Date())+ "";
            String trans_number = today + code1;
            System.out.println(trans_number);
            paraMap.put("appid", appid);
            paraMap.put("body", "商城-订单结算");
            paraMap.put("mch_id", mchId);
            paraMap.put("nonce_str", times);
            paraMap.put("openid", openId);
            paraMap.put("out_trade_no", ordernum);//订单号
            paraMap.put("spbill_create_ip", "39.98.232.186");
            paraMap.put("total_fee",prices3);
            paraMap.put("trade_type", "JSAPI");
            paraMap.put("notify_url","http://www.bybart.cn/ssm/front/notify");// 此路径是微信服务器调用支付结果通知路径随意写


            String sign = PayCommonUtil.createSign("UTF-8", paraMap, mch_secret);
            paraMap.put("sign", sign);
            System.out.println(sign);
            String xml = PayCommonUtil.getRequestXml(paraMap);//将所有参数(map)转xml格式
            System.out.println(xml);
            // 统一下单 https://api.mch.weixin.qq.com/pay/unifiedorder
            String unifiedorder_url ="https://api.mch.weixin.qq.com/pay/unifiedorder";
           // String unifiedorder_url ="https://api.mch.weixin.qq.com/sandboxnew/pay/unifiedorder";

            //	String xmlStr = HttpRequest.sendPost(unifiedorder_url, xml);//发送post请求"统一下单接口"返回预支付id:prepay_id
            String xmlStr=HttpUtil.postData(unifiedorder_url, xml, "utf-8");
            System.out.println(xmlStr);
            //以下内容是返回前端页面的json数据
            String prepay_id = "";//预支付id
            String noncstr="";
            if (xmlStr.indexOf("SUCCESS") != -1) {
                Map<String, String> map = XMLUtil.doXMLParse(xmlStr) ;
                prepay_id = (String) map.get("prepay_id");
                noncstr=(String) map.get("nonce_str");
            }
            SortedMap<Object, Object> payMap = new TreeMap<Object, Object>();
            payMap.put("appId", appid);
            payMap.put("nonceStr", noncstr);
            payMap.put("package", "prepay_id=" + prepay_id);
            payMap.put("signType", "MD5");
            payMap.put("timeStamp", times);
            payMap.put("key", mch_secret);

//			String stringA =""+"appId="+appid+"&nonceStr="+noncstr +"&package=prepay_id="+prepay_id+"&signType=MD5"+"&timeStamp=" + times + "&key="+mch_secret;
//			String paySign=PayUtil.sign(stringA, mch_secret, "UTF-8");
            String paySign = PayCommonUtil.createSign("UTF-8", payMap, mch_secret);
            payMap.put("paySign", paySign);
//			payMap.put("key", mch_secret);
            ShopOrders orders=ordersService.selectByOrderNum(ordernum);
            List<Integer> typeList=new ArrayList<>();
            if (orders!=null){
                List<ShopOrderitem> orderitemList=ordersService.selectByOrderId(orders.getoId());
                for (ShopOrderitem shopOrderitem : orderitemList) {
                    //查看商品是否为实物
                    ShopProduct product=productService.selProductBypid(shopOrderitem.getpId());
                    if (!product.getpValidity().equals(3)){
                        //不是实物
                        typeList.add(product.getpValidity());
                    }
                }
                if(orderitemList.size()==typeList.size()){
                    payMap.put("pVitual", 2);
                }else {
                    payMap.put("pVitual", 1);
                }
            }
            System.out.println(payMap);
            return JsonUtils.objectToJson(WxResult.ok(payMap));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 支付成功后，接收微信返回的回调方法
                */
        @RequestMapping(value="/notify", produces = "application/json;charset=UTF-8")
        @ResponseBody
        public void order(HttpServletRequest request, HttpServletResponse response) throws Exception{
            String msg = "success";
            response.setContentType("text/xml");
            String resXml = "";
            BufferedReader reader = null;
            reader = request.getReader();
            String line = "";
            String xmlString = null;
        StringBuffer inputString = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            inputString.append(line);
        }
        xmlString = inputString.toString();
        request.getReader().close();
        Document doc = null;
        try {
            // 下面的是通过解析xml字符串的
            doc = DocumentHelper.parseText(xmlString); // 将字符串转为XML
            Element rootElt = doc.getRootElement(); // 获取根节点
            Element recordEle = (Element)rootElt;
            String result_code = recordEle.elementTextTrim("result_code");
            String return_code = recordEle.elementTextTrim("return_code");
            String out_trade_no = recordEle.elementTextTrim("out_trade_no");
            String money=recordEle.elementTextTrim("total_fee");

            System.out.println("================================================="+money);
// String stuNo =out_trade_no.split("_ms_")[1];
            int i = Integer.parseInt(money);
            System.out.println(i);
            double a=i;
            System.out.println(a);
            double qw3 =0.00;
            qw3= a / 100;
            System.out.println(qw3);
            // String money2=String.valueOf(i/100);
            String money2 = new DecimalFormat("0.00").format(qw3);

            System.out.println("money2================================================" + money2);
            //   String stuNo =out_trade_no.split("_ms_")[1];
            System.out.println(out_trade_no);
            //在此处开始进行数据库订单记录状态插入与修改
            ShopOrders o=new ShopOrders();
            if(return_code.indexOf("SUCCESS")!=-1){
                if(result_code.indexOf("SUCCESS")!=-1){

                    ShopOrders orders2=ordersService.selectByOrderNum(out_trade_no);
                    List<Integer> typeList=new ArrayList<>();
                    if (orders2!=null){
                        List<ShopOrderitem> orderitemList=ordersService.selectByOrderId(orders2.getoId());
                        for (ShopOrderitem shopOrderitem : orderitemList) {
                            //查看商品是否为实物
                            ShopProduct product=productService.selProductBypid(shopOrderitem.getpId());
                            if (!product.getpValidity().equals(3)){
                                //不是实物
                                typeList.add(product.getpValidity());
                            }
                        }
                        if(orderitemList.size()==typeList.size()){
                            o.setoState(4);
                        }else {
                            o.setoState(2);
                        }
                    }
                    //支付成功
                    o.setMoney(money2);
                    o.setoOrdernum(out_trade_no);
                    ordersService.updateOrderStatus(o);

                   Users user = usersMapper.selectByPrimaryKey(orders2.getuId());
                    //根据订单编号查找用户id
                    //ShopOrders orders=ordersService.selectByOrderNum(out_trade_no);
                    ShopRecharge r=new ShopRecharge();
                    r.setRtId(1);
            //      Date d = new Date();
                    r.setuId(orders2.getuId());
                    r.setrMoney(Double.valueOf(money2));
                    r.setrDesc("微信支付");
                    r.setRtId(1);
                    r.setOrdernum(out_trade_no);
                    r.setPayTime(CommonUtils.nowtime());
                    rechargeService.addRecharge(r);
                    //赠送积分
                    IntegralsReward reward=rewardService.select();
                    if (reward!=null){
                        BigDecimal num1=new BigDecimal(money);
                        BigDecimal num2=new BigDecimal(reward.getrPrices());
                        BigDecimal result=num1.divide(num2);
                        String divide=String.format("%.0f",result);
                        if (!divide.equals("0")){
                            Integer integer=Integer.valueOf(divide);
                            Integer jifen=reward.getrNum()*integer;
                            Integrals integrals=new Integrals();
                            integrals.setiAddtime(CommonUtils.nowtime());
                            integrals.setiNum(jifen);
                            integrals.setiType(1);
                            integrals.setuId(orders2.getuId());
                            rewardService.inserIntegralis(integrals);

                            BigDecimal num3=new BigDecimal(user.getuIntegral());
                            BigDecimal num4=new BigDecimal(jifen);
                            int  num5 = num3.add(num4).intValue();

                            user.setuIntegral(num5);
                            List<Level> levels = levelMapper.selectByExample(null);
                            for (Level level : levels){
                                if (jifen > level.getLeMinscore() && jifen < level.getLeMaxscore()) {
                                    user.setuLevel(level.getLeId());
                                    int b =usersMapper.updateByPrimaryKeySelective(user);

                                }
                            }
                        }
                    }
                }else{
                    o.setoOrdernum(out_trade_no);
                    o.setoState(1);
                    ordersService.updateOrderStatus(o);
                }
                //这一步非常重要：返回给微信成功通知，否则会一直回调。
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                BufferedOutputStream out = new BufferedOutputStream(
                        response.getOutputStream());
                out.write(resXml.getBytes());
                out.flush();
                out.close();
                response.getWriter().println(msg);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *微信公众号申请退款
     * @param //orderId 订单id
     * @param //total_fee 退款金额
     * @param //refund_fee 退款金额
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="refundPay", method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    private WxResult refundwx(HttpServletRequest request, HttpServletResponse response) throws Exception{
       // logBefore(logger, "退款");
//        ModelAndView mv = this.getModelAndView();
//        PageData pd = new PageData();
//        pd = this.getPageData();
        /*--------1.初始化数据参数----------*/
        String appId= "wx7500e60816b113c8";
        String secret= "53efc09bf87b646b883cb6569f73417c";
        String shh= "1516361731";
        String key= "henandezhantianxiaxinxikeji12345";
        String filePath = "C:\\apiclient_cert.p12"; //退款需要提供证书数据，所以需要根据证书路径读取证书
        //需要退款的商户订单号，对应提交订单中的out_trade_no
        String orderId = request.getParameter("orderId");
        //根据订单编号ordernum获取总金额和退款金额
        ShopOrders orders=ordersService.selectByOrderNum(orderId);
        String total_fee=orders.getTotal().toString();  //也可以根据业务场景从数据库中获取总金额和退款金额
        String refund_fee=orders.getTotal().toString();
        Map<String,String> result = (Map<String, String>) wxRefund(request,response,appId,secret,shh,key,orderId,total_fee,refund_fee,filePath);
       System.out.println(result);
        /*
        根据result的返回状态，处理你的业务逻辑
        .....
        */
        return WxResult.ok();
    }
    private Object wxRefund(HttpServletRequest request,HttpServletResponse response,String appId,
                            String secret,String shh,String key,String orderId,String total_fee,String refund_fee,String path){
        Map<String,String> result=new HashMap<String,String>();
//        PageData pd = new PageData();
//        pd = this.getPageData();
        String uuid = UUID.randomUUID().toString();	//获取UUID并转化为String对象
        uuid = uuid.replace("-", "");
        String refundid = uuid;
        String nonce_str = MD5.getMessageDigest(String.valueOf(new Random().nextInt(10000)));
        //*-----  1.生成预支付订单需要的的package数据-----*//*
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        packageParams.put("appid", appId);
        packageParams.put("mch_id", shh);
        packageParams.put("nonce_str", nonce_str);
        packageParams.put("op_user_id", shh);
        packageParams.put("out_trade_no", orderId);
        packageParams.put("out_refund_no", refundid);
        packageParams.put("total_fee",total_fee);
        packageParams.put("refund_fee", refund_fee);
        //*----2.根据package生成签名sign---- *//*
        String sign = PayCommonUtil.createSign("UTF-8", packageParams, key);
        //*----3.拼装需要提交到微信的数据xml---- *//*
        String xml="<xml>"
                +"<appid>"+appId+"</appid>"
                + "<mch_id>"+shh+"</mch_id>"
                + "<nonce_str>"+nonce_str+"</nonce_str>"
                + "<op_user_id>"+shh+"</op_user_id>"
                + "<out_trade_no>"+orderId+"</out_trade_no>"
                + "<out_refund_no>"+refundid+"</out_refund_no>"
                + "<refund_fee>"+refund_fee+"</refund_fee>"
                + "<total_fee>"+total_fee+"</total_fee>"
                + "<sign>"+sign+"</sign>"
                +"</xml>";
        try {
            //*----4.读取证书文件,这一段是直接从微信支付平台提供的demo中copy的，所以一般不需要修改---- *//*
            KeyStore keyStore  = KeyStore.getInstance("PKCS12");
            FileInputStream instream = new FileInputStream(new File(path));
            try {
                keyStore.load(instream, shh.toCharArray());
            } finally {
                instream.close();
            }
            // Trust own CA and all self-signed certs
            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, shh.toCharArray()).build();
            // Allow TLSv1 protocol only
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,new String[] { "TLSv1" },null,
                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            //*----5.发送数据到微信的退款接口---- *//*
            String url="https://api.mch.weixin.qq.com/secapi/pay/refund";
            HttpPost httpost= HttpClientConnectionManager.getPostMethod(url);
            httpost.setEntity(new StringEntity(xml, "UTF-8"));
            HttpResponse weixinResponse = httpClient.execute(httpost);
            String jsonStr = EntityUtils.toString(weixinResponse.getEntity(), "UTF-8");
            System.out.println(jsonStr);
            Map map = XMLUtil.doXMLParse(jsonStr);
            if("success".equalsIgnoreCase((String) map.get("return_code"))){
                System.out.println("退款成功");
                result.put("returncode", "ok");
                result.put("returninfo", "退款成功");
            }else{
                System.out.println("退款失败");
                result.put("returncode", "error");
                result.put("returninfo", "退款失败");
            }
        } catch (Exception e) {
            System.out.println("退款失败");
            result.put("returncode", "error");
            result.put("returninfo", "退款失败");
        }
        return result;

    }

//    @ResponseBody
//    @RequestMapping(value ="/refund.do",method = {RequestMethod.POST,RequestMethod.GET})
//    public String refund(){
//        String certPath=this.getClass().getClassLoader().getResource("/").getPath()+"apiclient_cert.p12";
//        System.out.println("certPath:"+certPath);
//        String transaction_id = null;
//        String out_trade_no = "";
//
//        if (StrKit.isBlank(out_trade_no) && StrKit.isBlank(transaction_id)) {
//            System.out.println("transactionId、out_trade_no二選一");
//            return null;
//        }
//
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("appid", "wx7500e60816b113c8");
//        params.put("mch_id", "1516361731");
//        params.put("nonce_str", System.currentTimeMillis()+"");
//        if (StrKit.notBlank(transaction_id)) {
//            params.put("transaction_id", transaction_id);
//        }else {
//            params.put("out_trade_no", out_trade_no);
//        }
//        params.put("out_refund_no", System.currentTimeMillis()+"");
//        params.put("total_fee", "100");
//        params.put("refund_fee", "90");
//        params.put("sign", PaymentKit.createSign(params, partnerKey));
//        String refund = WxPayApi.orderRefund(false, params , certPath, mchID);
//        System.out.println("refund:"+refund);
//        return refund;
//    }
@RequestMapping(value="moewny")
@ResponseBody
private String test(HttpServletRequest request,String prices,String ordernum, HttpServletResponse response) throws Exception {
    String  prices2= ordersService.selMoneyByOrdernum(prices,ordernum);
return prices2;
}
}
