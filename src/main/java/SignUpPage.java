import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    WebDriver driver;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    WebElement newUserSignupText;

    @FindBy(name = "name")
    WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    WebElement emailInput;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signupButton;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isNewUserSignupVisible() {
        return newUserSignupText.isDisplayed();
    }

    public void enterNameAndEmail(String name, String email) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
    }

    public void clickSignupButton() {
        signupButton.click();
    }
}