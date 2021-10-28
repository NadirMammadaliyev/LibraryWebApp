/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service.impl;

import az.nadir.library.dao.AuthorDao;
import az.nadir.library.model.Author;
import az.nadir.library.service.AuthorService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author Asus
 */
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao;

    @Override
    public List<Author> getAuthorList() throws Exception {
        return authorDao.getAuthorList();
    }

    @Override
    public void addAuthor(Author author) throws Exception {
        authorDao.addAuthor(author);
    }

    @Override
    public Author getAuthorById(Long authorLong) throws Exception {
        return authorDao.getAuthorById(authorLong);
    }

    @Override
    public void updateAuthor(Author author) throws Exception {
        authorDao.updateAuthor(author);
    }

    @Override
    public void deleteAuthor(Long authorId) throws Exception {
        authorDao.deleteAuthor(authorId);
    }

    @Override
    public List<Author> searchAuthor(String keyWord) throws Exception {
        return authorDao.searchAuthor(keyWord);
    }

}
