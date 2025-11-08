package Views;

import Models.SignUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInForm extends JFrame{
    private JTextField textEmail;
    private JButton logInButton;
    private JButton signUpButton;
    private JPasswordField passwordField1;
    public JPanel backPanel;


    public LogInForm() {
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email=textEmail.getText();
                char[] password=passwordField1.getPassword();
                SignUp s1=new SignUp(email,password);
                boolean status= s1.LogIn();
                if (status){
                    JOptionPane.showMessageDialog(null, "Log In successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    LogInForm.this.dispose();
                    Dashboard ui=new Dashboard();
                    ui.setContentPane(ui.backPanel);
                    ui.setTitle("Register Farmer");
                    ui.setSize(600,600);
                    ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ui.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Email or Password Incorrect!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogInForm.this.dispose();
                SignUpForm ui=new SignUpForm();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Register Farmer");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        LogInForm ui=new LogInForm();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Register Farmer");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}