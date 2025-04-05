package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static DriverSettings.DriverManager.getDriver;
import static Utilities.Utility.*;

public class P01_ItemsPage {
    private final WebDriver driver;

    // Locators
    By sizeButton = By.id("option-label-size-143-item-166");
    By colorButton = By.id("option-label-color-93-item-50");
    By addToCartButton = By.xpath("//span[text()='Add to Cart']");
    By itemTitle = By.cssSelector(".products-grid > ol > li:nth-child(1) > div > div > strong > a");
    By addToCartSuccessMessage = By.xpath("//div[2]/div[2]/div/div/div");
    By searchInput = By.id("search");
    By cartIcon = By.xpath("//a[contains(@class, \"action showcart\")]");
    By cartCheckoutButton = By.id("top-cart-btn-checkout");
    By cartCounter = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div");



    // TODO: Create a constructor
    public P01_ItemsPage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: Create a method to click on the size button
    public P01_ItemsPage clickSizeButton() {
        clickingOnElement(driver, sizeButton);
        return this;
    }

    //TODO: Create a method to click on the color button
    public P01_ItemsPage clickColorButton() {
        clickingOnElement(driver, colorButton);
        return this;
    }

    //TODO: Create a method to click on the add to cart button
    public P01_ItemsPage clickAddToCartButton() {
        clickingOnElement(driver, addToCartButton);
        return this;
    }

    //TODO: Create a method to get the item title
    public String getItemTitle() {
        return getText(driver, itemTitle);
    }

    //TODO: Create a method to get the add to cart success message
    public String getAddToCartSuccessMessage() {
        return getText(driver, addToCartSuccessMessage);
    }

    //TODO: Create a method to check if the add to cart success message is displayed
    public boolean isAddToCartSuccessMessageDisplayed() {
        return getAddToCartSuccessMessage().contains(getItemTitle());
    }

    //TODO: Create a method to search for a product
    public P01_ItemsPage searchForProduct(String searchTerm) {
        enterData(driver, searchInput, searchTerm);
        // Click enter key
        driver.findElement(searchInput).sendKeys("\n");
        return this;
    }

    //TODO: Create a method to click on the cart icon
    public P01_ItemsPage clickCartIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(cartCounter));

        clickingOnElement(driver, cartIcon);
        return this;
    }

    //TODO: Create a method to click on the checkout button
    public P01_ItemsPage clickCheckoutButton() {
        clickingOnElement(driver, cartCheckoutButton);
        return this;
    }


}
