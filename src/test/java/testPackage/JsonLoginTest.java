package testPackage;

import base.BaseTest;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class JsonLoginTest extends BaseTest {

    SHAFT.TestData.JSON testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/loginTest.json");

    @Test(priority = 1,groups = "smoke")
    public void validLoginShowsProductsPage() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(testData.getTestData("users[0].username"), testData.getTestData("users[0].pass"));

        driver.assertThat().browser().url().contains("inventory").perform();
    }

    @Test(priority = 2)
    public void invalidLoginShowsErrorMessage() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(testData.getTestData("users[1].username"), testData.getTestData("users[1].pass"));

        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        String actualError = loginPage.showErrorMsg();

        SHAFT.Validations.assertThat().object(actualError).isEqualTo(expectedError).perform();
    }

    @Test(priority = 3)
    public void lockedOutUserShowsLockoutMessage() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(testData.getTestData("users[2].username"), testData.getTestData("users[2].pass"));

        String expectedError = "Epic sadface: Sorry, this user has been locked out.";
        String actualError = loginPage.showErrorMsg();

        SHAFT.Validations.assertThat().object(actualError).isEqualTo(expectedError).perform();
    }
}