package DatabaseLayer;

import javax.xml.transform.Result;
import java.sql.*;

public class DBConfig {

    private final String url = "jdbc:mysql://localhost:3306/econfarmconnect";
    private final String user = "root";
    private final String password = "koshiLA123(@)";

    public Connection DBConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
