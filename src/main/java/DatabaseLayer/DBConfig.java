package DatabaseLayer;

import javax.xml.transform.Result;
import java.sql.*;

public class DBConfig {

    private String url="jdbc:mysql://localhost:3306/econfarmconnect";
    private String user="root";
    private String password="koshiLA123(@)";

    public Connection DBConnection(){
        Connection connection=null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/econfarmconnect",
                    "root",
                    "koshiLA123(@)"
            );

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public static void main(String[] args) {

        DBConfig db=new DBConfig();

        try {

            Connection connection=db.DBConnection();
            Statement statement= connection.createStatement();
            ResultSet resultse= statement.executeQuery("SELECT * FROM farmer");

            while(resultse.next()){
                System.out.println(resultse.getString("farmerFirstName"));
                System.out.println(resultse.getString("farmerLastName"));
                System.out.println(resultse.getString("farmerEmail"));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
