/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service.impl;

import az.nadir.library.dao.TopicDao;
import az.nadir.library.model.Topic;
import az.nadir.library.service.TopicService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author Asus
 */
@AllArgsConstructor
public class TopicServiceImpl implements TopicService {

    private TopicDao topicDao;

    @Override
    public List<Topic> getTopicList() throws Exception {
        return topicDao.getTopicList();
    }

    @Override
    public void addTopic(Topic topic) throws Exception {
        topicDao.addTopic(topic);
    }

    @Override
    public Topic getTopicById(Long topicLong) throws Exception {
        return topicDao.getTopicById(topicLong);
    }

    @Override
    public void updateTopic(Topic topic) throws Exception {
        topicDao.updateTopic(topic);
    }

    @Override
    public void deleteTopic(Long topicId) throws Exception {
        topicDao.deleteTopic(topicId);
    }

    @Override
    public List<Topic> searchLTopicData(String keyWord) throws Exception {
        return topicDao.searchLTopicData(keyWord);
    }

}
