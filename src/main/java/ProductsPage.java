import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ProductsPage extends BasePage {
    // Locators
    private By searchInput = By.xpath("//*[@id=\"search_product\"]");
    private By searchButton = By.xpath("//*[@id=\"submit_search\"]");
    private By searchedProductsHeader = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    private By firstProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a");
    private By addToCartButton = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
    private By viewProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    private By viewCartButton = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    // Verify if user is on All Products page
    public boolean isProductsPageVisible() {
        return driver.getCurrentUrl().contains("products");
    }

    // Action: Enter product name in the search box and click the search button
    public void searchProduct(String productName) {
        driver.findElement(searchInput).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    // Verify if 'Searched Products' section is visible
    public boolean isSearchedProductsVisible() {
        return isElementVisible(searchedProductsHeader);
    }

    // Action: Hover over first product and click 'Add to cart'
    public void addFirstProductToCart() {
        WebElement product1 = driver.findElement(firstProduct);
        hoverOverElement(product1);
        driver.findElement(viewProduct).click();
        driver.findElement(addToCartButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Action: Click 'View Cart' button
    public void clickViewCartButton() {
        driver.findElement(viewCartButton).click();
    }
}