package edu.fpdual.webservice.mysql.manager.imp;

import edu.fpdual.webservice.mysql.manager.UserCodeManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserCodeManagerImp implements UserCodeManager {
    @Override
    public int getUsercode(Connection con, String username) {
        int id = 0;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT cod_user from user where username=?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (Exception e){
            e.printStackTrace();

        } finally {
            return id;
        }

    }
}
