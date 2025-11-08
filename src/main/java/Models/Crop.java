package Models;

import DatabaseLayer.DBConfig;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Crop {
    private String cropName;
    private String variety;
    private String plantingDate;
    private String expectedHarvestDate;
    private String growthStage;
    private double yieldPrediction;

    public Crop(String cropName, String variety, String plantingDate, String expectedHarvestDate) {
        this.cropName = cropName;
        this.variety = variety;
        this.plantingDate = plantingDate;
        this.expectedHarvestDate = expectedHarvestDate;
    }

    public void insertNewCrop(){
        DBConfig db =new DBConfig();
        String sql="INSERT INTO crop (cropName, variety, plantingDate, expectedHarvestDate) VALUES (?, ?, ?, ?)";
        Connection connection=null;

        try{
            connection=db.DBConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, cropName);
            pstmt.setString(2, variety);
            pstmt.setString(3, plantingDate);
            pstmt.setString(4, expectedHarvestDate);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Crop inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
