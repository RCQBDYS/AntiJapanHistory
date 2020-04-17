package com.nchu.anti_japan_history.webpage.service;

import com.nchu.anti_japan_history.webpage.entity.User;

/**
 * @Author: wangshen
 * @Date: 2020/4/10
 * @Description: 登录、注册服务层接口
 */
public interface UserService {
    /*注册*/
    int save(User user);

    /*登录*/
    User login(String userName,String userPassword);
}
