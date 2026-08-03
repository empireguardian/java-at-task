package com.epam.ta.test;

import com.epam.ta.driver.DriverManager;
import com.epam.ta.page.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class InventoryPageLayoutTest extends BaseTest {

    @Test(description = "UC-2", priority = 2)
    public void Test() {

        InventoryPage inventoryPage = loginAsStandardUser();
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(inventoryPage.areMainPageElementsDisplayed(), "Not all main elements are displayed");
        List<String> missingOptions = inventoryPage.getMissingDropdownElements();
        Assert.assertTrue(missingOptions.isEmpty(), "Missing dropdown elements: " + missingOptions);
        Assert.assertTrue(inventoryPage.isMenuIconDisplayed(), "Menu icon is absent");
        inventoryPage.openMenu();
        Assert.assertTrue(inventoryPage.areMenuElementsDisplayed(), "Not all menu elements are displayed");
    }

}
