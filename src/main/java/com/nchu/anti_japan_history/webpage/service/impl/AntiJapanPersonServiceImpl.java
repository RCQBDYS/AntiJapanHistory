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

    @Override
    public List<AntiJapanPerson> consumerPassPerson(String personContribution) {
        return antiJapanPersonMapper.consumerPassPerson(personContribution);
    }

    @Override
    public List<AntiJapanPerson> consumerAuditPerson(String personContribution) {
        return antiJapanPersonMapper.consumerAuditPerson(personContribution);
    }

    @Override
    public List<AntiJapanPerson> consumerNotAdoptedPerson(String personContribution) {
        return antiJapanPersonMapper.consumerNotAdoptedPerson(personContribution);
    }

    @Override
    public List<AntiJapanPerson> adminPassPerson() {
        return antiJapanPersonMapper.adminPassPerson();
    }

    @Override
    public List<AntiJapanPerson> adminAuditPerson() {
        return antiJapanPersonMapper.adminAuditPerson();
    }

    @Override
    public List<AntiJapanPerson> adminNotAdoptedPerson() {
        return antiJapanPersonMapper.adminNotAdoptedPerson();
    }

    @Override
    public int deleteByPersonId(Long antiJapanPersonId) {
        return antiJapanPersonMapper.deleteByPersonId(antiJapanPersonId);
    }

    @Override
    public void examinePersonUpdate(AntiJapanPerson antiJapanPerson) {
        antiJapanPersonMapper.examinePersonUpdate(antiJapanPerson);
    }


}
