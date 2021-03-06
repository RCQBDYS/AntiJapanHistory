package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 抗战故事实体类
*/
@Data
public class AntiWarStories implements Serializable {
    private Integer antiWarId;      //抗战故事Id
    private String title;           //抗战故事标题
    private String storiesDescription;//抗战故事描述
    private String storiesContent;  //抗战故事内容
    private String storiesPicture;  //抗战故事图片
    private Integer storiesState;   //审核状态
    private String storiesContribution;//贡献者
    private String storiesNotReason;//未通过原因
}
