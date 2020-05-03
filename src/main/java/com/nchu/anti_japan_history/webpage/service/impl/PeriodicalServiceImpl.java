package com.nchu.anti_japan_history.webpage.service.impl;

import com.nchu.anti_japan_history.webpage.entity.Periodical;
import com.nchu.anti_japan_history.webpage.mapper.PeriodicalMapper;
import com.nchu.anti_japan_history.webpage.service.PeriodicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@Author: wangshen
*@Date: 2020/4/21
*@Description: 期刊服务类接口实现类
*/
@Service
public class PeriodicalServiceImpl implements PeriodicalService {
    @Autowired
    PeriodicalMapper periodicalMapper;
    @Override
    public List<Periodical> periodicalListAll() {
        return periodicalMapper.periodicalListAll();
    }

    @Override
    public int periodicalSave(Periodical periodical) {
        return periodicalMapper.periodicalSave(periodical);
    }
}
