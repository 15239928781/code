package com.irs.util;

import java.text.SimpleDateFormat;
import java.util.*;


public class PayCommonUtil {
    /**
     * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
     * @return boolean
     */
    public static boolean isTenpaySign(String characterEncoding, SortedMap<Object, Object> packageParams, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if(!"sign".equals(k) && null != v && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
            }
        }

        sb.append("key=" + API_KEY);

        //算出摘要
        String mysign = MD5.MD5Encode(sb.toString(), characterEncoding).toLowerCase();
        String tenpaySign = ((String)packageParams.get("sign")).toLowerCase();

        //System.out.println(tenpaySign + "    " + mysign);
        return tenpaySign.equals(mysign);
    }

    /**
     * @author
     * @Description：sign签名
     * @param characterEncoding
     *            编码格式
     * @param
     *            请求参数
     * @return
     */
    public static String createSign(String characterEncoding, SortedMap<Object, Object> packageParams, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = entry.getKey().toString();
            String v = entry.getValue().toString();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + API_KEY);
        String sign = MD5.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }

    /**
     * @author
     * @Description：将请求参数转换为xml格式的string
     * @param parameters
     *            请求参数
     * @return
     */
    public static String getRequestXml(SortedMap<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = entry.getKey().toString();
            String v = entry.getValue().toString();
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
            } else {
                sb.append("<" + k + ">" + v + "</" + k + ">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 取出一个指定长度大小的随机正整数.
     *
     * @param length
     *            int 设定所取出随机数的长度。length小于11
     * @return int 返回生成的随机数。
     */
    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    /**
     * 获取当前时间 yyyyMMddHHmmss
     *
     * @return String
     */
    public static String getCurrTime() {
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = outFormat.format(now);
        return s;
    }

    public static void main(String[] args) throws Exception {
        String map="{appid=wx7500e60816b113c8, body=商城-订单结算, mch_id=1516361731, n\n" +
                "once_str=1553745282, notify_url=http://www.bybart.cn/ssm/front/notify, openid=nu\n" +
                "ll, out_trade_no=20190328115428510784, spbill_create_ip=39.98.232.186, total_fee\n" +
                "=1, trade_type=JSAPI}";
        String appid = "wx7500e60816b113c8"; // appid
        String mch_id = "1516361731"; // 商业号
        String key = "henandezhantianxiaxinxikeji12345"; // key

        String currTime = PayCommonUtil.getCurrTime();
        String strRandom = PayCommonUtil.buildRandom(4) + "";
        String nonce_str = currTime + strRandom;//currTime + strRandom; // 随机字符串
        String out_trade_no = "20190328133817071530";//申请退款的商户订单号

        String out_refund_no = out_trade_no + "1314";
        String total_fee = "0.01";
        String refund_fee = total_fee;
        String op_user_id = mch_id; // 操作员默认为商户号

        Map<String, String> m = new LinkedHashMap<String, String>();
        m.put("appid", appid);
        m.put("mch_id", mch_id);
        m.put("nonce_str", nonce_str);
        m.put("out_refund_no", out_refund_no);
        m.put("out_trade_no", out_trade_no);
        m.put("refund_fee", refund_fee);
        m.put("total_fee", total_fee);
        //签名算法
        String sign = PayCommonUtil.createSign2("UTF-8", m, key);
        m.put("sign", sign);
        System.out.println(sign);
        //将集合转换成xml
        String requestXML = XMLUtil.mapToXml(m);
        System.out.println(requestXML);
    }

    public static String createSign2(String characterEncoding, Map<String, String> packageParams, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = entry.getKey().toString();
            String v = entry.getValue().toString();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + API_KEY);
        String sign = MD5.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }

    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
