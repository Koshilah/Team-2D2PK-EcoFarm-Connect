package Models;
// 7


import DatabaseLayer.DBConfig;

import javax.swing.*;
import java.sql.*;

public class QualityCheckpoint {
    public String produceID;
    public String checkpointName;
    public String status;
    public String dateChecked;

    public QualityCheckpoint(String produceID, String checkpointName, String status, String dateChecked) {
        this.produceID = produceID;
        this.checkpointName = checkpointName;
        this.status = status;
        this.dateChecked = dateChecked;
    }

    public void logCheckpoint() {
        DBConfig db = new DBConfig();
        String sql = "INSERT INTO quality_checkpoints (produceID, checkpointName, status, dateChecked) VALUES (?, ?, ?, ?)";

        try (Connection conn = db.DBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, produceID);
            pstmt.setString(2, checkpointName);
            pstmt.setString(3, status);
            pstmt.setString(4, dateChecked);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Quality Check Logged successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}

