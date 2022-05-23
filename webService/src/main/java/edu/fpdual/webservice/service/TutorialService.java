package edu.fpdual.webservice.service;

import edu.fpdual.webservice.mysql.connector.MySQLConnector;
import edu.fpdual.webservice.mysql.manager.ModelInfoManager;
import edu.fpdual.webservice.mysql.manager.imp.ModelInfoManagerImp;

import java.sql.SQLException;
import java.util.ArrayList;

public class TutorialService {
    private ModelInfoManager modelInfoManager;

    public TutorialService(ModelInfoManagerImp modelInfoManagerImp) {
        this.modelInfoManager = modelInfoManagerImp;
    }

    public ArrayList<String> returnModelMessage(){
        try {
            return modelInfoManager.changeTip(new MySQLConnector().getMySQLConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
