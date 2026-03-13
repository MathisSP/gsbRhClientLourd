package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {
    private static final String URL      = "jdbc:mysql://localhost:3306/gsbfrais-2025-ap";
    private static final String USER     = "myroot";   // ton user phpMyAdmin
    private static final String PASSWORD = "root123*";        // ton mot de passe phpMyAdmin

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}