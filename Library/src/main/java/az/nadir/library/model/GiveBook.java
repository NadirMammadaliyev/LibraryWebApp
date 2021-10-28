/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Asus
 */
@Data
public class GiveBook extends LibraryModel {
    private User user;
    private Book book;
    private Employee employee;
    private ReadingRoom readingRoom;
    private Date returnDate;

}
