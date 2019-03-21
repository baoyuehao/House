package com.example.demo.utils;

import jdk.nashorn.internal.runtime.ECMAException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.function.Consumer;

/**
 * Created by baoyu on 2018/9/18.
 * 编程式事务管理类
 */
@Component
public class TransactionUtil {

    @Autowired
    private PlatformTransactionManager transactionManager;

    private static final Logger logger = LoggerFactory.getLogger(TransactionUtil.class);

    /**
     * 调用该方法，使用编程式事务管理，抛弃申明式事务管理，不需要在调用处加@Transactional,使用事务管理，必须建表的类型为InnoDB。
     * @param consumer
     * @return
     */
    public boolean transact(Consumer consumer,String message) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            consumer.accept(null);
            transactionManager.commit(status);
            //事务执行成功，返回true
            logger.info(message+"事务执行成功，返回true");
            return true;
        }catch (Exception e){
            //事务执行失败，回滚数据库操作
            transactionManager.rollback(status);
            logger.error(message+"事务执行失败，返回false..."+e.getMessage());
            return false;
        }
    }
}
