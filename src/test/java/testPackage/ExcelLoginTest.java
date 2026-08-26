package testPackage;

import base.BaseTest;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ExcelLoginTest extends BaseTest {

    SHAFT.TestData.EXCEL testData =
            new SHAFT.TestData.EXCEL("src/test/resources/testDataFiles/loginTest.xlsx");

    @Test(priority = 1,groups = "smoke")
    public void validLoginUsingExcel() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(testData.getCellData("valid", "username"), testData.getCellData("valid", "password"));

        driver.assertThat().browser().url().contains("inventory").perform();
    }

    @Test(priority = 2)
    public void invalidLoginUsingExcel() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(testData.getCellData("invalid", "username"), testData.getCellData("invalid", "password"));

        String actualError = loginPage.showErrorMsg();
        String expectedError = "Epic sadface: Username and password do not match any user in this service";

        SHAFT.Validations.assertThat().object(actualError).isEqualTo(expectedError).perform();
    }

    @Test(priority = 3)
    public void lockedUserLoginUsingExcel() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(testData.getCellData("locked", "username"), testData.getCellData("locked", "password"));

        String actualError = loginPage.showErrorMsg();
        String expectedError = "Epic sadface: Sorry, this user has been locked out.";

        SHAFT.Validations.assertThat().object(actualError).isEqualTo(expectedError).perform();
    }
}