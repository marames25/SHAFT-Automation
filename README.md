# SHAFT Automation Task #2

## Overview

Web automation testing project built using **SHAFT Engine, Selenium WebDriver, Java, and TestNG**.

The project automates login and checkout scenarios on the **SauceDemo** application.

**Website:** https://www.saucedemo.com

---

## Tech Stack

- Java
- Selenium WebDriver
- SHAFT Engine
- TestNG
- Maven
- Page Object Model (POM)
- Excel & JSON Test Data
- Allure Reports

---

## Test Coverage

### Login

Login scenarios are implemented using both **Excel** and **JSON** test data:

- Valid Login
- Invalid Login
- Locked User Login

### Checkout

- Login with a valid user
- Add two products to the cart
- Proceed to checkout
- Enter checkout information
- Complete the order
- Verify successful order completion

---

## Project Structure

```text
SHAFT-Automation-Task-2
│
├── .github
│
├── src
│   └── test
│       ├── java
│       │   ├── base
│       │   │   └── BaseTest.java
│       │   │
│       │   ├── pages
│       │   │   ├── LoginPage.java
│       │   │   ├── ProductsPage.java
│       │   │   ├── CartPage.java
│       │   │   └── CheckoutPage.java
│       │   │
│       │   └── testPackage
│       │       ├── ExcelLoginTest.java
│       │       ├── JsonLoginTest.java
│       │       └── CheckoutTest.java
│       │
│       └── resources
│           └── testDataFiles
│               ├── loginTest.xlsx
│               └── loginTest.json
│
├── smoke.xml
├── parallel-testing.xml
├── pom.xml
├── allurerc.yaml
├── generate_allure_report.bat
├── README.md
└── .gitignore
```

---

## Framework Design

The project follows the **Page Object Model (POM)** design pattern.

- `BaseTest` handles browser setup and teardown.
- Page classes contain locators and page actions.
- Test classes contain test scenarios and validations.
- Test data is separated from the automation code using Excel and JSON files.
- TestNG priorities are used to control test execution order.

---

## Test Suites

### Smoke Testing

The `smoke.xml` file contains the main smoke test scenarios.

Run the smoke suite using:

```text
mvn test -DsuiteXmlFile=smoke.xml
```

## Browser Support

The tests support the following browsers:

- Chrome
- Edge
- Firefox

The browser can be selected using the Maven system property:

```text
mvn clean test -Dbrowser=chrome
mvn clean test -Dbrowser=edge
mvn clean test -Dbrowser=firefox
```
### Parallel Testing

The `parallel-testing.xml` file is used to execute multiple test cases in parallel.

Run the parallel suite using:

```text
mvn test -DsuiteXmlFile=parallel-testing.xml
```

---

## Execution

Run the complete test suite using:

```text
mvn clean test
```

---

## Allure Report

Allure is used to generate test execution reports.

Generate the Allure report using:

```text
generate_allure_report.bat
```



---

## Execution Video

 **[Watch Test Execution](https://drive.google.com/file/d/1ZUZpdCcQ_zNvd1jwWctFLkn9ht08fdq0/view?usp=drive_link)**


---
