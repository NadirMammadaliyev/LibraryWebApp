/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service.impl;

import az.nadir.library.dao.UserDao;
import az.nadir.library.model.User;
import az.nadir.library.service.UserService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author Asus
 */
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public List<User> getUserList() throws Exception {
        return userDao.getUserList();
    }

    @Override
    public void addUser(User user) throws Exception {
        userDao.addUser(user);
    }

    @Override
    public User getUserById(Long userLong) throws Exception {
        return userDao.getUserById(userLong);

    }

    @Override
    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        userDao.deleteUser(userId);
    }

    @Override
    public List<User> searchUserData(String keyWord) throws Exception {
        return userDao.searchUserData(keyWord);
    }

    @Override
    public Integer getUserActivity(Long userLong) throws Exception {
        return userDao.getUserActivity(userLong);
    }

    @Override
    public void updateUserActivity(User user, Integer userActivity) throws Exception {
        userDao.updateUserActivity(user, userActivity);
    }

    @Override
    public List<User> getUserStatistList() throws Exception {
        return userDao.getUserStatistList();
    }

    @Override
    public List<User> getProblemicUsers() throws Exception {
        return userDao.getProblemicUsers();
    }

    @Override
    public void updateUserAddProblemicUser(User user) throws Exception {
        userDao.updateUserAddProblemicUser(user);
    }

    @Override
    public void updateUserDeleteProblemicUser(Long userId) throws Exception {
        userDao.updateUserDeleteProblemicUser(userId);
    }
}
