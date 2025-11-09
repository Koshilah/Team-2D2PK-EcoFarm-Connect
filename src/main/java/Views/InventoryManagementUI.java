package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryManagementUI extends JFrame{
    private JButton seedsButton;
    private JButton ferterlizersButton;
    private JButton toolsButton;
    private JButton equipmentsButton;
    private JButton goBackToDashBoardButton;
    public JPanel backPanel;

    public InventoryManagementUI() {
        goBackToDashBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InventoryManagementUI.this.dispose();
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
        InventoryManagementUI ui =new InventoryManagementUI();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Inventory Management");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}
