import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountFormPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/h2/b")
    WebElement accountInfoText;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"newsletter\"]")
    WebElement newsletterCheckbox;

    @FindBy(xpath = "//*[@id=\"optin\"]")
    WebElement specialOffersCheckbox;

    @FindBy(xpath = "//*[@id=\"first_name\"]")
    WebElement firstNameInput;

    @FindBy(xpath = "//*[@id=\"last_name\"]")
    WebElement lastNameInput;

    @FindBy(xpath = "//*[@id=\"company\"]")
    WebElement companyInput;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    WebElement address1Input;

    @FindBy(xpath = "//*[@id=\"address2\"]")
    WebElement address2Input;

    @FindBy(xpath = "//*[@id=\"state\"]")
    WebElement stateInput;

    @FindBy(xpath = "//*[@id=\"city\"]")
    WebElement cityInput;

    @FindBy(xpath = "//*[@id=\"zipcode\"]")
    WebElement zipcodeInput;

    @FindBy(xpath = "//*[@id=\"mobile_number\"]")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/form/button")
    WebElement createAccountButton;

    public AccountFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAccountInfoVisible() {
        return accountInfoText.isDisplayed();
    }

    public void fillAccountDetails(String password, String firstName, String lastName, String company,
                                   String address1, String address2, String state, String city,
                                   String zipcode, String mobileNumber) {
        passwordInput.sendKeys(password);
        newsletterCheckbox.click();
        specialOffersCheckbox.click();
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        companyInput.sendKeys(company);
        address1Input.sendKeys(address1);
        address2Input.sendKeys(address2);
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zipcode);
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }
}