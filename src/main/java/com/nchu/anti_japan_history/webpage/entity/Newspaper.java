package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 报纸实体类
*/
@Data
public class Newspaper implements Serializable {
    private Integer newspaperId;        //报纸id
    private String newspaperName;       //报纸名称
    private String newspaperPicture;    //报纸图片
    private String newspaperPath;       //报纸路径
    private String principalPerson;     //主要负责人
    private String publishing;          //出版社
    private String placeOfPublication;  //出版地点
    private Date publicationTime;     //出版时间
    private Integer newspaperState;     //审核状态
    private String newspaperContribution;//贡献者
}
