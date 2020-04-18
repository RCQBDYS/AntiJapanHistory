package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 导航栏实体类
*/
@Data
public class SpecialTopic implements Serializable {
    private Integer specialTopicId; //导航栏id
    private String topic;           //导航栏标题
}
