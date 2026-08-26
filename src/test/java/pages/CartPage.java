package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class CartPage {

    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By checkoutButton = By.id("checkout");

    public CartPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public CheckoutPage clickCheckout() {
        driver.element().click(checkoutButton);
        return new CheckoutPage(driver);
    }
}