package edu.fpdual.webservice.mysql.manager;

import java.sql.Connection;
import java.util.ArrayList;

public interface QueryRecoverManager {

    public ArrayList<ArrayList<String>> executeQuery(Connection connection, String query, int user_code);



    }
