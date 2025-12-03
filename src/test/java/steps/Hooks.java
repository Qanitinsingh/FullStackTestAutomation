package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utill.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setup(Scenario scenario) {
        String browser = decideBrowser(scenario);

        logger.info("Launching browser: {}", browser);

        // IMPORTANT FIX
        DriverFactory.setDriver(browser);
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed() && DriverFactory.getDriver() != null) {
                captureScreenshot(scenario);
            }
        } catch (Exception e) {
            logger.error("Error during teardown: {}", e.getMessage(), e);
        } finally {
            DriverFactory.quitDriver();
            logger.info("Browser closed.");
        }
    }

    // ----------------- Helper Methods ---------------------

    private String decideBrowser(Scenario scenario) {

        String sysBrowser = System.getProperty("browser");
        if (sysBrowser != null && !sysBrowser.isEmpty()) {
            return sysBrowser.toLowerCase();
        }

        return scenario.getSourceTagNames().stream()
                .filter(tag -> tag.matches("@(chrome|firefox|edge|safari)"))
                .map(tag -> tag.replace("@", "").toLowerCase())
                .findFirst()
                .orElse("chrome");
    }

    private void captureScreenshot(Scenario scenario) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String name = scenario.getName().replace(" ", "_") + "_" + timestamp + ".png";

        File screenshotDir = new File(System.getProperty("user.dir") + "/ScreenShots");
        screenshotDir.mkdirs();

        File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotDir, name);
        Files.copy(src.toPath(), dest.toPath());

        scenario.attach(((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES),
                "image/png", name);

        logger.error("Scenario FAILED. Screenshot saved at: {}", dest.getAbsolutePath());
    }
}
