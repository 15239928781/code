package com.irs.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Daojishi {
    private static long day = 0;
    private static long hour = 0;
    private static long minute = 0;
    private static long second = 0;
    private static boolean dayNotAlready = false;
    private static boolean hourNotAlready = false;
    private static boolean minuteNotAlready = false;
    private static boolean secondNotAlready = false;
    public static void main(String[] args) {
//        String aftertime="2019-03-29 15:08:26";
//        String timeStamp2 = date2TimeStamp(aftertime, "yyyy-MM-dd HH:mm:ss");
       /* long totalSeconds = 60 * 60 * 5;
        initData(totalSeconds);
        new Timer().schedule(new TimerTask() {
            public void run() {
                if (secondNotAlready) {
                    startCount();
                } else {
                    cancel();
                }
            }
        }, 0, 1000);*/
        //min 5分钟
                 int min=1;
                 long start=System.currentTimeMillis();
               //end 计算结束时间
                final long end=start+min*60*1000;

                 final Timer timer=new Timer();
                //延迟0毫秒（即立即执行）开始，每隔1000毫秒执行一次
                 timer.schedule(new TimerTask()
                        {
                        public void run()
                        {
                               //show是剩余时间，即要显示的时间
                                 long show=end-System.currentTimeMillis();
                                long h=show/1000/60/60;//时
                                long m=show/1000/60%60;//分
                                 long s=show/1000%60;//秒
                                System.out.println("现在时间："+h+"时"+m+"分"+s+"秒");
                          }
                    },0,1000);
             //计时结束时候，停止全部timer计时计划任务
                 timer.schedule(new TimerTask()
                        {
                        public void run()
                         {
                                 timer.cancel();
                            }

                    }, new Date(end));

             }

    /**
     * 初始化赋值
     *
     * @param totalSeconds
     */
    private static void initData(long totalSeconds) {
        resetData();
        if (totalSeconds > 0) {
            secondNotAlready = true;
            second = totalSeconds;
            if (second >= 60) {
                minuteNotAlready = true;
                minute = second / 60;
                second = second % 60;
                if (minute >= 60) {
                    hourNotAlready = true;
                    hour = minute / 60;
                    minute = minute % 60;
                    if (hour > 24) {
                        dayNotAlready = true;
                        day = hour / 24;
                        hour = hour % 24;
                    }
                }
            }
        }
        System.out.println("初始格式化后——>" + day + "天" + hour + "小时" + minute
                + "分钟" + second + "秒");
    }
    private static void resetData() {
        day = 0;
        hour = 0;
        minute = 0;
        second = 0;
        dayNotAlready = false;
        hourNotAlready = false;
        minuteNotAlready = false;
        secondNotAlready = false;
    }
    /**
     * 计算各个值的变动
     *
     */
    public static void startCount() {
        if (secondNotAlready) {
            if (second > 0) {
                second--;
                if (second == 0 && !minuteNotAlready) {
                    secondNotAlready = false;
                }
            } else {
                if (minuteNotAlready) {
                    if (minute > 0) {
                        minute--;
                        second = 59;
                        if (minute == 0 && !hourNotAlready) {
                            minuteNotAlready = false;
                        }
                    } else {
                        if (hourNotAlready) {
                            if (hour > 0) {
                                hour--;
                                minute = 59;
                                second = 59;
                                if (hour == 0 && !dayNotAlready) {
                                    hourNotAlready = false;
                                }
                            } else {
                                if (dayNotAlready) {
                                    day--;
                                    hour = 23;
                                    minute = 59;
                                    second = 59;
                                    if (day == 0) {
                                        dayNotAlready = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("距离截止日期还有——>" + day + "天" + hour + "小时" + minute
                + "分钟" + second + "秒");
    }

    public static String date2TimeStamp(String date_str,String format){
                 try {
                         SimpleDateFormat sdf = new SimpleDateFormat(format);
                         return String.valueOf(sdf.parse(date_str).getTime()/1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                 return "";
           }
}
