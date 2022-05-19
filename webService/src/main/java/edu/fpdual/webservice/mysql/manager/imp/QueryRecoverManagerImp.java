package edu.fpdual.webservice.mysql.manager.imp;

import org.login.app.model.mysql.manager.QueryRecoverManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryRecoverManagerImp implements QueryRecoverManager {

    @Override
    public  ArrayList<ArrayList<String>> executeQuery(Connection connection, String query) {
        ArrayList<ArrayList<String>> recoverQuery = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query+";");
            while (rs.next()){
                int index = 1;
                ArrayList<String> addInfo = new ArrayList<>();
                try{
                    while(true) {
                        addInfo.add(rs.getString(index));
                        index++;
                    }
                } catch (Exception e){
                    recoverQuery.add(addInfo);
                }
            }
            return recoverQuery;
        } catch (SQLException e) {
            System.out.println("Something introduced isn't correct");
            return null;
        }
    }

    private void countIndex(ResultSet rs, int index) {

    }
}
