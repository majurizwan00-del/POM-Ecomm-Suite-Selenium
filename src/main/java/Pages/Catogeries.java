package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Catogeries {

    ThreadLocal<WebDriver> driver;

    By AddCategory = By.xpath("//button[i[@class='feather-plus me-2'] and contains(text(),'Add Category')]");

    By CategoryName = By.xpath("//input[@formcontrolname='categoryName']");

    By SaveCategory = By.xpath("//button[contains(text(),'Save')]");

    By EditCategory = By.xpath("(//button[.//i[@class='feather-edit-3 me-3']])[1]");

    By CancelCategory = By.xpath("//button[text()=' Cancel ']");

    By SearchCatergory = By.xpath("//input[@placeholder='Search...']");

    By DownloadTemplate = By.xpath("//button[text()=' Download Template ']");

    public Catogeries(ThreadLocal<WebDriver> driver) {
        this.driver = driver;
    }
    public void clickAddCategory() {
        driver.get().findElement(AddCategory).click();
    }

    public void EnterCategoryName() {
        driver.get().findElement(CategoryName).sendKeys("Telenor");
    }

    public void SaveCategoryButton() throws InterruptedException {
        driver.get().findElement(SaveCategory).click();
        Thread.sleep(5000);
    }

    public void EditCategory()
    {
        driver.get().findElement(EditCategory).click();
    }

    public void CancelCategoryButton()
    {
        driver.get().findElement(CancelCategory).click();
    }

    public void SearchCategory()
    {
        driver.get().findElement(SearchCatergory).sendKeys("Text");
    }

    public void DownloadTemplateButton()
    {
        driver.get().findElement(DownloadTemplate).click();
    }
}
