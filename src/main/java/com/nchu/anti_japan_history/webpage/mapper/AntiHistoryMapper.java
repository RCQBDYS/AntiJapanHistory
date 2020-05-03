package com.nchu.anti_japan_history.webpage.mapper;

import com.nchu.anti_japan_history.webpage.entity.AntiHistory;

import java.util.List;

/**
*@Author: wangshen
*@Date: 2020/4/17
*@Description: 历史条目保存的mapping
*/
public interface AntiHistoryMapper {

    //历史条目的保存
    void addEntriesDataSave(AntiHistory antiHistory);
    //局部抗战历史显示
    List<AntiHistory> partHistorySelect();
    //全国抗战历史显示
    List<AntiHistory> nationwideHistorySelect();
    //伟大胜利抗战历史显示
    List<AntiHistory> victoryHistorySelect();
    //游击战争历史显示
    List<AntiHistory> guerrillaWarfareSelect();
    //局部抗战历史显示all
    List<AntiHistory> partListAll();
    //全国抗战历史显示all
    List<AntiHistory> nationwideListAll();
    //伟大胜利历史显示all
    List<AntiHistory> victoryListAll();
    //游击战争历史显示all
    List<AntiHistory> guerrillaWarfareListAll();

}
