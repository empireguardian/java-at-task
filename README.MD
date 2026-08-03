# SauceDemo UI Automation Tests

## Task Description

### The layout validation

**Focus:** Pages layouts

**Launch URL:** https://www.saucedemo.com

### UC-1 Login Page Layout

Open Login page.

Verify the page contains: "Username" field, "Password" field, "Login" button and "Swag Labs" text on the top.

### UC-2 Inventory page layout

Login with standard_user.

Verify user is redirected to the Inventory page.

Verify the page contains: "Swag Labs" text on the top of the page, Cart icon, Social networks links of Saucelabs: Twitter (X), Facebook, Linkedin, Sorting dropdown.

Verify the sorting dropdown contains: Name (A to Z), Name (Z to A), Price (low to high), Price (high to low)

Verify the page contains menu icon at top left corner.

Click the menu and verify it contains: All Items, About, Logout, Reset App State

### UC-3 Inventory item page layout

Login with standard_user.

Verify redirect to Inventory page.

Click on any inventory item.

Verify redirected to the item page.

Verify the page contains: "Swag Labs" text on the top of the page, Image of the product, Name of the product, Short description of the product, Price, "Add to cart" item, "Back to products" link, Cart icon, Menu button: Twitter (X), Facebook, Linkedin.

## Technical Requirements

Tool: Selenium WebDriver

Browsers: Chrome, Firefox (Run in Parallel)

Pattern: Page Object Model (POM)

Locators: CSS Selectors, Xpath

Reporting: Generate an Allure Report (or similar HTML report)

Documentation: Add a README.md explaining how to run tests and generate the report

## Requirements

Before running the project, make sure the following are installed:

* JDK 17.0.6
* Maven
* Google Chrome
* Mozilla Firefox
* Allure Commandline


The project was developed using:

```text
17.0.6
```


## Running Tests

To run all tests, execute the following command from the project root:

```bash
mvn clean test
```

The tests will be executed in Chrome and Firefox in parallel.

## Allure Report

After the tests are finished, Allure results will be stored in:

```text
target/allure-results
```

To generate and open the Allure Report for local preview, run:

```bash
allure serve target/allure-results
```

The report will be generated and opened automatically in the browser.

Alternatively, the report can be generated as static files:

```bash
allure generate target/allure-results --clean -o target/allure-report
```

The generated report will be available in:

```text
target/allure-report
```
