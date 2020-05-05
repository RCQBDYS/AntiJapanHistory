package com.nchu.anti_japan_history.webpage.mapper;

import com.nchu.anti_japan_history.webpage.entity.AntiWarStories;

import java.util.List;

public interface AntiWarStoriesMapper {
    //显示抗战故事
    List<AntiWarStories> antiWarStoriesSelect();
    //显示抗战故事all
    List<AntiWarStories> antiStoriesListAll();
    //保存抗战故事
    int antiStoriesSave(AntiWarStories antiWarStories);
    //抗战故事的详细显示id
    AntiWarStories antiStoriesDisplay(Long antiWarId);
}
