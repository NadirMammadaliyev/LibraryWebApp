/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao;

import az.nadir.library.model.BookInfo;

import java.util.List;

/**
 * @author Asus
 */
public interface BookInfoDao {

    List<BookInfo> getBookInfoList() throws Exception;

    BookInfo getBookInfoById(Long bookInfoLong) throws Exception;

    void addBookInfo(BookInfo bookInfo) throws Exception;

    List<BookInfo> searchBookInfoData(String keyWord) throws Exception;

    void deleteBookInfo(Long bookInfoId) throws Exception;

    List<BookInfo> getBookInfoByBookId(Long bookId) throws Exception;
}
