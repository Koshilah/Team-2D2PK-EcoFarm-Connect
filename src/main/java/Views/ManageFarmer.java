package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageFarmer extends JFrame {
    private JButton addNewFarmerButton;
    private JButton viewAllFarmersButton;
    private JButton backToDashBoardButton;
    public JPanel backPanel;

    public ManageFarmer() {
        addNewFarmerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageFarmer.this.dispose();
                RegisterFarmer ui =new RegisterFarmer();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Register Farmer");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
        viewAllFarmersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageFarmer.this.dispose();
                FarmerDisplayGUI ui = new FarmerDisplayGUI();
                ui.setVisible(true);
            }
        });
        backToDashBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageFarmer.this.dispose();
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
        ManageFarmer ui = new ManageFarmer();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Register Farmer");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}
