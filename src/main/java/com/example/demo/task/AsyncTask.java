package com.example.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created by baoyu on 2018/9/14.
 * 异步任务执行:同时调用两个方法，执行总时间是最大值，不是求和.
 */
@Component
public class AsyncTask {

    private static final Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    //异步任务返回值采用Future，判断任务执行结果.
    @Async
    public Future<Boolean> doing1() throws Exception{
        /**
         * 执行任务...
         */
        Thread.sleep(1000*5);
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doing2() throws Exception{
        /**
         * 执行任务...
         */
        Thread.sleep(1000*10);
        return new AsyncResult<>(true);
    }

}
