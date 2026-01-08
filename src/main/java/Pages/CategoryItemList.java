package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CategoryItemList {

    ThreadLocal<WebDriver> driver;

    By addCategoryItem = By.xpath("//button[text()=' Add Category Item ']");

    By categoryList = By.xpath("//input[@placeholder='Search and select category...']");

    By categoryItemName = By.xpath("//input[@placeholder='Enter Item Name']");

    By categoryBranch = By.xpath("//input[@placeholder='Search and select branch...']");

    By categoryPrice = By.xpath("//input[@formcontrolname='price']");

    By categoryUnit = By.xpath("//input[@formcontrolname='unit']");

    By categoryTaxRate = By.xpath("//input[@formcontrolname='taxRate']");

    By saveCategory = By.xpath("//button[@class='btn btn-primary']");

    By categorySearch = By.xpath("//input[@placeholder='Search...']");

    By horizantalScroll = By.xpath("//div[contains(@class,'ag-body-horizontal-scroll')]");

    By deleteCategory = By.xpath("(//i[@class='feather-trash-2 me-3'])[1]");

    By deleteConfirmation = By.xpath("//button[@class='btn btn-danger']");

    public CategoryItemList(ThreadLocal<WebDriver> driver) {
        this.driver = driver;
    }

    public void addCategoryItem() throws InterruptedException {
        driver.get().findElement(addCategoryItem).click();
        Thread.sleep(2000);
    }

    public void selectcategoryItemlist(String categoryName) throws InterruptedException {

        Thread.sleep(3000);

        WebElement input = driver.get().findElement(categoryList);
        input.clear();
        input.sendKeys(categoryName);

        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".autocomplete-dropdown .autocomplete-item")));

        List<WebElement> options = driver.get().findElements(By.cssSelector(".autocomplete-dropdown .autocomplete-item"));

        for (int i = 0; i < options.size(); i++) {
            String optionText = options.get(i).getText().trim();
            System.out.println("OptionText : " + optionText);
            if (optionText.equalsIgnoreCase(categoryName)) {
                options.get(i).click();
                break;
            }
        }

    }

    public void selectCategoryItemName() {
        driver.get().findElement(categoryItemName).sendKeys("Aplha");
    }

    public void selectCategoryBranch(String catBranch) {

        driver.get().findElement(categoryBranch).sendKeys(catBranch);

        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul.autocomplete-dropdown li.autocomplete-item span")));

        List<WebElement> options = driver.get().findElements(By.cssSelector("ul.autocomplete-dropdown li.autocomplete-item span"));

        for (int i = 0; i < options.size(); i++) {
            String optionText = options.get(i).getText().trim();
            System.out.println("OptionText : " + optionText);
            if (optionText.equalsIgnoreCase(catBranch)) {
                options.get(i).click();
                break;
            }
        }
    }

    public void entercategoryPrice() {
        driver.get().findElement(categoryPrice).sendKeys("100");
    }

    public void entercategoryUnit() {
        driver.get().findElement(categoryUnit).sendKeys("1A");
    }

    public void enterCategoryTaxRate() {
        driver.get().findElement(categoryTaxRate).sendKeys("200");
    }

    public void SaveCategoryButton() {
        driver.get().findElement(saveCategory).click();
    }

    public void enterCategorySearch()
    {
        driver.get().findElement(categorySearch).sendKeys("Fries");
    }

    public void scrollHorizontal(int pixel) throws InterruptedException {
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], 0);", pixel);
    }

    public void clickDeleteCategory() throws InterruptedException {
        Thread.sleep(3000);
        driver.get().findElement(deleteCategory).click();
        Thread.sleep(2000);
        driver.get().findElement(deleteConfirmation).click();
    }




}
