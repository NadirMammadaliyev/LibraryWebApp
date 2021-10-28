/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service.impl;

import az.nadir.library.dao.GiveBookDao;
import az.nadir.library.model.GiveBook;
import az.nadir.library.service.GiveBookService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author Asus
 */
@AllArgsConstructor
public class GiveBookServiceImpl implements GiveBookService {

    private GiveBookDao giveBookDao;

    @Override
    public List<GiveBook> getGiveBookList() throws Exception {
        return giveBookDao.getGiveBookList();
    }

    @Override
    public void addGiveBook(GiveBook giveBook) throws Exception {
        giveBookDao.addGiveBook(giveBook);
    }

    @Override
    public GiveBook getGiveBookById(Long giveBookLong) throws Exception {
        return giveBookDao.getGiveBookById(giveBookLong);
    }

    @Override
    public void updateGiveBook(GiveBook giveBook) throws Exception {
        giveBookDao.updateGiveBook(giveBook);
    }

    @Override
    public void deleteGiveBook(Long giveBookId) throws Exception {
        giveBookDao.deleteGiveBook(giveBookId);
    }

    @Override
    public List<GiveBook> searchGiveBookData(String keyWord) throws Exception {
        return giveBookDao.searchGiveBookData(keyWord);
    }

}
