package com.irs.controller;

import com.irs.pojo.GroupsBill;
import com.irs.service.GroupsBillService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class socketMain implements ServletContextListener {
    @Autowired
    private GroupsBillService billService;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        new   MyThread().start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
    class   MyThread   extends   Thread
    {
        public   void   run()
        {
//            List<GroupsBill> billList=billService.getBillByStatus();
//            for (GroupsBill bill : billList) {
//                int min=5;
//                long start=System.currentTimeMillis();
//                //end 计算结束时间
//                final long end=start+min*60*1000;
//
//                final Timer timer=new Timer();
//                //延迟0毫秒（即立即执行）开始，每隔1000毫秒执行一次
//                timer.schedule(new TimerTask()
//                {
//                    public void run()
//                    {
//                        //show是剩余时间，即要显示的时间
//                        long show=end-System.currentTimeMillis();
//                        long h=show/1000/60/60;//时
//                        long m=show/1000/60%60;//分
//                        long s=show/1000%60;//秒
//                        System.out.println("现在时间："+h+"时"+m+"分"+s+"秒");
//                    }
//                },0,1000);
//                //计时结束时候，停止全部timer计时计划任务
//                timer.schedule(new TimerTask()
//                {
//                    public void run()
//                    {
//                        timer.cancel();
//                    }
//
//                }, new Date(end));
//            }
            System.out.println("测试开始");
        }
    }
}
