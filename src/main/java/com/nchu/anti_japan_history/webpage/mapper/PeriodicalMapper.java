package com.nchu.anti_japan_history.webpage.mapper;

import com.nchu.anti_japan_history.webpage.entity.Periodical;

import java.util.List;

public interface PeriodicalMapper {

    //查询期刊all
    List<Periodical> periodicalListAll();
    //期刊信息的保存
    int periodicalSave(Periodical periodical);
    //期刊信息的详细显示
    Periodical periodicalDisplay(Long periodicalId);
    //普通用户查询通过的期刊信息
    List<Periodical> consumerPassPeriodical(String periodicalContribution);
    //普通用户查询待审核
    List<Periodical> consumerAuditPeriodical(String periodicalContribution);
    //普通用户查询未通过
    List<Periodical> consumerNotAdoptedPeriodical(String periodicalContribution);

    //管理员查询通过
    List<Periodical> adminPassPeriodical();
    //管理员查询待审核
    List<Periodical> adminAuditPeriodical();
    //管理员查询未通过
    List<Periodical> adminNotAdoptedPeriodical();

    //删除期刊信息
    int deleteByPeriodicalId(Long periodicalId);
}
