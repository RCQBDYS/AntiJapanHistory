package com.nchu.anti_japan_history.webpage.service.impl;
/**
*@Author: wangshen
*@Date: 2020/4/21
*@Description: 报纸服务类接口实现类
*/

import com.nchu.anti_japan_history.webpage.entity.Newspaper;
import com.nchu.anti_japan_history.webpage.mapper.NewspaperMapper;
import com.nchu.anti_japan_history.webpage.service.NewspaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewspaperServiceImpl implements NewspaperService {
    @Autowired
    NewspaperMapper newspaperMapper;
    @Override
    public List<Newspaper> newspaperListAll() {
        return newspaperMapper.newspaperListAll();
    }

    @Override
    public int newspaperSave(Newspaper newspaper) {
        return newspaperMapper.newspaperSave(newspaper);
    }
}
