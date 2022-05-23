package edu.fpdual.webservice.mysql.manager;

import java.sql.Connection;
import java.sql.SQLException;

public interface InsertHistoryManager {

    public void insertValues(Connection con, int user_code) throws SQLException;

}
