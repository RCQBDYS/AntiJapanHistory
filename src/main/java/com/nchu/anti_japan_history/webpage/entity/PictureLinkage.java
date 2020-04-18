package com.nchu.anti_japan_history.webpage.entity;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.Serializable;

/**
*@Author: wangshen
*@Date: 2020/4/6
*@Description: 图片连接实体类
*/
@Data
public class PictureLinkage implements Serializable {
    private Integer pictureId;              //图片Id
    private Integer antiJapanPersonId;      //抗日人物Id
    private Integer antiWarId;              //抗日战争Id
    private Integer antiSiteId;             //抗日遗址Id
    private Integer internationalFriendId;  //国际友人Id
}
