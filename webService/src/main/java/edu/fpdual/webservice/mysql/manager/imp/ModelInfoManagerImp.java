package edu.fpdual.webservice.mysql.manager.imp;

import edu.fpdual.webservice.mysql.manager.ModelInfoManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelInfoManagerImp implements ModelInfoManager {


    @Override
    public ArrayList<String> changeTip(Connection con) throws SQLException {
        try {
            PreparedStatement psmt = con.prepareStatement("Select tutorialInfo from model");
            ResultSet resultSet = psmt.executeQuery();
            ArrayList<String> infoRecover = new ArrayList<>();
            while(resultSet.next()) {
                infoRecover.add(resultSet.getString(1));
            }
                return infoRecover;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
