import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedInPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    WebElement loggedInAsText;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    WebElement deleteAccountButton;

    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoggedInAsVisible() {
        return loggedInAsText.isDisplayed();
    }

    public void clickDeleteAccount() {
        deleteAccountButton.click();
    }
}