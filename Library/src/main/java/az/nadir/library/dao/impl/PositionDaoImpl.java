/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao.impl;

import az.nadir.library.dao.DBHelper;
import az.nadir.library.dao.PositionDao;
import az.nadir.library.model.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Asus
 */
public class PositionDaoImpl implements PositionDao {

    @Override
    public List<Position> getPositionList() throws Exception {
        List<Position> positionList = new ArrayList<>();
        String sql = "SELECT ID,NAME FROM POSITION";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql)) {
            if (c != null) {
                while (rs.next()) {
                    Position position = new Position();
                    position.setId(rs.getLong("ID"));
                    position.setName(rs.getString("NAME"));
                    positionList.add(position);
                }

            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return positionList;
    }
}
