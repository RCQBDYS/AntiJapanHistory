package com.nchu.anti_japan_history.webpage.service.impl;

import com.nchu.anti_japan_history.webpage.entity.Periodical;
import com.nchu.anti_japan_history.webpage.mapper.PeriodicalMapper;
import com.nchu.anti_japan_history.webpage.service.PeriodicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@Author: wangshen
*@Date: 2020/4/21
*@Description: 期刊服务类接口实现类
*/
@Service
public class PeriodicalServiceImpl implements PeriodicalService {
    @Autowired
    PeriodicalMapper periodicalMapper;
    @Override
    public List<Periodical> periodicalListAll() {
        return periodicalMapper.periodicalListAll();
    }

    @Override
    public int periodicalSave(Periodical periodical) {
        return periodicalMapper.periodicalSave(periodical);
    }

    @Override
    public Periodical periodicalDisplay(Long periodicalId) {
        return periodicalMapper.periodicalDisplay(periodicalId);
    }

    @Override
    public List<Periodical> consumerPassPeriodical(String periodicalContribution) {
        return periodicalMapper.consumerPassPeriodical(periodicalContribution);
    }

    @Override
    public List<Periodical> consumerAuditPeriodical(String periodicalContribution) {
        return periodicalMapper.consumerAuditPeriodical(periodicalContribution);
    }

    @Override
    public List<Periodical> consumerNotAdoptedPeriodical(String periodicalContribution) {
        return periodicalMapper.consumerNotAdoptedPeriodical(periodicalContribution);
    }

    @Override
    public List<Periodical> adminPassPeriodical() {
        return periodicalMapper.adminPassPeriodical();
    }

    @Override
    public List<Periodical> adminAuditPeriodical() {
        return periodicalMapper.adminAuditPeriodical();
    }

    @Override
    public List<Periodical> adminNotAdoptedPeriodical() {
        return periodicalMapper.adminNotAdoptedPeriodical();
    }
}
