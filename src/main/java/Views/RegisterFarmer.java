package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFarmer extends  JFrame {
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtEmail;
    private JTextField txtTele;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblEmail;
    private JLabel lblTelephone;
    private JPanel backPanel;
    private JButton btnSubmit;
    private JTextField textAddress;
    private JTextField textCity;
    private JTextField txtSpecialization;
    private JTextField txtCertificates;

    public RegisterFarmer() {
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = txtFirstName.getText();
                String lastName = txtLastName.getText();
                String email = txtEmail.getText();
                String telephone = txtTele.getText();
                String address=textAddress.getText();
                String city=textCity.getText();
                String specialization=txtSpecialization.getText();
                String certificates=txtCertificates.getText();
                Models.RegisterFarmer farmer=new Models.RegisterFarmer(firstName,lastName,email,telephone,address,city,specialization,certificates);
                farmer.insertNewFarmer();
            }
        });
    }

    public static void main(String[] args) {
        RegisterFarmer ui =new RegisterFarmer();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Register Farmer");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);

    }

}

