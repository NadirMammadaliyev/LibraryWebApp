/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao;

import az.nadir.library.model.User;

import java.util.List;

/**
 * @author Asus
 */
public interface UserDao {

    List<User> getUserList() throws Exception;

    void addUser(User user) throws Exception;

    User getUserById(Long userLong) throws Exception;

    void updateUser(User user) throws Exception;

    void deleteUser(Long userId) throws Exception;

    List<User> searchUserData(String keyWord) throws Exception;

    Integer getUserActivity(Long userLong) throws Exception;

    void updateUserActivity(User user, Integer userActivity) throws Exception;

    List<User> getUserStatistList() throws Exception;

    List<User> getProblemicUsers() throws Exception;

    void updateUserAddProblemicUser(User user) throws Exception;

    void updateUserDeleteProblemicUser(Long userId) throws Exception;
}
