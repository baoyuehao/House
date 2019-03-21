package com.example.demo.mapper;

import com.example.demo.pojo.House;
import com.example.demo.pojo.Owner;
import com.example.demo.utils.MyMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public interface OwnerMapperCustom extends MyMapper<Owner> {
    /**
     * 查找所有房主
     */
    public List<Owner> queryOwnerByUserIdAndPage(HashMap<String, Object> map);


}