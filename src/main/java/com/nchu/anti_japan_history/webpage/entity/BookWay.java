package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 书籍存储路径
*/
@Data
public class BookWay implements Serializable {
    private Integer contentId;  //书籍内容id
    private String contentWay;  //书籍存放路径
    private Integer bookId;     //书籍id
}
