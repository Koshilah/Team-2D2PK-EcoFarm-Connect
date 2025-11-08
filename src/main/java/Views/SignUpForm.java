package Views;

import Models.SignUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpForm extends JFrame{
    private JTextField textName;
    private JTextField textEmail;
    private JButton registerButton;
    private JPasswordField passwordField1;
    public JPanel backPanel;
    private JButton logInButton;

    public SignUpForm() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=textName.getText();
                String email=textEmail.getText();
                char[] password=passwordField1.getPassword();
                SignUp s1=new SignUp(email,password,name);
                s1.SignUpNew();
                SignUpForm.this.dispose();
                LogInForm ui=new LogInForm();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Register Farmer");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpForm.this.dispose();
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
        SignUpForm ui=new SignUpForm();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Register Farmer");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}
