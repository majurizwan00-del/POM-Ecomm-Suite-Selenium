package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    ThreadLocal<WebDriver> driver;

    By UserName = By.xpath("//input[@id='inputUser']");

    By Password = By.xpath("//input[@id='inputPassword']");

    By LoginButton = By.xpath("//button[@type='submit']");

    public LoginPage(ThreadLocal<WebDriver> driver) {

        this.driver = driver;
    }

    public void login(String username, String password) throws InterruptedException {
        driver.get().findElement(UserName).sendKeys(username);
        driver.get().findElement(Password).sendKeys(password);
        driver.get().findElement(LoginButton).click();

        Thread.sleep(5000);
    }

}
