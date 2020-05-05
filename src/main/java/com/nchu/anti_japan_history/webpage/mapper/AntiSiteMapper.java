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
}
