package edu.fpdual.webservice.mysql.manager;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Interface that is going to be used in QueryRecoverManagerImp
 */
public interface QueryRecoverManager {
    /**
     * Abstract method
     *
     * @param connection Connection
     * @param query      String
     * @param user_code  int
     * @return ArrayList with String
     */
    public ArrayList<ArrayList<String>> executeQuery(Connection connection, String query, int user_code);


}
