package Models;
// 7


import DatabaseLayer.DBConfig;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Produce {
    private String produceId;
    private String name;
    private String category;
    private int availableQuantity;
    private String harvestDate;   // store as String for simplicity, but ideally use java.sql.Date
    private double pricePerUnit;

    // Constructor
    public Produce(String produceId, String name, String category, int availableQuantity, String harvestDate, double pricePerUnit) {
        this.produceId = produceId;
        this.name = name;
        this.category = category;
        this.availableQuantity = availableQuantity;
        this.harvestDate = harvestDate;
        this.pricePerUnit = pricePerUnit;
    }

    // Register new produce in DB
    public void registerProduce() {
        DBConfig db = new DBConfig();
        String sql = "INSERT INTO produce (produce_id, name, category, available_quantity, harvest_date, price_per_unit) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = db.DBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, produceId);
            pstmt.setString(2, name);
            pstmt.setString(3, category);
            pstmt.setInt(4, availableQuantity);
            pstmt.setString(5, harvestDate); // if using DATE type, convert with java.sql.Date.valueOf()
            pstmt.setDouble(6, pricePerUnit);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Produce registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error registering produce: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Example usage
    public static void main(String[] args) {
        Produce p1 = new Produce("P004", "Tomatoes", "Vegetable", 120, "2025-11-24", 45.50);
        p1.registerProduce();
    }
}
