package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputersPage extends BasePage {

    // Locators
    private By desktopsLink = By.linkText("Desktops");
    private By notebooksLink = By.linkText("Notebooks");
    private By accessoriesLink = By.linkText("Accessories");

    // Constructor
    public ComputersPage(WebDriver driver) {
        super(driver);
    }

    // Actions

    // Click on Desktops link
    public void clickDesktops() {
        click(desktopsLink);
    }

    // Click on Notebooks link
    public void clickNotebooks() {
        click(notebooksLink);
    }

    // Click on Accessories link
    public void clickAccessories() {
        click(accessoriesLink);
    }

    // Verify Desktops link is visible
    public boolean isDesktopsLinkVisible() {
        return isElementVisible(desktopsLink);
    }

    // Verify Notebooks link is visible
    public boolean isNotebooksLinkVisible() {
        return isElementVisible(notebooksLink);
    }

    // Verify Accessories link is visible
    public boolean isAccessoriesLinkVisible() {
        return isElementVisible(accessoriesLink);
    }
}
