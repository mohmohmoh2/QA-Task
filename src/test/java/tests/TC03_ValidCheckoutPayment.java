package tests;

import Driver.DriverSetup;
import Pages.P01_ItemsPage;
import Pages.P02_Checkout;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverSettings.DriverManager.getDriver;
import static Utilities.DataUtils.getJsonData;

public class TC03_ValidCheckoutPayment extends DriverSetup {

    @Test
    public void testValidCheckoutPayment() throws IOException, InterruptedException {
        // Create an instance of the items page
        P01_ItemsPage itemsPage = new P01_ItemsPage(getDriver());

        // Add item to cart
        itemsPage.clickSizeButton() // Select a size
                .clickColorButton() // Select a color
                .clickAddToCartButton() // Add item to cart
                .clickCartIcon() // Click on the cart icon
                .clickCheckoutButton(); // Click on the checkout button

        P02_Checkout checkoutPage = new P02_Checkout(getDriver());

        // Enter shipping information
        checkoutPage.enterEmail(getJsonData("information", "shippingEmail")) // Enter email
                .enterFirstName(getJsonData("information", "shippingFirstname")) // Enter first name
                .enterLastName(getJsonData("information", "shippingLastname")) // Enter last name
                .enterAddress(getJsonData("information", "shippingAddress")) // Enter address
                .enterCity(getJsonData("information", "shippingCity")) // Enter city
                .enterState(getJsonData("information", "shippingState")) // Enter state
                .enterZipCode(getJsonData("information", "shippingZip")) // Enter zip code
                .enterPhoneNumber(getJsonData("information", "shippingPhone")) // Enter phone number
                .selectShippingMethod() // Select shipping method
                .clickNextButton(); // Click on the next button

        // Wait for the checkout button to be clickable and click it
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.checkoutButton));
        checkoutPage.clickCheckoutButton();

        // Assert that the current URL is the expected URL
        wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/checkout/onepage/success/"));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://magento.softwaretestingboard.com/checkout/onepage/success/");
    }
}