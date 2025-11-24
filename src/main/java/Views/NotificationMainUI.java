package Views;

import Models.Notification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NotificationMainUI extends JFrame {
    private JTextField textfarmerid;
    private JButton getMessagesButton;
    private JButton sendMessagesButton;
    private JButton backToDashBoardButton;
    public JPanel backPanel;

    public NotificationMainUI() {
        getMessagesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Notification farmerModel = new Notification();
                List<Notification> messages = farmerModel.getMessagesByFarmerID(textfarmerid.getText());
                NotificationViewer viewer = new NotificationViewer();
                viewer.showMessagesTable(messages);
            }
        });
        sendMessagesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NotificationUI ui = new NotificationUI();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Send Notification");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
        backToDashBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NotificationMainUI.this.dispose();
                Dashboard ui=new Dashboard();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Register Farmer");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        NotificationMainUI ui=new NotificationMainUI();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Register Farmer");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}
