package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 期刊期号
*/
@Data
public class PeriodicalNum implements Serializable {
    private Integer periodicalsId;  //期刊数Id
    private Integer periodicalId;   //期刊id
    private String periodicalTime;  //期刊时间
    private String periodicalWay;   //期刊路径
}
