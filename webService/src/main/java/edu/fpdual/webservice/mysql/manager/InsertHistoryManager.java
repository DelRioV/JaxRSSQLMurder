package edu.fpdual.webservice.mysql.manager;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Interface that is going to be used in InsertHistoryManagerImp
 */
public interface InsertHistoryManager {
    /**
     * Abstract method
     *
     * @param con       Connection
     * @param user_code int
     * @return <ol>
     * <li>boolean true - if it's well done</li>
     * <li>boolean false - if it isn't done</li>
     * </ol>
     * @throws SQLException - in some circunstances
     */
    public boolean insertValues(Connection con, int user_code) throws SQLException;

}
