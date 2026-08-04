package com.epam.ta.page;

import com.epam.ta.driver.DriverManager;
import com.epam.ta.utilities.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected final Logger log =
            LogManager.getLogger(getClass());
    protected WebDriver driver;
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(Config.getInt("timeout.seconds"));


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

    protected boolean areElementsDisplayed(WebElement... elements) {
        for (WebElement element : elements) {
            log.info("Checking element: {}", element);

            if (!isElementDisplayed(element)) {
                log.error("Element is NOT displayed: {}", element);
                return false;
            }
        }

        return true;
    }
}
