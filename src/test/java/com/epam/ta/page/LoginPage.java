package com.epam.ta.page;

import com.epam.ta.utilities.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    private static final Logger log =
            LogManager.getLogger(LoginPage.class);

    @FindBy(css = "[data-test='username']")
    private WebElement usernameField;

    @FindBy(css = "[data-test='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[text() = 'Swag Labs']")
    private WebElement loginLogo;

    @FindBy(css = "[data-test='login-button']")
    private WebElement buttonLogin;

    public LoginPage() {
        super();
    }

    public LoginPage openPage() {
        driver.get(Config.get("base.url"));
        log.info("Opening login page");
        return this;
    }

    public InventoryPage login() {
        usernameField.sendKeys(Config.get("username"));
        passwordField.sendKeys(Config.get("password"));
        buttonLogin.click();
        log.info("Login as 'standard_user'");
        return new InventoryPage();
    }

    public boolean isUsernameFieldDisplayed() {
        log.info("Checking username field");
        return isElementDisplayed(usernameField);
    }

    public boolean isPasswordFieldDisplayed() {
        log.info("Checking password field");
        return isElementDisplayed(passwordField);
    }

    public boolean isLoginLogoDisplayed() {
        log.info("Checking logo");
        return isElementDisplayed(loginLogo);
    }

    public boolean isButtonLoginDisplayed() {
        log.info("Checking 'Login' button");
        return isElementDisplayed(buttonLogin);
    }
}
