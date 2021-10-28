/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao.impl;

import az.nadir.library.dao.AuthorDao;
import az.nadir.library.dao.DBHelper;
import az.nadir.library.model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Asus
 */
public class AuthorDaoImpl implements AuthorDao {

    @Override
    public List<Author> getAuthorList() throws Exception {
        List<Author> authorList = new ArrayList<>();
        String sql = "SELECT ID,NAME,SURNAME FROM AUTHOR\n"
                + "WHERE ACTIVE = 1";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql)) {
            if (c != null) {
                while (rs.next()) {
                    Author author = new Author();
                    author.setId(rs.getLong("ID"));
                    author.setName(rs.getString("NAME"));
                    author.setSurname(rs.getString("SURNAME"));

                    authorList.add(author);

                }
            } else {
                System.out.println("Conecction is null! ");
            }

        }
        return authorList;
    }

    @Override
    public void addAuthor(Author author) throws Exception {
        String sql = "INSERT INTO AUTHOR(ID,NAME,SURNAME)\n"
                + "VALUES(AUTHOR_SEQ.NEXTVAL,?,?)";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, author.getName());
            ps.setString(2, author.getSurname());
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Author getAuthorById(Long authorLong) throws Exception {
        Author author = new Author();

        String sql = "SELECT ID,NAME,SURNAME FROM AUTHOR \n"
                + "WHERE ACTIVE =1 AND ID =?";
        ResultSet rs = null;
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, authorLong);
            rs = ps.executeQuery();
            if (rs.next()) {
                author.setId(rs.getLong("ID"));
                author.setName(rs.getString("NAME"));
                author.setSurname(rs.getString("SURNAME"));


            } else {
                author = null;
            }

        }
        return author;
    }

    @Override
    public void updateAuthor(Author author) throws Exception {
        String sql = "UPDATE AUTHOR SET NAME =? ,SURNAME = ?  \n"
                + "WHERE ID =?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, author.getName());
            ps.setString(2, author.getSurname());

            ps.setLong(3, author.getId());
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteAuthor(Long authorId) throws Exception {
        String sql = "UPDATE AUTHOR SET ACTIVE = 0 \n"
                + "WHERE ID =?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, authorId);
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Author> searchAuthor(String keyWord) throws Exception {
        List<Author> authorList = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT ID, NAME, SURNAME FROM AUTHOR WHERE ACTIVE = 1 OR ACTIVE = 2 AND (LOWER (NAME) LIKE LOWER (?) OR LOWER(SURNAME) LIKE LOWER (?))  ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyWord + "%");
            ps.setString(2, "%" + keyWord + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getLong("ID"));
                author.setName(rs.getString("NAME"));
                author.setSurname(rs.getString("SURNAME"));

                authorList.add(author);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return authorList;
    }

}
