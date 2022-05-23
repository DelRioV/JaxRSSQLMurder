package edu.fpdual.webservice.mysql.manager;

import java.sql.Connection;

public interface UserCodeManager {
    public int getUsercode(Connection con,String username);
}
