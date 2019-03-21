package com.example.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by baoyu on 2018/9/14.
 * 定时任务执行类
 */
@Component
public class MyTask {

    private static final Logger logger = LoggerFactory.getLogger(MyTask.class);

    //每10s执行一次
    //@Scheduled(fixedRate = 1000*10)
    public void dojob(){
        logger.info(new Date()+"dojob doing....");
    }

    //cron表达式
    //@Scheduled(cron = "4-40 * * * * ? ")
    public void dojob2(){
        logger.info(new Date()+"dojob2 doing 。。。 ");

    }

}
