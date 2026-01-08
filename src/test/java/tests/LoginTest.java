package tests;

import Pages.LoginPage;
import base.BaseTest;
import org.testng.annotations.Test;

import static utils.DriverManager.driver;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginAccount() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
    }
}


