package tests;

import Pages.CategoryItemList;
import Pages.LeftMenuPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import static utils.DriverManager.driver;

public class CategoryItemListTest extends LoginTest {

    @Test
    public void positiveCategoryTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        login.login("MP", "MP");

        LeftMenuPage leftMenuPage = new LeftMenuPage(driver);
        leftMenuPage.clickCategory();
        leftMenuPage.clickCategoryItems();

        CategoryItemList categoryItemList = new CategoryItemList(driver);
        categoryItemList.addCategoryItem();
        categoryItemList.selectcategoryItemlist("Pizzas");
        categoryItemList.selectCategoryItemName();
        categoryItemList.selectCategoryBranch("Mirchi Pizzas");
        categoryItemList.entercategoryPrice();
        categoryItemList.entercategoryUnit();
        categoryItemList.enterCategoryTaxRate();
        categoryItemList.SaveCategoryButton();
   //     categoryItemList.enterCategorySearch();
        categoryItemList.scrollHorizontal(300);
        categoryItemList.clickDeleteCategory();
    }
}
