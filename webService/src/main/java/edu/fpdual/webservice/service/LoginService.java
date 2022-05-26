package edu.fpdual.webservice.service;

import edu.fpdual.webservice.exception.ExceptionPersonal;
import edu.fpdual.webservice.mysql.connector.MySQLConnector;
import edu.fpdual.webservice.mysql.manager.LoginSuccesfulManager;
import edu.fpdual.webservice.mysql.manager.imp.LoginSuccesfulManagerImp;

import java.sql.Connection;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Class that connects Controller with Service classes
 */
public class LoginService {
    private final LoginSuccesfulManager loginSuccesfulManager;

    /**
     * Constructor that substitute one variable
     *
     * @param loginSuccesfulManagerImp LoginSuccesfulManagerImp
     */
    public LoginService(LoginSuccesfulManagerImp loginSuccesfulManagerImp) {
        this.loginSuccesfulManager = loginSuccesfulManagerImp;
    }

    /**
     * Method that confirms the log in credentials
     *
     * @param username String
     * @param password - String
     * @return <ol>
     * <li>true boolean - if it's correct</li>
     * <li>false boolean - if it isn't correct</li>
     * </ol>
     */
    public boolean logIn(String username, String password) throws ExceptionPersonal {
        boolean kk = false;
        try (Connection connection = new MySQLConnector().getMySQLConnection()) {
            if (loginSuccesfulManager.executeLoginQuery(connection, username, password)) {
                kk = true;
            } else{
                throw new ExceptionPersonal(username);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kk;
    }
}
