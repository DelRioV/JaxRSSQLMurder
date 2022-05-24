package edu.fpdual.webservice.mysql.manager.imp;

import edu.fpdual.webservice.mysql.manager.InsertHistoryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertHistoryManagerImp implements InsertHistoryManager {



    private static final String HISTORYQUERY="Insert into History select distinct History_Id,?,Characters_id,Rooms_id" +
            "from History_admin";
    private static final String CHARACTERSQUERY="Insert into Characters select distinct ?,Character_id,Name,Features," +
            "Personality,Version_Of_History from Characters_admin";

    private static final String ROOMSQUERY="insert into Rooms" +
            "select distinct ?,RoomId,RoomName,RoomLocation,Description" +
            "from Rooms_admin";

    private static final String MAINHISTORYSQUERY="Insert into Main_History select distict History_id,Description,? from" +
            "Main_History_Admin";

    @Override
    public boolean insertValues(Connection con, int user_code) throws SQLException {
        boolean kk = false;
        try {
            roomsQueryInsert(con, user_code);
            charactersQueryInsert(con, user_code);
            mainHistoryQueryInsert(con, user_code);
            historyQueryInsert(con, user_code);
            kk = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return kk;
    }

    public void roomsQueryInsert(Connection con, int user_code) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement(ROOMSQUERY);
        preparedStatement.setInt(1,user_code);
        preparedStatement.executeUpdate();
    }

    public void historyQueryInsert(Connection con, int user_code) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement(HISTORYQUERY);
        preparedStatement.setInt(1,user_code);
        preparedStatement.executeUpdate();
    }

    public void mainHistoryQueryInsert(Connection con, int user_code) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement(MAINHISTORYSQUERY);
        preparedStatement.setInt(1,user_code);
        preparedStatement.executeUpdate();
    }

    public void charactersQueryInsert(Connection con, int user_code) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement(CHARACTERSQUERY);
        preparedStatement.setInt(1,user_code);
        preparedStatement.executeUpdate();
    }




}
