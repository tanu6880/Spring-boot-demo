package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int stop =0;

        do {
            System.out.println("1. Create Table");
            System.out.println("2. Insert Data");
            System.out.println("3. display Data");
            System.out.println("4. Delete Data");
            System.out.print("Enter What Do you want choose : ");
            Scanner kb = new Scanner(System.in);
            int choice = kb.nextInt();
            switch (choice) {
                case 1:
                    CreateTable.CreateTable();
                    break;

                case 2 :
                    InsertData.Insert_Data();
                    break;
                case 3:
                    FetchData.FetchTData();
                    break;
                case 4:
                    DeleteData.DeleteTData();
                    break;
                default:
                    System.out.println("Please Enter Valid Option");
            }
            System.out.println("Do U want to Continue --Enter 1 Otherwise Enter 0 : ");
            stop = kb.nextInt();
        }
        while (stop == 1);
    }
}