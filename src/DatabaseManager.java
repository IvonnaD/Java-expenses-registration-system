import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/ExpensesDB";
    private static final String USER = "root";
    private static final String PASSWORD = "";

//connecting to the databse
    public Connection connect() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }
//adding entry of expenses to the database
    public void addExpense(String date, double sum, String description) {
        String sql = "INSERT INTO expsenses (expense_date, sum, description) VALUES (?, ?, ?)";
//values empty for now

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, date);
            stmt.setString(2, sum);
            stmt.setString(3, description);
//to insert expense entry into the database
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
//to catch in case error happens
        }
    }
}