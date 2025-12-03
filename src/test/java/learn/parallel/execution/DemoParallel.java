package learn.parallel.execution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoParallel {

    private static ThreadLocal<WebDriver> threadLocaldriver = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        WebDriver driver = new ChromeDriver();
        threadLocaldriver.set(new ChromeDriver());
        threadLocaldriver.get().get("https://alphabetaops.com/");
        System.out.println("Opening the url using thread local driver: " + Thread.currentThread().getId());
    }

    @Test
    public void getPageTitle() {
        String title = threadLocaldriver.get().getTitle();
        System.out.println("Page Title: " + title + " | Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    public void clickOnNovoice() {
        threadLocaldriver.get().findElement(By.cssSelector(".mb-2:first-child")).click();
        System.out.println("Clicked on Novice | Thread ID: " + Thread.currentThread().getId());
    }

    @AfterMethod
    public void teardown() {
        threadLocaldriver.get().quit();
        System.out.println("quitting the browser using thread local driver: " + Thread.currentThread().getId());
    }
}
