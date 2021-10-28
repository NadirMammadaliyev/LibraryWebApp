/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao.impl;

import az.nadir.library.dao.DBHelper;
import az.nadir.library.dao.TopicDao;
import az.nadir.library.model.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Asus
 */
public class TopicDaoImpl implements TopicDao {

    @Override
    public List<Topic> getTopicList() throws Exception {
        List<Topic> topicList = new ArrayList<>();
        String sql = "SELECT ID,NAME FROM TOPIC WHERE ACTIVE=1";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql)) {
            if (c != null) {
                while (rs.next()) {
                    Topic topic = new Topic();
                    topic.setId(rs.getLong("ID"));
                    topic.setName(rs.getString("NAME"));
                    topicList.add(topic);
                }

            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return topicList;
    }

    @Override
    public void addTopic(Topic topic) throws Exception {
        String sql = "INSERT INTO TOPIC (ID,NAME) \n"
                + "VALUES(TOPIC_SEQ.NEXTVAL,?) ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, topic.getName());
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    @Override
    public Topic getTopicById(Long topicLong) throws Exception {
        Topic topic = new Topic();
        String sql = "SELECT ID,NAME FROM TOPIC\n"
                + "WHERE ACTIVE =1 AND ID =?";
        ResultSet rs = null;
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, topicLong);
            rs = ps.executeQuery();
            if (rs.next()) {
                topic.setId(rs.getLong("ID"));
                topic.setName(rs.getString("NAME"));

            } else {
                topic = null;
            }

        }
        return topic;
    }

    @Override
    public void updateTopic(Topic topic) throws Exception {
        String sql = "UPDATE TOPIC SET NAME =? WHERE ID =? ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, topic.getName());
            ps.setLong(2, topic.getId());
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteTopic(Long topicId) throws Exception {
        String sql = "UPDATE TOPIC SET ACTIVE = 0 \n"
                + "WHERE ID =?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, topicId);
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Topic> searchLTopicData(String keyWord) throws Exception {
        List<Topic> topicList = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT ID, NAME FROM TOPIC WHERE ACTIVE = 1 AND (LOWER (NAME) LIKE LOWER (?)) ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyWord + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Topic topic = new Topic();
                topic.setId(rs.getLong("ID"));
                topic.setName(rs.getString("NAME"));
                topicList.add(topic);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return topicList;
    }

}
