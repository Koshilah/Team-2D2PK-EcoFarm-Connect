package Views;

import Models.Notification;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class NotificationViewer {

    public void showMessagesTable(List<Notification> messages) {
        // Column headers
        String[] columnNames = {"Notification ID", "Farmer ID", "Message", "Sent Date"};

        // Table model
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Populate rows
        for (Notification note : messages) {
            Object[] row = {
                    note.notificationID,
                    note.FarmerID,
                    note.message,
                    note.SentDate
            };
            model.addRow(row);
        }

        // Create table
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Create frame
        JFrame frame = new JFrame("Farmer Notifications");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Example usage
    public static void main(String[] args) {
        Notification farmerModel = new Notification();
        List<Notification> messages = farmerModel.getMessagesByFarmerID("123");

        NotificationViewer viewer = new NotificationViewer();
        viewer.showMessagesTable(messages);
    }
}

