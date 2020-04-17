package com.nchu.anti_japan_history.webpage.service.impl;

import com.nchu.anti_japan_history.webpage.entity.AntiHistory;
import com.nchu.anti_japan_history.webpage.mapper.AntiHistoryMapper;
import com.nchu.anti_japan_history.webpage.service.AntiHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*@Author: wangshen
*@Date: 2020/4/17
*@Description: 历史条目服务接口的实现
*/
@Service
public class AntiHistoryServiceImpl implements AntiHistoryService {
    @Autowired
    AntiHistoryMapper antiHistoryMapper;

    @Override
    public int addEntriesDataSave(AntiHistory antiHistory) {
        return antiHistoryMapper.addEntriesDataSave(antiHistory);
    }
}
