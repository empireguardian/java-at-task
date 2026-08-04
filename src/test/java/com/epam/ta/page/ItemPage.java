package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage{


    @FindBy(xpath = "//div[text()='Swag Labs']")
    private WebElement logo;

    @FindBy(css = "[data-test='item-sauce-labs-bolt-t-shirt-img']")
    private WebElement productImage;

    @FindBy(css = "[data-test='inventory-item-name']")
    private WebElement productName;

    @FindBy(css = "[data-test='inventory-item-desc']")
    private WebElement productDescription;

    @FindBy(css = "[data-test='inventory-item-price']")
    private WebElement productPrice;

    @FindBy(css = "[data-test='add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(css = "[data-test='back-to-products']")
    private WebElement backToProductsButton;

    @FindBy(css = "[data-test='shopping-cart-link']")
    private WebElement shoppingCart;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuIcon;

    @FindBy(css = "[data-test='social-twitter']")
    private WebElement twitter;

    @FindBy(css = "[data-test='social-facebook']")
    private WebElement facebook;

    @FindBy(css = "[data-test='social-linkedin']")
    private WebElement linkedIn;


    public boolean areMainPageElementsDisplayed() {

        return areElementsDisplayed(
                logo,
                shoppingCart,
                twitter,
                facebook,
                linkedIn,
                backToProductsButton,
                menuIcon
        );
    }

    public boolean areProductElementsDisplayed() {

        return areElementsDisplayed(
                productImage,
                productName,
                productDescription,
                productPrice,
                addToCartButton
        );
    }
}
