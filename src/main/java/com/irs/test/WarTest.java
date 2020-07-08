package com.irs.test;


import org.apache.commons.io.FileUtils;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.net.HttpURLConnection;
import java.net.URL;

public class WarTest {


    //删除文件或文件夹
    public static void deleteDir(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles())
                deleteDir(f);
        }
        file.delete();
    }

    /**
     * @功能 下载文件
     * @return
     */

    public static void saveUrlAs(String saveUrl,String filePath,String fileName){
        try {

            URL url = new URL(saveUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置超时间为3秒
            conn.setConnectTimeout(3 * 1000);
            // 防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            // 得到输入流
            InputStream inputStream = conn.getInputStream();
            // 获取自己数组
            byte[] getData = readInputStream(inputStream);

            // 文件保存位置
            File saveDir = new File(filePath);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            File file = new File(saveDir + File.separator + fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            if (fos != null) {
                fos.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            // System.out.println("info:"+url+" download success");
//            return saveDir + File.separator + fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return null;
    }
    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
        //重启tomcat
    public static void restart(){
        File directory=new File("");//设定为当前文件夹
        String binPath=directory.getAbsolutePath();
        String pid= ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
            File restart=new File(binPath+"\\restart.bat");
            String bats="call taskkill /F /PID "+pid+" && call ping -n 5 127.0.0.1>null && "+
            "call "+binPath+"\\catalina.bat start";
            try {
                FileOutputStream stream=new FileOutputStream(restart);
                stream.write(bats.getBytes());
                stream.flush();
                stream.close();
                File restartVbs=new File(binPath+"\\restart.vbs");
                String vbs="Set ws = CreateObject(\"Wscript.Shell\") \n"+
                        "ws.run \"cmd /c restart.bat\",0";
                stream=new FileOutputStream(restartVbs);
                stream.write(vbs.getBytes());
                stream.flush();
                stream.close();
                Runtime.getRuntime().exec("cmd /c start"+binPath+"\\restart.vbs");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        saveUrlAs("http://www.bybart.cn/ssm/pc/MP_verify_A28uqszSYZXBrHEp.txt","E:\\war","MP_verify_A28uqszSYZXBrHEp.txt");
        /*File file=new File("E:\\项目\\在线课程项目\\白又白课程\\baiyoubai_project\\target\\ssm\\pc\\ssm.war");
        deleteDir(file);*/
//        restart();
    }

}
