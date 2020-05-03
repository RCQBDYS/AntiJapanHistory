package com.nchu.anti_japan_history.webpage.service;

import com.nchu.anti_japan_history.webpage.entity.Newspaper;

import java.util.List;

public interface NewspaperService {

    //查询报纸信息所有
    List<Newspaper> newspaperListAll();
    //报纸信息的保存
    int newspaperSave(Newspaper newspaper);
}
