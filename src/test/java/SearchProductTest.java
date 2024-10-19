import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class SearchProductTest {
    private WebDriver driver;
    private HomePagee homePage;
    private ProductsPage productsPage;
    private SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void setUp() {
        // Setup WebDriver (Chrome)
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize Page Objects
        homePage = new HomePagee(driver);
        productsPage = new ProductsPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void testSearchProduct() {
        // Step 1: Launch browser and navigate to URL
        homePage.navigateTo("http://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 2: Verify home page is visible
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        // Step 3: Click 'Products' button
        homePage.clickProductsButton();

        // Step 4: Verify user is on All Products page
        Assert.assertTrue(productsPage.isProductsPageVisible(), "All Products page is not visible");

        // Step 5: Enter product name in search input and click search button
        productsPage.searchProduct("T-shirt");

        // Step 6: Verify 'Searched Products' section is visible
        Assert.assertTrue(productsPage.isSearchedProductsVisible(), "'Searched Products' section is not visible");

        // Step 7: Verify all products related to search are visible
        Assert.assertTrue(searchResultsPage.areSearchResultsVisible(), "Search results are not visible");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}