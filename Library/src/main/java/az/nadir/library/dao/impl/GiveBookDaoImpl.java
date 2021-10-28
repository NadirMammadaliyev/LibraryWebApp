/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao.impl;

import az.nadir.library.dao.DBHelper;
import az.nadir.library.dao.GiveBookDao;
import az.nadir.library.model.Book;
import az.nadir.library.model.Employee;
import az.nadir.library.model.GiveBook;
import az.nadir.library.model.ReadingRoom;
import az.nadir.library.model.User;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Asus
 */
public class GiveBookDaoImpl implements GiveBookDao {

    @Override
    public List<GiveBook> getGiveBookList() throws Exception {

        List<GiveBook> giveBookList = new ArrayList<>();
        String sql = "  SELECT GB.ID,\n"
                + "         U.ID USER_ID,\n"
                + "         U.NAME USER_NAME,\n"
                + "         U.SURNAME USER_SURNAME,\n"
                + "         B.ID BOOK_ID,\n"
                + "         B.NAME BOOK_NAME,"
                + "         E.ID EMPLOYEE_ID,\n"
                + "         E.NAME EMPLOYEE_NAME,\n"
                + "         E.SURNAME EMPLOYEE_SURNAME,\n"
                + "         R.ID READING_ROOM_ID,\n"
                + "         R.NAME READING_ROOM_NAME,\n"
                + "         GB.RETURN_DATE RETURN_DATE,\n"
                + "         GB.DATA_DATE DATA_DATE\n"
                + "    FROM GIVE_BOOK GB\n"
                + "         INNER JOIN LIB_USER U\n"
                + "            ON GB.USER_ID = U.ID\n"
                + "         INNER JOIN BOOK B\n"
                + "            ON GB.BOOK_ID = B.ID\n"
                + "         INNER JOIN EMPLOYEE E\n"
                + "            ON GB.EMPLOYEE_ID = E.ID\n"
                + "         INNER JOIN READING_ROOM R\n"
                + "            ON GB.READING_ROOM_ID = R.ID\n"
                + "   WHERE GB.ACTIVE = 1\n"
                + "ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql);) {

            if (c != null) {

                while (rs.next()) {
                    GiveBook giveBook = new GiveBook();
                    User user = new User();
                    user.setId(rs.getLong("USER_ID"));
                    user.setName(rs.getString("USER_NAME"));
                    user.setSurname(rs.getString("USER_SURNAME"));

                    Employee employee = new Employee();
                    employee.setId(rs.getLong("EMPLOYEE_ID"));
                    employee.setName(rs.getString("EMPLOYEE_NAME"));
                    employee.setSurname(rs.getString("EMPLOYEE_SURNAME"));

                    ReadingRoom readingRoom = new ReadingRoom();
                    readingRoom.setId(rs.getLong("READING_ROOM_ID"));
                    readingRoom.setName(rs.getString("READING_ROOM_NAME"));

                    Book book = new Book();
                    book.setId(rs.getLong("BOOK_ID"));
                    book.setName(rs.getString("BOOK_NAME"));

                    giveBook.setId(rs.getLong("ID"));
                    giveBook.setUser(user);
                    giveBook.setReadingRoom(readingRoom);
                    giveBook.setEmployee(employee);
                    giveBook.setBook(book);

                    giveBook.setReturnDate(rs.getDate("RETURN_DATE"));
                    giveBook.setDataDate(rs.getDate("DATA_DATE"));

                    giveBookList.add(giveBook);

                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return giveBookList;
    }

    @Override
    public void addGiveBook(GiveBook giveBook) throws Exception {
        String sql = "INSERT INTO GIVE_BOOK\n"
                + "VALUES(GIVE_BOOK_SEQ.NEXTVAL,?,?,?,?,?,SYSDATE,1)";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setLong(1, giveBook.getUser().getId());
            ps.setLong(2, giveBook.getBook().getId());
            ps.setLong(3, giveBook.getEmployee().getId());
            ps.setLong(4, giveBook.getReadingRoom().getId());
            ps.setDate(5, new java.sql.Date(giveBook.getReturnDate().getTime()));

            ps.execute();
            c.commit();
        }
    }

    @Override
    public GiveBook getGiveBookById(Long giveBookLong) throws Exception {
        GiveBook giveBook = new GiveBook();
        String sql = "  SELECT GB.ID,\n"
                + "         U.ID USER_ID,\n"
                + "         U.NAME USER_NAME,\n"
                + "         U.SURNAME USER_SURNAME,\n"
                + "         B.ID BOOK_ID,\n"
                + "         B.NAME BOOK_NAME,"
                + "         E.ID EMPLOYEE_ID,\n"
                + "         E.NAME EMPLOYEE_NAME,\n"
                + "         E.SURNAME EMPLOYEE_SURNAME,\n"
                + "         R.ID READING_ROOM_ID,\n"
                + "         R.NAME READING_ROOM_NAME,\n"
                + "         GB.RETURN_DATE RETURN_DATE,\n"
                + "         GB.DATA_DATE DATA_DATE\n"
                + "    FROM GIVE_BOOK GB\n"
                + "         INNER JOIN LIB_USER U\n"
                + "            ON GB.USER_ID = U.ID\n"
                + "         INNER JOIN BOOK B\n"
                + "            ON GB.BOOK_ID = B.ID\n"
                + "         INNER JOIN EMPLOYEE E\n"
                + "            ON GB.EMPLOYEE_ID = E.ID\n"
                + "         INNER JOIN READING_ROOM R\n"
                + "            ON GB.READING_ROOM_ID = R.ID\n"
                + "   WHERE GB.ACTIVE = 1\n"
                + " AND GB.ID=?\n"
                + "ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, giveBookLong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                User user = new User();
                user.setId(rs.getLong("USER_ID"));
                user.setName(rs.getString("USER_NAME"));
                user.setSurname(rs.getString("USER_SURNAME"));

                Employee employee = new Employee();
                employee.setId(rs.getLong("EMPLOYEE_ID"));
                employee.setName(rs.getString("EMPLOYEE_NAME"));
                employee.setSurname(rs.getString("EMPLOYEE_SURNAME"));

                ReadingRoom readingRoom = new ReadingRoom();
                readingRoom.setId(rs.getLong("READING_ROOM_ID"));
                readingRoom.setName(rs.getString("READING_ROOM_NAME"));

                Book book = new Book();
                book.setId(rs.getLong("BOOK_ID"));
                book.setName(rs.getString("BOOK_NAME"));

                giveBook.setId(rs.getLong("ID"));
                giveBook.setUser(user);
                giveBook.setReadingRoom(readingRoom);
                giveBook.setEmployee(employee);
                giveBook.setBook(book);

                giveBook.setReturnDate(rs.getDate("RETURN_DATE"));
                giveBook.setDataDate(rs.getDate("DATA_DATE"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return giveBook;
    }

    @Override
    public void updateGiveBook(GiveBook giveBook) throws Exception {
        String sql = "UPDATE GIVE_BOOK SET USER_ID =? , BOOK_ID = ? , EMPLOYEE_ID = ?,READING_ROOM_ID=?,RETURN_DATE=? WHERE ID =? ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, giveBook.getUser().getId());
            ps.setLong(2, giveBook.getBook().getId());
            ps.setLong(3, giveBook.getEmployee().getId());
            ps.setLong(4, giveBook.getReadingRoom().getId());
            ps.setDate(5, new java.sql.Date(giveBook.getReturnDate().getTime()));
            ps.setLong(6, giveBook.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteGiveBook(Long giveBookId) throws Exception {
        String sql = "UPDATE GIVE_BOOK SET ACTIVE = 0 \n"
                + "WHERE ID =?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, giveBookId);
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<GiveBook> searchGiveBookData(String keyWord) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
