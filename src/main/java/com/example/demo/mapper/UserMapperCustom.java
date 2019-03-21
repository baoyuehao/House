package com.example.demo.mapper;

import com.example.demo.pojo.User;
import com.example.demo.utils.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public interface UserMapperCustom extends MyMapper<User> {
    /**
     * 自定义查找：查询age条件的用户
     */
    public List<User> queryUserByAge(HashMap<String,String> map);

    /**
     * 自定义查找：查询用户根据账号和密码
     */
    public User queryUserByNameAndPassword(HashMap<String,String> map);
}