package Models;

import DatabaseLayer.DBConfig;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Notification {
    String notificationID;
    String FarmerID;
    String message;
    String SentDate;

    public Notification(String notificationID, String farmerID, String message, String sentDate) {
        this.notificationID = notificationID;
        FarmerID = farmerID;
        this.message = message;
        SentDate = sentDate;
    }

    public Notification(String farmerID, String message) {
        FarmerID = farmerID;
        this.message = message;
    }

    public void AddNewMessage() {
        DBConfig db = new DBConfig();
        Connection conn=null;
        String sql="INSERT INTO notifications (farmerID,message) VALUES (?,?)";

        try{
            conn=db.DBConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, FarmerID);
            pstmt.setString(2, message);
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Notification Sent successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
