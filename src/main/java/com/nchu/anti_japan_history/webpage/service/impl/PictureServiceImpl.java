package com.nchu.anti_japan_history.webpage.service.impl;

import com.nchu.anti_japan_history.webpage.entity.Picture;
import com.nchu.anti_japan_history.webpage.mapper.PictureMapper;
import com.nchu.anti_japan_history.webpage.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@Author: wangshen
*@Date: 2020/4/21
*@Description: 图片服务接口实现类
*/
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureMapper pictureMapper;
    @Override
    public List<Picture> pictureListAll() {
        return pictureMapper.pictureListAll();
    }

    @Override
    public int pictureSave(Picture picture) {
        return pictureMapper.pictureSave(picture);
    }

    @Override
    public Picture pictureDisplay(Long pictureId) {
        return pictureMapper.pictureDisplay(pictureId);
    }

    @Override
    public List<Picture> consumerPassPicture(String pictureContribution) {
        return pictureMapper.consumerPassPicture(pictureContribution);
    }

    @Override
    public List<Picture> consumerAuditPicture(String pictureContribution) {
        return pictureMapper.consumerAuditPicture(pictureContribution);
    }

    @Override
    public List<Picture> consumerNotAdoptedPicture(String pictureContribution) {
        return pictureMapper.consumerNotAdoptedPicture(pictureContribution);
    }

    @Override
    public List<Picture> adminPassPicture() {
        return pictureMapper.adminPassPicture();
    }

    @Override
    public List<Picture> adminAuditPicture() {
        return pictureMapper.adminAuditPicture();
    }

    @Override
    public List<Picture> adminNotAdoptedPicture() {
        return pictureMapper.adminNotAdoptedPicture();
    }

    @Override
    public int deleteByPictureId(Long pictureId) {
        return pictureMapper.deleteByPictureId(pictureId);
    }

    @Override
    public void examinePictureUpdate(Picture picture) {
        pictureMapper.examinePictureUpdate(picture);
    }

}
