package com.irs.test;

import com.irs.pojo.GroupsBill;
import com.irs.service.GroupsBillService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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
            GroupsBill search=new GroupsBill();
            billService.getBillList(1,10,search);
            System.out.println("测试开始");
        }
    }
}
