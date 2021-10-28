/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao;

import az.nadir.library.model.Book;
import az.nadir.library.model.BookInfo;

import java.util.List;

/**
 * @author Asus
 */
public interface BookDao {

    List<Book> getBookList() throws Exception;

    void addBook(BookInfo bookInfo) throws Exception;

    Book getBookById(Long bookLong) throws Exception;

    void updateBook(Book book) throws Exception;

    void updateNumberOfBookMinus(Book book, Integer numOfBook) throws Exception;

    void updateNumberOfBookPlus(Book book, Integer numOfBook) throws Exception;

    Integer getNumberOfBook(Long bookLong) throws Exception;

    void deleteBook(Long bookId) throws Exception;

    List<Book> searchBookData(String keyWord) throws Exception;
}
