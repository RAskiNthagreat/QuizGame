package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/quiz_game";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // Method to establish and return a database connection
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("✓ Connected to MySQL successfully.");
        } catch (SQLException e) {
            System.out.println("✗ Database connection failed.");
            System.out.println("Error: " + e.getMessage());
        }

        return connection;
    }

    // Method to safely close the connection
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}