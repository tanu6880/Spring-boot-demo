package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {

    public static void Insert_Data() throws SQLException, ClassNotFoundException {
        Connection conn = Build_Connection.connect();
        System.out.print("Enter Table Name : ");
        Scanner k = new Scanner(System.in);
        String tname = k.nextLine();
        Statement stmt = conn.createStatement();
        Scanner kb = new Scanner(System.in);
        String first;
        String last;
        int age;
        System.out.print("Enter id : ");
        int id  = kb.nextInt();
        System.out.print("Enter First Name : ");
        first = k.nextLine();
        System.out.print("Enter Last Name : ");
        last = k.nextLine();
        System.out.print("Enter Age : ");
        age = kb.nextInt();
        String sql = "Insert Into " +
                tname +
                " values ( ?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,first);
        preparedStatement.setString(3,last);
        preparedStatement.setInt(4,age);
        int result = preparedStatement.executeUpdate();
        if(result==1)
        {
            System.out.println("Data Inserted ");
        }
        else
        {
            System.out.println("Already Exits");
        }
        Build_Connection.close();
    }
}
