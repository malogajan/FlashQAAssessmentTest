package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    // Locators
    private By genderMaleRadio = By.id("gender-male");
    private By genderFemaleRadio = By.id("gender-female");
    private By firstNameInput = By.id("FirstName");
    private By lastNameInput = By.id("LastName");
    private By emailInput = By.id("Email");
    private By passwordInput = By.id("Password");
    private By confirmPasswordInput = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By successMessage = By.className("result");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            click(genderMaleRadio);
        } else if (gender.equalsIgnoreCase("female")) {
            click(genderFemaleRadio);
        }
    }

    public void enterFirstName(String firstName) {
        type(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        type(lastNameInput, lastName);
    }

    public void enterEmail(String email) {
        type(emailInput, email);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void confirmPassword(String confirmPassword) {
        type(confirmPasswordInput, confirmPassword);
    }

    public void clickRegister() {
        click(registerButton);
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return getText(successMessage);
    }
}
