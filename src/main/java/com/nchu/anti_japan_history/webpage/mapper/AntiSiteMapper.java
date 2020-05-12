package com.nchu.anti_japan_history.webpage.mapper;

import com.nchu.anti_japan_history.webpage.entity.AntiSite;

import java.util.List;

public interface AntiSiteMapper {
    //显示历史遗址
    List<AntiSite> antiSiteSelect();
    //显示历史遗址all
    List<AntiSite> antiSiteListAll();
    //历史博物馆信息保存
    int antiSiteSave(AntiSite antiSite);
    //历史博物馆信息详细显示
    AntiSite antiSiteDisplay(Long antiSiteId);
    //普通用户查询通过
    List<AntiSite> consumerPassSite(String antiSiteContribution);
    //普通用户查询待审核
    List<AntiSite> consumerAuditSite(String antiSiteContribution);
    //普通用户查询未通过
    List<AntiSite> consumerNotAdoptedSite(String antiSiteContribution);

    //管理员查询通过
    List<AntiSite> adminPassSite();
    //管理员查询待审核
    List<AntiSite> adminAuditSite();
    //管理员查询未通过
    List<AntiSite> adminNotAdoptSite();
}
