package com.nchu.anti_japan_history.webpage.mapper;

import com.nchu.anti_japan_history.webpage.entity.AntiHistory;

/**
*@Author: wangshen
*@Date: 2020/4/17
*@Description: 历史条目保存的mapping
*/
public interface AntiHistoryMapper {
    int addEntriesDataSave(AntiHistory antiHistory);
}
