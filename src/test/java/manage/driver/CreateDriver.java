package manage.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateDriver {
    private static CreateDriver INSTANCE;

    private WebDriver driver;

    ThreadLocal<WebDriver> threadLocaldriver = new ThreadLocal<>();

    private CreateDriver() {
        // Private constructor to prevent instantiation
    }

    public static CreateDriver getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CreateDriver();
        }
        return INSTANCE;
    }

    public void setDriver() {
         driver = new ChromeDriver();
        threadLocaldriver.set(new ChromeDriver());

    }
    public WebDriver getDriver() {
        return threadLocaldriver.get();
    }

}
