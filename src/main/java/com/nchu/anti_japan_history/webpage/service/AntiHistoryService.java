package com.nchu.anti_japan_history.webpage.service;
/**
*@Author: wangshen
*@Date: 2020/4/17
*@Description: 历史事件的服务接口
*/
import com.nchu.anti_japan_history.webpage.entity.AntiHistory;

public interface AntiHistoryService {
    //历史条目的保存
    int addEntriesDataSave(AntiHistory antiHistory);
}
