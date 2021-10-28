/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service.impl;

import az.nadir.library.dao.ShelfDao;
import az.nadir.library.model.Shelf;
import az.nadir.library.service.ShelfService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author Asus
 */
@AllArgsConstructor
public class ShelfServiceImpl implements ShelfService {

    private ShelfDao shelfDao;

    @Override
    public List<Shelf> getShelfList() throws Exception {
        return shelfDao.getShelfList();
    }

    @Override
    public Shelf getShelfById(Long shelfLong) throws Exception {
        return shelfDao.getShelfById(shelfLong);
    }

}
