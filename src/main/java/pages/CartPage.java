package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private By cartLink = By.className("cart-label");
    private By productRows = By.cssSelector(".cart-item-row");
    private By totalPrice = By.cssSelector(".cart-total-right");
    private By removeItemCheckboxes = By.cssSelector("input[name*='removefromcart']");
    private By updateCartButton = By.name("updatecart");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        click(cartLink);
    }

    public int getNumberOfItemsInCart() {
        List<WebElement> items = driver.findElements(productRows);
        return items.size();
    }

    public String getTotalPrice() {
        return getText(totalPrice);
    }

    public void removeItemFromCart(int itemIndex) {
        List<WebElement> checkboxes = driver.findElements(removeItemCheckboxes);
        if (itemIndex >= 0 && itemIndex < checkboxes.size()) {
            checkboxes.get(itemIndex).click();
            click(updateCartButton);
        }
    }

    public boolean isCartEmpty() {
        return getNumberOfItemsInCart() == 0;
    }
}
