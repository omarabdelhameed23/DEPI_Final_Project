
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    WebElement accountCreatedText;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    WebElement continueButton;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAccountCreatedVisible() {
        return accountCreatedText.isDisplayed();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}