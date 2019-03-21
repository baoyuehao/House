package com.example.demo.service;

import com.example.demo.controller.MainController;
import com.example.demo.mapper.*;
import com.example.demo.pojo.House;
import com.example.demo.pojo.Owner;
import com.example.demo.pojo.Picture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by baoyu on 2019/2/11.
 */
@Service
@Slf4j
public class HouseServiceImpl implements HouseService{
    @Autowired
    HouseMapper houseMapper;
    @Autowired
    HouseMapperCustom houseMapperCustom;
    @Autowired
    OwnerMapper ownerMapper;
    @Autowired
    PictureMapper pictureMapper;
    @Autowired
    PictureMapperCustom pictureMapperCustom;
    @Autowired
    OwnerMapperCustom ownerMapperCustom;
    @Override
    public boolean addHouse(House house,int hid) {
        try {
            if(hid == 0)
                houseMapper.insert(house);
            else {
                houseMapper.updateByPrimaryKey(house);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<House> getHouses(Integer userid, int page) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("huid",userid);
        map.put("begin",(page-1)*10);
        map.put("num",10);
        return (ArrayList<House>) houseMapperCustom.queryHouseByPage(map);
    }

    @Override
    public ArrayList<Owner> getOwnerByHouses(ArrayList<House> houses) {
        ArrayList<Owner> owners  = new ArrayList<Owner>();
        for(int i=0;i<houses.size();i++){
            Owner owner = ownerMapper.selectByPrimaryKey(houses.get(i).getHowner());
            if(owner == null) {
                owner = new Owner();
                owner.setOname("暂无");
                owner.setOphone("暂无");
            }
            owners.add(owner);
        }
        return owners;
    }

    @Override
    public ArrayList<Owner> getOwners() {
        return (ArrayList<Owner>) ownerMapper.selectAll();
    }

    @Override
    public void addPicture(Picture picture) {
        pictureMapper.insert(picture);
    }

    @Override
    public ArrayList<ArrayList<Picture>> getPicUrlsByHouses(ArrayList<House> houses) {
        ArrayList<ArrayList<Picture>> picUris = new ArrayList<ArrayList<Picture>>();
        for(int i=0;i<houses.size();i++){
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("hid",houses.get(i).getHid());
            ArrayList<Picture> pictures = (ArrayList<Picture>) pictureMapperCustom.queryPicURIsByHouses(map);
            if(pictures==null) {
                pictures = new ArrayList<Picture>();
            }
            picUris.add(pictures);
        }
        return picUris;
    }

    @Override
    public void deleteHouse(int hid) {
        houseMapper.deleteByPrimaryKey(hid);
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("hid",hid);
        ArrayList<Picture> pictures = (ArrayList<Picture>) pictureMapperCustom.queryPicURIsByHouses(map);
        for(int i=0;i<pictures.size();i++){
            String path = MainController.UPLOAD_PATH+"/"+pictures.get(i).getPname();
            File file = new File(path);
            if(file.exists())
                file.delete();
            pictureMapper.deleteByPrimaryKey(pictures.get(i).getPid());
        }
    }

    @Override
    public void addOwner(Owner owner,int oid) {
        if(oid ==0)
            ownerMapper.insert(owner);
        else
            ownerMapper.updateByPrimaryKey(owner);
    }

    @Override
    public ArrayList<Owner> getOwnersByUserIdAndPage(Integer userid, int owner_page) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("ouserid",userid);
        map.put("begin",(owner_page-1)*10);
        return (ArrayList<Owner>) ownerMapperCustom.queryOwnerByUserIdAndPage(map);
    }

    @Override
    public void deleteOwner(int oid) {
        ownerMapper.deleteByPrimaryKey(oid);
    }
}
