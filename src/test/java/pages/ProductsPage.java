package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ProductsPage {

    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By backpack = By.id("add-to-cart-sauce-labs-backpack");
    private By bikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartIcon = By.className("shopping_cart_link");

    public ProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public ProductsPage addBackpackToCart() {
        driver.element().click(backpack);
        return this;
    }

    public ProductsPage addBikeLightToCart() {
        driver.element().click(bikeLight);
        return this;
    }

    public CartPage openCart() {
        driver.element().click(cartIcon);
        return new CartPage(driver);
    }
}