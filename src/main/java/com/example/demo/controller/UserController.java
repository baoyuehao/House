package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.properties.Html5Properties;
import com.example.demo.service.UserService;
import com.example.demo.utils.TransactionUtil;
import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by baoyu on 2018/9/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private Html5Properties html5;

    @Autowired
    private Sid sid;

    /**
     * 编程式事务管理
     */
    @Autowired
    private TransactionUtil transactionUtil;

    @RequestMapping(value = "/users")
    public String Users(ModelMap map){
        List<User> users = userService.queryUserList(new User());
        map.addAttribute("users",users);
        User user = userService.queryUserById(50);
        map.addAttribute("user",user);
        return "/thymeleaf/user";
    }

    @RequestMapping("/adduser")
    public String adduser(){
            User user = new User();
            user.setAge(10);
            user.setBirthday(new Date());
            user.setContent(sid.nextShort());
            user.setName(sid.nextShort());
            user.setPassword("123");
          //  userService.saveUser(user);
        /**
         * 使用编程式事务来管理，调用数据库操作
         */
        boolean result = transactionUtil.transact(s -> userService.saveUser(user),"修改用户信息...");
        return "redirect:users";
    }

    @RequestMapping("/adduser2")
    public String adduser2(){
        User user = new User();
        user.setAge(100);
        user.setBirthday(new Date());
        user.setContent(sid.nextShort());
        user.setName(sid.nextShort());
        user.setPassword("123546");
        /**
         * 使用申明式事务管理.
         */
        userService.saveUser2(user);
        return "redirect:users";
    }

    @GetMapping("/userspage")
    @ResponseBody
    public Object userspage(@RequestParam(value = "page",required = true,defaultValue = "1") Integer page){
        logger.error(">>>>>>>>> userspage >>>>>>>>"+page);
        List<User> users = userService.queryUserListPaged(new User(),page,10);
        return users;
    }

    @GetMapping("/usersbyage")
    @ResponseBody
    public Object usersbyage(@RequestParam(value = "age",required = true,defaultValue = "10") Integer age){
        List<User> users = userService.queryUserByAge(age);
        return users;
    }



}
