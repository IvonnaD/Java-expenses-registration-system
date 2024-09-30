import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseManager<ActionEvent> {
    private JTextField dateField;
    private JTextField sumField;
    private JTextField descriptionField;
    private DatabaseManager dbManager;

    private void initUI() {
        JFrame frame = new JFrame("Expense Registration");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // to set up the Graphical user interface
    public ExpenseManager() {
        // creating a window (Jframe)
        JFrame frame = new JFrame ("Expense Registration");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
