package edu.fpdual.webservice.mysql.manager.imp;

import edu.fpdual.webservice.mysql.manager.QueryRecoverManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Class that use QueryRecoverManager interface
 */
public class QueryRecoverManagerImp implements QueryRecoverManager {

    private static final String[] WORDS = {"insert", "update", "drop", ";", "user", "user_code", "solution", "delete", "admin"};

    @Override
    public ArrayList<ArrayList<String>> executeQuery(Connection connection, String query, int user_code) {
        ArrayList<ArrayList<String>> recoverQuery = new ArrayList<>();
        String lowerQuery = query.toLowerCase();
        if (!confirmQuery(lowerQuery)) {
            try {
                if (!query.contains("Table_name")) {
                    query = convertQuery(query, user_code);
                }
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query + ";");
                while (rs.next()) {
                    int index = 1;
                    ArrayList<String> addInfo = new ArrayList<>();
                    try {
                        while (true) {
                            if (!rs.getString(index).equals(String.valueOf(user_code))) {
                                addInfo.add(rs.getString(index));
                            }
                            index++;
                        }
                    } catch (Exception e) {
                        recoverQuery.add(addInfo);
                    }
                }
                return recoverQuery;
            } catch (SQLException e) {
                System.out.println("Something introduced isn't correct");
                return null;
            }
        } else {
            return null;
        }
    }

    private boolean confirmQuery(String query) {
        boolean condition = false;
        for (int i = 0; i < WORDS.length; i++) {
            if (query.contains(WORDS[i])) {
                condition = true;
                break;
            }
        }
        return condition;
    }

    private int getWhereCounter(String query) {
        String comparableWord = "where";
        int counter = 0;
        if (query.contains(comparableWord)) {
            for (int i = 0; i < query.length(); i++) {
                if (query.charAt(i) == comparableWord.charAt(0)) {
                    String compareQuery = "";
                    for (int x = 0; x < comparableWord.length(); x++) {
                        compareQuery += query.charAt(i++);
                    }
                    if (compareQuery.equalsIgnoreCase(comparableWord)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public String convertQuery(String query, int user_code) {
        int counter = getWhereCounter(query);
        String updatedQuery = "";
        while (counter != -1) {
            if (counter == 0) {
                if (query.contains("(")) {
                    updatedQuery += query + " where user_code = " + user_code + ")";
                } else {
                    updatedQuery += query + " where user_code = " + user_code;
                }
                counter = -1;
            } else if (counter == 1) {

                if (query.contains("(")) {
                    String query2 = query.substring(query.indexOf("("), query.indexOf(")"));
                    updatedQuery += query.substring(0, query.indexOf("where")) + "where user_code = " + user_code + " and" +
                            query.substring(query.indexOf("where") + "where".length(), query.indexOf("(")) + query2 +
                            " where user_code = " + user_code + ")";
                } else if (query.contains(")")) {
                    System.out.println("Soy )");
                    updatedQuery += "" + query.substring(0, query.length() - 1) + " and user_code = " + user_code + ")";
                } else {
                    updatedQuery += query + " and user_code = " + user_code;
                }
                counter = -1;
            } else {
                String compareWord = "where";
                for (int i = 0; i < query.length(); i++) {
                    String kk = "";
                    if (i + 4 < query.length() && compareWord.equals("where")) {
                        for (int y = 0; y < 5; y++) {
                            kk += Character.toString(query.charAt(i + y));
                        }
                        if (kk.equals(compareWord)) {
                            i = i + 5;
                            updatedQuery += " where user_code = " + user_code + " and ";
                        } else {
                            updatedQuery += query.charAt(i);
                        }
                    }
                    String aux = Character.toString(query.charAt(i));
                    if (aux.equals("(")) {
                        System.out.println("Entro");
                        counter = getWhereCounter(query.substring(query.indexOf("(")));
                        query = query.substring(query.indexOf("(") + 1);
                        System.out.println(query);
                        System.out.println(counter);
                        break;
                    }

                }
            }
        }
        return updatedQuery;
    }
}


