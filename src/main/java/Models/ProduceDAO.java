package Models;

import DatabaseLayer.DBConfig;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProduceDAO {
    public List<String[]> getAvailableProduce(LocalDate date) {
        List<String[]> produceList = new ArrayList<>();
        DBConfig db = new DBConfig();
        Connection connection = null;

        try {
            connection = db.DBConnection();
            String sql = "SELECT * FROM produce WHERE harvest_date >= ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, Date.valueOf(date));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                produceList.add(new String[]{
                        rs.getString("produce_id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        String.valueOf(rs.getInt("available_quantity")),
                        rs.getDate("harvest_date").toString(),
                        String.valueOf(rs.getDouble("price_per_unit"))
                });
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produceList;
    }

    public List<String[]> searchProduceByPreference(List<String> preferences) {
        List<String[]> produceList = new ArrayList<>();
        DBConfig db = new DBConfig();
        Connection connection = null;

        try {
            connection = db.DBConnection();
            StringBuilder sql = new StringBuilder("SELECT * FROM produce WHERE category IN (");
            for (int i = 0; i < preferences.size(); i++) {
                sql.append("?");
                if (i < preferences.size() - 1) sql.append(",");
            }
            sql.append(")");

            PreparedStatement stmt = connection.prepareStatement(sql.toString());
            for (int i = 0; i < preferences.size(); i++) {
                stmt.setString(i + 1, preferences.get(i));
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produceList.add(new String[]{
                        rs.getString("produce_id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        String.valueOf(rs.getInt("available_quantity")),
                        rs.getDate("harvest_date").toString(),
                        String.valueOf(rs.getDouble("price_per_unit"))
                });
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produceList;
    }
}

