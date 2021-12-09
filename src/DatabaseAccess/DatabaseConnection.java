package DatabaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;

    public static DatabaseConnection getInstance() {
        if (instance == null)
            instance = new DatabaseConnection();
        return instance;
    }

    private DatabaseConnection() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=food4u",
                "postgres", "maria5561");
    }
}
