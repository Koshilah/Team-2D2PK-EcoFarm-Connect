package testModels;

import DatabaseLayer.DBConfig;
import Models.Famer;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class FarmerCountUnitTest {
    static Famer famer;
    int actualCount=0;

    @BeforeAll
    public static void initDBConfig() {
        famer = new Famer();
    }

    @BeforeEach
    public void openConnection() {
        actualCount=famer.getFarmerCount();
    }

    @Test
    public void testFarmerCountMatchesExpected() {
        int expectedCount = 7;
        assertEquals(expectedCount, actualCount,
                "Farmer count should match the expected number in the database");
    }


    @AfterEach
    public void closeConnection() throws SQLException {
        actualCount=0;
    }

    @AfterAll
    public static void cleanup() {
        famer = null;
    }
}
