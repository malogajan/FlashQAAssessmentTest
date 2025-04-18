package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    // Updated locators (Make sure these match actual website)
    private By registerLink = By.className("ico-register");
    private By loginLink = By.className("ico-login");
    private By computersMenu = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Click Register link
    public void clickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    // Click Login link
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    // Click Computers menu
    public void clickOnComputers() {
        wait.until(ExpectedConditions.elementToBeClickable(computersMenu)).click();
    }
    public boolean isLogoutVisible() {
        return isElementVisible(By.className("logout"));
    }
}
