package BDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {
    private static final String URL      = "jdbc:mysql://localhost:3306/gsbfrais-2025-ap?useSSL=false";
    private static final String USER     = "myroot";
    private static final String PASSWORD = "root123*";
    
    private static Connection instance = null;

    // Constructeur privé = personne ne peut faire "new ConnexionDB()"
    private ConnexionDB() {}

    // Retourne toujours la même connexion
    public static Connection getConnection() {
        try {
            if (instance == null || instance.isClosed()) {
                instance = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur de connexion à la base de données");
        }
        return instance;
    }

    // Fermeture de la connexion
    public static void close() {
        try {
            if (instance != null && !instance.isClosed()) {
                instance.close();
                instance = null;
                System.out.println("Connexion fermée");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la fermeture");
        }
    }
}
