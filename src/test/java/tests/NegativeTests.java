package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class NegativeTests extends BaseTest {

    @Test
    public void loginWithInvalidCredentials() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver); // 💡 Make sure this exists
        login.login("invalid@example.com", "wrongpassword");

        String expectedError = "Login was unsuccessful. Please correct the errors and try again.";
        Assert.assertTrue(login.getLoginError().contains(expectedError), "❌ Error message not displayed as expected");
    }

    @Test
    public void registerWithExistingEmail() {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("John");
        driver.findElement(By.id("LastName")).sendKeys("Doe");
        driver.findElement(By.id("Email")).sendKeys("existinguser@example.com");  // use real registered email
        driver.findElement(By.id("Password")).sendKeys("Password123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Password123");
        driver.findElement(By.id("register-button")).click();

        String error = driver.findElement(By.cssSelector(".message-error li")).getText();
        Assert.assertTrue(error.contains("already exists"), "❌ Email duplicate error not shown");
        System.out.println("✅ Register with existing email failed as expected.");
    }

    @Test
    public void checkoutWithoutAcceptingTerms() {
        // Add item to cart
        driver.findElement(By.linkText("Computers")).click();
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElements(By.cssSelector(".product-box-add-to-cart-button")).get(0).click();

        // Try to checkout without ticking terms
        driver.findElement(By.className("cart-label")).click();
        driver.findElement(By.id("checkout")).click();

        // Check error notification
        String warning = driver.findElement(By.cssSelector(".terms-of-service-warning")).getText();
        Assert.assertTrue(warning.contains("You must accept"), "❌ No warning about accepting terms");
        System.out.println("✅ Checkout failed without accepting terms - working as expected.");
    }
}

