package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by baoyu on 2018/9/11.
 */
@Controller
@RequestMapping("/ftl")
public class Controller_ftl {



    @RequestMapping("/index")
    public String index(ModelMap map){
        //map.addAttribute("girlProperties",girlProperties);
        return "/freemarker/index";
    }


}
