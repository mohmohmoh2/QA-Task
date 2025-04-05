package tests;

import Driver.DriverSetup;
import Pages.P01_ItemsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static DriverSettings.DriverManager.getDriver;
import static Utilities.DataUtils.getJsonData;

public class TC02_ValidProductSearch extends DriverSetup {

    @Test
    public void testValidProductSearch() throws IOException {
        // Create an instance of the items page
        P01_ItemsPage itemsPage = new P01_ItemsPage(getDriver());

        // Perform a search for a valid product
        itemsPage.searchForProduct(getJsonData("information", "searchWord"));

        // Verify that the search results are displayed
        Assert.assertTrue(itemsPage.getItemTitle().contains(getJsonData("information", "searchWord")));

    }
}
