import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/ExpensesDB";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    //connecting to the databse
    public Connection connect() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }
}