package Views;

import Models.Famer;
import Models.RegisterFarmer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FarmerDisplayGUI extends JFrame {

    private JTable farmerTable;
    private DefaultTableModel tableModel;
    private JButton refreshButton;


    public FarmerDisplayGUI() {
        setTitle("Farmer Management System");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        loadFarmerData();
    }

    private void initComponents() {
        // Create main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create title panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("All Registered Farmers");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);

        // Create table with column names
        String[] columnNames = {
                "First Name", "Last Name", "Email", "Phone",
                "Address", "City", "Specialization", "Certificates"
        };

        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };

        farmerTable = new JTable(tableModel);
        farmerTable.setRowHeight(25);
        farmerTable.setFont(new Font("Arial", Font.PLAIN, 12));
        farmerTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        // Set column widths
        farmerTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        farmerTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        farmerTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        farmerTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        farmerTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        farmerTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        farmerTable.getColumnModel().getColumn(6).setPreferredWidth(120);
        farmerTable.getColumnModel().getColumn(7).setPreferredWidth(100);

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(farmerTable);

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        refreshButton = new JButton("Refresh Data");
        refreshButton.setFont(new Font("Arial", Font.BOLD, 14));
        refreshButton.setPreferredSize(new Dimension(150, 35));
        refreshButton.addActionListener(e -> loadFarmerData());
        buttonPanel.add(refreshButton);

        // Add components to main panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void loadFarmerData() {
        // Clear existing data
        tableModel.setRowCount(0);

        // Get farmers from database
        Famer farmerDAO = new Famer();
        List<RegisterFarmer> farmers = farmerDAO.getAllFarmers();

        // Add farmers to table
        for (RegisterFarmer farmer : farmers) {
            Object[] row = {
                    farmer.getFarmerFirstName(),
                    farmer.getFarmerLastName(),
                    farmer.getFarmerEmail(),
                    farmer.getFarmerPhone(),
                    farmer.getFarmerAddress(),
                    farmer.getFarmerCity(),
                    farmer.getSpecialization(),
                    farmer.getCertificates()
            };
            tableModel.addRow(row);
        }

        // Show message if no data
        if (farmers.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No farmers found in the database.",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FarmerDisplayGUI gui = new FarmerDisplayGUI();
            gui.setVisible(true);
        });
    }
}
