import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeometryApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private GeometryFrame geometryFrame;
    private StackPanel stackPanel; // Add the StackPanel here

    public GeometryApp() {
        setTitle("Advanced Geometry App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Navigation menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Navigation");

        JMenuItem homeItem = new JMenuItem("Home");
        JMenuItem drawItem = new JMenuItem("Draw");
        JMenuItem stackItem = new JMenuItem("Stack Operations"); // Add Stack navigation item
        JMenuItem settingsItem = new JMenuItem("Settings");

        homeItem.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        drawItem.addActionListener(e -> cardLayout.show(mainPanel, "Draw"));
        stackItem.addActionListener(e -> cardLayout.show(mainPanel, "Stack")); // Stack navigation action
        settingsItem.addActionListener(e -> cardLayout.show(mainPanel, "Settings"));

        menu.add(homeItem);
        menu.add(drawItem);
        menu.add(stackItem); // Add Stack menu item
        menu.add(settingsItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Panels for each page
        JPanel homePanel = new HomePanel();

        JPanel settingsPanel = new JPanel();
        settingsPanel.add(new JLabel("Settings Panel"));

        geometryFrame = new GeometryFrame();
        stackPanel = new StackPanel(); // Initialize the StackPanel

        mainPanel.add(homePanel, "Home");
        mainPanel.add(geometryFrame.getMainPanel(), "Draw");
        mainPanel.add(stackPanel, "Stack"); // Add StackPanel to the main panel
        mainPanel.add(settingsPanel, "Settings");

        add(mainPanel);
        cardLayout.show(mainPanel, "Home");
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GeometryApp::new);
    }
}


class GeometryFrame {
    private GeometryPanel geometryPanel;
    private JPanel mainPanel;
    private JTextField xField, yField, dxField, dyField;
    private JComboBox<String> pointA, pointB;
    private JTextArea infoArea;

    public GeometryFrame() {
        geometryPanel = new GeometryPanel();

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 8, 8));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Geometry Controls"));

        xField = new JTextField();
        yField = new JTextField();
        dxField = new JTextField();
        dyField = new JTextField();
        pointA = new JComboBox<>();
        pointB = new JComboBox<>();

        JButton addPointButton = new JButton("➕ Add Point");
        JButton addSegmentButton = new JButton("📏 Add Segment");
        JButton clearButton = new JButton("🧹 Clear All");
        JButton translateButton = new JButton("↔️ Translate Point");
        JButton distanceButton = new JButton("📐 Distance Between Points");
        JButton lengthButton = new JButton("📏 Segment Length");

        addPointButton.addActionListener(e -> {
            try {
                float x = Float.parseFloat(xField.getText());
                float y = Float.parseFloat(yField.getText());
                geometryPanel.addPoint(new Point(x, y));
                String name = geometryPanel.getPointName(geometryPanel.getPoints().size() - 1);
                pointA.addItem(name);
                pointB.addItem(name);
                xField.setText("");
                yField.setText("");
                infoArea.append("✅ Point added at (" + x + ", " + y + ")\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "❗ Please enter valid numbers for X and Y.");
            }
        });

        addSegmentButton.addActionListener(e -> {
            int i = pointA.getSelectedIndex();
            int j = pointB.getSelectedIndex();
            if (i != j && i >= 0 && j >= 0) {
                geometryPanel.addSegment(i, j);
                infoArea.append("📏 Segment added between P" + i + " and P" + j + "\n");
            }
        });

        clearButton.addActionListener(e -> {
            geometryPanel.clear();
            pointA.removeAllItems();
            pointB.removeAllItems();           
            infoArea.setText("🧹 All cleared.\n");
        });

        translateButton.addActionListener(e -> {
            try {
                int i = pointA.getSelectedIndex();
                float dx = Float.parseFloat(dxField.getText());
                float dy = Float.parseFloat(dyField.getText());
                geometryPanel.getPoints().get(i).translate(dx, dy);
                geometryPanel.repaint();
                infoArea.append("↔️ Point P" + i + " translated by (" + dx + ", " + dy + ")\n");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "❗ Please select a valid point and enter valid translation values.");
            }
        });

        distanceButton.addActionListener(e -> {
            int i = pointA.getSelectedIndex();
            int j = pointB.getSelectedIndex();
            if (i >= 0 && j >= 0 && i != j) {
                float dist = geometryPanel.getPoints().get(i).distance(geometryPanel.getPoints().get(j));
                infoArea.append("📐 Distance between P" + i + " and P" + j + " = " + dist + "\n");
            }
        });

        lengthButton.addActionListener(e -> {
            int i = pointA.getSelectedIndex();
            int j = pointB.getSelectedIndex();
            if (i >= 0 && j >= 0 && i != j) {
                Segment seg = new Segment(geometryPanel.getPoints().get(i), geometryPanel.getPoints().get(j));
                infoArea.append("📏 Length of segment P" + i + "-P" + j + " = " + seg.length() + "\n");
            }
        });

        inputPanel.add(new JLabel("X:"));
        inputPanel.add(xField);
        inputPanel.add(new JLabel("Y:"));
        inputPanel.add(yField);
        inputPanel.add(addPointButton);
        inputPanel.add(clearButton);

        inputPanel.add(new JLabel("Point A:"));
        inputPanel.add(pointA);
        inputPanel.add(new JLabel("Point B:"));
        inputPanel.add(pointB);
        inputPanel.add(addSegmentButton);
        inputPanel.add(distanceButton);

        inputPanel.add(new JLabel("Translate dx:"));
        inputPanel.add(dxField);
        inputPanel.add(new JLabel("Translate dy:"));
        inputPanel.add(dyField);
        inputPanel.add(translateButton);
        inputPanel.add(lengthButton);

        infoArea = new JTextArea(6, 30);
        infoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(infoArea);

        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(geometryPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}

