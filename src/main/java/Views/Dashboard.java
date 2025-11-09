package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame{
    private JButton addNewFarmerButton;
    private JButton manageCropButton;
    private JButton manageInventoryButton;
    private JButton managePreOrdersButton;
    private JButton manageProductionButton;
    private JButton sendNotificationsButton;
    public JPanel backPanel;
    private JButton logOutButton;

    public Dashboard() {
        addNewFarmerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard.this.dispose();
                RegisterFarmer ui =new RegisterFarmer();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Register Farmer");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
        manageCropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard.this.dispose();
                CropForm ui =new CropForm();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Register Farmer");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
        manageInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard.this.dispose();
                InventoryManagementUI ui =new InventoryManagementUI();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Inventory Management");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
        managePreOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard.this.dispose();
                new OrderUI();
            }
        });
        manageProductionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard.this.dispose();
                new ProduceUI();
            }
        });
        sendNotificationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard.this.dispose();
                NotificationUI ui = new NotificationUI();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Send Notification");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard.this.dispose();
                LogInForm ui=new LogInForm();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Register Farmer");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Dashboard ui=new Dashboard();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Register Farmer");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }

}
