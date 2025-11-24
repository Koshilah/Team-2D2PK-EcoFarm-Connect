package Models;
// 7


import DatabaseLayer.DBConfig;
import java.sql.*;

public class QualityCheckpoint {
    public int produceID;
    public String checkpointName;
    public String status;
    public String dateChecked;

    public QualityCheckpoint(int produceID, String checkpointName, String status, String dateChecked) {
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

            pstmt.setInt(1, produceID);
            pstmt.setString(2, checkpointName);
            pstmt.setString(3, status);
            pstmt.setString(4, dateChecked);

            pstmt.executeUpdate();
            System.out.println("Quality checkpoint logged.");
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}

