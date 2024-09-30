import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/ExpensesDB";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Connecting to the database
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Adding entry of expenses to the database
    public void addExpense(String date, double sum, String description) {
        String sql = "INSERT INTO expenses (expense_date, sum, description) VALUES (?, ?, ?)";

    // Try-with-resources to automatically close the database connection and statement
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) { // PreparedStatement to prevent SQL injection
            stmt.setString(1, date);
            stmt.setDouble(2, sum);  // Using setDouble for sum
            stmt.setString(3, description);

    // Inserting expense data entry into the database
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Information added successfully!");
            } else {
                System.out.println("Failed to add the information.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
