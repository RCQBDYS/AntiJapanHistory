package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;

import java.io.Serializable;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 期刊实体类
*/
@Data
public class Periodical implements Serializable {
    private Integer periodicalId;       //期刊Id
    private String periodicalName;      //期刊名称
    private String publishingCompany;   //出版社
    private String sponsorPerson;       //作者
}