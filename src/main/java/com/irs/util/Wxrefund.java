package com.irs.util;

import org.jdom2.JDOMException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Wxrefund {

    public static Map refund(String out_trade_no,String out_refund_no,String total_fee,String refund_fee) throws Exception{
        String appid = "wx7500e60816b113c8"; // appid
        String mch_id = "1516361731"; // 商业号
        String key = "henandezhantianxiaxinxikeji12345"; // key

        String nonce_str = PayCommonUtil.getRandomStringByLength(32);//currTime + strRandom; // 随机字符串
        //String out_trade_no = "20190328133817071530";//申请退款的商户订单号

        // String out_refund_no = out_trade_no + "1314";
        // String total_fee = "0.01";
        //  String refund_fee = total_fee;
        String op_user_id = mch_id; // 操作员默认为商户号

        Map<String, String> m = new LinkedHashMap<>();
        m.put("appid", appid);
        m.put("mch_id", mch_id);
        m.put("nonce_str", nonce_str);
        m.put("out_refund_no", out_refund_no);
        m.put("out_trade_no", out_trade_no);
        m.put("refund_fee", refund_fee);
        m.put("total_fee", total_fee);
        //  m.put("op_user_id", op_user_id);
        //签名算法
        String sign = PayCommonUtil.createSign2("UTF-8", m, key);
        m.put("sign", sign);
        //将集合转换成xml
        String requestXML = XMLUtil.mapToXml(m);
        //带证书的post
        String resXml = CertHttpUtil.postData("https://api.mch.weixin.qq.com/secapi/pay/refund", requestXML);
        //解析xml为集合，请打断点查看resXml详细信息
        Map map = null;
        try {
            map = XMLUtil.doXMLParse(resXml);
            //查看申请退款状态
//            PrintWriter out = response.getWriter();
//            out.print(map.get("return_code"));
//            out.print(map.get("return_msg"));
            System.out.println(map.get("return_code"));
            System.out.println(map.get("return_msg"));
            return map;
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
