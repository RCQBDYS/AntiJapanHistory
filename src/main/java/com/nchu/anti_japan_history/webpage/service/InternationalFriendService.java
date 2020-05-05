package com.nchu.anti_japan_history.webpage.service;

import com.nchu.anti_japan_history.webpage.entity.InternationalFriend;

import java.util.List;

public interface InternationalFriendService {

    //显示国际友人
    List<InternationalFriend> internationalFriendSelect();
    //显示国际友人
    List<InternationalFriend> internationalFriendListAll();
    //国际友人信息的保存
    int internationalFriendSave(InternationalFriend internationalFriend);
    //国际友人信息详细显示
    InternationalFriend internationalFriendDisplay(Long internationalFriendId);
}
