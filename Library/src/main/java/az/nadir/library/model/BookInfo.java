/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.model;

import lombok.Data;

/**
 * @author Asus
 */
@Data
public class BookInfo extends LibraryModel {
    private Book book;
    private Author author;
    private Topic topic;

}
