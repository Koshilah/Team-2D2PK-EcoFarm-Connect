package testModels;

import DatabaseLayer.DBConfig;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConfigUnitTest {

    static DBConfig dbConfig;
    Connection connection;

    @BeforeAll
    public static void initDBConfig() {
        dbConfig = new DBConfig();
    }

    @BeforeEach
    public void openConnection() {
        connection = dbConfig.DBConnection();
    }

    @Test
    public void testConnectionNotNull() {
        Assertions.assertNotNull(connection, "Connection should not be null");
    }

    @Test
    public void testConnectionIsValid() throws SQLException {
        Assertions.assertTrue(connection.isValid(2), "Connection should be valid");
    }

    @AfterEach
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @AfterAll
    public static void cleanup() {
        dbConfig = null;
    }
}
