/*
package com.ssm.task;

*/
/**
 * @program: vaccine
 * @description: 定时任务
 * @author: huzi
 * @create: 2019-04-02 20:18
 **//*

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.irs.service.WxUserTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 *
 * 类名称：TimerTask
 * 类描述：定时器任务
 * 创建人：geekfly
 * 创建时间：Aug 29, 2016 10:56:27 AM
 * @version  V1.0
 *
 *//*

@Component
public class TimerTask {

    */
/**
     * 每天22点30启动任务
     *//*

    @Scheduled(cron = "0 30 13 ? * *")
    public void test1()
    {

            String templateId= Global.getConfig("global.notify_template_id");
            String templateUrl= Global.getConfig("global.notify_template_url");
            Map dataMap=new HashMap(){{
                put("touser",openId);
                put("template_id",templateId);
                put("url",templateUrl);
            }};
            Map innerDataMap=new HashMap(){{
                put("first",new HashMap(){{
                    put("value","您好,您有明日疫苗需注射");
                }});
                put("keyword1",new HashMap(){{
                    put("value",patientTreatment.getPatientName());
                }});
                put("keyword2",new HashMap(){{
                    put("value",pullDay);
                }});
                put("remark",new HashMap(){{
                    put("value","请您于明日到"+station.getFullName()+"诊所接受疫苗注射");
                }});
            }};
            Map key3Map=new HashMap();
            key3Map.put("value",msg);
            innerDataMap.put("keyword3",key3Map);
            dataMap.put("data",innerDataMap);
            JSONObject resObj= WxUserTool.sendTemplateMsg(accessToken, JSON.toJSONString(dataMap));
            System.out.println(resObj.toJSONString());
        }

}*/
