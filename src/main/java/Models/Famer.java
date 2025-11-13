package Models;

import DatabaseLayer.DBConfig;
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
}
