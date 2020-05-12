package com.nchu.anti_japan_history.webpage.service.impl;

import com.nchu.anti_japan_history.webpage.entity.AntiWarStories;
import com.nchu.anti_japan_history.webpage.mapper.AntiWarStoriesMapper;
import com.nchu.anti_japan_history.webpage.service.AntiWarStoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntiWarStoriesServiceImpl implements AntiWarStoriesService {
    @Autowired
    AntiWarStoriesMapper antiWarStoriesMapper;

    @Override
    public List<AntiWarStories> antiWarStoriesSelect() {

        return antiWarStoriesMapper.antiWarStoriesSelect();
    }

    @Override
    public List<AntiWarStories> antiStoriesListAll() {
        return antiWarStoriesMapper.antiStoriesListAll();
    }

    @Override
    public int antiStoriesSave(AntiWarStories antiWarStories) {
        return antiWarStoriesMapper.antiStoriesSave(antiWarStories);
    }

    @Override
    public AntiWarStories antiStoriesDisplay(Long antiWarId) {
        return antiWarStoriesMapper.antiStoriesDisplay(antiWarId);
    }

    @Override
    public List<AntiWarStories> consumerPassStories(String storiesContribution) {
        return antiWarStoriesMapper.consumerPassStories(storiesContribution);
    }

    @Override
    public List<AntiWarStories> consumerAuditStories(String storiesContribution) {
        return antiWarStoriesMapper.consumerAuditStories(storiesContribution);
    }

    @Override
    public List<AntiWarStories> consumerNotAdoptedStores(String storiesContribution) {
        return antiWarStoriesMapper.consumerNotAdoptedStores(storiesContribution);
    }

    @Override
    public List<AntiWarStories> adminPassStories() {
        return antiWarStoriesMapper.adminPassStories();
    }

    @Override
    public List<AntiWarStories> adminAuditStories() {
        return antiWarStoriesMapper.adminAuditStories();
    }

    @Override
    public List<AntiWarStories> adminNotAdoptedStories() {
        return antiWarStoriesMapper.adminNotAdoptedStories();
    }
}
