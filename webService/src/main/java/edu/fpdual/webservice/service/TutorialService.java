package edu.fpdual.webservice.service;

import edu.fpdual.webservice.mysql.connector.MySQLConnector;
import edu.fpdual.webservice.mysql.manager.ModelInfoManager;
import edu.fpdual.webservice.mysql.manager.imp.ModelInfoManagerImp;

import java.util.ArrayList;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Class that connects Controller with Service classes
 */
public class TutorialService {
    private ModelInfoManager modelInfoManager;

    /**
     * Constructor that substitute one variable
     *
     * @param modelInfoManagerImp ModelInfoManagerImp
     */
    public TutorialService(ModelInfoManagerImp modelInfoManagerImp) {
        this.modelInfoManager = modelInfoManagerImp;
    }

    /**
     * Method that connects with ModelInfoManagerImp.class
     *
     * @return Arraylist with the model information
     */
    public ArrayList<String> returnModelMessage() {
        try {
            return modelInfoManager.changeTip(new MySQLConnector().getMySQLConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
