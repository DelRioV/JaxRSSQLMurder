package edu.fpdual.webservice.mysql.manager;

import java.sql.Connection;

public interface LoginSuccesfulManager {
    public boolean executeLoginQuery(Connection con,String username,String password);

}
