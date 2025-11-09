package Models;
//4
import DatabaseLayer.DBConfig;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public boolean placePreOrder(String orderId, String customerId, String produceId, int quantity, LocalDate deliveryDate) {
        DBConfig db = new DBConfig();
        Connection connection = null;
        try {
            connection = db.DBConnection();
            String sql = "INSERT INTO orders(order_id, customer_id, produce_id, quantity, preferred_delivery_date, delivery_status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, orderId);
            stmt.setString(2, customerId);
            stmt.setString(3, produceId);
            stmt.setInt(4, quantity);
            stmt.setDate(5, Date.valueOf(deliveryDate));
            stmt.setString(6, "Pending");
            stmt.executeUpdate();
            stmt.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String[]> getCustomerOrders(String customerId) {
        List<String[]> orders = new ArrayList<>();
        DBConfig db = new DBConfig();
        Connection connection = null;
        try {
            connection = db.DBConnection();
            String sql = "SELECT * FROM orders WHERE customer_id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                orders.add(new String[]{
                        rs.getString("order_id"),
                        rs.getString("produce_id"),
                        String.valueOf(rs.getInt("quantity")),
                        rs.getDate("preferred_delivery_date").toString(),
                        rs.getString("delivery_status")
                });
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public boolean updateDeliveryStatus(String orderId, String status) {
        DBConfig db = new DBConfig();
        Connection connection = null;
        try {
            connection = db.DBConnection();
            String sql = "UPDATE orders SET delivery_status=? WHERE order_id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setString(2, orderId);
            int rows = stmt.executeUpdate();
            stmt.close();
            connection.close();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

