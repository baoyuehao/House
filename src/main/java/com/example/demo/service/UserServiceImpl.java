package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserMapperCustom;
import com.example.demo.pojo.User;
import com.github.pagehelper.PageHelper;
import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by baoyu on 2018/9/10.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private Sid sid;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserMapperCustom userMapperCustom;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    /**
     * 使用编程式事务管理，不需要添加@Transactional
     */
    public void saveUser(User user){
            logger.info(">>>>>> 1 >>>>>>>");
            user = userMapper.selectByPrimaryKey(41);
            logger.info(">>>>> 2 >>>>>");

            logger.info("??????? 3 ?????");
            user.setPassword("6666");
            userMapper.updateByPrimaryKey(user);
            int a=1/0;
            user.setPassword("7777");
            userMapper.updateByPrimaryKey(user);
            logger.info(">>>>>>>>>> 4 >>>>>>>>");
    }

    @Override
    /**
         * 修改数据库需要事务管理--申明式事务
         */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void saveUser2(User user) {
        logger.info(">>>>>> 1 >>>>>>>");
        user = userMapper.selectByPrimaryKey(42);
        logger.info(">>>>> 23 >>>>>");

        logger.info("??????? 3 ?????");
        user.setPassword("6666");
        userMapper.updateByPrimaryKey(user);
        int a=1/0;
        user.setPassword("7777");
        userMapper.updateByPrimaryKey(user);
        logger.info(">>>>>>>>>> 4 >>>>>>>>");
    }

    @Override
    /**
     * 修改数据库需要事务管理--申明式事务
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    /**
     * 修改数据库需要事务管理--申明式事务
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    /**
     * 查询数据库需要事务管理--申明式事务
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> queryUserList(User user) {
        return userMapper.selectAll();
    }

    /**
     * 分页查询
     * @param user
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<User> queryUserListPaged(User user, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

//        Example example = new Example(User.class);
//        Example.Criteria criteria = example.createCriteria();
//
//        if (!StringUtils.isEmptyOrWhitespace(user.getName())) {
//            criteria.andLike("name", "%" + user.getName() + "%");
//        }
//        example.orderBy("birthday").desc();
//        List<User> userList = userMapper.selectByExample(example);
          List<User> userList = userMapper.select(new User());
        return userList;
    }

    @Override
    public User queryUserByIdCustom(Integer userId) {
        return null;
    }

    @Override
    public void saveUserTransactional(User user) {

    }

    @Override
    public List<User> queryUserByAge(Integer age) {
        /**
         * 多参数查询，构造一个map参数集合.根据key来设置.
         */
        HashMap<String,String> map=new HashMap<String,String>();
        map.put("age","10");
        map.put("name","1809129");
        return userMapperCustom.queryUserByAge(map);
    }

    @Override
    public User checkUserByLoginIn(String name, String password) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("name",name);
        map.put("password",password);
        return userMapperCustom.queryUserByNameAndPassword(map);
    }
}
