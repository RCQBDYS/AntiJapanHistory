package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 照片数据实体类
*/
@Data
public class Picture implements Serializable {
    private Integer pictureId;          //图片Id
    private String pictureWay;          //图片路径
    private String pictureDescription;  //图片描述
    private String pictureName;         //图片名称
    private String pictureContribution; //贡献者
    private Integer pictureState;       //审核状态
}
