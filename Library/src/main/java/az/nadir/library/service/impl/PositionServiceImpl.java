/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service.impl;

import az.nadir.library.dao.PositionDao;
import az.nadir.library.model.Position;
import az.nadir.library.service.PositionService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author Asus
 */
@AllArgsConstructor
public class PositionServiceImpl implements PositionService {
    private PositionDao positionDao;

    @Override
    public List<Position> getPositionList() throws Exception {
        return positionDao.getPositionList();
    }

}
