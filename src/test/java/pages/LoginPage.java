package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {

    SHAFT.GUI.WebDriver driver;

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    // Constructor
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public LoginPage login(String username, String password) {
        driver.element().type(usernameField, username).type(passwordField, password).click(loginButton);
        return this;
    }

    public String showErrorMsg() {
        return driver.element().get().text(errorMessage);
    }
}