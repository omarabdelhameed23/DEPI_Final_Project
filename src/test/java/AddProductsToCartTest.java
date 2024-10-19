import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class AddProductsToCartTest {
    private WebDriver driver;
    private HomePagee homePage;
    private ProductsPage productsPage;

    @BeforeMethod
    public void setUp() {
        // Setup WebDriver (Chrome)
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize Page Objects
        homePage = new HomePagee(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void testAddProductsToCart() {
        // Step 1: Launch browser and navigate to URL
        homePage.navigateTo("http://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 2: Verify home page is visible
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        // Step 3: Click 'Products' button
        homePage.clickProductsButton();

        // Step 4: Hover over first product and click 'Add to cart'
        productsPage.addFirstProductToCart();

        // Step 5: Click 'View Cart' button
        productsPage.clickViewCartButton();

    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}