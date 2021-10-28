/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service.impl;

import az.nadir.library.dao.BookInfoDao;
import az.nadir.library.model.BookInfo;
import az.nadir.library.service.BookInfoService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author Asus
 */
@AllArgsConstructor
public class BookInfoServiceImpl implements BookInfoService {

    private BookInfoDao bookInfoDao;

    @Override
    public List<BookInfo> getBookInfoList() throws Exception {
        return bookInfoDao.getBookInfoList();
    }

    @Override
    public BookInfo getBookInfoById(Long bookInfoLong) throws Exception {
        return bookInfoDao.getBookInfoById(bookInfoLong);
    }

    @Override
    public void addBookInfo(BookInfo bookInfo) throws Exception {
        bookInfoDao.addBookInfo(bookInfo);
    }

    @Override
    public List<BookInfo> searchBookInfoData(String keyWord) throws Exception {
        return bookInfoDao.searchBookInfoData(keyWord);
    }

    @Override
    public void deleteBookInfo(Long bookInfoId) throws Exception {
        bookInfoDao.deleteBookInfo(bookInfoId);
    }

    @Override
    public List<BookInfo> getBookInfoByBookId(Long bookId) throws Exception {
        return bookInfoDao.getBookInfoByBookId(bookId);
    }

}
