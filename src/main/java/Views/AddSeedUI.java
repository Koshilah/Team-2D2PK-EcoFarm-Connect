package Views;

import Models.InventoryItems;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSeedUI extends JFrame{
    private JTextField textname;
    private JTextField textquantity;
    private JTextField textunit;
    private JTextField textfarm;
    private JButton ADDButton;
    private JPanel backPanel;

    public AddSeedUI() {
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textname.getText();
                String quantity = textquantity.getText();
                String unit = textunit.getText();
                String farm = textfarm.getText();
                InventoryItems seedsAdd= new InventoryItems(name,"seeds",quantity,unit,farm);
                seedsAdd.AddNewSeedInventory();
            }
        });
    }

    public static void main(String[] args) {
        AddSeedUI ui=new AddSeedUI();
        ui.setVisible(true);
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Add New Seed");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
