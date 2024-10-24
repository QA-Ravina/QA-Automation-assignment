# QA-Automation-assignment

## Assignment 1: E-Commerce Product Automation
This project automates a product search, filtering, selection, and adding to the cart on an e-commerce website using Selenium WebDriver with Java.

### Key Features
Search for a product ( "Laptop").
Filter results by brand.
Select a product from the filtered results.
Verify the product's title and price.
Add the product to the cart.
Take a screenshot of the cart to verify the product has been added.

### Tools and Technologies Used
Selenium WebDriver: For interacting with the browser and automating user actions.
Java: The programming language for writing the test.
JUnit: To structure the tests.
Maven: To manage project dependencies.
WebDriverManager: To automatically handle the WebDriver setup (ChromeDriver).
Flipkart: Target website for the automation flow.

### Approach
Initialization: The WebDriver is set up using WebDriverManager. A ChromeDriver instance is created, and the browser window is maximized.
Product Search: The script searches for a product by sending the term "Laptop" into the Flipkart search bar.
Brand Filtering: The script applies a filter for a specific brand ("HP").
Product Selection: The script selects the first product from the filtered results.
Product Verification: The script captures the product title and price.
Add to Cart: The product is added to the cart, and a screenshot is taken as proof of successful addition.
Teardown: The browser is closed at the end of the test.

### Project Setup
Clone the repository
Install dependencies
Run the tests
Screenshot

## Assignment 2: API Testing Project

### Overview
This project contains automated tests for the ReqRes API using **RestAssured** and **TestNG**. The tests validate various API endpoints including user retrieval, creation, updating, and deletion, as well as JSON schema validation for API responses.

### Key Features
- Get list of users.
- Get user by ID.
- Create, update, and delete users.
- Validate JSON schema of responses.

### Tools and Technologies Used
- RestAssured: For API testing.
- TestNG: For structuring the tests.
- Jackson: For reading JSON data files.

### Setup Instructions
1. Clone the repository.
2. Import as a Maven project.
3. Install dependencies using `mvn clean install`.

### Running the Tests
- From the IDE or command line using `mvn test`.

