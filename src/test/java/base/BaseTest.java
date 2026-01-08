package base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ConfigManager;
import utils.DriverManager;

import java.io.IOException;

public class BaseTest {

    @BeforeClass

    public void setup() throws IOException {
        WebDriver driver = ConfigManager.createDriver();
        DriverManager.setDriver(driver);
    }

    @Test
    public void verifyHomePageTitle() {
        String title = DriverManager.getDriver().getTitle();
        Assert.assertEquals(title, "POS Inventory Invoicing | Track 360");
    }

    @AfterClass
    public void tearDown() {
        DriverManager.getDriver().quit();
        DriverManager.unload();
    }
}
