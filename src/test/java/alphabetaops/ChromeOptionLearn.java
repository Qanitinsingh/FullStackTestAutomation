package alphabetaops;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeOptionLearn {
    private WebDriver driver;

    // Base method to create chrome driver using given ChromeOptions
    public WebDriver launch(ChromeOptions options) {
        driver = new ChromeDriver();
        return new ChromeDriver(options);
    }

    @Test
    public void testIncognito() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); // used for private browsing (no history/cache)
        driver = launch(options);
        driver.get("https://alphabetaops.com/");
        driver.quit();
    }

    @Test
    public void testStartMaximized() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // opens browser in full screen
        driver = launch(options);
        driver.get("https://alphabetaops.com/");
        driver.quit();
    }

    @Test
    public void testDisableNotifications() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // blocks push notifications
        driver = launch(options);
        driver.get("https://alphabetaops.com/");
        driver.quit();
    }

    @Test
    public void testDisablePopupBlocking() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking"); // allows popups (useful in some apps)
        driver = launch(options);
        driver.get("https://alphabetaops.com/");
        driver.quit();
    }

    @Test
    public void testDisableExtensions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions"); // runs Chrome without any extensions
        driver = launch(options);
        driver.get("https://alphabetaops.com/");
        driver.quit();
    }

    @Test
    public void testWindowSize() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080"); // fixed screen resolution (for layout testing)
        driver = launch(options);
        driver.get("https://alphabetaops.com/");
        driver.quit();
    }

    @Test
    public void testNoSandbox() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox"); // required when running in Docker / Linux CI
        driver = launch(options);
        driver.get("https://alphabetaops.com/");
        driver.quit();
    }

    @Test
    public void testDisableGPU() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu"); // solves GPU issues on Windows headless
        driver = launch(options);
        driver.get("https://alphabetaops.com/");
        driver.quit();
    }

    @Test
    public void testDisableDevShmUsage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage"); // prevents crashes in Docker/Linux low memory
        driver = launch(options);
        driver.get("https://alphabetaops.com/");
        driver.quit();
    }

    @Test
    public void testUserAgent() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Custom-UA-Test"); // mock a different device type / browser
        driver = launch(options);
        driver.get("https://alphabetaops.com/");
        driver.quit();
    }

    @Test
    public void testRemoteAllowOrigins() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // prevents blocked requests in latest Chrome
        driver = launch(options);
        driver.get("https://alphabetaops.com/");
        driver.quit();
    }
}
