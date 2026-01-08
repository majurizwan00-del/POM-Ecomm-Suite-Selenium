package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftMenuPage {

    ThreadLocal<WebDriver> driver;

    By dashboardLink = By.xpath("//span[text()='Dashboard']");

    By category = By.xpath("//span[@class='nxl-mtext' and text()='Category']");

    By categories = By.xpath("//span[text()='Categories']");

    By CategoryItemsLink = By.xpath("//span[text()='Category Items']");

    public LeftMenuPage(ThreadLocal<WebDriver> driver) {
        this.driver = driver;
    }

    public void openDashboardMenu() {
        driver.get().findElement(dashboardLink).click();
    }

    public void clickCategory() {
        driver.get().findElement(category).click();
    }

    public void clickCategories() {
        openDashboardMenu();
        driver.get().findElement(categories).click();
    }

    public void clickCategoryItems() {
        clickCategories();
        driver.get().findElement(CategoryItemsLink).click();
    }
}
