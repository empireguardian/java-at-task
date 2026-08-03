package com.epam.ta.test;

import com.epam.ta.driver.DriverManager;
import com.epam.ta.page.InventoryPage;
import com.epam.ta.page.ItemPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InventoryItemPageLayoutTest extends BaseTest {

    @Test(description = "UC-3", priority = 3)
    public void test() {
        InventoryPage inventoryPage = loginAsStandardUser();
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        ItemPage tShirtPage = inventoryPage.openTShirt();
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=1");
        Assert.assertTrue(tShirtPage.areMainPageElementsDisplayed(), "Not all main elements are displayed");
        Assert.assertTrue(tShirtPage.areProductElementsDisplayed(), "Not all product elements are displayed");

    }

}
