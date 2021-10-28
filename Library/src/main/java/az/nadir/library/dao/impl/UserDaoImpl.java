/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao.impl;

import az.nadir.library.dao.DBHelper;
import az.nadir.library.dao.UserDao;
import az.nadir.library.model.User;

import static java.awt.image.ImageObserver.ERROR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Asus
 */
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getUserList() throws Exception {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT ID,NAME,SURNAME,DOB,IDENTITY_NUMBER,PHONE,MAIL,USER_ACTIVITY ,PROBLEM FROM LIB_USER\n"
                + "WHERE ACTIVE = 1 AND PROBLEM=0";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql)) {
            if (c != null) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getLong("ID"));
                    user.setName(rs.getString("NAME"));
                    user.setSurname(rs.getString("SURNAME"));
                    user.setDob(rs.getDate("DOB"));
                    user.setIdentityNumber(rs.getString("IDENTITY_NUMBER"));
                    user.setPhone(rs.getString("PHONE"));
                    user.setMail(rs.getString("MAIL"));
                    user.setUserActivity(rs.getInt("USER_ACTIVITY"));
                    user.setProblem(rs.getInt("PROBLEM"));
                    userList.add(user);

                }
            } else {
                System.out.println("Conecction is null! ");
            }

        }
        return userList;
    }

    @Override
    public void addUser(User user) throws Exception {
        String sql = "INSERT INTO LIB_USER(ID,NAME,SURNAME,DOB,IDENTITY_NUMBER,PHONE,MAIL)\n"
                + "VALUES(LIB_USER_SEQ.NEXTVAL,?,?,?,?,?,?1)";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setDate(3, new java.sql.Date(user.getDob().getTime()));
            ps.setString(4, user.getIdentityNumber());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getMail());
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "User has not been succsessfully added!", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();

        }
    }

    @Override
    public User getUserById(Long userLong) throws Exception {
        User user = new User();

        String sql = "SELECT ID,NAME,SURNAME,DOB,IDENTITY_NUMBER,PHONE,MAIL,USER_ACTIVITY,PROBLEM FROM LIB_USER\n"
                + "WHERE ACTIVE =1 AND ID =?";
        ResultSet rs = null;
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, userLong);
            rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getLong("ID"));
                user.setName(rs.getString("NAME"));
                user.setSurname(rs.getString("SURNAME"));
                user.setDob(rs.getDate("DOB"));
                user.setIdentityNumber(rs.getString("IDENTITY_NUMBER"));
                user.setPhone(rs.getString("PHONE"));
                user.setMail(rs.getString("MAIL"));
                user.setUserActivity(rs.getInt("USER_ACTIVITY"));
                user.setProblem(rs.getInt("PROBLEM"));

            } else {
                user = null;
            }

        }
        return user;
    }

    @Override
    public void updateUser(User user) throws Exception {
        String sql = "UPDATE LIB_USER SET NAME =? ,SURNAME = ? , DOB =?,IDENTITY_NUMBER=?,PHONE =? , MAIL=? ,USER_ACTIVITY =? \n"
                + "WHERE ID =?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setDate(3, new java.sql.Date(user.getDob().getTime()));
            ps.setString(4, user.getIdentityNumber());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getMail());
            ps.setInt(7, user.getUserActivity());

            ps.setLong(8, user.getId());
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        String sql = "UPDATE LIB_USER SET ACTIVE = 0 \n"
                + "WHERE ID =?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, userId);
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<User> searchUserData(String keyWord) throws Exception {
        List<User> userList = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT ID, NAME, SURNAME,DOB,IDENTITY_NUMBER, PHONE, MAIL FROM LIB_USER WHERE ACTIVE = 1 AND (LOWER (NAME) LIKE LOWER (?) OR LOWER(SURNAME) LIKE LOWER (?) OR LOWER(DOB) LIKE LOWER (?) OR LOWER(IDENTITY_NUMBER) LIKE LOWER (?)  OR LOWER(PHONE) LIKE LOWER(?) OR LOWER(MAIL) LIKE LOWER(?)) ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyWord + "%");
            ps.setString(2, "%" + keyWord + "%");
            ps.setString(3, "%" + keyWord + "%");
            ps.setString(4, "%" + keyWord + "%");
            ps.setString(5, "%" + keyWord + "%");
            ps.setString(6, "%" + keyWord + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("ID"));
                user.setName(rs.getString("NAME"));
                user.setSurname(rs.getString("SURNAME"));
                user.setDob(rs.getDate("DOB"));
                user.setIdentityNumber(rs.getString("IDENTITY_NUMBER"));
                user.setPhone(rs.getString("PHONE"));
                user.setMail(rs.getString("MAIL"));
                userList.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    @Override
    public Integer getUserActivity(Long userLong) throws Exception {
        User user = new User();
        Integer userActive = 0;
        String sql = "SELECT USER_ACTIVITY FROM LIB_USER WHERE ID = ? ";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, userLong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                user.setUserActivity(rs.getInt("USER_ACTIVITY"));
                userActive = user.getUserActivity();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userActive;
    }

    @Override
    public void updateUserActivity(User user, Integer userActivity) throws Exception {
        String sql = "UPDATE LIB_USER SET USER_ACTIVITY = ? WHERE ID =? ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, userActivity + 1);

            ps.setLong(2, user.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<User> getUserStatistList() throws Exception {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT ID,NAME,SURNAME,USER_ACTIVITY FROM LIB_USER\n"
                + "WHERE ACTIVE = 1 ORDER BY USER_ACTIVITY DESC";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql)) {
            if (c != null) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getLong("ID"));
                    user.setName(rs.getString("NAME"));
                    user.setSurname(rs.getString("SURNAME"));
                    user.setUserActivity(rs.getInt("USER_ACTIVITY"));
                    userList.add(user);

                }
            } else {
                System.out.println("Conecction is null! ");
            }

        }
        return userList;
    }

    @Override
    public List<User> getProblemicUsers() throws Exception {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT ID,NAME,SURNAME,DOB,IDENTITY_NUMBER,PHONE,MAIL,USER_ACTIVITY ,PROBLEM FROM LIB_USER\n"
                + "WHERE ACTIVE = 1 AND  PROBLEM=1";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("ID"));
                user.setName(rs.getString("NAME"));
                user.setSurname(rs.getString("SURNAME"));
                user.setDob(rs.getDate("DOB"));
                user.setIdentityNumber(rs.getString("IDENTITY_NUMBER"));
                user.setPhone(rs.getString("PHONE"));
                user.setMail(rs.getString("MAIL"));
                user.setUserActivity(rs.getInt("USER_ACTIVITY"));
                user.setProblem(rs.getInt("PROBLEM"));
                userList.add(user);

            }
        }

        return userList;
    }

    @Override
    public void updateUserAddProblemicUser(User user) throws Exception {
        String sql = "UPDATE LIB_USER SET PROBLEM = 1 WHERE ID =? ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, user.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void updateUserDeleteProblemicUser(Long userId) throws Exception {
        String sql = "UPDATE LIB_USER SET PROBLEM = 0 WHERE ID =? ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, userId);
            ps.execute();
            c.commit();
        }
    }

}
