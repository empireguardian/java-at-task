package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage{

    private final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

    @FindBy(xpath = "//div[text()='Swag Labs']")
    private WebElement logo;

    @FindBy(css = "[data-test='shopping-cart-link']")
    private WebElement shoppingCart;

    @FindBy(css = "[data-test='social-twitter']")
    private WebElement twitter;

    @FindBy(css = "[data-test='social-facebook']")
    private WebElement facebook;

    @FindBy(css = "[data-test='social-linkedin']")
    private WebElement linkedIn;

    @FindBy(css = "[data-test='product-sort-container']")
    private WebElement sortingDropdown;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuIcon;

    @FindBy(css = "[data-test='inventory-sidebar-link']")
    private WebElement menuAllItems;

    @FindBy(css = "[data-test='about-sidebar-link']")
    private WebElement menuAbout;

    @FindBy(css = "[data-test='logout-sidebar-link']")
    private WebElement menuLogout;

    @FindBy(css = "[data-test='reset-sidebar-link']")
    private WebElement menuResetAppState;

    @FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']")
    private WebElement tShirt;

    public InventoryPage() {
        super();
    }

    public boolean areMainPageElementsDisplayed() {
        return areElementsDisplayed(
                logo,
                shoppingCart,
                twitter,
                facebook,
                linkedIn,
                sortingDropdown
        );
    }

    public List<String> getMissingDropdownElements() {
        log.info("Starting dropdown options verification");
        Select select = new Select(sortingDropdown);
        List<String> actualOptions = new ArrayList<>();

        for(WebElement option : select.getOptions()) {
            actualOptions.add(option.getText());
        }

        List<String> expectedOptions = List.of(
                "Name (A to Z)",
                "Name (Z to A)",
                "Price (low to high)",
                "Price (high to low)"
        );

        List<String> missingOptions = new ArrayList<>();

        for(String expectedOption : expectedOptions) {
            if(!actualOptions.contains(expectedOption)) {
                missingOptions.add(expectedOption);
            }
        }
        return missingOptions;
    }

    public boolean isMenuIconDisplayed() {
        log.info("Checking menu icon");
        return isElementDisplayed(menuIcon);
    }

    public void openMenu() {
        log.info("Opening menu");
        menuIcon.click();
    }

    public boolean areMenuElementsDisplayed() {

        return areElementsDisplayed(
                menuAllItems,
                menuAbout,
                menuLogout,
                menuResetAppState
        );
    }

    public ItemPage openTShirt() {
        tShirt.click();
        log.info("Opening T-Shirt page");
        return new ItemPage();
    }
}
