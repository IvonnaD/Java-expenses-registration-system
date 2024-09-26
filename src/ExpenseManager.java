import javax.swing.*;

public class ExpenseManager {
    private JTextField dateField;
    private JTextField sumField;
    private JTextField descriptionField;
    private DatabaseManager dbManager;

    // to set up the Graphical user interface
    public ExpenseManager() {
        // creating a window (Jframe)
        JFrame frame = new JFrame ("Expense Registration");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creating panel to hold the components
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        // set up the UI components

    }







}
