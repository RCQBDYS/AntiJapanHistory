package com.nchu.anti_japan_history.webpage.entity;
/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 抗日历史表实体类
*/
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class AntiHistory implements Serializable {
    private Integer antiHistoryId;        //历史事件id
    private String antiHistoryName;     //历史事件名称
    private String antiHistoryDescription;//历史事件描述
    private String antiHistoryPicture;  //历史事件头像
    private String antiHistoryContent;  //历史事件内容
    private Integer antiHistoryType;    //历史事件类型
    private Integer antiHistoryState;   //历史事件审核状态
    private String antiHistoryContribution;//历史事件贡献者
    private String notAdoptedReason;        //未通过原因
    private Date antiHistoryTime;           //历史事件的时间
    private String antiHistorySite;         //历史事件的地点
}
