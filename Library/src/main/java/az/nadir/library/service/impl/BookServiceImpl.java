/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service.impl;

import az.nadir.library.dao.BookDao;
import az.nadir.library.model.Book;
import az.nadir.library.model.BookInfo;
import az.nadir.library.service.BookService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author Asus
 */
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Override
    public List<Book> getBookList() throws Exception {
        return bookDao.getBookList();
    }

    @Override
    public void addBook(BookInfo bookInfo) throws Exception {
        bookDao.addBook(bookInfo);
    }

    @Override
    public Book getBookById(Long bookLong) throws Exception {
        return bookDao.getBookById(bookLong);
    }

    @Override
    public void updateBook(Book book) throws Exception {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBook(Long bookId) throws Exception {
        bookDao.deleteBook(bookId);
    }

    @Override
    public List<Book> searchBookData(String keyWord) throws Exception {
        return bookDao.searchBookData(keyWord);
    }


    @Override
    public Integer getNumberOfBook(Long bookLong) throws Exception {
        return bookDao.getNumberOfBook(bookLong);
    }

    @Override
    public void updateNumberOfBookMinus(Book book, Integer numOfBook) throws Exception {
        bookDao.updateNumberOfBookMinus(book, numOfBook);
    }

    @Override
    public void updateNumberOfBookPlus(Book book, Integer numOfBook) throws Exception {
        bookDao.updateNumberOfBookPlus(book, numOfBook);
    }


}
