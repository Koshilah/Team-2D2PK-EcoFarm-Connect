package Models;

import DatabaseLayer.DBConfig;

import javax.swing.*;
import java.io.CharArrayReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUp {
    private String email;
    private char[] Password;
    private String name;

    public SignUp(String email, char[] password) {
        this.email = email;
        Password = password;
    }

    public SignUp(String email, char[] password, String name) {
        this.email = email;
        Password = password;
        this.name = name;
    }

    public void SignUpNew(){
        DBConfig db=new DBConfig();
        Connection conn=null;
        String sql="INSERT INTO signup VALUES (?, ?, ?)";

        try{
            conn= db.DBConnection();
            PreparedStatement ptst=conn.prepareStatement(sql);

            ptst.setString(1,email);
            ptst.setCharacterStream(2, new CharArrayReader(Password));
            ptst.setString(3,name);

            int rows=ptst.executeUpdate();

            if (rows==1){
                JOptionPane.showMessageDialog(null, "Signed Up successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            conn.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
