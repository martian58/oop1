import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI application to demonstrate string manipulation using different filters.
 */
public class StringManipulationGUI {

    // Create frame for the GUI
    private JFrame frame;
    private JTextField inputField;
    private JLabel resultLabel;

    public static void main(String[] args) {
        // Launch the GUI
        EventQueue.invokeLater(() -> {
            try {
                StringManipulationGUI window = new StringManipulationGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public StringManipulationGUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("String Manipulation GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Make it responsive to screen size
        frame.getContentPane().setLayout(new BorderLayout());

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(240, 248, 255)); // Light blue background
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.setOpaque(false); // Transparent to match background
        JLabel inputLabel = new JLabel("Enter a string:");
        inputLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        inputField = new JTextField(20);
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        mainPanel.add(inputPanel);

        // Result Panel
        JPanel resultPanel = new JPanel();
        resultPanel.setOpaque(false); // Transparent
        resultLabel = new JLabel("Transformed string will appear here");
        resultLabel.setFont(new Font("SansSerif", Font.ITALIC, 18));
        resultLabel.setForeground(new Color(70, 130, 180)); // Steel blue color
        resultPanel.add(resultLabel);
        mainPanel.add(resultPanel);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // Two columns with spacing
        buttonPanel.setOpaque(false); // Transparent
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // Add space at the top

        // Add action buttons for each transformation
        JButton upperCaseButton = createFilterButton("Uppercase", new UpperCaseStringFilter());
        JButton lowerCaseButton = createFilterButton("Lowercase", new LowerCaseStringFilter());
        JButton prefixButton = createFilterButton("Prefix (first 3)", new PrefixStringFilter(3));
        JButton suffixButton = createFilterButton("Suffix (last 3)", new SuffixStringFilter(3));
        StringFilter[] filters = { new LowerCaseStringFilter(), new SuffixStringFilter(3) };
        JButton compositeButton = createFilterButton("Composite (Lower + Suffix)", new CompositeStringFilter(filters));

        // Add buttons to the button panel
        buttonPanel.add(upperCaseButton);
        buttonPanel.add(lowerCaseButton);
        buttonPanel.add(prefixButton);
        buttonPanel.add(suffixButton);
        buttonPanel.add(compositeButton);

        mainPanel.add(buttonPanel);

        // Set the frame to center and visible
        frame.setLocationRelativeTo(null);
    }

    /**
     * Helper method to create a button with consistent styling that applies a given filter to the input string.
     * @param label Text for the button.
     * @param filter The filter to apply.
     * @return The JButton component.
     */
    private JButton createFilterButton(String label, StringFilter filter) {
        JButton button = new JButton(label);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(70, 130, 180)); // Steel blue color
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false); // Remove focus border
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText(); // Get the user input
                String transformedText = filter.filter(inputText); // Apply the filter
                resultLabel.setText("Result: " + transformedText); // Display the result
            }
        });
        return button;
    }
}