package com.nchu.anti_japan_history.webpage.entity;
/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 抗日历史表实体类
*/
import lombok.Data;

import java.io.Serializable;
@Data
public class AntiHistory implements Serializable {
    private Integer antiHistoryId;        //历史事件id
    private String antiHistoryName;     //历史事件名称
    private String antiHistoryPicture;  //历史事件头像
    private String antiHistoryContent;  //历史事件内容
}
