package com.example.demo.pojo;

import java.util.Date;
import javax.persistence.*;

public class House {
    /**
     * 主键递增
     */
    @Id
    private Integer hid;

    /**
     * 房屋类型
     */
    private String htype;

    /**
     * 楼层
     */
    private Integer hlevel;

    /**
     * 面积
     */
    private Double hsize;

    /**
     * 房龄
     */
    private String hage;

    /**
     * 装修
     */
    private String hpaint;

    /**
     * 来源
     */
    private String hsource;

    /**
     * 创建时间
     */
    private Date hcreatetime;

    /**
     * 最后一次更改时间
     */
    private Date hlastupdatetime;

    /**
     * 房屋最低价格
     */
    private Double hlowestprice;

    /**
     * 房屋最高价
     */
    private Double hhighestprice;

    private Integer howner;

    /**
     * 创建者
     */
    private Integer huid;

    /**
     * 房屋标题
     */
    private String htitle;

    /**
     * 小区名称
     */
    private String hvillage;

    /**
     * 跟进
     */
    private String hstep;

    /**
     * 质量
     */
    private String hquality;

    /**
     * 房屋描述
     */
    private String hdescribe;

    /**
     * 获取主键递增
     *
     * @return hid - 主键递增
     */
    public Integer getHid() {
        return hid;
    }

    /**
     * 设置主键递增
     *
     * @param hid 主键递增
     */
    public void setHid(Integer hid) {
        this.hid = hid;
    }

    /**
     * 获取房屋类型
     *
     * @return htype - 房屋类型
     */
    public String getHtype() {
        return htype;
    }

    /**
     * 设置房屋类型
     *
     * @param htype 房屋类型
     */
    public void setHtype(String htype) {
        this.htype = htype;
    }

    /**
     * 获取楼层
     *
     * @return hlevel - 楼层
     */
    public Integer getHlevel() {
        return hlevel;
    }

    /**
     * 设置楼层
     *
     * @param hlevel 楼层
     */
    public void setHlevel(Integer hlevel) {
        this.hlevel = hlevel;
    }

    /**
     * 获取面积
     *
     * @return hsize - 面积
     */
    public Double getHsize() {
        return hsize;
    }

    /**
     * 设置面积
     *
     * @param hsize 面积
     */
    public void setHsize(Double hsize) {
        this.hsize = hsize;
    }

    /**
     * 获取房龄
     *
     * @return hage - 房龄
     */
    public String getHage() {
        return hage;
    }

    /**
     * 设置房龄
     *
     * @param hage 房龄
     */
    public void setHage(String hage) {
        this.hage = hage;
    }

    /**
     * 获取装修
     *
     * @return hpaint - 装修
     */
    public String getHpaint() {
        return hpaint;
    }

    /**
     * 设置装修
     *
     * @param hpaint 装修
     */
    public void setHpaint(String hpaint) {
        this.hpaint = hpaint;
    }

    /**
     * 获取来源
     *
     * @return hsource - 来源
     */
    public String getHsource() {
        return hsource;
    }

    /**
     * 设置来源
     *
     * @param hsource 来源
     */
    public void setHsource(String hsource) {
        this.hsource = hsource;
    }

    /**
     * 获取创建时间
     *
     * @return hcreatetime - 创建时间
     */
    public Date getHcreatetime() {
        return hcreatetime;
    }

    /**
     * 设置创建时间
     *
     * @param hcreatetime 创建时间
     */
    public void setHcreatetime(Date hcreatetime) {
        this.hcreatetime = hcreatetime;
    }

    /**
     * 获取最后一次更改时间
     *
     * @return hlastupdatetime - 最后一次更改时间
     */
    public Date getHlastupdatetime() {
        return hlastupdatetime;
    }

    /**
     * 设置最后一次更改时间
     *
     * @param hlastupdatetime 最后一次更改时间
     */
    public void setHlastupdatetime(Date hlastupdatetime) {
        this.hlastupdatetime = hlastupdatetime;
    }

    /**
     * 获取房屋最低价格
     *
     * @return hlowestprice - 房屋最低价格
     */
    public Double getHlowestprice() {
        return hlowestprice;
    }

    /**
     * 设置房屋最低价格
     *
     * @param hlowestprice 房屋最低价格
     */
    public void setHlowestprice(Double hlowestprice) {
        this.hlowestprice = hlowestprice;
    }

    /**
     * 获取房屋最高价
     *
     * @return hhighestprice - 房屋最高价
     */
    public Double getHhighestprice() {
        return hhighestprice;
    }

    /**
     * 设置房屋最高价
     *
     * @param hhighestprice 房屋最高价
     */
    public void setHhighestprice(Double hhighestprice) {
        this.hhighestprice = hhighestprice;
    }

    /**
     * @return howner
     */
    public Integer getHowner() {
        return howner;
    }

    /**
     * @param howner
     */
    public void setHowner(Integer howner) {
        this.howner = howner;
    }

    /**
     * 获取创建者
     *
     * @return huid - 创建者
     */
    public Integer getHuid() {
        return huid;
    }

    /**
     * 设置创建者
     *
     * @param huid 创建者
     */
    public void setHuid(Integer huid) {
        this.huid = huid;
    }

    /**
     * 获取房屋标题
     *
     * @return htitle - 房屋标题
     */
    public String getHtitle() {
        return htitle;
    }

    /**
     * 设置房屋标题
     *
     * @param htitle 房屋标题
     */
    public void setHtitle(String htitle) {
        this.htitle = htitle;
    }

    /**
     * 获取小区名称
     *
     * @return hvillage - 小区名称
     */
    public String getHvillage() {
        return hvillage;
    }

    /**
     * 设置小区名称
     *
     * @param hvillage 小区名称
     */
    public void setHvillage(String hvillage) {
        this.hvillage = hvillage;
    }

    /**
     * 获取跟进
     *
     * @return hstep - 跟进
     */
    public String getHstep() {
        return hstep;
    }

    /**
     * 设置跟进
     *
     * @param hstep 跟进
     */
    public void setHstep(String hstep) {
        this.hstep = hstep;
    }

    /**
     * 获取质量
     *
     * @return hquality - 质量
     */
    public String getHquality() {
        return hquality;
    }

    /**
     * 设置质量
     *
     * @param hquality 质量
     */
    public void setHquality(String hquality) {
        this.hquality = hquality;
    }

    /**
     * 获取房屋描述
     *
     * @return hdescribe - 房屋描述
     */
    public String getHdescribe() {
        return hdescribe;
    }

    /**
     * 设置房屋描述
     *
     * @param hdescribe 房屋描述
     */
    public void setHdescribe(String hdescribe) {
        this.hdescribe = hdescribe;
    }
}