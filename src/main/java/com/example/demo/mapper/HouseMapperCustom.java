package com.example.demo.mapper;

import com.example.demo.pojo.House;
import com.example.demo.pojo.User;
import com.example.demo.utils.MyMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public interface HouseMapperCustom extends MyMapper<House> {
    /**
     * 自定义查找：查询用户下的第几页房源
     */
    public List<House> queryHouseByPage(HashMap<String, Object> map);


}