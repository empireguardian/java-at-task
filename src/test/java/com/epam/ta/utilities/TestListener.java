package com.epam.ta.utilities;

import com.epam.ta.driver.DriverManager;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;


public class TestListener implements ITestListener {

    private static final Logger log =
            LogManager.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        attachScreenshot();
        attachPageSource();
    }

    private void attachScreenshot() {
        WebDriver driver = DriverManager.getDriver();

        if (driver == null) {
            log.warn("WebDriver is null. Screenshot cannot be taken");
            return;
        }

        try {
            byte[] screenshot =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(
                    "Failure Screenshot",
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    ".png"
            );
            log.info("Screenshot attached to Allure report");
        } catch (Exception e) {
            log.error("Failed to attach screenshot", e);
        }
    }

    private void attachPageSource() {
        WebDriver driver = DriverManager.getDriver();

        if (driver == null) {
            log.warn("WebDriver is null. Page source cannot be taken");
            return;
        }

        try {
            String pageSource = driver.getPageSource();

            Allure.addAttachment(
                    "Page Source",
                    "text/html",
                    new ByteArrayInputStream(
                            pageSource.getBytes(StandardCharsets.UTF_8)),
                    ".html"
            );

            log.info("Page source attached to Allure report");

        } catch (Exception e) {

            log.error("Failed to attach page source", e);
        }
    }
}
