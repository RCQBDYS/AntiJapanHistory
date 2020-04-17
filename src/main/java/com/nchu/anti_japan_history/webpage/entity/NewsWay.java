package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 报纸存储路径实体类
*/
@Data
public class NewsWay implements Serializable {
    private Integer newsWayId;     //报纸存储Id
    private Integer newspaperId;   //报纸Id
    private String contentWay;     //报纸存储路径
}
