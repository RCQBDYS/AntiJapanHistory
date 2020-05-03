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
}
