/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service;

import az.nadir.library.model.LoginUser;

/**
 * @author Asus
 */
public interface LoginUserService {
    LoginUser login(String username, String password) throws Exception;
}
