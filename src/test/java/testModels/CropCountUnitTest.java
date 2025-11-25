package testModels;

import Models.AnalyticsDashboard;
import Models.Famer;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CropCountUnitTest {
    static AnalyticsDashboard dashboard;
    int actualCount=0;

    @BeforeAll
    public static void initDBConfig() {
        dashboard = new AnalyticsDashboard();
    }

    @BeforeEach
    public void openConnection() {
        actualCount=dashboard.getCropCount();
    }

    @Test
    public void testFarmerCountMatchesExpected() {
        int expectedCount = 3;
        assertEquals(expectedCount, actualCount,
                "Crop count should match the expected number in the database");
    }


    @AfterEach
    public void closeConnection() throws SQLException {
        actualCount=0;
    }

    @AfterAll
    public static void cleanup() {
        dashboard = null;
    }
}
