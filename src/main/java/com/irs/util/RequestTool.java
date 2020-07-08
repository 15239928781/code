package com.irs.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: yimiao
 * @description: 请求工具
 * @author: huzi
 * @create: 2019-02-25 11:00
 **/
public class RequestTool {

    /**
     * 获取ip地址
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }

    private static final String BOUNDARY = "----WebKitFormBoundaryT1HoybnYeFOGFlBR";


    /* @Description: //TODO
     *
     * @param params    传递的普通参数
     * @param fileFormName  表单中文件名称
     * @param uploadFile    上传的文件File类型
     * @param newFileName   上传的文件名称，不填写将为uploadFile的名称
     * @param urlStr        上传的服务器的路径
     * @return void
     * @Author:huzi
     * @Date: 2019/3/19 15:34
     */
    public static void uploadForm(Map<String, String> params, String fileFormName,
                                  File uploadFile, String newFileName, String urlStr)
            throws IOException {
        if (newFileName == null || newFileName.trim().equals("")) {
            newFileName = uploadFile.getName();
        }

        StringBuilder sb = new StringBuilder();
        /**
         * 普通的表单数据
         */
        for (String key : params.keySet()) {
            sb.append("--" + BOUNDARY + "\r\n");
            sb.append("Content-Disposition: form-data; name=\"" + key + "\""
                    + "\r\n");
            sb.append("\r\n");
            sb.append(params.get(key) + "\r\n");
        }
        /**
         * 上传文件的头
         */
        sb.append("--" + BOUNDARY + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"" + fileFormName
                + "\"; filename=\"" + newFileName + "\"" + "\r\n");
        sb.append("Content-Type: image/png" + "\r\n");// 如果服务器端有文件类型的校验，必须明确指定ContentType
        sb.append("\r\n");

        byte[] headerInfo = sb.toString().getBytes("UTF-8");
        byte[] endInfo = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");
        System.out.println(sb.toString());
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type",
                "multipart/form-data; boundary=" + BOUNDARY);
        conn.setRequestProperty("Content-Length", String
                .valueOf(headerInfo.length + uploadFile.length()
                        + endInfo.length));
        conn.setDoOutput(true);

