package tests;

import Pages.MainPage;
import Pages.RegisterPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
import static utils.ConfigManager.driver;
import static utils.DriverManager.driver;

public class RegisterTest extends BaseTest {

    @Test
    public void positiveCreateAccount() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.clickCreateAccount();

        // Validate navigation to Register Page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/register"), "Navigation to Register page failed");

        registerPage.DropdownSubscriptionPlan();

        registerPage.TextCompanyName();
        registerPage.TextContactEmail();
        registerPage.TextContactPhone();
        registerPage.selectCountry(driver, "Pakistan");
        registerPage.CountryOption();
        registerPage.TextBusinessAddress();
        registerPage.CheckBoxBusinessType();
        registerPage.clicktermsCondition();
        registerPage.clickCreateAccount();
    }

}
*/