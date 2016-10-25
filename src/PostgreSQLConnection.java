import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLConnection {
    private static PostgreSQLConnection ourInstance = new PostgreSQLConnection();

    public static PostgreSQLConnection getInstance() {
        return ourInstance;
    }
    // declare variables
    private Connection connection;
    public Statement statement;
    private String jdbc, username, password;

    // constructor
    public PostgreSQLConnection() {
        connection = null;
        statement = null;
        jdbc = "jdbc:postgresql://localhost:5432/YOUR_DATABASENAME";
        username = "YOUR_USERNAME";
        password = "YOUR_PASSWORD";
    }
    // method to set statement
    public void setConnection() throws SQLException {
        connection = DriverManager.getConnection(jdbc, username, password);
        connection.setAutoCommit(false);
        statement = connection.createStatement();
    }
    // method to close connection
    public void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }
}

