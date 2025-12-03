package learn.parallel.execution;

import manage.driver.CreateDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoParallelSequential {


    @BeforeMethod
    public void setup() {
        CreateDriver.getInstance().setDriver();
        CreateDriver.getInstance().getDriver().get("https://alphabetaops.com/");
        System.out.println("Opening the url using thread local driver: " + Thread.currentThread().getId());
    }

    @Test
    public void getPageTitle() {
        String title = CreateDriver.getInstance().getDriver().getTitle();
        System.out.println("Page Title: " + title + " | Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    public void clickOnNovoice() {
        CreateDriver.getInstance().getDriver().findElement(By.cssSelector(".mb-2:first-child")).click();
        System.out.println("Clicked on Novice | Thread ID: " + Thread.currentThread().getId());
    }

    @AfterMethod
    public void teardown() {
        CreateDriver.getInstance().getDriver().quit();
        System.out.println("quitting the browser using thread local driver: " + Thread.currentThread().getId());
    }
}
