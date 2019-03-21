package com.example.demo.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.User;
import com.example.demo.redis.RedisOperator;
import com.example.demo.service.UserService;
import com.example.demo.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by baoyu on 2018/9/13.
 */
@RestController
@RequestMapping("/redis")
public class Controller_redis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisOperator redis;

    @RequestMapping("/test")
    public JSONObject test(){
        stringRedisTemplate.opsForValue().set("test","123456");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("test",stringRedisTemplate.opsForValue().get("test"));
        System.out.println(jsonObject.toString());
        User user = userService.queryUserById(60);
        stringRedisTemplate.opsForValue().set("json:user2", JsonUtils.objectToJson(user));

        return JSONObject.parseObject(stringRedisTemplate.opsForValue().get("json:user2"));
    }

    @RequestMapping("/test2")
    public JSONObject test2(){
        return JSONObject.parseObject(redis.get("json:user2"));
    }


}
