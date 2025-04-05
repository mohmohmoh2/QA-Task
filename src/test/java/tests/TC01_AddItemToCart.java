package tests;

import Driver.DriverSetup;
import Pages.P01_ItemsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static DriverSettings.DriverManager.*;

public class TC01_AddItemToCart extends DriverSetup {

    @Test
    public void addItemToCart(){
         P01_ItemsPage itemsPage = new P01_ItemsPage(getDriver());

            // add item to cart
         itemsPage.clickSizeButton()
                 .clickColorButton()
                 .clickAddToCartButton();


            // Check if the item is added to the cart successfully or not
            Assert.assertTrue(itemsPage.isAddToCartSuccessMessageDisplayed());
    }

}
