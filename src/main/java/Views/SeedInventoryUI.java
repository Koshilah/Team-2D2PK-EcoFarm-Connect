package Views;

import DatabaseLayer.DBConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class SeedInventoryUI extends JFrame {

    public SeedInventoryUI() {
        setTitle("Seed Inventory");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Call your method to get ResultSet
        ResultSet rs = viewSeeds();

        // Convert ResultSet to TableModel
        JTable table = new JTable(buildTableModel(rs));

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setLocationRelativeTo(null); // Center window
    }


    public ResultSet viewSeeds() {
        DBConfig db = new DBConfig();
        Connection conn = null;
        String sql = "SELECT * FROM inventory WHERE category='seeds'";
        ResultSet resultSet = null;

        try {
            conn = db.DBConnection();
            PreparedStatement ptsm = conn.prepareStatement(sql);
            resultSet = ptsm.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }


    public static DefaultTableModel buildTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();

            // Column names
            int columnCount = metaData.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }

            // Data rows
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
            return new DefaultTableModel();
        }
    }

    // Run the UI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SeedInventoryUI().setVisible(true);
        });
    }
}

