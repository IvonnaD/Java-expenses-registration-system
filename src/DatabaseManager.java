import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/ExpensesDB";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    //connecting to the database
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }

    //adding entry of expenses to the database
    public void addExpense(String date, double sum, String description) {
        String sql = "INSERT INTO expenses (expense_date, sum, description) VALUES (?, ?, ?)";
//values empty for now

// try-with-resources to automatically close the database connection and statement after they are used
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, date);
            stmt.setString(2, String.valueOf(sum));
            stmt.setString(3, description);


//to insert expense entry into the database
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Expense updated successfully!");
            } else System.out.println("Expense not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
