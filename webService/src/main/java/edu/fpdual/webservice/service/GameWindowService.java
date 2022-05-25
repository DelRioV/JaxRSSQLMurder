package edu.fpdual.webservice.service;

import edu.fpdual.webservice.mysql.connector.MySQLConnector;
import edu.fpdual.webservice.mysql.manager.QueryRecoverManager;
import edu.fpdual.webservice.mysql.manager.imp.QueryRecoverManagerImp;
import edu.fpdual.webservice.mysql.manager.imp.UserCodeManagerImp;

import java.util.ArrayList;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Class that connects Controller with Service classes
 */
public class GameWindowService {
    private QueryRecoverManager queryRecoverManager;

    /**
     * Constructor that substitute one variable
     *
     * @param queryRecoverManagerImp QueryRecoverManagerImp
     */
    public GameWindowService(QueryRecoverManagerImp queryRecoverManagerImp) {
        this.queryRecoverManager = queryRecoverManagerImp;
    }

    /**
     * Method that connects with the DataBase
     *
     * @param query     String
     * @param user_code int
     * @return ArrayList with the information
     */
    public ArrayList<ArrayList<String>> queryRecover(String query, int user_code) {
        try {
            return new QueryRecoverManagerImp().executeQuery(new MySQLConnector().getMySQLConnection(), query, user_code);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method that connects with the DataBase
     *
     * @param username String
     * @return the user_code
     */
    public int usercodeRecover(String username) {
        try {
            return new UserCodeManagerImp().getUsercode(new MySQLConnector().getMySQLConnection(), username);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
