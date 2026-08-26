package base;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected SHAFT.GUI.WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        String browser = System.getProperty("browser", "chrome").toLowerCase();

        WebDriver nativeDriver;

        switch (browser) {

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                nativeDriver = new EdgeDriver(edgeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                nativeDriver = new FirefoxDriver(firefoxOptions);
                break;

            case "chrome":
            default:

                Map<String, Object> prefs = new HashMap<>();

                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.password_manager_leak_detection", false);
                prefs.put("profile.password_manager_save_passwords", false);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.addArguments("--disable-save-password-bubble");

                nativeDriver = new ChromeDriver(chromeOptions);
                break;
        }

        driver = new SHAFT.GUI.WebDriver(nativeDriver);

        driver.browser().navigateToURL("https://www.saucedemo.com");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}