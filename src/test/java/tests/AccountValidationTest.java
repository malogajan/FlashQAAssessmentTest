package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class AccountValidationTest extends BaseTest {

    @Test
    public void verifyUserAccountDetails() {
        // Navigate to login
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        // Login using valid credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("john@example.com"); // ✅ Replace with a real email
        loginPage.enterPassword("Test123!");           // ✅ Replace with a real password
        loginPage.clickLogin();

        // Navigate to My Account and validate
        MyAccountPage accountPage = new MyAccountPage(driver);

        Assert.assertTrue(accountPage.isMyAccountPageLoaded(), "❌ My Account page not loaded.");
        System.out.println("✅ My Account page is displayed");

        Assert.assertTrue(accountPage.isAccountDisplayed(), "❌ Account email is not visible.");
        System.out.println("✅ Logged in as: " + accountPage.getAccountEmail());

        // Navigate to additional sections
        accountPage.navigateToOrders();
        System.out.println("🛒 Navigated to Orders");

        accountPage.navigateToAddresses();
        System.out.println("📍 Navigated to Addresses");

        accountPage.navigateToRewardPoints();
        System.out.println("🎁 Navigated to Reward Points");

        // ✅ You can add more assertions here to verify each section
    }
}
