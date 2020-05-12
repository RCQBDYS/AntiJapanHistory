package com.nchu.anti_japan_history.webpage.service;

import com.nchu.anti_japan_history.webpage.entity.AntiWarStories;

import java.util.List;

public interface AntiWarStoriesService {

    //显示抗战故事
    List<AntiWarStories> antiWarStoriesSelect();
    //显示抗战故事all
    List<AntiWarStories> antiStoriesListAll();
    //保存抗战故事
    int antiStoriesSave(AntiWarStories antiWarStories);
    //抗战故事的详细显示id
    AntiWarStories antiStoriesDisplay(Long antiWarId);
    //普通用户查询通过的抗战故事
    List<AntiWarStories> consumerPassStories(String storiesContribution);
    //普通用户查询待审查
    List<AntiWarStories> consumerAuditStories(String storiesContribution);
    //普通用户查询未通过
    List<AntiWarStories> consumerNotAdoptedStores(String storiesContribution);

    //管理员查询通过
    List<AntiWarStories> adminPassStories();
    //管理员查询待审核
    List<AntiWarStories> adminAuditStories();
    //管理员查询未通过
    List<AntiWarStories> adminNotAdoptedStories();
}
