package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryFerterlizers extends JFrame {
    private JButton backToDashBoardButton;
    private JButton addFertilizerButton;
    private JButton viewFertilizerButton;
    public JPanel backPanel;

    public InventoryFerterlizers() {
        backToDashBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard ui=new Dashboard();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Register Farmer");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
        addFertilizerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFerterlizerUI ui=new AddFerterlizerUI();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Register Farmer");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
        viewFertilizerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    new FerterlizerInventoryUI().setVisible(true);
                });
            }
        });
    }

    public static void main(String[] args) {
        InventoryFerterlizers ui=new InventoryFerterlizers();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Fertilizer Inventory");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}
