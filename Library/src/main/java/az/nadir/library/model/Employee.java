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
public class Employee extends LibraryModel {
    private String name;
    private String surname;
    private Position position;

}
