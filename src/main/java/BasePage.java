import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void hoverOverElement(WebElement element) {
        actions.moveToElement(element).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public boolean isElementVisible(By element) {
        return driver.findElement(element).isDisplayed();
    }
}