package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Build_Connection {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    private static final String USER = "sa";
    private static final String PASS = "";

    static Connection con = null;

    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        System.out.println("Connecting to database...");
        con = DriverManager.getConnection(DB_URL,USER,PASS);
        return con;
    }
    public static void close() throws SQLException {
        con.close();
    }



}
