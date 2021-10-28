/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao.impl;

import az.nadir.library.dao.DBHelper;
import az.nadir.library.dao.LoginUserDao;
import az.nadir.library.model.LoginUser;
import az.nadir.library.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Asus
 */
public class LoginUserDaoImpl implements LoginUserDao {

    @Override
    public LoginUser login(String username, String password) throws Exception {
        LoginUser loginUser = new LoginUser();
        String sql = "SELECT LU.ID, LU.USERNAME, LU.NAME, LU.SURNAME, R.ID ,R.ROLE_NAME FROM LOGIN_USER LU\n"
                + "INNER JOIN ROLE R ON LU.ROLE_ID =R.ID\n"
                + "WHERE LU.ACTIVE = 1 AND LU.USERNAME = ? AND LU.PASSWORD = ? ";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loginUser.setId(rs.getLong("ID"));
                loginUser.setUsername(rs.getString("USERNAME"));
                loginUser.setName(rs.getString("NAME"));
                loginUser.setSurname(rs.getString("SURNAME"));
                Role role = new Role();
                role.setId(rs.getLong("ID"));
                role.setRoleName(rs.getString("ROLE_NAME"));
                loginUser.setRole(role);

            } else {
                loginUser = null;
            }

        }

        return loginUser;
    }

}
