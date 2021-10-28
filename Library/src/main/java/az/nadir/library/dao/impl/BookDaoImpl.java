/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao.impl;

import az.nadir.library.dao.BookDao;
import az.nadir.library.dao.DBHelper;
import az.nadir.library.model.Book;
import az.nadir.library.model.BookInfo;
import az.nadir.library.model.Language;
import az.nadir.library.model.Shelf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Asus
 */
public class BookDaoImpl implements BookDao {

    @Override
    public List<Book> getBookList() throws Exception {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT B.ID,\n"
                + "       B.NAME BOOK_NAME,\n"
                + "       L.ID LANGUAGE_ID,\n"
                + "       L.NAME LANGUAGE_NAME,\n"
                + "       S.ID SHELF_ID,\n"
                + "       S.NAME SHELF_NAME,\n"
                + "       B.PAGE BOOK_PAGE,\n"
                + "       B.PRICE BOOK_PRICE,\n"
                + "       B.DATE_OF_PUBLICATION BOOK_DATE_OF_PUBLICATION,\n"
                + "       B.CURRENT_SITUATION BOOK_CURRENT_SITUATION,\n"
                + "       B.NUMBER_OF_BOOK BOOK_NUMBER_OF_BOOK\n"
                + "       FROM BOOK B\n"
                + "       INNER JOIN LANGUAGE L\n"
                + "          ON B.LANGUAGE_ID = L.ID\n"
                + "       INNER JOIN SHELF S\n"
                + "          ON B.SHELF_ID = S.ID\n"
                + "          WHERE B.ACTIVE=1 AND B.CURRENT_SITUATION=1 ORDER BY B.ID ";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql);) {

            if (c != null) {

                while (rs.next()) {
                    Book book = new Book();

                    Language language = new Language();
                    language.setId(rs.getLong("LANGUAGE_ID"));
                    language.setName(rs.getString("LANGUAGE_NAME"));

                    Shelf shelf = new Shelf();
                    shelf.setId(rs.getLong("SHELF_ID"));
                    shelf.setName(rs.getString("SHELF_NAME"));

                    book.setId(rs.getLong("ID"));
                    book.setName(rs.getString("BOOK_NAME"));
                    book.setLanguage(language);
                    book.setShelf(shelf);
                    book.setPage(rs.getInt("BOOK_PAGE"));
                    book.setPrice(rs.getDouble("BOOK_PRICE"));
                    book.setDateOfPublication(rs.getString("BOOK_DATE_OF_PUBLICATION"));
                    book.setNumberOfBook(rs.getInt("BOOK_NUMBER_OF_BOOK"));
                    bookList.add(book);

                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public void addBook(BookInfo bookInfo) throws Exception {

        String sql = "INSERT INTO BOOK VALUES(BOOK_SEQ.NEXTVAL,?,?,?,?,?,?,1,?, SYSDATE,1) ";
//        String sql = "INSERT ALL INTO BOOK\n"
//                + "                VALUES(BOOK_SEQ.NEXTVAL,?,?,?,?,?,?,1,?, SYSDATE,1)\n"
//                + "INTO AUTHOR_BOOK_TOPIC\n"
//                + "                VALUES(ABT_SEQ.NEXTVAL,?,BOOK_SEQ.CURRVAL,?,SYSDATE,1)\n"
//                + "                SELECT * FROM DUAL ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, bookInfo.getBook().getName());
            ps.setLong(2, bookInfo.getBook().getLanguage().getId());
            ps.setLong(3, bookInfo.getBook().getShelf().getId());
            ps.setInt(4, bookInfo.getBook().getPage());
            ps.setDouble(5, bookInfo.getBook().getPrice());
            ps.setString(6, bookInfo.getBook().getDateOfPublication());
            ps.setInt(7, bookInfo.getBook().getNumberOfBook());
//          ps.setLong(8, bookInfo.getAuthor().getId());
            //         ps.setLong(9, bookInfo.getTopic().getId());

            ps.execute();
            c.commit();
        }
    }

    @Override
    public Book getBookById(Long bookLong) throws Exception {
        Book book = new Book();
        String sql = "SELECT B.ID,\n"
                + "       B.NAME BOOK_NAME,\n"
                + "       L.ID LANGUAGE_ID,\n"
                + "       L.NAME LANGUAGE_NAME,\n"
                + "       S.ID SHELF_ID,\n"
                + "       S.NAME SHELF_NAME,\n"
                + "       B.PAGE BOOK_PAGE,\n"
                + "       B.PRICE BOOK_PRICE,\n"
                + "       B.DATE_OF_PUBLICATION BOOK_DATE_OF_PUBLICATION,\n"
                + "       B.CURRENT_SITUATION BOOK_CURRENT_SITUATION,\n"
                + "       B.NUMBER_OF_BOOK BOOK_NUMBER_OF_BOOK\n"
                + "       FROM BOOK B\n"
                + "       INNER JOIN LANGUAGE L\n"
                + "          ON B.LANGUAGE_ID = L.ID\n"
                + "       INNER JOIN SHELF S\n"
                + "          ON B.SHELF_ID = S.ID\n"
                + "          WHERE B.ACTIVE=1 AND B.CURRENT_SITUATION=1 AND B.ID=? ORDER BY B.ID ";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, bookLong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Language language = new Language();
                language.setId(rs.getLong("LANGUAGE_ID"));
                language.setName(rs.getString("LANGUAGE_NAME"));

                Shelf shelf = new Shelf();
                shelf.setId(rs.getLong("SHELF_ID"));
                shelf.setName(rs.getString("SHELF_NAME"));

                book.setId(rs.getLong("ID"));
                book.setName(rs.getString("BOOK_NAME"));
                book.setLanguage(language);
                book.setShelf(shelf);
                book.setPage(rs.getInt("BOOK_PAGE"));
                book.setPrice(rs.getDouble("BOOK_PRICE"));
                book.setDateOfPublication(rs.getString("BOOK_DATE_OF_PUBLICATION"));
                book.setNumberOfBook(rs.getInt("BOOK_NUMBER_OF_BOOK"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;

    }

    @Override
    public void updateBook(Book book) throws Exception {
        String sql = "UPDATE BOOK SET  NAME = ? , LANGUAGE_ID = ?, SHELF_ID=?, PAGE=? , PRICE=? ,DATE_OF_PUBLICATION =?,NUMBER_OF_BOOK=? WHERE ID =? ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, book.getName());
            ps.setLong(2, book.getLanguage().getId());
            ps.setLong(3, book.getShelf().getId());
            ps.setInt(4, book.getPage());
            ps.setDouble(5, book.getPrice());
            ps.setString(6, book.getDateOfPublication());
            ps.setInt(7, book.getNumberOfBook());
            ps.setLong(8, book.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteBook(Long bookId) throws Exception {
        String sql = "UPDATE BOOK SET ACTIVE = 0 \n"
                + "WHERE ID =?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, bookId);
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Book> searchBookData(String keyWord) throws Exception {
        List<Book> bookList = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT B.ID,\n"
                + "       B.NAME BOOK_NAME,\n"
                + "       L.ID LANGUAGE_ID,\n"
                + "       L.NAME LANGUAGE_NAME,\n"
                + "       S.ID SHELF_ID,\n"
                + "       S.NAME SHELF_NAME,\n"
                + "       B.PAGE BOOK_PAGE,\n"
                + "       B.PRICE BOOK_PRICE,\n"
                + "       B.DATE_OF_PUBLICATION BOOK_DATE_OF_PUBLICATION,\n"
                + "       B.CURRENT_SITUATION BOOK_CURRENT_SITUATION,\n"
                + "       B.NUMBER_OF_BOOK BOOK_NUMBER_OF_BOOK \n"
                + "       FROM BOOK B\n"
                + "       INNER JOIN LANGUAGE L\n"
                + "          ON B.LANGUAGE_ID = L.ID\n"
                + "       INNER JOIN SHELF S\n"
                + "          ON B.SHELF_ID = S.ID\n"
                + "          WHERE B.ACTIVE=1 AND B.CURRENT_SITUATION=1 AND (   LOWER (B.NAME) LIKE LOWER (?) OR LOWER(L.NAME) LIKE LOWER (?) OR LOWER(S.NAME) LIKE LOWER(?) OR LOWER(B.PAGE) LIKE LOWER(?) OR LOWER (B.PRICE) LIKE LOWER(?) OR LOWER(B.DATE_OF_PUBLICATION) LIKE LOWER(?) OR LOWER(B.NUMBER_OF_BOOK) LIKE LOWER (?) ) ORDER BY B.ID ";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyWord + "%");
            ps.setString(2, "%" + keyWord + "%");
            ps.setString(3, "%" + keyWord + "%");
            ps.setString(4, "%" + keyWord + "%");
            ps.setString(5, "%" + keyWord + "%");
            ps.setString(6, "%" + keyWord + "%");
            ps.setString(7, "%" + keyWord + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();

                Language language = new Language();
                language.setId(rs.getLong("LANGUAGE_ID"));
                language.setName(rs.getString("LANGUAGE_NAME"));

                Shelf shelf = new Shelf();
                shelf.setId(rs.getLong("SHELF_ID"));
                shelf.setName(rs.getString("SHELF_NAME"));

                book.setId(rs.getLong("ID"));
                book.setName(rs.getString("BOOK_NAME"));
                book.setLanguage(language);
                book.setShelf(shelf);
                book.setPage(rs.getInt("BOOK_PAGE"));
                book.setPrice(rs.getDouble("BOOK_PRICE"));
                book.setDateOfPublication(rs.getString("BOOK_DATE_OF_PUBLICATION"));
                book.setNumberOfBook(rs.getInt("BOOK_NUMBER_OF_BOOK"));
                bookList.add(book);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookList;
    }

    @Override
    public void updateNumberOfBookMinus(Book book, Integer numOfBook) throws Exception {
        String sql = "UPDATE BOOK SET NUMBER_OF_BOOK = ? WHERE ID =? ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, numOfBook - 1);

            ps.setLong(2, book.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Integer getNumberOfBook(Long bookLong) throws Exception {
        Book book = new Book();
        Integer numOfBook = 0;
        String sql = "SELECT NUMBER_OF_BOOK FROM BOOK WHERE ID = ? ";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, bookLong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                book.setNumberOfBook(rs.getInt("NUMBER_OF_BOOK"));
                numOfBook = book.getNumberOfBook();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return numOfBook;
    }

    @Override
    public void updateNumberOfBookPlus(Book book, Integer numOfBook) throws Exception {
        String sql = "UPDATE BOOK SET NUMBER_OF_BOOK = ? WHERE ID =? ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, numOfBook + 1);

            ps.setLong(2, book.getId());
            ps.execute();
            c.commit();
        }
    }

}
