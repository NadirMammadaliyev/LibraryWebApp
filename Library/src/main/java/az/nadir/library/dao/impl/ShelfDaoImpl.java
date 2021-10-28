/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao.impl;

import az.nadir.library.dao.DBHelper;
import az.nadir.library.dao.ShelfDao;
import az.nadir.library.model.Shelf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Asus
 */
public class ShelfDaoImpl implements ShelfDao {

    @Override
    public List<Shelf> getShelfList() throws Exception {
        List<Shelf> shelfList = new ArrayList<>();
        String sql = "SELECT ID,NAME FROM SHELF";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql)) {
            if (c != null) {
                while (rs.next()) {
                    Shelf shelf = new Shelf();
                    shelf.setId(rs.getLong("ID"));
                    shelf.setName(rs.getString("NAME"));
                    shelfList.add(shelf);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return shelfList;

    }

    @Override
    public Shelf getShelfById(Long shelfLong) throws Exception {

        Shelf shelf = new Shelf();
        String sql = "SELECT ID,NAME FROM SHELF";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql)) {
            if (c != null) {
                while (rs.next()) {

                    shelf.setId(rs.getLong("ID"));
                    shelf.setName(rs.getString("NAME"));
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return shelf;
    }

}
