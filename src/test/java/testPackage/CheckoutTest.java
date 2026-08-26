package testPackage;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    @DataProvider(name = "checkoutData")
    public Object[][] checkoutData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "Maram", "Esmaeil", "12345"}
        };
    }

    @Test(priority = 4, groups = "smoke", dataProvider = "checkoutData")
    public void addProductsAndCheckout(String username, String password, String firstName, String lastName, String postalCode) {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        // Add 2 products
        ProductsPage productsPage = new ProductsPage(driver);

        CartPage cartPage = productsPage
                .addBackpackToCart()
                .addBikeLightToCart()
                .openCart();

        // Checkout
        CheckoutPage checkoutPage = cartPage.clickCheckout();

        checkoutPage.enterCustomerInformation(firstName, lastName, postalCode).clickContinue().clickFinish();
        // Verify order confirmation
        String actualMessage = checkoutPage.getConfirmationMessage();

        driver.assertThat().object(actualMessage).isEqualTo("Thank you for your order!").perform();
    }
}