class GeometryPanel extends JPanel {
    private ArrayList<Point> points = new ArrayList<>();
    private ArrayList<Segment> segments = new ArrayList<>();

    public GeometryPanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);
    }

    public void addPoint(Point p) {
        points.add(p);
        repaint();
    }

    public void addSegment(int i, int j) {
        segments.add(new Segment(points.get(i), points.get(j)));
        repaint();
    }

    public void clear() {
        points.clear();
        segments.clear();
        repaint();
    }

    public java.util.List<Point> getPoints() {
        return points;
    }

    public String getPointName(int i) {
        Point p = points.get(i);
        return "P" + i + " (" + p.getX() + "," + p.getY() + ")";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int scale = 30;
        int midX = getWidth() / 2;
        int midY = getHeight() / 2;

        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < getWidth(); i += scale) g.drawLine(i, 0, i, getHeight());
        for (int i = 0; i < getHeight(); i += scale) g.drawLine(0, i, getWidth(), i);

        g.setColor(Color.BLACK);
        g.drawLine(midX, 0, midX, getHeight());
        g.drawLine(0, midY, getWidth(), midY);

        g.setColor(Color.RED);
        for (Segment s : segments) {
            int x1 = (int) (midX + s.getP1().getX() * scale);
            int y1 = (int) (midY - s.getP1().getY() * scale);
            int x2 = (int) (midX + s.getP2().getX() * scale);
            int y2 = (int) (midY - s.getP2().getY() * scale);
            g.drawLine(x1, y1, x2, y2);
        }

        g.setColor(Color.BLUE);
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            int x = (int) (midX + p.getX() * scale);
            int y = (int) (midY - p.getY() * scale);
            g.fillOval(x - 5, y - 5, 10, 10);
            g.drawString("P" + i, x + 6, y - 6);
        }
        
        g.setColor(Color.DARK_GRAY);
        for (int i = -midX / scale; i < midX / scale; i++) {
            int x = midX + i * scale;
            g.drawString(Integer.toString(i), x + 2, midY + 15);
        }
        for (int i = -midY / scale; i < midY / scale; i++) {
            int y = midY - i * scale;
            g.drawString(Integer.toString(i), midX + 6, y - 2);
        }
    }
}


class HomePanel extends JPanel {
    public HomePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Title at the top
        JLabel title = new JLabel("Welcome to the Geometry & Stack App!", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        // Center Panel for Image + Description
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);

