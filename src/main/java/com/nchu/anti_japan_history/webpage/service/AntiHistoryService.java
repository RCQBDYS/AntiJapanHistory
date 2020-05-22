package com.nchu.anti_japan_history.webpage.service;
/**
*@Author: wangshen
*@Date: 2020/4/17
*@Description: 历史事件的服务接口
*/
import com.nchu.anti_japan_history.webpage.entity.AntiHistory;
import com.nchu.anti_japan_history.webpage.entity.User;

import java.util.List;

public interface AntiHistoryService {
    //历史条目的保存
    void addEntriesDataSave(AntiHistory antiHistory);
    //局部抗战历史显示
    List<AntiHistory> partHistorySelect();
    //全国抗战历史显示
    List<AntiHistory> nationwideHistorySelect();
    //伟大胜利抗战历史显示
    List<AntiHistory> victoryHistorySelect();
    //游击战争历史显示
    List<AntiHistory> guerrillaWarfareSelect();
    //局部抗战历史显示all
    List<AntiHistory> partListAll();
    //全国抗战历史显示all
    List<AntiHistory> nationwideListAll();
    //伟大胜利历史显示all
    List<AntiHistory> victoryListAll();
    //游击战争历史显示all
    List<AntiHistory> guerrillaWarfareListAll();
    //查阅具体信息
    AntiHistory selectHistoryDisplay(Long historyId);
    //后台查询已通过历史条目listall
    List<AntiHistory> antiHistoryPastListAll();
    //后台查询待审核的历史条目listall
    List<AntiHistory> antiHistoryAuditListAll();
    //后台查询未通过的历史条目listal
    List<AntiHistory> antiHistoryNotAdoptedListAll();
    //后台管理员信息修改保存
    void examineUpdate(AntiHistory antiHistory);
    //历史时间轴信息显示
    List<AntiHistory> timeListAll();
    //普通用户中心待审核历史条目查询
    List<AntiHistory> consumerAuditHistoryListAll(String antiHistoryContribution);
    //普通用户中心审核通过历史条目查询
    List<AntiHistory> consumerPassHistoryListAll(String antiHistoryContribution);
    //普通用户中心未通过历史条目查询
    List<AntiHistory> consumerNotAdoptedListAll(String antiHistoryContribution);
    //普通用户历史条目修改保存
    void editAntiHistoryUpdate(AntiHistory antiHistory);

    //历史条目的删除
    int deleteByAntiHistoryId(Long antiHistoryId);

    //地图信息显示
    //地点江西战役信息显示
    List<AntiHistory> JiangxiListAll();
    //黑龙江
    List<AntiHistory> HeilongjiangListAll();
    //吉林
    List<AntiHistory> JilinListAll();
    //辽宁
    List<AntiHistory> LiaoningListAll();
    //河北
    List<AntiHistory> HebeiListAll();
    //山东
    List<AntiHistory> ShandongListAll();
    //江苏
    List<AntiHistory> JiangsuListAll();
    //浙江
    List<AntiHistory> ZhejiangListAll();
    //河南
    List<AntiHistory> HenanListAll();
    //山西
    List<AntiHistory> ShanxiListAll();
    //湖北
    List<AntiHistory> HubeiListAll();
    //湖南
    List<AntiHistory> HunanListAll();
    //云南
    List<AntiHistory> YunnanListAll();
    //上海
    List<AntiHistory> ShanghaiListAll();
    //重庆
    List<AntiHistory> ChongqingListAll();
    //北京
    List<AntiHistory> BeijingListAll();
    //内蒙古
    List<AntiHistory> NeimengguListAll();
    //广西
    List<AntiHistory> GuangxiListAll();
    //广东
    List<AntiHistory> GuangdongListAll();

}
