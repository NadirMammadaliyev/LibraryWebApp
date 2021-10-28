/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao;

import az.nadir.library.model.ReadingRoom;

import java.util.List;

/**
 * @author Asus
 */
public interface ReadingRoomDao {
    List<ReadingRoom> getReadingRoomList() throws Exception;
}
