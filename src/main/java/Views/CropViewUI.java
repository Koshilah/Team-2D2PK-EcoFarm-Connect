package Views;

import DatabaseLayer.DBConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class CropViewUI extends JFrame {

    private JTable cropTable;
    private DefaultTableModel tableModel;

    public CropViewUI() {
        setTitle("Crop Details");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table model with column names
        tableModel = new DefaultTableModel(new String[]{"Crop Name", "Variety", "Planting Date", "Expected Harvest Date"}, 0);
        cropTable = new JTable(tableModel);

        // Scroll pane for table
        JScrollPane scrollPane = new JScrollPane(cropTable);
        add(scrollPane, BorderLayout.CENTER);

        // Load data from DB
        loadCropData();
    }

    private void loadCropData() {
        DBConfig db = new DBConfig();
        Connection connection = null;

        try {
            connection = db.DBConnection();
            String sql = "SELECT cropName, variety, plantingDate, expectedHarvestDate FROM crop";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // Clear old rows
            tableModel.setRowCount(0);

            // Add rows to table
            while (rs.next()) {
                String cropName = rs.getString("cropName");
                String variety = rs.getString("variety");
                String plantingDate = rs.getString("plantingDate");
                String expectedHarvestDate = rs.getString("expectedHarvestDate");

                tableModel.addRow(new Object[]{cropName, variety, plantingDate, expectedHarvestDate});
            }

            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading crop data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CropViewUI().setVisible(true);
        });
    }
}
