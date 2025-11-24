package Models;

import DatabaseLayer.DBConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;

public class AnalyticsDashboard {
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
    public static int getCropCount() {
        DBConfig db = new DBConfig();
        String sql = "SELECT COUNT(*) AS total FROM crop";
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
    public static int getCropsToHarvestThisMonth() {
        int count = 0;
        DBConfig db = new DBConfig();

        // Get current month and year
        YearMonth currentMonth = YearMonth.now();
        LocalDate startOfMonth = currentMonth.atDay(1);
        LocalDate endOfMonth = currentMonth.atEndOfMonth();

        String sql = "SELECT COUNT(*) AS total " +
                "FROM crop " +
                "WHERE STR_TO_DATE(expectedHarvestDate, '%Y-%m-%d') " +
                "BETWEEN ? AND ?";

        try (Connection conn = db.DBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, java.sql.Date.valueOf(startOfMonth));
            pstmt.setDate(2, java.sql.Date.valueOf(endOfMonth));

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("total");
            }

        } catch (SQLException e) {
            System.err.println("Error calculating crops to harvest: " + e.getMessage());
        }

        return count;
    }
    private static int getOrderCountByStatus(String status) {
        int count = 0;
        DBConfig db = new DBConfig();
        String sql = "SELECT COUNT(*) AS total FROM orders WHERE delivery_status = ?";

        try (Connection conn = db.DBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, status);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt("total");
            }

        } catch (SQLException e) {
            System.err.println("Error fetching order count for status " + status + ": " + e.getMessage());
        }

        return count;
    }


    public static int getPendingOrders() {
        return getOrderCountByStatus("Pending");
    }

    public static int getDeliveredOrders() {
        return getOrderCountByStatus("Delivered");
    }

    public static int getShippedOrders() {
        return getOrderCountByStatus("Shipped");
    }

    public static double getTotalRevenueThisMonth() {
        double totalRevenue = 0.0;
        DBConfig db = new DBConfig();

        // Get current month range
        YearMonth currentMonth = YearMonth.now();
        LocalDate startOfMonth = currentMonth.atDay(1);
        LocalDate endOfMonth = currentMonth.atEndOfMonth();

        String sql = "SELECT SUM(available_quantity * price_per_unit) AS revenue " +
                "FROM produce " +
                "WHERE harvest_date BETWEEN ? AND ?";

        try (Connection conn = db.DBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, java.sql.Date.valueOf(startOfMonth));
            pstmt.setDate(2, java.sql.Date.valueOf(endOfMonth));

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                totalRevenue = rs.getDouble("revenue");
            }

        } catch (SQLException e) {
            System.err.println("Error calculating total revenue: " + e.getMessage());
        }

        return totalRevenue;
    }
}
