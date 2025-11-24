package Models;
// 7

import DatabaseLayer.DBConfig;
import javax.swing.*;
import java.sql.*;

public class InspectorAlert {
    public int produceID;
    public String inspectorID;
    public String message;

    public InspectorAlert(int produceID, String inspectorID, String message) {
        this.produceID = produceID;
        this.inspectorID = inspectorID;
        this.message = message;
    }

    public void sendAlert() {
        DBConfig db = new DBConfig();
        String sql = "INSERT INTO inspector_alerts (produceID, inspectorID, message) VALUES (?, ?, ?)";

        try (Connection conn = db.DBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, produceID);
            pstmt.setString(2, inspectorID);
            pstmt.setString(3, message);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alert sent to inspector!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}

