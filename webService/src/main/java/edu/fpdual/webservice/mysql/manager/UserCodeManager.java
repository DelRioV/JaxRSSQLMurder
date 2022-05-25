package edu.fpdual.webservice.mysql.manager;

import java.sql.Connection;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Interface that is going to be used in UserCodeManagerImp
 */
public interface UserCodeManager {
    /**
     * Abstract method
     *
     * @param con      Connection
     * @param username String
     * @return the user_code
     */
    public int getUsercode(Connection con, String username);
}
