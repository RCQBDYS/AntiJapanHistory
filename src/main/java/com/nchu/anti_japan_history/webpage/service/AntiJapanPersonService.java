package com.nchu.anti_japan_history.webpage.service;

import com.nchu.anti_japan_history.webpage.entity.AntiJapanPerson;

import java.util.List;

public interface AntiJapanPersonService {
    //历史人物显示
    List<AntiJapanPerson> antiJapanPersonSelect();

    //历史人物显示All
    List<AntiJapanPerson> antiPersonListAll();

    //历史人物信息保存
    int antiPersonSave(AntiJapanPerson antiJapanPerson);
    //历史人物详细显示id

    AntiJapanPerson antiPersonDisplay(Long antiJapanPersonId);

    //普通用户查询通过的人物信息
    List<AntiJapanPerson> consumerPassPerson(String personContribution);

    //普通用户查询待审核的人物信息
    List<AntiJapanPerson> consumerAuditPerson(String personContribution);

    //普通用户查询未通过的人物信息
    List<AntiJapanPerson> consumerNotAdoptedPerson(String personContribution);

    //管理员用户查询通过的人物信息
    List<AntiJapanPerson> adminPassPerson();
    //管理员查询待审核的人物信息
    List<AntiJapanPerson> adminAuditPerson();
    //管理员查询未通过的人物信息
    List<AntiJapanPerson> adminNotAdoptedPerson();

    //删除人物信息
    int deleteByPersonId(Long antiJapanPersonId);

    //审核信息保存
    void examinePersonUpdate(AntiJapanPerson antiJapanPerson);

}

