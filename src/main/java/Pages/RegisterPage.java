package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;
import java.util.List;

public class RegisterPage {

    WebDriver driver;

    By SubscriptionPlan = By.xpath("//select[@formcontrolname='planId']/option");

    By CompanyName = By.xpath("//input[@formcontrolname='tenantName']");

    By ContactEmail = By.xpath("//input[@formcontrolname='contactEmail']");

    By ContactPhone = By.xpath("//input[@formcontrolname='contactPhone']");

    By Country = By.xpath("//input[@placeholder='Search and select country...']");

    By CountryOption = By.xpath("//input[@placeholder='Search and select country...']/following-sibling::ul[contains(@class,'autocomplete-dropdown')]");

    By BusinessAddress = By.xpath("//textarea[@formcontrolname='address']");

    By BusinessType = By.xpath("//label[contains(normalize-space(.), 'Pharmacy')]/preceding-sibling::input");

    By termsCondition = By.xpath("//label[@for='termsCondition']");

    By CreateAccount = By.xpath("//button[.//span[normalize-space()='Create Company Account']]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void DropdownSubscriptionPlan() throws InterruptedException {

        Thread.sleep(2000);

        List<WebElement> options = driver.findElements(SubscriptionPlan);

        for (int i = 0; i < options.size(); i++) {
            String text = options.get(i).getText().trim();
            System.out.println("Options Text: " + text);

            if (text.equals("Pro - $19.99/month")) {

                WaitUtils.waitElementToBeVisible(driver, options.get(i), 1000);
                WaitUtils.waitElementToBeVisible(driver, options.get(i), 1000);

                options.get(i).click();
                System.out.println("Selected: " + text);
                break;
            }
        }
    }

    public void TextCompanyName() {
        driver.findElement(CompanyName).sendKeys("Decodics");
    }

    public void TextContactEmail() {
        driver.findElement(ContactEmail).sendKeys("gulkhan@shahzad.com");
    }

    public void TextContactPhone() {
        driver.findElement(ContactPhone).sendKeys("03455454545");
    }

    public void selectCountry(WebDriver driver, String countryName) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement countryInput = driver.findElement(Country);
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(countryInput));
        input.clear();
        input.sendKeys(countryName);

    }

    public void CountryOption() throws InterruptedException {

        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(50, 200);");

        List<WebElement> countryoptions = driver.findElements(CountryOption);

        for (int i = 0; i < countryoptions.size(); i++) {
            String text = countryoptions.get(i).getText().trim();
            System.out.println("Country Options Text:" + text);

            if (text.equals("Pakistan")) {
                countryoptions.get(i).click();
                System.out.println("Selected: " + text);
            }
        }
    }

    public void TextBusinessAddress() {
        driver.findElement(BusinessAddress).sendKeys("544 Block G4");
    }

    public void CheckBoxBusinessType() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        driver.findElement(BusinessType).click();

    }

    public void clicktermsCondition() {
        driver.findElement(termsCondition).click();
    }

    public void clickCreateAccount() {
        driver.findElement(CreateAccount).click();
    }


}