        // Logo
        ImageIcon originalIcon = new ImageIcon("./static/logo.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        centerPanel.add(imageLabel);

        // Description
        JTextArea description = new JTextArea(
            "Welcome to the Geometry & Stack App!\n\n" +
            "This application allows you to:\n" +
            "• Add and visualize points and segments on a coordinate grid.\n" +
            "• Perform various operations on stacks, such as push, pop, and peek, with visual representation.\n" +
            "• Interact with intuitive graphical tools for geometry and stack management.\n\n" +
            "How to Navigate:\n" +
            "• Use the navigation menu at the top of the screen to switch between different panels:\n" +
            "  - 'Home': Returns you to this page.\n" +
            "  - 'Draw': Access the geometry tools to add points, segments, and interact with the grid.\n" +
            "  - 'Stack Operations': Perform stack-related operations and see them visually.\n" +
            "  - 'Settings': Customize your experience with various settings (future feature).\n\n"
        );
        description.setFont(new Font("Monospaced", Font.PLAIN, 16));
        description.setEditable(false);
        description.setOpaque(false);
        description.setFocusable(false);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);
        description.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        centerPanel.add(description);

        add(centerPanel, BorderLayout.CENTER);

        // Button at the bottom
        JButton getStarted = new JButton("Get Started →");
        getStarted.setFont(new Font("SansSerif", Font.BOLD, 18));
        getStarted.setFocusPainted(false);
        getStarted.setBackground(new Color(70, 130, 180));
        getStarted.setForeground(Color.WHITE);
        getStarted.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        getStarted.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "Draw");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        buttonPanel.add(getStarted);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}

class StackPanel extends JPanel {
    private MyStack stack;
    private JTextField inputField;
    private JTextArea stackDisplay;
    private JLabel statusLabel;

    public StackPanel() {
        setLayout(new BorderLayout(10, 10));

        stack = new MyStack(10); // Default capacity for the stack
        stackDisplay = new JTextArea(10, 20);
        stackDisplay.setEditable(false);
        stackDisplay.setFont(new Font("Monospaced", Font.PLAIN, 16));
        stackDisplay.setBorder(BorderFactory.createTitledBorder("Stack Visualization"));

        JPanel controlsPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        controlsPanel.setBorder(BorderFactory.createTitledBorder("Stack Controls"));

        inputField = new JTextField();
        JButton pushButton = new JButton("Push");
        JButton popButton = new JButton("Pop");
        JButton peekButton = new JButton("Peek");
        JButton clearButton = new JButton("Clear");

        statusLabel = new JLabel(" ");
        statusLabel.setForeground(Color.BLUE);

        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(inputField.getText());
                    stack.push(value);
                    inputField.setText("");
                    statusLabel.setText("✅ Pushed " + value);
                    updateStackDisplay();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "❗ Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(null, "❗ Stack Overflow: Unable to push.", "Stack Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int poppedValue = stack.pop();
                    statusLabel.setText("✅ Popped " + poppedValue);
                    updateStackDisplay();
                } catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(null, "❗ Stack Underflow: Unable to pop.", "Stack Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        peekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int topValue = stack.peek();
                    statusLabel.setText("🔍 Top of stack: " + topValue);
                } catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(null, "❗ Stack Underflow: Unable to peek.", "Stack Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stack.setCapacity(stack.getCapacity()); // Resets the stack
                statusLabel.setText("🧹 Stack cleared.");
                updateStackDisplay();
            }
        });

        controlsPanel.add(new JLabel("Value:"));
        controlsPanel.add(inputField);
        controlsPanel.add(pushButton);
        controlsPanel.add(popButton);
        controlsPanel.add(peekButton);
        controlsPanel.add(clearButton);

        add(controlsPanel, BorderLayout.NORTH);
        add(new JScrollPane(stackDisplay), BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        updateStackDisplay();
    }

    private void updateStackDisplay() {
        StringBuilder sb = new StringBuilder();
        for (int i = stack.getCapacity() - 1; i >= 0; i--) {
            if (i == stack.getTop()) {
                sb.append("TOP -> ");
            } else {
                sb.append("       ");
            }
            sb.append(i >= 0 && i <= stack.getTop() ? stack.getElements()[i] : "EMPTY");
            sb.append("\n");
        }
        stackDisplay.setText(sb.toString());
    }
}