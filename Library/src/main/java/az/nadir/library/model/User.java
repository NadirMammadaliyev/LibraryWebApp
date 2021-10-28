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
public class User extends LibraryModel {
    private String name;
    private String surname;
    private Date dob;
    private String identityNumber;
    private String mail;
    private String phone;
    private Integer userActivity;
    private Integer problem;


}
