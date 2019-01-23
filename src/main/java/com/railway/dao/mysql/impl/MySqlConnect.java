package com.railway.dao.mysql.impl;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public  abstract class MySqlConnect {
    private String url = "jdbc:mysql://localhost/trainproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String user = "root";
    private String password = "root";
    private Statement st;
    private Connection myConn;
    final static Logger logger = Logger.getLogger(MySqlConnect.class);
    public void connectDb() throws DataAccessException {
        try {
            logger.info("Obtaining connection");
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, user, password);
            st = myConn.createStatement();
            logger.info("Connected to database");
        } catch (Exception ex) {
            throw new DataAccessException(3);
        }
    }

    public void closeConnection() throws DataAccessException{
        try {
            myConn.close();
            logger.info("Connection to database is closed");
        } catch (Exception ex) {
            throw new DataAccessException(3);
        }
    }
    public Connection getConnection(){
        return myConn;
    }

}
