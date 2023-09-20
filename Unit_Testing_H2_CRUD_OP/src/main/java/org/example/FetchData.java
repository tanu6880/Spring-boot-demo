package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FetchData {

    public static void FetchTData() throws SQLException, ClassNotFoundException {
        Connection conn = Build_Connection.connect();
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter Table Name : ");
        String tname = kb.nextLine();
        String sql = "Select * from "+ tname;
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        while(resultSet.next())
        {
            int id = resultSet.getInt("id");
            String first = resultSet.getNString(2);
            String last = resultSet.getNString(3);
            int age = resultSet.getInt("age");

            System.out.print(id + "\t" + first + "\t" + last + "\t" + age);
            System.out.println();
        }
        Build_Connection.close();
    }
}
