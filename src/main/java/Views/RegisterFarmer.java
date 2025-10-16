package Views;

import javax.swing.*;

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

    public static void main(String[] args) {
        RegisterFarmer ui =new RegisterFarmer();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Register Farmer");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);

    }

}

