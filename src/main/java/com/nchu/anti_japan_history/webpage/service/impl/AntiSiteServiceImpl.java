package com.nchu.anti_japan_history.webpage.service.impl;


import com.nchu.anti_japan_history.webpage.entity.AntiSite;
import com.nchu.anti_japan_history.webpage.mapper.AntiSiteMapper;
import com.nchu.anti_japan_history.webpage.service.AntiSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntiSiteServiceImpl implements AntiSiteService {

    @Autowired
    AntiSiteMapper antiSiteMapper;
    @Override
    public List<AntiSite> antiSiteSelect() {
        return antiSiteMapper.antiSiteSelect();
    }

    @Override
    public List<AntiSite> antiSiteListAll() {
        return antiSiteMapper.antiSiteListAll();
    }

    @Override
    public int antiSiteSave(AntiSite antiSite) {
        return antiSiteMapper.antiSiteSave(antiSite);
    }

    @Override
    public AntiSite antiSiteDisplay(Long antiSiteId) {
        return antiSiteMapper.antiSiteDisplay(antiSiteId);
    }

    @Override
    public List<AntiSite> consumerPassSite(String antiSiteContribution) {
        return antiSiteMapper.consumerPassSite(antiSiteContribution);
    }

    @Override
    public List<AntiSite> consumerAuditSite(String antiSiteContribution) {
        return antiSiteMapper.consumerAuditSite(antiSiteContribution);
    }

    @Override
    public List<AntiSite> consumerNotAdoptedSite(String antiSiteContribution) {
        return antiSiteMapper.consumerNotAdoptedSite(antiSiteContribution);
    }

    @Override
    public List<AntiSite> adminPassSite() {
        return antiSiteMapper.adminPassSite();
    }

    @Override
    public List<AntiSite> adminAuditSite() {
        return antiSiteMapper.adminAuditSite();
    }

    @Override
    public List<AntiSite> adminNotAdoptSite() {
        return antiSiteMapper.adminNotAdoptSite();
    }
}
