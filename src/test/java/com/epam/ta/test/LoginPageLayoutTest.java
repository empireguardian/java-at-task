package com.epam.ta.test;

import com.epam.ta.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageLayoutTest extends BaseTest {
    @Test(description = "UC-1", priority = 1)
    public void Test() {

        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field is absent");
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field is absent");
        Assert.assertTrue(loginPage.isLoginLogoDisplayed(), "Login logo is absent");
        Assert.assertTrue(loginPage.isButtonLoginDisplayed(), "Button 'Login' field is absent");

    }
}
