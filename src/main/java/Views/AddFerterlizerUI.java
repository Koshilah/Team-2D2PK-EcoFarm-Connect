package Views;

import Models.InventoryItems;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFerterlizerUI extends JFrame {
    private JTextField textname;
    private JTextField textquantity;
    private JTextField textunit;
    private JTextField textfarmId;
    private JButton ADDButton;
    public JPanel backPanel;

    public AddFerterlizerUI() {
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textname.getText();
                String quantity = textquantity.getText();
                String unit = textunit.getText();
                String farm = textfarmId.getText();
                InventoryItems seedsAdd= new InventoryItems(name,"ferterlizers",quantity,unit,farm);
                seedsAdd.AddNewSeedInventory();
            }
        });
    }

    public static void main(String[] args) {
        AddFerterlizerUI ui=new AddFerterlizerUI();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Register Farmer");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}
