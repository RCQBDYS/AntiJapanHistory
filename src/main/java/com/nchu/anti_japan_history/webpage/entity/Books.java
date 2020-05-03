package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 资料书籍实体类
*/
@Data
public class Books implements Serializable {
    private Integer bookId;             //书籍id
    private String bookName;            //书籍名称
    private String bookPicture;         //书籍图片
    private String bookPath;            //书籍存储路径
    private String bookAuthor;          //数据作者
    private Date publicationTime;       //出版时间
    private String publishingCompany;   //出版公司
    private String briefIntroduction;   //书籍简介
    private Integer bookState;          //审核状态
    private String bookContribution;    //贡献者
}
