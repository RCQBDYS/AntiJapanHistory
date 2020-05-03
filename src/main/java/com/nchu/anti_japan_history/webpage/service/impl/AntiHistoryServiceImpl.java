package com.nchu.anti_japan_history.webpage.service.impl;

import com.nchu.anti_japan_history.webpage.entity.AntiHistory;
import com.nchu.anti_japan_history.webpage.mapper.AntiHistoryMapper;
import com.nchu.anti_japan_history.webpage.service.AntiHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void addEntriesDataSave(AntiHistory antiHistory) {
        antiHistoryMapper.addEntriesDataSave(antiHistory);
    }

    @Override
    public List<AntiHistory> partHistorySelect() {
        return antiHistoryMapper.partHistorySelect();
    }

    @Override
    public List<AntiHistory> nationwideHistorySelect() {
        return antiHistoryMapper.nationwideHistorySelect();
    }

    @Override
    public List<AntiHistory> victoryHistorySelect() {
        return antiHistoryMapper.victoryHistorySelect();
    }

    @Override
    public List<AntiHistory> guerrillaWarfareSelect() {
        return antiHistoryMapper.guerrillaWarfareSelect();
    }

    @Override
    public List<AntiHistory> partListAll() {
        return antiHistoryMapper.partListAll();
    }

    @Override
    public List<AntiHistory> nationwideListAll() {
        return antiHistoryMapper.nationwideListAll();
    }

    @Override
    public List<AntiHistory> victoryListAll() {
        return antiHistoryMapper.victoryListAll();
    }

    @Override
    public List<AntiHistory> guerrillaWarfareListAll() {
        return antiHistoryMapper.guerrillaWarfareListAll();
    }
}
