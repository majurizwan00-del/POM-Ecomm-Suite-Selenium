package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By CreateAccount = By.xpath("//a[@href='/register']");

    public void clickCreateAccount() {
        driver.findElement(CreateAccount).click();
    }

}
