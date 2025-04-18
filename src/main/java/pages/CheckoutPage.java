package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Locators for checkout steps
    private By checkoutAsGuestBtn = By.cssSelector(".checkout-as-guest-button");
    private By billingContinueBtn = By.xpath("//input[@onclick='Billing.save()']");
    private By shippingContinueBtn = By.xpath("//input[@onclick='Shipping.save()']");
    private By shippingMethodContinueBtn = By.xpath("//input[@onclick='ShippingMethod.save()']");
    private By paymentMethodContinueBtn = By.xpath("//input[@onclick='PaymentMethod.save()']");
    private By paymentInfoContinueBtn = By.xpath("//input[@onclick='PaymentInfo.save()']");
    private By confirmOrderBtn = By.xpath("//input[@onclick='ConfirmOrder.save()']");
    private By orderConfirmationMessage = By.cssSelector(".section.order-completed .title");

    public void proceedToCheckoutAsGuest() {
        click(checkoutAsGuestBtn);
    }

    public void continueBilling() {
        click(billingContinueBtn);
    }

    public void continueShipping() {
        click(shippingContinueBtn);
    }

    public void continueShippingMethod() {
        click(shippingMethodContinueBtn);
    }

    public void continuePaymentMethod() {
        click(paymentMethodContinueBtn);
    }

    public void continuePaymentInfo() {
        click(paymentInfoContinueBtn);
    }

    public void confirmOrder() {
        click(confirmOrderBtn);
    }

    public String getConfirmationMessage() {
        return getText(orderConfirmationMessage);
    }
}
