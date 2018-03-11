package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     *
     * @return New instance of {@link WebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    private static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        switch (browser) {
            // TODO prepare required WebDriver instance according to browser type
            case "firefox":
                System.setProperty(
                        "webdriver.firefox.driver",
                        new File(BaseScript.class.getResource("/geckodriver").getFile()).getPath());
            default:
                System.setProperty(
                        "webdriver.chrome.driver",
                        new File(BaseScript.class.getResource("/chromedriver").getFile()).getPath());
                return new ChromeDriver();
        }
    }

    /**
     * Creates {@link WebDriver} instance with timeout and browser window configurations.
     *
     * @return New instance of {@link EventFiringWebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    protected static EventFiringWebDriver getConfiguredDriver() {
       // TODO configure browser window (set timeouts, browser pindow position) and connect loggers.
        WebDriver driver = getDriver();
        driver.manage().window().maximize();

        EventFiringWebDriver webDriver = new EventFiringWebDriver(driver);
        webDriver.register(new EventHandler());
        return webDriver;
    }

    protected static void quiteDriver(WebDriver driver) {
        driver.quit();
    }
}
