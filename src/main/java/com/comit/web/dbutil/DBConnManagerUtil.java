package com.comit.web.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnManagerUtil {
	
    private Connection connection;
    //private String dbUrl;
    //private String dbUser;
    //private String dbPWord;
    
    /*
    public DBConnManagerUtil(String dbUrl, String dbUser, String dbPWord) {
    	this.dbUrl = dbUrl;
    	this.dbUser = dbUser;
    	this.dbPWord = dbPWord;
    }
    */

    public Connection getConnection(String dbUrl, String dbUser, String dbPWord) {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Found JDBC Driver!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.err.println("Could not find JDBC Driver.");
            }

            try {
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPWord);
                System.out.println("Successfully connected to the DB!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Cannot connect to the DB.");
            }
        }

        return connection;
    }
}
