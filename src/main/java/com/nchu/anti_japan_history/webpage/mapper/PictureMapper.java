package com.nchu.anti_japan_history.webpage.mapper;

import com.nchu.anti_japan_history.webpage.entity.Picture;

import java.util.List;

public interface PictureMapper {

    //查询图片all
    List<Picture> pictureListAll();
    //图片保存
    int pictureSave(Picture picture);
    //图片信息详细显示
    Picture pictureDisplay(Long pictureId);
    //普通用户查询通过的图片
    List<Picture> consumerPassPicture(String pictureContribution);
    //普通用户查询待审核
    List<Picture> consumerAuditPicture(String pictureContribution);
    //普通用户查询未通过
    List<Picture> consumerNotAdoptedPicture(String pictureContribution);

    //管理员查询通过
    List<Picture> adminPassPicture();
    //管理员查询带审核
    List<Picture> adminAuditPicture();
    //管理员查询未通过
    List<Picture> adminNotAdoptedPicture();
}
