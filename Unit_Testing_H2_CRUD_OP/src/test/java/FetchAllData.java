import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class FetchAllData {

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

    @Test(description = "Display All Data From Table")
    public void DisplayData() throws SQLException {
        String sql = "Select * from std6";
        stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        boolean datafound = false;
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String first = resultSet.getNString(2);
            String last = resultSet.getNString(3);
            int age = resultSet.getInt("age");

            System.out.print(id + "\t" + first + "\t" + last + "\t" + age);
            System.out.println();
            datafound = true;
        }
        Assert.assertTrue(datafound,"data not found in table");
    }


    @AfterTest
    public void close() throws SQLException {
        stmt.close();
        conn.close();
        System.out.println("Connection close ");
    }
}
