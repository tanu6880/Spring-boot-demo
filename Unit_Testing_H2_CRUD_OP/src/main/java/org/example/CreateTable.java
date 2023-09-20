package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTable {

    public static void CreateTable() throws SQLException, ClassNotFoundException {
        Connection conn = Build_Connection.connect();
        System.out.print("Enter Table Name : ");
        Scanner k = new Scanner(System.in);
        String tname = k.nextLine();
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE  " +
                 tname +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " +
                " last VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY ( id ))";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        int result = preparedStatement.executeUpdate();
        if(result==0)
        {
            System.out.println("Table Created");
        }
        else
        {
            System.out.println("Already Exits");
        }
        Build_Connection.close();
    }
}
