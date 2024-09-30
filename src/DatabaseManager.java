import Expenses.Expense;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
            stmt.enquoteIdentifier()(4, id);


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
    // Reading all expenses from the database
    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("expense_date");
                double sum = rs.getDouble("sum");
                String description = rs.getString("description");
                expenses.add(new Expense(id, date, sum, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    // Updating an existing expense
    public void updateExpense(int id, String date, double sum, String description) {
        String sql = "UPDATE expenses SET expense_date = ?, sum = ?, description = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, date);
            stmt.setDouble(2, sum);
            stmt.setString(3, description);
            stmt.setInt(4, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Expense updated successfully!");
            } else {
                System.out.println("Expense not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deleting an expense
    public void deleteExpense(int id) {
        String sql = "DELETE FROM expenses WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Expense deleted successfully!");
            } else {
                System.out.println("Expense not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
