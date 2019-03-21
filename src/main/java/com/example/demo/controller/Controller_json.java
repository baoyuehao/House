package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by baoyu on 2018/9/10.
 */
@RestController  //RestController--请求返回json格式数据.
@RequestMapping("/json")
public class Controller_json {

    private static final Logger logger = LoggerFactory.getLogger(Controller_json.class);
//
//    @Autowired
//    private GirlProperties girlProperties;
//
//    @Autowired
//    private UserDao userDao;
//
//    @Autowired
//    private TestBeanDao testBeanDao;
//
//
////    @Value("${cupSize}")
////    private String cupSize;
//
//    @RequestMapping(value = {"/testjson","/test"},method = RequestMethod.GET)
//    public String testjson(){
//        return girlProperties.getContent();
//    }
//
//    /**
//     * 查询所有用户
//     * @return
//     */
//    @GetMapping(value = "/findAllUsers")
//    public List<User> findAllUsers(){
//            return null;
//    }
//
//    /**
//     * 添加一个用户
//     */
//    @Transactional  //开启事务管理
//    @PostMapping(value = "/addUser")
//    public User addUser(@RequestParam(value = "uname",required = true,defaultValue = "wait") String uname,
//                          @RequestParam(value = "pwd",required = true,defaultValue = "wait") String pwd,
//                          @RequestParam(value = "role",required = true,defaultValue = "0") Integer role) throws Exception{
//        User user = new User();
//        user.setUname(uname);
//        user.setPwd(pwd);
//        user.setRole(role);
//        return null;
//    }
//
//    /**
//     * 添加一个用户
//     */
//    @Transactional  //开启事务管理
//    @PostMapping(value = "/addUser2")
//    public User addUser2(@Valid  User user, BindingResult bindingResult) throws Exception{
//        if(bindingResult.hasErrors()){
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
//            return null;
//        }
//        user.setUname(user.getUname());
//        user.setPwd(user.getPwd());
//        user.setRole(user.getRole());
//        return null;
//    }
//
//    /**
//     * 通过role查询用户
//     */
//    @GetMapping(value = "/findUsersByRole")
//    public List<User> findUsersByRole(@RequestParam(value = "role",required = true,defaultValue = "0") Integer role){
//        return null;
//    }

    /**
     * 获取下一个视频信息
     */
    @GetMapping("/findNextVideo")
    public JSONObject findNextVideo(@RequestParam(value = "vid",defaultValue = "video0.mp4",required = true)String vid){
        logger.info(">>>>>>>>>>>"+vid+">>>>>>>>>>>>");
        JSONObject jsonObject = new JSONObject();
        if(vid.equals("video0.mp4")){
            vid="video1.mp4";
        }else if(vid.equals("video1.mp4")){
            vid="video2.mp4";
        }else if(vid.equals("video2.mp4")){
            vid="video0.mp4";
        }
        logger.info("请求"+vid+"视屏资源......");
            jsonObject.put("playUrl","/static/video/"+vid);
            jsonObject.put("id",vid);
            return jsonObject;

    }

}
