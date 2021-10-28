/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao.impl;

import az.nadir.library.dao.BookInfoDao;
import az.nadir.library.dao.DBHelper;
import az.nadir.library.model.Author;
import az.nadir.library.model.Book;
import az.nadir.library.model.BookInfo;
import az.nadir.library.model.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Asus
 */
public class BookInfoDaoImpl implements BookInfoDao {

    @Override
    public List<BookInfo> getBookInfoList() throws Exception {
        List<BookInfo> bookInfoList = new ArrayList<>();
        String sql = "SELECT AUT.ID, A.ID AUTHOR_ID,A.NAME AUTHOR_NAME,A.SURNAME AUTHOR_SURNAME, B.ID BOOK_ID,B.NAME BOOK_NAME,T.ID TOPIC_ID ,T.NAME TOPIC_NAME\n"
                + "  FROM AUTHOR_BOOK_TOPIC AUT\n"
                + "       INNER JOIN AUTHOR A\n"
                + "          ON AUT.AUTHOR_ID = A.ID\n"
                + "       INNER JOIN BOOK B\n"
                + "          ON AUT.BOOK_ID = B.ID\n"
                + "       INNER JOIN TOPIC T\n"
                + "          ON AUT.TOPIC_ID = T.ID\n"
                + "          WHERE AUT.ACTIVE=1 ORDER BY AUT.ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql);) {
            if (c != null) {

                while (rs.next()) {
                    BookInfo bookInfo = new BookInfo();
                    Book book = new Book();
                    book.setId(rs.getLong("BOOK_ID"));
                    book.setName(rs.getString("BOOK_NAME"));
                    Author author = new Author();
                    author.setId(rs.getLong("AUTHOR_ID"));
                    author.setName(rs.getString("AUTHOR_NAME"));
                    author.setSurname(rs.getString("AUTHOR_SURNAME"));

                    Topic topic = new Topic();
                    topic.setId(rs.getLong("TOPIC_ID"));
                    topic.setName(rs.getString("TOPIC_NAME"));

                    bookInfo.setId(rs.getLong("ID"));
                    bookInfo.setBook(book);
                    bookInfo.setAuthor(author);
                    bookInfo.setTopic(topic);

                    bookInfoList.add(bookInfo);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookInfoList;
    }

    @Override
    public BookInfo getBookInfoById(Long bookInfoLong) throws Exception {
        BookInfo bookInfo = new BookInfo();
        String sql = "SELECT AUT.ID, A.ID AUTHOR_ID,A.NAME AUTHOR_NAME,A.SURNAME AUTHOR_SURNAME, B.ID BOOK_ID,B.NAME BOOK_NAME,T.ID TOPIC_ID ,T.NAME TOPIC_NAME\n"
                + "  FROM AUTHOR_BOOK_TOPIC AUT\n"
                + "       INNER JOIN AUTHOR A\n"
                + "          ON AUT.AUTHOR_ID = A.ID\n"
                + "       INNER JOIN BOOK B\n"
                + "          ON AUT.BOOK_ID = B.ID\n"
                + "       INNER JOIN TOPIC T\n"
                + "          ON AUT.TOPIC_ID = T.ID\n"
                + "          WHERE AUT.ACTIVE=1 AND AUT.ID=? ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, bookInfoLong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("BOOK_ID"));
                book.setName(rs.getString("BOOK_NAME"));


                Author author = new Author();
                author.setId(rs.getLong("AUTHOR_ID"));
                author.setName(rs.getString("AUTHOR_NAME"));
                author.setSurname(rs.getString("AUTHOR_SURNAME"));

                Topic topic = new Topic();
                topic.setId(rs.getLong("TOPIC_ID"));
                topic.setName(rs.getString("TOPIC_NAME"));

                bookInfo.setId(rs.getLong("ID"));
                bookInfo.setBook(book);
                bookInfo.setAuthor(author);
                bookInfo.setTopic(topic);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookInfo;
    }

    @Override
    public void addBookInfo(BookInfo bookInfo) throws Exception {
        Long nullLong = null;
        String sql = "INSERT INTO AUTHOR_BOOK_TOPIC\n"
                + "VALUES(ABT_SEQ.NEXTVAL,?,?,?,SYSDATE,1)";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, bookInfo.getAuthor().getId());
            ps.setLong(2, bookInfo.getBook().getId());
            ps.setLong(3, bookInfo.getTopic().getId());
            //    ps.setObject(3,java.sql.Types.NULL);


            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<BookInfo> searchBookInfoData(String keyWord) throws Exception {
        List<BookInfo> bookInfoList = new ArrayList<>();
        ResultSet rs = null;
        String sql = " SELECT AUT.ID, A.ID AUTHOR_ID,A.NAME AUTHOR_NAME,A.SURNAME AUTHOR_SURNAME, B.ID BOOK_ID,B.NAME BOOK_NAME,T.ID TOPIC_ID ,T.NAME TOPIC_NAME\n"
                + "  FROM AUTHOR_BOOK_TOPIC AUT\n"
                + "       INNER JOIN AUTHOR A\n"
                + "          ON AUT.AUTHOR_ID = A.ID\n"
                + "       INNER JOIN BOOK B\n"
                + "          ON AUT.BOOK_ID = B.ID\n"
                + "       INNER JOIN TOPIC T\n"
                + "          ON AUT.TOPIC_ID = T.ID\n"
                + "          WHERE AUT.ACTIVE=1 AND (LOWER (A.NAME) LIKE LOWER(?) OR LOWER (A.SURNAME) LIKE LOWER (?) OR LOWER (B.NAME) LIKE LOWER(?) OR LOWER(T.NAME) LIKE LOWER (?) ) ORDER BY AUT.ID ";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyWord + "%");
            ps.setString(2, "%" + keyWord + "%");
            ps.setString(3, "%" + keyWord + "%");
            ps.setString(4, "%" + keyWord + "%");


            rs = ps.executeQuery();
            while (rs.next()) {
                BookInfo bookInfo = new BookInfo();
                Book book = new Book();
                book.setId(rs.getLong("BOOK_ID"));
                book.setName(rs.getString("BOOK_NAME"));
                Author author = new Author();
                author.setId(rs.getLong("AUTHOR_ID"));
                author.setName(rs.getString("AUTHOR_NAME"));
                author.setSurname(rs.getString("AUTHOR_SURNAME"));

                Topic topic = new Topic();
                topic.setId(rs.getLong("TOPIC_ID"));
                topic.setName(rs.getString("TOPIC_NAME"));

                bookInfo.setId(rs.getLong("ID"));
                bookInfo.setBook(book);
                bookInfo.setAuthor(author);
                bookInfo.setTopic(topic);

                bookInfoList.add(bookInfo);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookInfoList;
    }

    @Override
    public void deleteBookInfo(Long bookInfoId) throws Exception {
        String sql = "UPDATE AUTHOR_BOOK_TOPIC SET ACTIVE = 0 \n"
                + "WHERE ID =?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, bookInfoId);
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<BookInfo> getBookInfoByBookId(Long bookId) throws Exception {
        List<BookInfo> bookInfoList = new ArrayList<>();
        ResultSet rs = null;
        String sql = " SELECT AUT.ID, A.ID AUTHOR_ID,A.NAME AUTHOR_NAME,A.SURNAME AUTHOR_SURNAME, B.ID BOOK_ID,B.NAME BOOK_NAME,T.ID TOPIC_ID ,T.NAME TOPIC_NAME\n" +
                "                  FROM AUTHOR_BOOK_TOPIC AUT\n" +
                "                       INNER JOIN AUTHOR A\n" +
                "                          ON AUT.AUTHOR_ID = A.ID\n" +
                "                      INNER JOIN BOOK B\n" +
                "                           ON AUT.BOOK_ID = B.ID\n" +
                "                      INNER JOIN TOPIC T\n" +
                "                       ON AUT.TOPIC_ID = T.ID\n" +
                "                           WHERE B.ID=? ";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, bookId);
            rs = ps.executeQuery();
            while (rs.next()) {
                BookInfo bookInfo = new BookInfo();
                Book book = new Book();
                book.setId(rs.getLong("BOOK_ID"));
                book.setName(rs.getString("BOOK_NAME"));
                Author author = new Author();
                author.setId(rs.getLong("AUTHOR_ID"));
                author.setName(rs.getString("AUTHOR_NAME"));
                author.setSurname(rs.getString("AUTHOR_SURNAME"));

                Topic topic = new Topic();
                topic.setId(rs.getLong("TOPIC_ID"));
                topic.setName(rs.getString("TOPIC_NAME"));

                bookInfo.setId(rs.getLong("ID"));
                bookInfo.setBook(book);
                bookInfo.setAuthor(author);
                bookInfo.setTopic(topic);

                bookInfoList.add(bookInfo);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookInfoList;
    }

}
