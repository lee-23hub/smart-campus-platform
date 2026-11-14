
package com.scasp.core.database;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    public static void main(String[] args) {

        try (Connection connection =
                DatabaseConnection.getConnection()) {

            System.out.println("Database connection successful!");
            System.out.println("Connected to Smart Campus Database.");

        } catch (SQLException e) {

            System.out.println("Database connection failed!");
            System.out.println(e.getMessage());
        }
    }
}
