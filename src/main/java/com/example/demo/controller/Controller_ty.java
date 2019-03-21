package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by baoyu on 2018/9/11.
 */
@Controller
@RequestMapping("/ty")
public class Controller_ty {

    private final static Logger logger = LoggerFactory.getLogger(Controller_ty.class);

//    @Autowired
//    private GirlProperties girlProperties;
//
//    @RequestMapping("/index")
//    public String index(ModelMap map){
//        girlProperties.setDate(new Date());
//        girlProperties.setContent("<code>123456</code>");
//        map.addAttribute("girlProperties",girlProperties);
//
//        return "/thymeleaf/index";
//    }

//    @RequestMapping("/login")
//    public String login(User user){
//        logger.info("登录用户名："+user.getUname());
//        return "redirect:/ty/index";
//    }


}
