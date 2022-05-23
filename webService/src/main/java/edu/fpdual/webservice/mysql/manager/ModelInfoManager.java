package edu.fpdual.webservice.mysql.manager;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ModelInfoManager {

    public ArrayList<String> changeTip(Connection con) throws SQLException;

}
