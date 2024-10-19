import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePagee extends BasePage {
    // Locators
    private By productsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");

    public HomePagee(WebDriver driver) {
        super(driver);
    }

    // Action: Click 'Products' button
    public void clickProductsButton() {
        driver.findElement(productsButton).click();
    }

    // Verify if home page is visible
    public boolean isHomePageVisible() {
        return getPageTitle().contains("Automation Exercise");
    }
}