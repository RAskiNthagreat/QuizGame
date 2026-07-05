package main;

import java.sql.Connection;
import database.DatabaseConnection;

public class Main {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("       JAVA QUIZ GAME");
        System.out.println("=================================");

        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {
            System.out.println("Connection test successful!");
            DatabaseConnection.closeConnection(connection);
        } else {
            System.out.println("Connection test failed.");
        }
    }
}