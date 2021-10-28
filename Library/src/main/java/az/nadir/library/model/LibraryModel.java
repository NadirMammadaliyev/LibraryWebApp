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
public abstract class LibraryModel {

    private Long id;
    private Date dataDate;
    private Integer active;

}
