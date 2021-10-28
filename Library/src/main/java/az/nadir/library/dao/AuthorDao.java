/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao;

import az.nadir.library.model.Author;

import java.util.List;

/**
 * @author Asus
 */
public interface AuthorDao {

    List<Author> getAuthorList() throws Exception;

    void addAuthor(Author author) throws Exception;

    Author getAuthorById(Long authorLong) throws Exception;

    void updateAuthor(Author author) throws Exception;

    void deleteAuthor(Long authorId) throws Exception;

    List<Author> searchAuthor(String keyWord) throws Exception;
}
