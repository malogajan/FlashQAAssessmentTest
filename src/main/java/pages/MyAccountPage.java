package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    // Locators for account information sections
    private By accountLink = By.className("account"); // Email/account identifier
    private By customerInfoHeader = By.cssSelector(".page-title"); // Header on My Account Page
    private By ordersLink = By.linkText("Orders");
    private By addressesLink = By.linkText("Addresses");
    private By rewardPointsLink = By.linkText("Reward points");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountDisplayed() {
        return isElementVisible(accountLink);
    }

    public String getAccountEmail() {
        return getText(accountLink);
    }

    public boolean isMyAccountPageLoaded() {
        return getText(customerInfoHeader).contains("My account");
    }

    public void navigateToOrders() {
        click(ordersLink);
    }

    public void navigateToAddresses() {
        click(addressesLink);
    }

    public void navigateToRewardPoints() {
        click(rewardPointsLink);
    }
}
