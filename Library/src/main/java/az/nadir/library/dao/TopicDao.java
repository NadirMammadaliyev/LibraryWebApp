/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao;

import az.nadir.library.model.Topic;

import java.util.List;

/**
 * @author Asus
 */
public interface TopicDao {
    List<Topic> getTopicList() throws Exception;

    void addTopic(Topic topic) throws Exception;

    Topic getTopicById(Long topicLong) throws Exception;

    void updateTopic(Topic topic) throws Exception;

    void deleteTopic(Long topicId) throws Exception;

    List<Topic> searchLTopicData(String keyWord) throws Exception;
}
