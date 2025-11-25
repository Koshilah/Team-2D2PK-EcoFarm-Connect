package Views;

import DatabaseLayer.DBConfig;
import Models.InventoryItems;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class FerterlizerInventoryUI extends JFrame{
    public FerterlizerInventoryUI() {
        setTitle("Fertilizer Inventory");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InventoryItems i=new InventoryItems();
        ResultSet rs = i.viewFerterlizers();

        // Convert ResultSet to TableModel
        JTable table = new JTable(buildTableModel(rs));

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setLocationRelativeTo(null); // Center window
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


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FerterlizerInventoryUI().setVisible(true);
        });
    }
}
