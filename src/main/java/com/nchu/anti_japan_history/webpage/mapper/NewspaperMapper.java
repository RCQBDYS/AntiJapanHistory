package com.nchu.anti_japan_history.webpage.mapper;

import com.nchu.anti_japan_history.webpage.entity.Newspaper;

import java.util.List;

public interface NewspaperMapper {
    //查询报纸信息所有
    List<Newspaper> newspaperListAll();
    //报纸信息的保存
    int newspaperSave(Newspaper newspaper);
    //报纸信息的详细显示
    Newspaper newspaperDisplay(Long newspaperId);
    //普通用户查询通过报纸信息
    List<Newspaper> consumerPassNewspaper(String newspaperContribution);
    //普通用户查询待审核
    List<Newspaper> consumerAuditNewspaper(String newspaperContribution);
    //普通用户查询未通过
    List<Newspaper> consumerNotAdoptedNewspaper(String newspaperContribution);

    //管理员查询通过
    List<Newspaper> adminPassNews();
    //管理员查询待审核
    List<Newspaper> adminAuditNews();
    //管理员查询未通过
    List<Newspaper> adminNotAdoptedNews();
}
