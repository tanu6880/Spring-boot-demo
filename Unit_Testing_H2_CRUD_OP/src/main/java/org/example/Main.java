package org.example;
import org.h2.jdbc.JdbcSQLSyntaxErrorException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.DeleteData.DeleteTData;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args)  {
        int stop;

        do {
            System.out.println("1. Create Table");
            System.out.println("2. Insert Data");
            System.out.println("3. display Data");
            System.out.println("4. Delete Data");
            System.out.println("5. Update Data");
            System.out.print("Enter What Do you want choose : ");
            Scanner kb = new Scanner(System.in);
            int choice = kb.nextInt();
            switch (choice) {
                case 1 -> {
                    try {
                        CreateTable.CreateTable();
                    } catch (SQLException E) {
                        System.out.println("Table already Exits");
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 2 -> {
                    try {
                        InsertData.Insert_Data();
                    } catch (InputMismatchException e) {
                        System.out.println("Enter valid number format");
                    } catch (JdbcSQLSyntaxErrorException E) {
                        System.out.println("SQL Syntax Error may be table not found");
                    } catch (SQLException E) {
                        System.out.println("Sql error");
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 3 -> {
                    try {
                        FetchData.FetchTData();
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 4 -> {
                    try {
                        DeleteData.DeleteTData();
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 5 ->
                {
                    try {
                        UpdateData.UpdateTData();
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> System.out.println("Please Enter Valid Option");
            }
            System.out.println("Do U want to Continue --Enter 1 Otherwise Enter 0 : ");
            stop = kb.nextInt();
        }
        while (stop == 1);
    }
}