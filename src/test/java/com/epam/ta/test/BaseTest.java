package com.epam.ta.test;

import com.epam.ta.driver.DriverFactory;
import com.epam.ta.driver.DriverManager;
import com.epam.ta.page.InventoryPage;
import com.epam.ta.page.LoginPage;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser) {
        DriverManager.setBrowser(browser);
        ThreadContext.put("browser", browser);

        WebDriver driver = DriverFactory.createDriver(browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
        ThreadContext.clearAll();
    }

    protected InventoryPage loginAsStandardUser() {
        return  new LoginPage().openPage().login();
    }
}
