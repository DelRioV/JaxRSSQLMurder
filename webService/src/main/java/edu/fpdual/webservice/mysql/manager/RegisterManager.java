package edu.fpdual.webservice.mysql.manager;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Interface that is going to be used in RegisterManagerImp
 */
public interface RegisterManager {
    /**
     * Abstract method
     *
     * @param con      Connection
     * @param username String
     * @return<ol> <li>boolean true - if it's well done</li>
     * <li>boolean false - if it isn't done</li>
     * </ol>
     */
    public boolean compareRegisterQuery(Connection con, String username);

    /**
     * Abstract method
     *
     * @param con      Connection
     * @param email    String
     * @param username String
     * @param password String
     * @throws SQLException - in some circunstances
     */
    public void executeRegisterQuery(Connection con, String email, String username, String password) throws SQLException;


}
