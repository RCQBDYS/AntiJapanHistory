package com.nchu.anti_japan_history.webpage.service.impl;

import com.nchu.anti_japan_history.webpage.entity.AntiHistory;
import com.nchu.anti_japan_history.webpage.entity.User;
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

    @Override
    public AntiHistory selectHistoryDisplay(Long historyId) {
        return antiHistoryMapper.selectHistoryDisplay(historyId);
    }

    @Override
    public List<AntiHistory> antiHistoryPastListAll() {
        return antiHistoryMapper.antiHistoryPastListAll();
    }

    @Override
    public List<AntiHistory> antiHistoryAuditListAll() {
        return antiHistoryMapper.antiHistoryAuditListAll();
    }

    @Override
    public List<AntiHistory> antiHistoryNotAdoptedListAll() {
        return antiHistoryMapper.antiHistoryNotAdoptedListAll();
    }

    @Override
    public void examineUpdate(AntiHistory antiHistory) {
        antiHistoryMapper.examineUpdate(antiHistory);
    }

    @Override
    public List<AntiHistory> timeListAll() {
        return antiHistoryMapper.timeListAll();
    }

    @Override
    public List<AntiHistory> consumerAuditHistoryListAll(String antiHistoryContribution) {
        return antiHistoryMapper.consumerAuditHistoryListAll(antiHistoryContribution);
    }

    @Override
    public List<AntiHistory> consumerPassHistoryListAll(String antiHistoryContribution) {
        return antiHistoryMapper.consumerPassHistoryListAll(antiHistoryContribution);
    }

    @Override
    public List<AntiHistory> consumerNotAdoptedListAll(String antiHistoryContribution) {
        return antiHistoryMapper.consumerNotAdoptedListAll(antiHistoryContribution);
    }

    @Override
    public void editAntiHistoryUpdate(AntiHistory antiHistory) {
        antiHistoryMapper.editAntiHistoryUpdate(antiHistory);
    }



    //地图信息显示
    @Override
    public List<AntiHistory> JiangxiListAll() {
        return antiHistoryMapper.JiangxiListAll();
    }

    @Override
    public List<AntiHistory> HeilongjiangListAll() {
        return antiHistoryMapper.HeilongjiangListAll();
    }

    @Override
    public List<AntiHistory> JilinListAll() {
        return antiHistoryMapper.JilinListAll();
    }

    @Override
    public List<AntiHistory> LiaoningListAll() {
        return antiHistoryMapper.LiaoningListAll();
    }

    @Override
    public List<AntiHistory> HebeiListAll() {
        return antiHistoryMapper.HebeiListAll();
    }

    @Override
    public List<AntiHistory> ShandongListAll() {
        return antiHistoryMapper.ShandongListAll();
    }

    @Override
    public List<AntiHistory> JiangsuListAll() {
        return antiHistoryMapper.JiangsuListAll();
    }

    @Override
    public List<AntiHistory> ZhejiangListAll() {
        return antiHistoryMapper.ZhejiangListAll();
    }

    @Override
    public List<AntiHistory> HenanListAll() {
        return antiHistoryMapper.HenanListAll();
    }

    @Override
    public List<AntiHistory> ShanxiListAll() {
        return antiHistoryMapper.ShanxiListAll();
    }

    @Override
    public List<AntiHistory> HubeiListAll() {
        return antiHistoryMapper.HubeiListAll();
    }

    @Override
    public List<AntiHistory> HunanListAll() { return antiHistoryMapper.HunanListAll(); }

    @Override
    public List<AntiHistory> YunnanListAll() {
        return antiHistoryMapper.YunnanListAll();
    }

    @Override
    public List<AntiHistory> ShanghaiListAll() {
        return antiHistoryMapper.ShanghaiListAll();
    }

    @Override
    public List<AntiHistory> ChongqingListAll() {
        return antiHistoryMapper.ChongqingListAll();
    }

    @Override
    public List<AntiHistory> BeijingListAll() { return antiHistoryMapper.BeijingListAll(); }

    @Override
    public List<AntiHistory> NeimengguListAll() {
        return antiHistoryMapper.NeimengguListAll();
    }

    @Override
    public List<AntiHistory> GuangxiListAll() {
        return antiHistoryMapper.GuangxiListAll();
    }

    @Override
    public List<AntiHistory> GuangdongListAll() {
        return antiHistoryMapper.GuangdongListAll();
    }


}
