package tests;

import Pages.Catogeries;
import Pages.LeftMenuPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import static utils.DriverManager.driver;

public class CatogeriesTest extends LoginTest {

    @Test
    public void positiveDashboardTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        login.login("MP", "MP");

        LeftMenuPage leftMenuPage = new LeftMenuPage(driver);
        leftMenuPage.clickCategory();
        leftMenuPage.clickCategories();

        Catogeries catogeries = new Catogeries(driver);

        catogeries.clickAddCategory();
        catogeries.EnterCategoryName();
        catogeries.SaveCategoryButton();
        catogeries.EditCategory();
        catogeries.CancelCategoryButton();
        catogeries.SearchCategory();
        catogeries.DownloadTemplateButton();
    }
}

