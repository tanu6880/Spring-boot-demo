package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {
    public static void DeleteTData() throws SQLException, ClassNotFoundException
    {
        Connection conn = Build_Connection.connect();
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter Table Name : ");
        String tname = kb.nextLine();
        System.out.println("Enter ID : ");
        int id = kb.nextInt();
        String sql = "Delete from "+tname+" where id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        int result = preparedStatement.executeUpdate();
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


}
