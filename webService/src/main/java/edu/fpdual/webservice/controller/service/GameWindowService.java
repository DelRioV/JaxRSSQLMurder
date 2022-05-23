package edu.fpdual.webservice.controller.service;

import edu.fpdual.webservice.controller.GameWindowController;
import edu.fpdual.webservice.mysql.connector.MySQLConnector;
import edu.fpdual.webservice.mysql.manager.QueryRecoverManager;
import edu.fpdual.webservice.mysql.manager.imp.QueryRecoverManagerImp;
import edu.fpdual.webservice.mysql.manager.imp.UserCodeManagerImp;

import java.util.ArrayList;
import java.util.List;

public class GameWindowService {
    private QueryRecoverManager queryRecoverManager;

    public GameWindowService(QueryRecoverManagerImp queryRecoverManagerImp) {
        this.queryRecoverManager = queryRecoverManagerImp;
    }

    public ArrayList<ArrayList<String>> queryRecover(String query, int user_code) {
        try {
            return new QueryRecoverManagerImp().executeQuery(new MySQLConnector().getMySQLConnection(), query, user_code);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int usercodeRecover(String username) {
        try {
            return new UserCodeManagerImp().getUsercode(new MySQLConnector().getMySQLConnection(), username);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
