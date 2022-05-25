package edu.fpdual.webservice.mysql.manager;

import java.sql.Connection;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Interface that is going to be used in LoginSuccesfulManagerImp
 */
public interface LoginSuccesfulManager {
    /**
     * Abstract method
     *
     * @param con      Connection
     * @param username String
     * @param password String
     * @return<ol> <li>boolean true - if it's well done</li>
     * <li>boolean false - if it isn't done</li>
     * </ol>
     */
    public boolean executeLoginQuery(Connection con, String username, String password);

}
