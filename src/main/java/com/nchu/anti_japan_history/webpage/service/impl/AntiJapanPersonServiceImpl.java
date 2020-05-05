package com.nchu.anti_japan_history.webpage.service.impl;

import com.nchu.anti_japan_history.webpage.entity.AntiJapanPerson;
import com.nchu.anti_japan_history.webpage.mapper.AntiJapanPersonMapper;
import com.nchu.anti_japan_history.webpage.service.AntiJapanPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntiJapanPersonServiceImpl implements AntiJapanPersonService {

    @Autowired
    AntiJapanPersonMapper antiJapanPersonMapper;
    @Override
    public List<AntiJapanPerson> antiJapanPersonSelect() {
        return antiJapanPersonMapper.antiJapanPersonSelect();
    }

    @Override
    public List<AntiJapanPerson> antiPersonListAll() {
        return antiJapanPersonMapper.antiPersonListAll();
    }

    @Override
    public int antiPersonSave(AntiJapanPerson antiJapanPerson) {
        return antiJapanPersonMapper.antiPersonSave(antiJapanPerson);
    }

    @Override
    public AntiJapanPerson antiPersonDisplay(Long antiJapanPersonId) {
        return antiJapanPersonMapper.antiPersonDisplay(antiJapanPersonId);
    }
}
