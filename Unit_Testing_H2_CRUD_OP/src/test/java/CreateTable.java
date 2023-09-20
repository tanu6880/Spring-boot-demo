import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.Scanner;

public class CreateTable {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    Connection conn = null;
    Statement stmt = null;

    @BeforeTest
    public void connection() throws ClassNotFoundException, SQLException {
        // STEP 1: Register JDBC driver
        Class.forName(JDBC_DRIVER);

        // STEP 2: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Assert.assertNotNull(conn, "Not Connected");
    }

    @Test(description = "Create Table")
    public void createTable() throws SQLException {
        stmt = conn.createStatement();
        String sql = "CREATE TABLE std6 " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " +
                " last VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY ( id ))";
        int result = stmt.executeUpdate(sql);
        Assert.assertEquals(0, result);
        Assert.assertTrue(result == 0, "Table Created");
    }

    @Test(description = "Insert data into Students", dependsOnMethods = "createTable")
    public void insertDataIntoStudents() throws SQLException {
        Scanner kb = new Scanner(System.in);
        String first;
        String last;
        int age;
        /*System.out.print("Enter First Name : ");
        first = kb.nextLine();
        System.out.print("Enter Last Name : ");
        last = kb.nextLine();
        System.out.print("Enter Age : ");
        age = kb.nextInt();*/

        String sql = "INSERT INTO std6 (id, first, last, age) VALUES (1, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, "Tanu");
        preparedStatement.setString(2, "Saini");
        preparedStatement.setInt(3,21);
        int result = preparedStatement.executeUpdate();
        System.out.println(result + " row(s) affected.");
        Assert.assertTrue(result==0,"Quires Wrong Test Failed");
    }



    @AfterTest
    public void close() throws SQLException {
        stmt.close();
        conn.close();
        System.out.println("Connection close ");
    }
}
