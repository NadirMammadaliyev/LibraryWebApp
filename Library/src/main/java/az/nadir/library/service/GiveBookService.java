/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service;

import az.nadir.library.model.GiveBook;

import java.util.List;

/**
 * @author Asus
 */
public interface GiveBookService {
    List<GiveBook> getGiveBookList() throws Exception;

    void addGiveBook(GiveBook giveBook) throws Exception;

    GiveBook getGiveBookById(Long giveBookLong) throws Exception;

    void updateGiveBook(GiveBook giveBook) throws Exception;

    void deleteGiveBook(Long giveBookId) throws Exception;

    List<GiveBook> searchGiveBookData(String keyWord) throws Exception;
}
