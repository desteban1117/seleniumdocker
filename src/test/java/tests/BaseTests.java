package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {

        String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        }else {
            dc = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            dc.setCapability(ChromeOptions.CAPABILITY, options);
        }

        if(System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        driver = new RemoteWebDriver(new URL(completeUrl), dc);
//        System.setProperty("webdriver.chrome.driver", "/Users/david.alvarez/udemy-docker/chromedriver");
//        driver = new ChromeDriver();
    }

    @AfterTest
    public void quitBrowser() {
        driver.quit();
    }
}
