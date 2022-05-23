package edu.fpdual.webservice.service;

import edu.fpdual.webservice.api.dto.User;
import edu.fpdual.webservice.mysql.connector.MySQLConnector;
import edu.fpdual.webservice.mysql.manager.LoginSuccesfulManager;
import edu.fpdual.webservice.mysql.manager.imp.LoginSuccesfulManagerImp;

import java.sql.Connection;

public class LoginService {
    private final LoginSuccesfulManager loginSuccesfulManager;

    public LoginService(LoginSuccesfulManagerImp loginSuccesfulManagerImp) {
        this.loginSuccesfulManager = loginSuccesfulManagerImp;
    }

    public boolean logOn(String username, String password){
        boolean kk = false;
        try(Connection connection = new MySQLConnector().getMySQLConnection()){
            if(loginSuccesfulManager.executeLoginQuery(connection,username,password)) {
                kk = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return kk;
    }
}
