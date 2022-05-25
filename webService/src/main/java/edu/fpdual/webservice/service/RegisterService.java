package edu.fpdual.webservice.service;

import edu.fpdual.webservice.mysql.connector.MySQLConnector;
import edu.fpdual.webservice.api.dto.User;
import edu.fpdual.webservice.mysql.manager.RegisterManager;
import edu.fpdual.webservice.mysql.manager.imp.RegisterManagerImp;

import java.sql.Connection;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Class that connects Controller with Service classes
 */
public class RegisterService {

    private final RegisterManager registerManager;

    /**
     * Constructor that substitute one variable
     *
     * @param registerManagerImp RegisterManagerImp
     */
    public RegisterService(RegisterManagerImp registerManagerImp) {
        registerManager = registerManagerImp;
    }

    /**
     * Method that connect with RegisterManagerImp.class
     *
     * @param user User
     * @return<ol> <li>true boolean - if it's well done</li>
     * <li>false boolean - if it isn't done</li>
     * </ol>
     */
    public boolean createUser(User user) {
        boolean kk = false;
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            if (registerManager.compareRegisterQuery(con, user.getUsername())) {
                registerManager.executeRegisterQuery(con, user.getEmail(), user.getUsername(), user.getPassword());
                kk = true;

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return kk;
    }

}
