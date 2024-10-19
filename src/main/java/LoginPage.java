import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/h2")
    WebElement loginToYourAccountText;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/p")
    WebElement incorrectCredentialsError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoginToYourAccountVisible() {
        return loginToYourAccountText.isDisplayed();
    }

    public void enterEmailAndPassword(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isErrorVisible() {
        return incorrectCredentialsError.isDisplayed();
    }
}