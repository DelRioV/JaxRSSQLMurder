package edu.fpdual.webservice.mysql.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Interface that is going to be used in ModelInfoManagerImp
 */
public interface ModelInfoManager {
    /**
     * Abstract method
     *
     * @param con Conneciton
     * @return ArrayList with message texts
     * @throws SQLException - in some cirscunstances
     */
    public ArrayList<String> changeTip(Connection con) throws SQLException;

}
