package com.example.demo.pojo;

import java.util.Date;
import javax.persistence.*;

public class User {
    /**
     * 主键递增
     */
    @Id
    private Integer userid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 密码
     */
    private String password;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 描述
     */
    private String content;

    /**
     * 获取主键递增
     *
     * @return userid - 主键递增
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置主键递增
     *
     * @param userid 主键递增
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取描述
     *
     * @return content - 描述
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置描述
     *
     * @param content 描述
     */
    public void setContent(String content) {
        this.content = content;
    }
}