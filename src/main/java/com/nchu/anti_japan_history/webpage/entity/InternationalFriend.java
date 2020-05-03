package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 国际友人实体类
*/
@Data
public class InternationalFriend implements Serializable {
    private Integer internationalFriendId; //国际友人id
    private String name;                   //姓名
    private String achievement;            //成就
    private String picture;                //图片
    private Integer friendState;           //审核状态
    private String friendContribution;     //贡献者
}
