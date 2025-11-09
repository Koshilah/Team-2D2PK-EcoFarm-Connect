package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventorySeeds extends JFrame {
    private JButton goBackToDashBoardButton;
    private JButton addNewSeedButton;
    private JButton viewSeedsButton;
    public JPanel backPanel;

    public InventorySeeds() {
        addNewSeedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InventorySeeds.this.dispose();
                AddSeedUI ui=new AddSeedUI();
                ui.setVisible(true);
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Add New Seed");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        goBackToDashBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InventorySeeds.this.dispose();
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
        InventorySeeds ui=new InventorySeeds();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Register Farmer");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}
