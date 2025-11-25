package Views;

import Models.Famer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageFarmer extends JFrame {
    private JButton addNewFarmerButton;
    private JButton viewAllFarmersButton;
    private JButton backToDashBoardButton;
    public JPanel backPanel;
    private JTextField txtFarmerId;
    private JButton searchButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JLabel lblFarmercount;
    private JTextField texttele;

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
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Famer farmer=new Famer();
                Models.RegisterFarmer farmer1=farmer.getFarmerByID(txtFarmerId.getText());
                if(farmer1!=null){
                    JOptionPane.showMessageDialog(null, farmer1.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);

                }
                else{
                    JOptionPane.showMessageDialog(null, "Farmer not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Famer farmer=new Famer();
                farmer.deleteFarmer(txtFarmerId.getText());
            }
        });
        lblFarmercount.setText(Integer.toString(Famer.getFarmerCount()));
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Famer.updateFarmerTelephone(txtFarmerId.getText(), texttele.getText());
            }
        });
    }

    public static void main(String[] args) {
        ManageFarmer ui = new ManageFarmer();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Register Farmer");
        ui.setSize(700,500);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}
