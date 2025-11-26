package alphabetaops;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class CookieOperations {
    private WebDriver driver;

    // Base method to start browser and navigate
    public WebDriver launch() {
        driver = new ChromeDriver();
        driver.get("https://alphabetaops.com/");
        return driver;
    }

    @Test
    public void testAddCookie() {
        driver = launch();
        // Add a new cookie (name-value pair)
        Cookie cookie = new Cookie("userType", "automationTester");
        driver.manage().addCookie(cookie);
        driver.quit();
    }

    @Test
    public void testGetCookie() {
        driver = launch();
        Cookie cookie = new Cookie("sessionStatus", "active");
        driver.manage().addCookie(cookie);

        // Retrieve cookie by name
        Cookie retrieved = driver.manage().getCookieNamed("sessionStatus");
        System.out.println("Retrieved Cookie: " + retrieved);
        driver.quit();
    }

    @Test
    public void testGetAllCookies() {
        driver = launch();
        driver.manage().addCookie(new Cookie("id", "123"));
        driver.manage().addCookie(new Cookie("role", "QA"));

        // Get all cookies on current domain
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println("All Cookies: " + allCookies);
        driver.quit();
    }

    @Test
    public void testEditCookie() {
        driver = launch();
        driver.manage().addCookie(new Cookie("department", "testing"));

        // Update cookie by re-adding with same name + new value
        Cookie updated = new Cookie("department", "development");
        driver.manage().addCookie(updated);

        System.out.println("Updated cookie: " + driver.manage().getCookieNamed("department"));
        driver.quit();
    }

    @Test
    public void testDeleteSpecificCookie() {
        driver = launch();
        Cookie cookie = new Cookie("theme", "dark");
        driver.manage().addCookie(cookie);

        // Delete that cookie by name
        driver.manage().deleteCookieNamed("theme");

        System.out.println("Cookie Exists After Delete: " +
                driver.manage().getCookieNamed("theme"));
        driver.quit();
    }

    @Test
    public void testDeleteSpecificCookieObject() {
        driver = launch();
        Cookie cookie = new Cookie("country", "India");
        driver.manage().addCookie(cookie);

        // Delete cookie by Cookie object
        driver.manage().deleteCookie(cookie);
        driver.quit();
    }

    @Test
    public void testDeleteAllCookies() {
        driver = launch();
        driver.manage().addCookie(new Cookie("A", "1"));
        driver.manage().addCookie(new Cookie("B", "2"));

        // Clear all cookies
        driver.manage().deleteAllCookies();

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Cookies after deleteAll: " + cookies.size());
        driver.quit();
    }
}
