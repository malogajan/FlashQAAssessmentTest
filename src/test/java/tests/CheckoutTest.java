package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void userCanCheckoutAsGuest() throws InterruptedException {
        // Step 1: Add item to cart
        driver.findElement(By.linkText("Computers")).click();
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElements(By.cssSelector(".product-box-add-to-cart-button")).get(0).click();

        // Step 2: Go to cart and agree to terms
        driver.findElement(By.className("cart-label")).click();
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();

        // Step 3: Fill in guest checkout form and continue
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.proceedToCheckoutAsGuest();

        // Fill billing form (assuming defaults)
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("John");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Doe");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("johndoe@example.com");
        driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("South Africa");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Pretoria");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("123 Demo Street");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("0001");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("0831234567");

        checkout.continueBilling();
        checkout.continueShipping();
        checkout.continueShippingMethod();
        checkout.continuePaymentMethod();
        checkout.continuePaymentInfo();
        checkout.confirmOrder();

        // Validate order success message
        String confirmation = checkout.getConfirmationMessage();
        Assert.assertTrue(confirmation.contains("Your order has been successfully processed!"),
                "❌ Order confirmation failed. Message was: " + confirmation);

        System.out.println("✅ Order was successfully placed.");
    }
}

