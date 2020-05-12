package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 抗日人物实体类
*/
@Data
public class AntiJapanPerson implements Serializable {
    private Integer antiJapanPersonId;  //人物id
    private String personName;          //人物名称
    private String personDescription;   //人物描述
    private String timeQuantum;         //人物存在时间段
    private String content;             //人物介绍
    private String personPicture;       //人物图片
    private Integer personState;        //审核状态
    private String personContribution;  //贡献者
    private String personNotReason;     //未通过原因
}
