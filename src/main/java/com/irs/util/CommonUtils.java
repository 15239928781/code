package com.irs.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommonUtils {

    //获取系统当前时间
    public static String nowtime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());
    }

    /**
     * 每天
     */
    public static String todayTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date());
    }
    /**
     * 月
     */
    public static String monthTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//设置日期格式
        return df.format(new Date());
    }

    /**
     * 年
     */
    public static String yearTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return df.format(new Date());
    }
    /**
     * 目前时间加n个小时
     */
    public static String aftertime(Integer i){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, i); // 目前時間加3小時
        System.out.println(df.format(c.getTime()));
        return df.format(c.getTime());
    }

    public static void main(String[] args) {
        System.out.println(getFileName("1.ppt"));
//        System.out.println(aftertime(24));
    }

    public static List<Object> removeDuplicate(List<Object> list) {
        List<Object> result = new ArrayList<Object>(list.size());
        for (Object str : list) {
            if (!result.contains(str)) {
                result.add(str);
            }
        }
        list.clear();
        list.addAll(result);
        return list;
    }

    //判断文件后缀名
    public static String getSuffix(String fileName){
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return suffix;
    }
    //判断文件后缀名
    public static String getqzm(String fileName){
        String caselsh = fileName.substring(0,fileName.lastIndexOf("."));
        return caselsh;
    }
    //获取文件名
    public  static String getFileName(String name){
        String fileName=name.substring(0, name.length()-4);
        return fileName;
    }

}
