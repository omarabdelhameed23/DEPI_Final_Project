import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterUserTest {
    WebDriver driver;
    HomePage homePage;
    SignUpPage signupPage;
    AccountFormPage accountInfoPage;
    AccountCreatedPage accountCreatedPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePage(driver);
        signupPage = new SignUpPage(driver);
        accountInfoPage = new AccountFormPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
    }

    @Test
    public void registerNewUser() {
        // Step 1: Verify home page
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");

        // Step 2: Click on 'Signup / Login'
        homePage.clickOnSignupLogin();

        // Step 3: Verify 'New User Signup!' is visible
        Assert.assertTrue(signupPage.isNewUserSignupVisible());

        // Step 4-6: Enter name and email address
        signupPage.enterNameAndEmail("ahmed", "tester104@gmail.com");

        // Step 7: Click 'Signup' button
        signupPage.clickSignupButton();

        // Step 8: Verify 'Enter Account Information' is visible
        Assert.assertTrue(accountInfoPage.isAccountInfoVisible());

        // Step 9-12: Fill out account information and newsletter
        accountInfoPage.fillAccountDetails(
                "test123", "ahmed", "mohammed", "abc Company",
                "123 asd St", "asd 24", "NasrCity",
                "Cairo", "12345", "1234567890"
        );

        // Step 13: Click 'Create Account'
        accountInfoPage.clickCreateAccount();

        // Step 14: Verify 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(accountCreatedPage.isAccountCreatedVisible());

        // Step 15: Click 'Continue' button
        accountCreatedPage.clickContinueButton();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}