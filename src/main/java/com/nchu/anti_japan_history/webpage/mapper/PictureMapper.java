package com.nchu.anti_japan_history.webpage.mapper;

import com.nchu.anti_japan_history.webpage.entity.Picture;

import java.util.List;

public interface PictureMapper {

    //查询图片all
    List<Picture> pictureListAll();
    //图片保存
    int pictureSave(Picture picture);
}
