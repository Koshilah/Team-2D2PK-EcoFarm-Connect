package Views;

import Models.Notification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotificationUI extends JFrame {
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton sendButton;
    public JPanel backPanel;

    public NotificationUI() {
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = textArea1.getText();
                String farmerId=textField1.getText();
                Notification notification = new Notification(farmerId,message);
                notification.AddNewMessage();
            }
        });
    }

    public static void main(String[] args) {
        NotificationUI ui = new NotificationUI();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Send Notification");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}
