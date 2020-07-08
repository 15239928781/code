package com.irs.quartz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.irs.pojo.GroupsBill;
import com.irs.pojo.ShopOrders;
import com.irs.service.GroupsBillService;
import com.irs.service.OrdersService;
import com.irs.util.CommonUtils;
import com.irs.util.Wxrefund;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.irs.pojo.TbLog;
import com.irs.service.LogService;
import com.irs.util.DateUtil;
import com.irs.util.GlobalUtil;

import javax.servlet.http.HttpServletResponse;

/**
 * 清除系统日志任务
 * @author Mr Du
 *
 */

@Component
public class MethodLogQuartz {
    private static Logger LOGGER = Logger.getLogger(MethodLogQuartz.class);
    private static final String LOGDAYS = "log.days";

    @Autowired
    private LogService logServiceImpl;

    @Autowired
    private GroupsBillService billService;

    @Autowired
    private OrdersService ordersService;


    /** 
     * cron表达式：* * * * * *（共6位，使用空格隔开，具体如下） 
     * cron表达式：*(秒0-59) *(分 钟0-59) *(小时0-23) *(日期1-31) *(月份1-12或是JAN-DEC) *(星期1-7或是SUN-SAT) 
     */
    @Scheduled(cron="0/5 * * * * ?")
    public void clearLog() {
     /*   int logDays = Integer.valueOf(GlobalUtil.getValue(LOGDAYS));
        Date date = DateUtil.getDate(DateUtil.getDate(), -logDays);
        int count =logServiceImpl.delLogsByDate(date);
        String date1=DateUtil.getStringDate(date, DateUtil.DateFormat1);
		LOGGER.info("日志定时删除任务，删除日志数量:" + count + ", createDate < "
                + date1);
        TbLog log=new TbLog();
        log.setIp("");
        log.setOperation("定时删除日志："+count+"条");
        log.setCreateTime(date1);
        log.setUsername("系统自动任务");
        log.setMethod("");
        log.setParams("");
		logServiceImpl.insLog(log);*/
        List<GroupsBill> billList=billService.getBillByStatus();
        for (GroupsBill bill : billList) {
            //退款
            //根据订单id查看订单编号
            ShopOrders orders=ordersService.selOrderById(Integer.valueOf(bill.getoId()));
            if(orders!=null){
               String out_refund_no=String.valueOf(System.currentTimeMillis())+orders.getoId();
                try {
                    Map resultMap= Wxrefund.refund(orders.getoOrdernum(),out_refund_no,orders.getTotal().toString(),orders.getTotal().toString());
                    if (resultMap!=null){
                       //将信息存放在数据库表中
                        System.out.println(bill.getId()+"--------"+resultMap);
                        //将状态改为退款然后将记录表中的数据改为退款
                    }
                } catch (Exception e) {
                }
            }



        }
    }


}
