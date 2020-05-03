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
}
