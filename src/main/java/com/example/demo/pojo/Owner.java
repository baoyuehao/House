package com.example.demo.pojo;

import javax.persistence.*;

public class Owner {
    @Id
    private Integer oid;

    /**
     * 房主姓名
     */
    private String oname;

    /**
     * 房主联系方式
     */
    private String ophone;

    /**
     * 房主座机
     */
    private String otelphone;

    /**
     * 房主会员等级
     */
    private Integer olevel;

    /**
     * 房主性别
     */
    private Integer osex;

    /**
     * 会员所属用户
     */
    private Integer ouserid;

    /**
     * 房主地址
     */
    private String oaddress;

    /**
     * 房主描述
     */
    private String ocontent;

    /**
     * @return oid
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * @param oid
     */
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    /**
     * 获取房主姓名
     *
     * @return oname - 房主姓名
     */
    public String getOname() {
        return oname;
    }

    /**
     * 设置房主姓名
     *
     * @param oname 房主姓名
     */
    public void setOname(String oname) {
        this.oname = oname;
    }

    /**
     * 获取房主联系方式
     *
     * @return ophone - 房主联系方式
     */
    public String getOphone() {
        return ophone;
    }

    /**
     * 设置房主联系方式
     *
     * @param ophone 房主联系方式
     */
    public void setOphone(String ophone) {
        this.ophone = ophone;
    }

    /**
     * 获取房主座机
     *
     * @return otelphone - 房主座机
     */
    public String getOtelphone() {
        return otelphone;
    }

    /**
     * 设置房主座机
     *
     * @param otelphone 房主座机
     */
    public void setOtelphone(String otelphone) {
        this.otelphone = otelphone;
    }

    /**
     * 获取房主会员等级
     *
     * @return olevel - 房主会员等级
     */
    public Integer getOlevel() {
        return olevel;
    }

    /**
     * 设置房主会员等级
     *
     * @param olevel 房主会员等级
     */
    public void setOlevel(Integer olevel) {
        this.olevel = olevel;
    }

    /**
     * 获取房主性别
     *
     * @return osex - 房主性别
     */
    public Integer getOsex() {
        return osex;
    }

    /**
     * 设置房主性别
     *
     * @param osex 房主性别
     */
    public void setOsex(Integer osex) {
        this.osex = osex;
    }

    /**
     * 获取会员所属用户
     *
     * @return ouserid - 会员所属用户
     */
    public Integer getOuserid() {
        return ouserid;
    }

    /**
     * 设置会员所属用户
     *
     * @param ouserid 会员所属用户
     */
    public void setOuserid(Integer ouserid) {
        this.ouserid = ouserid;
    }

    /**
     * 获取房主地址
     *
     * @return oaddress - 房主地址
     */
    public String getOaddress() {
        return oaddress;
    }

    /**
     * 设置房主地址
     *
     * @param oaddress 房主地址
     */
    public void setOaddress(String oaddress) {
        this.oaddress = oaddress;
    }

    /**
     * 获取房主描述
     *
     * @return ocontent - 房主描述
     */
    public String getOcontent() {
        return ocontent;
    }

    /**
     * 设置房主描述
     *
     * @param ocontent 房主描述
     */
    public void setOcontent(String ocontent) {
        this.ocontent = ocontent;
    }
}