package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static DriverSettings.DriverManager.getDriver;
import static Utilities.Utility.*;

public class P02_Checkout {
    private final WebDriver driver;
    By emailInput = By.id("customer-email");
    By firstNameInput = By.xpath("//input[@name=\"firstname\"]");
    By lastNameInput = By.xpath("//input[@name=\"lastname\"]");
    By addressInput = By.xpath("//input[@name=\"street[0]\"]");
    By cityInput = By.xpath("//input[@name=\"city\"]");
    By stateInput = By.xpath("//select[@name=\"region_id\"]"); // <Select> element List
    By zipCodeInput = By.xpath("//input[@name=\"postcode\"]");
    By phoneInput = By.xpath("//input[@name=\"telephone\"]");
    By shipMethod = By.cssSelector("tr:nth-child(1) > td:nth-child(1) > input");
    By nextButton = By.xpath("//button[@class=\"button action continue primary\"]");
    public By checkoutButton = By.xpath("//button[@class=\"action primary checkout\"]");


    // TODO: Create a constructor
    public P02_Checkout(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: Create a method to enter email
    public P02_Checkout enterEmail(String email) {
        enterData(driver, emailInput, email);
        return this;
    }

    //TODO: Create a method to enter first name
    public P02_Checkout enterFirstName(String firstName) {
        enterData(driver, firstNameInput, firstName);
        return this;
    }

    //TODO: Create a method to enter last name
    public P02_Checkout enterLastName(String lastName) {
        enterData(driver, lastNameInput, lastName);
        return this;
    }

    //TODO: Create a method to enter address
    public P02_Checkout enterAddress(String address) {
        enterData(driver, addressInput, address);
        return this;
    }
    //TODO: Create a method to enter city
    public P02_Checkout enterCity(String city) {
        enterData(driver, cityInput, city);
        return this;
    }
    //TODO: Create a method to enter state
    public P02_Checkout enterState(String state) {
        selectingFromDropDown(driver, stateInput, state);
        return this;
    }
    //TODO: Create a method to enter zip code
    public P02_Checkout enterZipCode(String zipCode) {
        enterData(driver, zipCodeInput, zipCode);
        return this;
    }
    //TODO: Create a method to enter phone number
    public P02_Checkout enterPhoneNumber(String phoneNumber) {
        enterData(driver, phoneInput, phoneNumber);
        return this;
    }
    //TODO: Create a method to select shipping method
    public P02_Checkout selectShippingMethod() {
        clickingOnElement(driver, shipMethod);
        return this;
    }

    //TODO: Create a method to click on the next button
    public P02_Checkout clickNextButton() {
        clickingOnElement(driver, nextButton);
        return this;
    }

    //TODO: Create a method to click on the checkout button
    public P02_Checkout clickCheckoutButton() throws InterruptedException {
        Thread.sleep(3000);

        clickingOnElement(driver, checkoutButton);
        // Wait for the checkout button to be clickable

        return this;
    }



}
