package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static Properties properties;

    private static void loadProperties() throws IOException {
        if (properties == null) {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        }
    }

    public static WebDriver createDriver() throws IOException {

        loadProperties();

        String browser = properties.getProperty("browser");
        String baseUrl = properties.getProperty("baseUrl");

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            if (Boolean.parseBoolean(properties.getProperty("start-maximized"))) {
                options.addArguments("--start-maximized");
            }

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.get(baseUrl);
        return driver;
    }
}
