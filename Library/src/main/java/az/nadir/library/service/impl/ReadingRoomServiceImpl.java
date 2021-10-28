/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service.impl;

import az.nadir.library.dao.ReadingRoomDao;
import az.nadir.library.model.ReadingRoom;
import az.nadir.library.service.ReadingRoomService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author Asus
 */
@AllArgsConstructor
public class ReadingRoomServiceImpl implements ReadingRoomService {

    private ReadingRoomDao readingRoomDao;


    @Override
    public List<ReadingRoom> getReadingRoomList() throws Exception {
        return readingRoomDao.getReadingRoomList();
    }

}
