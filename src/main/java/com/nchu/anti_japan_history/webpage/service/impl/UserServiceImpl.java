package com.nchu.anti_japan_history.webpage.service.impl;

import com.nchu.anti_japan_history.webpage.entity.User;
import com.nchu.anti_japan_history.webpage.mapper.UserMapper;
import com.nchu.anti_japan_history.webpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangshen
 * @Date: 2020/4/10
 * @Description: 登录、注册类服务层
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    //注册用户
    @Override
    public int save(User user) {
        return userMapper.save(user);
    }

    //登录
    @Override
    public User login(String userName, String userPassword) {
        return userMapper.login(userName,userPassword);
    }

    //动态检验用户名是否存在
    @Override
    public List<User> selectUserName(String userName) {
        return userMapper.selectUserName(userName);
    }

    //查询单个用户
    @Override
    public User selectById(Long userId) {
        return userMapper.selectById(userId);
    }

    //更新用户信息
    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    //查询所有用户
    @Override
    public List<User> userMessageListAll() {
        return userMapper.userMessageListAll();
    }

    //用户信息的查询
    @Override
    public List<User> searchByKeyWord(String keyWord) {
        return userMapper.searchByKeyWord(keyWord);
    }

    @Override
    public int deleteById(Long userId) {
        return userMapper.deleteById(userId);
    }


}
