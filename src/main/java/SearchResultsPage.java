import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {
    // Locators
    private By productsList = By.xpath("/html/body/section[2]/div/div/div[2]/div");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    // Verify all products related to the search are visible
    public boolean areSearchResultsVisible() {
        return isElementVisible(productsList);
    }
}