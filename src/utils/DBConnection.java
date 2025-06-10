package utils;

import  java.sql.*;
public class DBConnection {
    private static final  String url = "jdbc:mysql://localhost:3306/dummyEcommerce",
                        password = "bala1618", userName = "root";
    public static Connection getConnection() throws Exception{
        // returns connection type
        return DriverManager.getConnection(url, userName, password);
    }

}
