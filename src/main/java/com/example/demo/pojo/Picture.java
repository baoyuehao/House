package com.example.demo.pojo;

import javax.persistence.*;

public class Picture {
    /**
     * 主键递增
     */
    @Id
    private Integer pid;

    /**
     * 图片名称
     */
    private String pname;

    /**
     * 图片路径
     */
    private String ppath;

    /**
     * 图片大小
     */
    private Integer psize;

    /**
     * 图片类型
     */
    private String ptype;

    /**
     * 属于外键hid
     */
    private Integer phid;

    /**
     * 获取主键递增
     *
     * @return pid - 主键递增
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置主键递增
     *
     * @param pid 主键递增
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取图片名称
     *
     * @return pname - 图片名称
     */
    public String getPname() {
        return pname;
    }

    /**
     * 设置图片名称
     *
     * @param pname 图片名称
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * 获取图片路径
     *
     * @return ppath - 图片路径
     */
    public String getPpath() {
        return ppath;
    }

    /**
     * 设置图片路径
     *
     * @param ppath 图片路径
     */
    public void setPpath(String ppath) {
        this.ppath = ppath;
    }

    /**
     * 获取图片大小
     *
     * @return psize - 图片大小
     */
    public Integer getPsize() {
        return psize;
    }

    /**
     * 设置图片大小
     *
     * @param psize 图片大小
     */
    public void setPsize(Integer psize) {
        this.psize = psize;
    }

    /**
     * 获取图片类型
     *
     * @return ptype - 图片类型
     */
    public String getPtype() {
        return ptype;
    }

    /**
     * 设置图片类型
     *
     * @param ptype 图片类型
     */
    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    /**
     * 获取属于外键hid
     *
     * @return phid - 属于外键hid
     */
    public Integer getPhid() {
        return phid;
    }

    /**
     * 设置属于外键hid
     *
     * @param phid 属于外键hid
     */
    public void setPhid(Integer phid) {
        this.phid = phid;
    }
}