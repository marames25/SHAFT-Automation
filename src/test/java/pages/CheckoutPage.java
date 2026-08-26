package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class CheckoutPage {

    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By confirmationMessage = By.className("complete-header");

    public CheckoutPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public CheckoutPage enterCustomerInformation(
            String firstName,
            String lastName,
            String postalCode) {

        driver.element().type(firstNameField, firstName).type(lastNameField, lastName).type(postalCodeField, postalCode);

        return this;
    }

    public CheckoutPage clickContinue() {
        driver.element().click(continueButton);
        return this;
    }

    public CheckoutPage clickFinish() {
        driver.element().click(finishButton);
        return this;
    }

    public String getConfirmationMessage() {
        return driver.element().get().text(confirmationMessage);
    }
}