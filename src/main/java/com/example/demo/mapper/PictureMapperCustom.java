package com.example.demo.mapper;

import com.example.demo.pojo.House;
import com.example.demo.pojo.Picture;
import com.example.demo.utils.MyMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public interface PictureMapperCustom extends MyMapper<Picture> {
    /**
     * 自定义查找：查询某个房源的所有图片
     */
    public List<Picture> queryPicURIsByHouses(HashMap<String, Object> map);


}