package com.epam.ta.page;

import com.epam.ta.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);


    protected BasePage(){
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            new WebDriverWait(
                    DriverManager.getDriver(),
                    WAIT_TIMEOUT_SECONDS
            ).until(ExpectedConditions.visibilityOf(webElement));

            return true;

        } catch (TimeoutException e) {
            return false;
        }
    }
}
