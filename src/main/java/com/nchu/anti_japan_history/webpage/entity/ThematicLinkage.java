package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 导航栏连接实体类
*/
@Data
public class ThematicLinkage implements Serializable {
    private Integer specialTopicId; //导航栏id
    private Integer pictureId;      //图片id
    private Integer antiHistoryId;  //抗日故事id
    private Integer periodicalId;   //期刊id
    private Integer bookId;         //书籍id
    private Integer newspaperId;    //报纸id
}
