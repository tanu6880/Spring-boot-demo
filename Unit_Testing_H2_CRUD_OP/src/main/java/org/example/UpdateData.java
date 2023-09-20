package org.example;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateData {

    public static void UpdateTData() throws SQLException, ClassNotFoundException {
        Connection conn = Build_Connection.connect();
        Scanner kb = new Scanner(System.in);
        Scanner k = new Scanner(System.in);
        System.out.println("Enter Table Name : ");
        String tname = kb.nextLine();
        System.out.println("Enter ID : ");
        int id = kb.nextInt();
        System.out.println("What do you want to update: ");
        System.out.println("1. id");
        System.out.println("2. first");
        System.out.println("3. last");
        System.out.println("4. age");
        System.out.println();
        System.out.println("Enter Choice : ");
        int i = kb.nextInt();

        PreparedStatement preparedStatement = null;
        switch(i)
        {
            case 1 -> {
                System.out.print("Enter id : ");
                int ide = k.nextInt();
                String sql = "UPDATE "+tname+" SET id=? where id = ?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1,ide);
            }
            case 2 -> {
                System.out.print("Enter first name : ");
                String first = k.nextLine();
                String sql = "UPDATE "+tname+" SET first=? where id = ?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,first);
            }
            case 3 -> {
                System.out.print("Enter last name : ");
                String last = k.nextLine();
                String sql = "UPDATE "+tname+" SET last=? where id = ?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,last);
            }
            case 4 -> {
                System.out.print("Enter age : ");
                int age = k.nextInt();
                String sql = "UPDATE "+tname+" SET age=? where id = ?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1,age);
            }
        }
        if (preparedStatement != null) {
            preparedStatement.setInt(2,id);
        }
        int result = 0;
        if (preparedStatement != null) {
            result = preparedStatement.executeUpdate();
        }
        System.out.print(result +" Row Affected");
        if(result!=0)
        {
            System.out.println(result+" row deleted");
        }
        else
        {
            System.out.println("Nothing deleted");
        }
        Build_Connection.close();
    }
    public static void makeprepared(String sql)
    {

    }
}
