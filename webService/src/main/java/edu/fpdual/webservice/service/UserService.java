package edu.fpdual.webservice.service;

import edu.fpdual.webservice.mysql.connector.MySQLConnector;
import edu.fpdual.webservice.api.dto.User;
import edu.fpdual.webservice.mysql.manager.RegisterManager;
import edu.fpdual.webservice.mysql.manager.imp.RegisterManagerImp;

import java.sql.Connection;

public class UserService {

    private final RegisterManager registerManager;

    public UserService(RegisterManagerImp registerManagerImp) {
        registerManager = registerManagerImp;
    }

    public boolean createUser(User user) {
        boolean kk = false;
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
                registerManager.executeRegisterQuery(con, user.getEmail(), user.getUsername(), user.getPassword());
                kk = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return kk;
    }

}
