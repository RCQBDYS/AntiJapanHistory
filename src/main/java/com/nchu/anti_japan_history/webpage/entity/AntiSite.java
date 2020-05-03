package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 地图类实体
*/
@Data
public class AntiSite implements Serializable {
    private Integer antiSiteId;     //遗址id
    private String antiSiteName;    //遗址名称
    private String exhibitions;     //展览内容
    private String collections;     //收藏物品
    private String address;         //地址
    private String url;             //网址
    private String antiSitePicture; //遗址图片
    private Integer antiSiteState;  //审核状态
    private String antiSiteContribution;//贡献者
}
