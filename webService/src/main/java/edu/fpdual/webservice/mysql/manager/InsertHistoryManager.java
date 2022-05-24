package edu.fpdual.webservice.mysql.manager;

import java.sql.Connection;
import java.sql.SQLException;

public interface InsertHistoryManager {

    public boolean insertValues(Connection con, int user_code) throws SQLException;

}
