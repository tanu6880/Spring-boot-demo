import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.AlgorithmConstraints;
import java.sql.*;

public class DeleteData {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    static Connection conn = null;
    static Statement stmt = null;

    @BeforeTest
    public void connection() throws ClassNotFoundException, SQLException {
        // STEP 1: Register JDBC driver
        Class.forName(JDBC_DRIVER);

        // STEP 2: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Assert.assertNotNull(conn, "Not Connected");
    }

    @Test(description = "Table Exits")
    public void exits() throws SQLException {
        String sql = "Select * from std6";
        stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        int t = 0;
        while (resultSet.next())
        {
            t=1;
            break;
        }
        Assert.assertEquals(1,t);
    }

    @Test(description = "Delete Table Data",dependsOnMethods = "exits")
    public static void deleteData() throws SQLException {
        String sql = "Delete from std6 where id = 1";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        int result = preparedStatement.executeUpdate();
        System.out.print(result +" Row Affected");
        Assert.assertEquals(1,result);


    }





    @AfterTest
    public void close() throws SQLException {
        stmt.close();
        conn.close();
        System.out.println("Connection close ");
    }
}

