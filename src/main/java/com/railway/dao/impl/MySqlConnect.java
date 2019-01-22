package com.railway.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Logger;

public  abstract class MySqlConnect {
    private String url = "jdbc:mysql://localhost/trainproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String user = "root";
    private String password = "root";
    private Statement st;
    private Connection myConn;
    public void connectDb() throws DataAccessException {
        try {
            System.out.println("Obtaining connection...");
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, user, password);
            st = myConn.createStatement();
            System.out.println("connected");
        } catch (Exception ex) {
            throw new DataAccessException(3);
        }
    }

    public void closeConnection() throws DataAccessException{
        try {
            myConn.close();
            System.out.println("Connection Closed");
        } catch (Exception ex) {
            throw new DataAccessException(3);
        }
    }
    public Connection getConnection(){
        return myConn;
    }

}
