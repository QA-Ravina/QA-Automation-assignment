# QA-Automation-assignment
E-Commerce Product Automation
This project automates a product search, filtering, selection, and adding to the cart on an e-commerce website using Selenium WebDriver with Java.

Key Features:
Search for a product ( "Laptop").
Filter results by brand.
Select a product from the filtered results.
Verify the product's title and price.
Add the product to the cart.
Take a screenshot of the cart to verify the product has been added.

Tools and Technologies Used:
Selenium WebDriver: For interacting with the browser and automating user actions.
Java: The programming language for writing the test.
JUnit: To structure the tests.
Maven: To manage project dependencies.
WebDriverManager: To automatically handle the WebDriver setup (ChromeDriver).
Flipkart: Target website for the automation flow.

Approach:
Initialization: The WebDriver is set up using WebDriverManager. A ChromeDriver instance is created, and the browser window is maximized.
Product Search: The script searches for a product by sending the term "Laptop" into the Flipkart search bar.
Brand Filtering: The script applies a filter for a specific brand ("HP").
Product Selection: The script selects the first product from the filtered results.
Product Verification: The script captures the product title and price.
Add to Cart: The product is added to the cart, and a screenshot is taken as proof of successful addition.
Teardown: The browser is closed at the end of the test.

Project Setup:
Clone the repository
Install dependencies
Run the tests
Screenshot