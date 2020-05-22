package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wangshen
 * @Date: 2020/4/6
 * @Description: 用户实体类
 */
@Data
public class User implements Serializable {
    private Integer userId;         //用户id
    private String userName;        //用户账号
    private String userPassword;    //用户密码
    private String userPicture;     //用户头像
    private Integer userPower;      //用户权限
    private Integer userPoint;      //用户积分
    private Integer number;         //贡献次数
}
