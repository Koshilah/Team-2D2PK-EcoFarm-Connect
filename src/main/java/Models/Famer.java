package Models;
// 2
import DatabaseLayer.DBConfig;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Famer {

    public List<RegisterFarmer> getAllFarmers() {
        List<RegisterFarmer> farmers = new ArrayList<>();
        DBConfig db = new DBConfig();
        String sql = "SELECT * FROM farmer";
        Connection connection = null;

        try {
            connection = db.DBConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                RegisterFarmer farmer = new RegisterFarmer(
                        rs.getString("farmerFirstName"),
                        rs.getString("farmerLastName"),
                        rs.getString("farmerEmail"),
                        rs.getString("phoneNumber"),
                        rs.getString("farmerAddress"),
                        rs.getString("farmerCity"),
                        rs.getString("specialization"),
                        rs.getString("certificates")
                );
                farmers.add(farmer);
            }

            rs.close();
            pstmt.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        return farmers;
    }

    public RegisterFarmer getFarmerByID(String farmerID) {
        int id = Integer.parseInt(farmerID);
        DBConfig db = new DBConfig();
        String sql = "SELECT * FROM farmer WHERE id = ?";
        Connection connection = null;
        RegisterFarmer farmer = null;

        try {
            connection = db.DBConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                farmer = new RegisterFarmer(
                        rs.getString("farmerFirstName"),
                        rs.getString("farmerLastName"),
                        rs.getString("farmerEmail"),
                        rs.getString("phoneNumber"),
                        rs.getString("farmerAddress"),
                        rs.getString("farmerCity"),
                        rs.getString("specialization"),
                        rs.getString("certificates")
                );
            }

            rs.close();
            pstmt.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        return farmer;
    }

    public static void deleteFarmer(String farmerId) {
        DBConfig db = new DBConfig();
        String sql = "DELETE FROM farmer WHERE id = ?";

        try (Connection conn = db.DBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, farmerId);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null,
                        "Farmer deleted successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "No farmer found with ID: " + farmerId,
                        "Not Found",
                        JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error deleting farmer: " + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public static int getFarmerCount() {
        DBConfig db = new DBConfig();
        String sql = "SELECT COUNT(*) AS total FROM farmer";
        int count = 0;

        try (Connection conn = db.DBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt("total");
            }

        } catch (SQLException e) {
            System.err.println("Error fetching farmer count: " + e.getMessage());
        }

        return count;
    }

}
