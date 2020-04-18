package com.nchu.anti_japan_history.webpage.service.impl;

import com.nchu.anti_japan_history.webpage.entity.User;
import com.nchu.anti_japan_history.webpage.mapper.UserMapper;
import com.nchu.anti_japan_history.webpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wangshen
 * @Date: 2020/4/10
 * @Description: 登录、注册类服务层
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /*
     * 注册
     * */
    @Override
    public int save(User user) {
        return userMapper.save(user);
    }

    /*
     * 登录
     * */
    @Override
    public User login(String userName, String userPassword) {
        return userMapper.login(userName,userPassword);
    }
}
