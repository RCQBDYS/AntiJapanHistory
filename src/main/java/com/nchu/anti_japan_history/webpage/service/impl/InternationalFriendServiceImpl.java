package com.nchu.anti_japan_history.webpage.service.impl;

import com.nchu.anti_japan_history.webpage.entity.InternationalFriend;
import com.nchu.anti_japan_history.webpage.mapper.InternationalFriendMapper;
import com.nchu.anti_japan_history.webpage.service.InternationalFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternationalFriendServiceImpl implements InternationalFriendService {
   @Autowired
    InternationalFriendMapper internationalFriendMapper;
    @Override
    public List<InternationalFriend> internationalFriendSelect() {
        return internationalFriendMapper.internationalFriendSelect();
    }

    @Override
    public List<InternationalFriend> internationalFriendListAll() {
        return internationalFriendMapper.internationalFriendListAll();
    }

    @Override
    public int internationalFriendSave(InternationalFriend internationalFriend) {
        return internationalFriendMapper.internationalFriendSave(internationalFriend);
    }

    @Override
    public InternationalFriend internationalFriendDisplay(Long internationalFriendId) {
        return internationalFriendMapper.internationalFriendDisplay(internationalFriendId);
    }

    @Override
    public List<InternationalFriend> consumerPassFriend(String friendContribution) {
        return internationalFriendMapper.consumerPassFriend(friendContribution);
    }

    @Override
    public List<InternationalFriend> consumerAuditFriend(String friendContribution) {
        return internationalFriendMapper.consumerAuditFriend(friendContribution);
    }

    @Override
    public List<InternationalFriend> consumerNotAdoptedFriend(String friendContribution) {
        return internationalFriendMapper.consumerNotAdoptedFriend(friendContribution);
    }

    @Override
    public List<InternationalFriend> adminPassFriend() {
        return internationalFriendMapper.adminPassFriend();
    }

    @Override
    public List<InternationalFriend> adminAuditFriend() {
        return internationalFriendMapper.adminAuditFriend();
    }

    @Override
    public List<InternationalFriend> adminNotAdoptedFriend() {
        return internationalFriendMapper.adminNotAdoptedFriend();
    }

    @Override
    public int deleteByFriendId(Long internationalFriendId) {
        return internationalFriendMapper.deleteByFriendId(internationalFriendId);
    }

    @Override
    public void examineFriendUpdate(InternationalFriend internationalFriend) {
        internationalFriendMapper.examineFriendUpdate(internationalFriend);
    }
}