        OutputStream out = conn.getOutputStream();
        InputStream in = new FileInputStream(uploadFile);
        out.write(headerInfo);
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) != -1)
            out.write(buf, 0, len);

        out.write(endInfo);
        out.flush();
        in.close();
        out.close();
        if (conn.getResponseCode() == 200) {
            System.out.println("上传成功");
        }
    }

    /**
     * @param params       传递的普通参数
     * @param uploadFile   需要上传的文件名
     * @param fileFormName 需要上传文件表单中的名字
     * @param newFileName  上传的文件名称，不填写将为uploadFile的名称
     * @param urlStr       上传的服务器的路径
     * @throws IOException
     */
    public static void uploadFromBySocket(Map<String, String> params,
                                          String fileFormName, File uploadFile, String newFileName,
                                          String urlStr) throws IOException {
        if (newFileName == null || newFileName.trim().equals("")) {
            newFileName = uploadFile.getName();
        }

        StringBuilder sb = new StringBuilder();
        /**
         * 普通的表单数据
         */

        if (params != null) {
            for (String key : params.keySet()) {
                sb.append("--" + BOUNDARY + "\r\n");
                sb.append("Content-Disposition: form-data; name=\"" + key
                        + "\"" + "\r\n");
                sb.append("\r\n");
                sb.append(params.get(key) + "\r\n");
            }
        } else {
            sb.append("\r\n");
        }
        /**
         * 上传文件的头
         */
        sb.append("--" + BOUNDARY + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"" + fileFormName
                + "\"; filename=\"" + newFileName + "\"" + "\r\n");
        sb.append("Content-Type: image/jpeg" + "\r\n");// 如果服务器端有文件类型的校验，必须明确指定ContentType
        sb.append("\r\n");

        byte[] headerInfo = sb.toString().getBytes("UTF-8");
        byte[] endInfo = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");

        System.out.println(sb.toString());

        URL url = new URL(urlStr);
        Socket socket = new Socket(url.getHost(), url.getPort());
        OutputStream os = socket.getOutputStream();
//        PrintStream ps = new PrintStream(os, true, "UTF-8");
//
//        // 写出请求头
//        ps.println("POST " + urlStr + " HTTP/1.1");
//        ps.println("Content-Type: multipart/form-data; boundary=" + BOUNDARY);
//        ps.println("Content-Length: "
//                + String.valueOf(headerInfo.length + uploadFile.length()
//                + endInfo.length));
//        ps.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");

        InputStream in = new FileInputStream(uploadFile);
        // 写出数据
        os.write(headerInfo);

        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) != -1)
            os.write(buf, 0, len);

        os.write(endInfo);
        os.flush();
        in.close();
        os.close();
    }

    public void parseRequest(InputStream inputStream) {
        LineNumberReader br = new LineNumberReader(new InputStreamReader(inputStream));
        StringBuffer sb = new StringBuffer();
        String str = null;
        String method = "";
        Map parameters = new HashMap();
        Map headers = new HashMap();
        try {
            //读取请求行
            String requestLine = br.readLine();
            if (!StringUtils.isEmpty(requestLine)) {
                sb.append(requestLine);
                String[] reqs = requestLine.split(" ");
                if (reqs != null && reqs.length > 0) {
                    if ("GET".equals(reqs[0])) {
                        method = "GET";
                    } else {
                        method = "POST";
                    }
                }
            }
            //读取请求头
            while ((str = br.readLine()) != null) {
                if ("".equals(str)) {
                    break;
                }
                if (!StringUtils.isEmpty(str)) {
                    if (str.indexOf(":") > 0) {
                        String[] strs = str.split(":");
                        headers.put(strs[0].toLowerCase(), strs[1].trim());
                    }
                }
                sb.append(str).append("\n");
            }
            //POST请求，Content-type为 multipart/form-data
            String contentType = null;
            if ("POST".equals(method) && ((contentType = headers.get("content-type").toString()) != null
                    && headers.get("content-type").toString().startsWith("multipart/form-data"))) {
                //文件上传的分割位 这里只处理单个文件的上传
                String boundary = contentType.substring(contentType.indexOf("boundary") +
                        "boundary=".length());
                //解析消息体
                while ((str = br.readLine()) != null) {
                    //解析结束的标记
                    do {
                        //读取boundary中的内容
                        //读取Content-Disposition
                        str = br.readLine();
                        //说明是文件上传
                        if (str.indexOf("Content-Disposition:") >= 0 && str.indexOf("filename") > 0) {
                            str = str.substring("Content-Disposition:".length());
                            String[] strs = str.split(";");
                            String fileName = strs[strs.length - 1].replace("\"", "").split("=")[1];
                            System.out.println("fileName = " + fileName);
                            //这一行是Content-Type
                            br.readLine();
                            //这一行是换行
                            br.readLine();
                            //正式去读文件的内容
                            BufferedWriter bw = null;
                            try {
                                bw = new BufferedWriter(new OutputStreamWriter(new
                                        FileOutputStream("G:\\LearnVideo\\fileLoad" +
                                        File.separator + fileName), "UTF-8"));
                                while (true) {
                                    str = br.readLine();
                                    if (str.startsWith("--" + boundary)) {
                                        break;
                                    }
                                    bw.write(str);
                                    bw.newLine();
                                }
                                bw.flush();
                            } catch (Exception e) {

                            } finally {
                                if (bw != null) {
                                    bw.close();
                                }
                            }
                        }
                        if (str.indexOf("Content-Disposition:") >= 0) {
                            str = str.substring("Content-Disposition:".length());
                            String[] strs = str.split(";");
                            String name = strs[strs.length - 1].replace("\"", "").split("=")[1];
                            br.readLine();
                            StringBuilder stringBuilder = new StringBuilder();
                            while (true) {
                                str = br.readLine();
                                if (str.startsWith("--" + boundary)) {
                                    break;
                                }
                                stringBuilder.append(str);
                            }
                            parameters.put(name, stringBuilder.toString());
                        }
                    } while (("--" + boundary).equals(str));
                    //解析结束
                    if (str.equals("--" + boundary + "--")) {
                        break;
                    }
                }
            }
            //System.out.println(sb.toString());
            //获取URI
            /*String uri = StringUtils.parserUri(sb.toString(), " ");
            int flag = -1;
            //说明有参数
            if ((flag = uri.indexOf('?')) >= 0) {
                String oldUri = uri;
                uri = uri.substring(0,flag);
                String parameterPath = oldUri.substring(flag+1);
                String[] parameter = parameterPath.split("&");
                if (parameter != null && parameter.length > 0) {
                    for (int i = 0; i < parameter.length; i++) {
                        String str1 = parameter[i];
                        if((flag = str1.indexOf('=')) >= 0){
                            String key = str1.substring(0,flag);
                            String value = str1.substring(flag+1);
                            parameters.put(key,value);
                        }else{
                            parameters.put(str,null);
                        }
                    }
                }
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
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
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
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
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            OutputStreamWriter outWriter =new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            out = new PrintWriter(outWriter);
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    /**
     * 将map转换成url
     * @param map
     * @return
     */
    public static String getUrlParamsByMap(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = org.apache.commons.lang3.StringUtils.substringBeforeLast(s, "&");
        }
        return s;
    }
    /* @Description: uri编码
     *
     * @param source
     * @return java.lang.String
     * @Author:huzi
     * @Date: 2019/3/29 15:04
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
}
