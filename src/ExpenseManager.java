import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseManager {
    private JTextField dateField;
    private JTextField sumField;
    private JTextField descriptionField;
    private DatabaseManager dbManager;

    // Constructor to set up the Graphical User Interface
    public ExpenseManager() {
        initUI();  // Initialize the GUI in the constructor
        dbManager = new DatabaseManager();  // Initialize the database manager
    }

    // Method to initialize the GUI
    private void initUI() {
        JFrame frame = new JFrame("Expense Registration");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating a panel to hold the components
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true); // Showing the window
    }

    // Method to set up the user interface components
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Date label and text field
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(10, 20, 80, 25);
        panel.add(dateLabel);

        dateField = new JTextField(20);
        dateField.setBounds(100, 20, 165, 25);
        panel.add(dateField);

        // Sum label and text field
        JLabel sumLabel = new JLabel("Sum:");
        sumLabel.setBounds(10, 50, 80, 25);
        panel.add(sumLabel);

        sumField = new JTextField(20);
        sumField.setBounds(100, 50, 165, 25);
        panel.add(sumField);

        // Description label and text field
        JLabel descLabel = new JLabel("Description:");
        descLabel.setBounds(10, 80, 80, 25);
        panel.add(descLabel);

        descriptionField = new JTextField(20);
        descriptionField.setBounds(100, 80, 165, 25);
        panel.add(descriptionField);

        // Button to add expense
        JButton addButton = new JButton("Add Expense");
        addButton.setBounds(10, 110, 150, 25);
        panel.add(addButton);

        // ActionListener to handle button click
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle input and validate
                String date = dateField.getText();
                String description = descriptionField.getText();
                double sum;

                // Validate sum input
                try {
                    sum = Double.parseDouble(sumField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for the sum.");
                    return;
                }

                // Add the expense to the database
                dbManager.addExpense(date, sum, description);
                JOptionPane.showMessageDialog(null, "Expense added successfully!");

                // Clear fields after adding the expense
                dateField.setText("");
                sumField.setText("");
                descriptionField.setText("");
            }
        });
    }

    // Main method to run the application
    public static void main(String[] args) {
        new ExpenseManager(); // Create and show the app
    }
}
