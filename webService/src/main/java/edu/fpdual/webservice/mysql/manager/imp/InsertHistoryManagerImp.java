package edu.fpdual.webservice.mysql.manager.imp;

import edu.fpdual.webservice.mysql.manager.InsertHistoryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Class that uses InsertHistoryManager interface
 */
public class InsertHistoryManagerImp implements InsertHistoryManager {


    private static final String CHARACTERSQUERY = "Insert into Characters select distinct Character_id,Name,features," +
            "Personality,? from Characters_admin";

    private static final String ROOMSQUERY = "insert into Rooms" +
            "select distinct 1,RoomId,RoomName,RoomLocation,Description" +
            "from Rooms_admin";

    private static final String HOURSSQUERY = "Insert into Hours select distinct character_id,Hours,Register,? from Hours_admin";

    @Override
    public boolean insertValues(Connection con, int user_code) throws SQLException {
        boolean kk = false;
        try {
            roomsQueryInsert(con, user_code);
            charactersQueryInsert(con, user_code);
            hoursQueryInsert(con, user_code);
            kk = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kk;
    }

    public void roomsQueryInsert(Connection con, int user_code) throws SQLException {
        Statement statement = con.createStatement();
        String query = "insert into Rooms select distinct RoomId,RoomName,RoomLocation,Description," + user_code + " from Rooms_admin;";
        statement.executeUpdate(query);
    }


    public void hoursQueryInsert(Connection con, int user_code) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement(HOURSSQUERY);
        preparedStatement.setInt(1, user_code);
        preparedStatement.executeUpdate();
    }

    public void charactersQueryInsert(Connection con, int user_code) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement(CHARACTERSQUERY);
        preparedStatement.setInt(1, user_code);
        preparedStatement.executeUpdate();
    }


}
