package com.nchu.anti_japan_history.webpage.mapper;

import com.nchu.anti_japan_history.webpage.entity.InternationalFriend;

import java.util.List;

public interface InternationalFriendMapper {
    //显示国际友人
    List<InternationalFriend> internationalFriendSelect();
    //显示国际友人
    List<InternationalFriend> internationalFriendListAll();
    //国际友人信息的保存
    int internationalFriendSave(InternationalFriend internationalFriend);
    //国际友人信息详细显示
    InternationalFriend internationalFriendDisplay(Long internationalFriendId);
    //普通用户查询通过的国际友人信息
    List<InternationalFriend> consumerPassFriend(String friendContribution);
    //普通用户查询待审核
    List<InternationalFriend> consumerAuditFriend(String friendContribution);
    //普通用户查询未通过
    List<InternationalFriend> consumerNotAdoptedFriend(String friendContribution);

    //管理员查询通过
    List<InternationalFriend> adminPassFriend();
    //管理员查询待审核
    List<InternationalFriend> adminAuditFriend();
    //管理员查询未通过
    List<InternationalFriend> adminNotAdoptedFriend();


    //删除国际友人信息
    int deleteByFriendId(Long internationalFriendId);

    //国际友人审核信息保存
    void examineFriendUpdate(InternationalFriend internationalFriend);
}
