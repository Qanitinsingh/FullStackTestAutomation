package utill;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    private static WebDriver driver;
    private static String browserName;

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getBrowser() {
        return browserName;
    }

    public static void setDriver(String browser) {
        if (browser == null || browser.trim().isEmpty()) {
            browser = "chrome";
        }
        browser = browser.toLowerCase();
        browserName = browser;

        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            case "chrome":
            default:
                ChromeOptions options = new ChromeOptions();
                // options.addArguments("--headless=new"); // uncomment for CI pipelines
                driver = new ChromeDriver(options);
                break;
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public static void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) {
            }
        }
        driver = null;
        browserName = null;
    }
}
