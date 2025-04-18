package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void userShouldRegisterSuccessfully() {
        // Navigate to HomePage and click Register
        HomePage home = new HomePage(driver);
        home.clickRegister(); // Uses explicit wait internally

        // Fill out registration form
        RegisterPage register = new RegisterPage(driver);
        register.selectGender("male");
        register.enterFirstName("John");
        register.enterLastName("Doe");
        register.enterEmail(generateUniqueEmail());
        register.enterPassword("Test123!");
        register.confirmPassword("Test123!");
        register.clickRegister();

        // Assert registration success
        Assert.assertTrue(register.getSuccessMessage().contains("Your registration completed"),
                "❌ Registration failed!");
        System.out.println("✅ Registration completed successfully.");
    }
    // 🔧 Helper method to generate a unique email for each test run
    private String generateUniqueEmail() {
        return "john" + System.currentTimeMillis() + "@example.com";
    }
}
