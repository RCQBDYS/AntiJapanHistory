package com.nchu.anti_japan_history.webpage.service;

import com.nchu.anti_japan_history.webpage.entity.User;

import java.util.List;

/**
 * @Author: wangshen
 * @Date: 2020/4/10
 * @Description: 登录、注册服务层接口
 */
public interface UserService {
    //注册
    int save(User user);
    //登录
    User login(String userName,String userPassword);

    //用户名校验
    List<User> selectUserName(String userName);
    //用户信息查询
    User selectById(Long userId);
    //用户信息修改
    int update(User user);
    //查询所有用户名信息
    List<User> userMessageListAll();
    //用户信息模糊查询
    List<User> searchByKeyWord(String keyWord);
    //用户信息删除
    int deleteById(Long userId);
}
