package com.example.timescheduler.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection databaseLink;

    /**
     * Connection for Database
     */
    public Connection getConnection() throws Exception {
        String databaseName = "timeemef";
        String databaseUser = "timeemef";
        String databasePassword = "12345678";
        String url = "jdbc:mysql://db4free.net:3306/timeemef?serverTimezone=UTC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser, databasePassword);
        }catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}
