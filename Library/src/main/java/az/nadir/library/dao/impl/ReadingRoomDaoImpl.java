/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao.impl;

import az.nadir.library.dao.DBHelper;
import az.nadir.library.dao.ReadingRoomDao;
import az.nadir.library.model.ReadingRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Asus
 */
public class ReadingRoomDaoImpl implements ReadingRoomDao {

    @Override
    public List<ReadingRoom> getReadingRoomList() throws Exception {
        List<ReadingRoom> readingRoomList = new ArrayList<>();
        String sql = "SELECT ID,NAME FROM READING_ROOM WHERE ACTIVE=1";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql)) {
            if (c != null) {
                while (rs.next()) {
                    ReadingRoom readingRoom = new ReadingRoom();
                    readingRoom.setId(rs.getLong("ID"));
                    readingRoom.setName(rs.getString("NAME"));
                    readingRoomList.add(readingRoom);
                }

            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return readingRoomList;
    }

}
