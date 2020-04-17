package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 报纸实体类
*/
@Data
public class Newspaper implements Serializable {
    private Integer newspaperId;        //报纸id
    private String newspaperName;       //报纸名称
    private String principalPerson;     //主要负责人
    private String publishing;          //出版社
    private String placeOfPublication;  //出版地点
    private String publicationTime;     //出版时间
}
