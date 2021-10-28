/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service.impl;

import az.nadir.library.dao.LoginUserDao;
import az.nadir.library.model.LoginUser;
import az.nadir.library.service.LoginUserService;
import lombok.AllArgsConstructor;

/**
 * @author Asus
 */
@AllArgsConstructor
public class LoginUserServiceImpl implements LoginUserService {

    private LoginUserDao loginUserDao;

    @Override
    public LoginUser login(String username, String password) throws Exception {
        return loginUserDao.login(username, password);
    }

}
