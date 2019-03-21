package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by baoyu on 2018/9/10.
 */
@Controller
@RequestMapping("/hello")
public class Controller_html {

    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String say(@PathVariable("id") Integer id){
        return "id:"+id;
    }

    @RequestMapping(value = "/say2", method = RequestMethod.GET)
    @ResponseBody
    public String say2(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "id2:"+id;
    }

    @GetMapping(value = "/say3")
    @ResponseBody
    public String say3(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "id3:"+id;
    }

    @PostMapping(value = "/say4")
    @ResponseBody
    public String say4(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "id4:"+id;
    }

}
