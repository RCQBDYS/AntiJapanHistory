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
}
