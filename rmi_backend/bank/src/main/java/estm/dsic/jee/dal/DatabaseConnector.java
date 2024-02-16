package estm.dsic.jee.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_bank";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    private static Connection connection;

    private DatabaseConnector() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            // Create a new connection if it doesn't exist or is closed
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("new Connection to database 🎁:" + connection);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}