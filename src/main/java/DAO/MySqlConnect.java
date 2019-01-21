package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public abstract class MySqlConnect {

    private String url = "jdbc:mysql://localhost/trainproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String user = "root";
    private String password = "root";
    protected Statement statement;
    protected Connection connection;

    public Statement getStatement() {
        return statement;
    }


    public Connection getConnection() {
        return connection;
    }


    public void connectDb() {
        try {
            System.out.println("Obtaining connection...");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);// Connection;
            statement = connection.createStatement();
            System.out.println("connected");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection Closed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
