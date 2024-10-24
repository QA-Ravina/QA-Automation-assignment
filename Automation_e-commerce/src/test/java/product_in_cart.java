import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import static org.junit.Assert.assertTrue;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class product_in_cart {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void setUp() {
        // Set the path for the ChromeDriver executable
        WebDriverManager.chromedriver().setup();

        // Initialize the ChromeDriver and WebDriverWait
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout

        // Open the e-commerce website
        driver.get("https://www.flipkart.com/");
    }

    @Test
    public void testAddProductToCart() throws IOException, InterruptedException {
        //  Search for a product ("Laptop")
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='Pke_EE']"));
        searchBox.click();
        searchBox.sendKeys("Laptop");
        searchBox.submit();

        WebElement brandFilter = wait.until(driver -> driver.findElement(By.xpath("//div[@class='fxf7w6 rgHxCQ']")));
        brandFilter.click();
        WebElement checkBox = driver.findElement(By.xpath("//div[@class='XqNaEv']"));
        checkBox.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='KzDlHZ']")));

        // Select the first product from the filtered results
        WebElement firstProduct = driver.findElement(By.xpath("(//div[contains(@class,'DOjaWF gdgoEp')]//div[@class='Otbq5D'])[1]"));
        Thread.sleep(2000);
        firstProduct.click();
        Thread.sleep(1000);

        driver.manage().window().maximize();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='C7fEHH']")));
        String productTitle = driver.findElement(By.xpath("(///div[@class='C7fEHH']")).getText();
        String productPrice = driver.findElement(By.xpath("//div[@class='Nx9bqj CxhGGd']")).getText(); // Adjust for actual price locator
        System.out.println("Product Title: " + productTitle);
        System.out.println("Product Price: " + productPrice);

        // Add the product to the cart

        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")));
        addToCartButton.click();

        // Take a screenshot of the cart
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("cart_screenshot.png");
        Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);


    }

    @After
    public void tearDown() {
        // Close the browser
            driver.quit();

    }
}
