package com.example.demo.service;

import com.example.demo.pojo.House;
import com.example.demo.pojo.Owner;
import com.example.demo.pojo.Picture;

import java.util.ArrayList;

/**
 * Created by baoyu on 2019/2/11.
 */
public interface HouseService {
    boolean addHouse(House house,int hid);

    ArrayList<House> getHouses(Integer userid, int page);

    ArrayList<Owner> getOwnerByHouses(ArrayList<House> houses);

    ArrayList<Owner> getOwners();

    void addPicture(Picture picture);

    ArrayList<ArrayList<Picture>> getPicUrlsByHouses(ArrayList<House> houses);

    void deleteHouse(int hid);

    void addOwner(Owner owner,int oid);

    ArrayList<Owner> getOwnersByUserIdAndPage(Integer userid, int owner_page);

    void deleteOwner(int oid);
}
