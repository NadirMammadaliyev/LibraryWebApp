/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao;

import az.nadir.library.model.Shelf;

import java.util.List;

/**
 * @author Asus
 */
public interface ShelfDao {
    List<Shelf> getShelfList() throws Exception;

    Shelf getShelfById(Long shelfLong) throws Exception;
}
