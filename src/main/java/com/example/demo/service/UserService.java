package com.example.demo.service;

import com.example.demo.pojo.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by baoyu on 2018/9/10.
 */
public interface UserService {

    public void saveUser(User user) ;

    public void saveUser2(User user);

    public void updateUser(User user);

    public void deleteUser(Integer userId);

    public User queryUserById(Integer userId);

    public List<User> queryUserList(User user);

    public List<User> queryUserListPaged(User user, Integer page, Integer pageSize);

    public User queryUserByIdCustom(Integer userId);

    public void saveUserTransactional(User user);

    public List<User> queryUserByAge(Integer age);

    User checkUserByLoginIn(String name, String password);
}
