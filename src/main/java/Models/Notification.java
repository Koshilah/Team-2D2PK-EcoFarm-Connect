package Models;
// 6
import DatabaseLayer.DBConfig;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Notification {
    public String notificationID;
    public String FarmerID;
    public String message;
    public String SentDate;

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

    public Notification() {
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


    public List<Notification> getMessagesByFarmerID(String farmerID) {
        List<Notification> messages = new ArrayList<>();
        DBConfig db = new DBConfig();
        String sql = "SELECT * FROM notifications WHERE farmerID = ?";
        Connection conn = null;

        try {
            conn = db.DBConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, farmerID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Notification note = new Notification(
                        rs.getString("notificationID"),
                        rs.getString("farmerID"),
                        rs.getString("message"),
                        rs.getString("sentDate")
                );
                messages.add(note);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        return messages;
    }

}
