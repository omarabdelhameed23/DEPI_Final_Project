import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidLoginTest {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    LoggedInPage loggedInPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        loggedInPage = new LoggedInPage(driver);
    }

    @Test
    public void loginUserWithCorrectCredentials() {
        // Step 1: Verify home page is visible
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");

        // Step 2: Click on 'Signup / Login' button
        homePage.clickOnSignupLogin();

        // Step 3: Verify 'Login to your account' is visible
        Assert.assertTrue(loginPage.isLoginToYourAccountVisible());

        // Step 4: Enter correct email and password
        loginPage.enterEmailAndPassword("tester104@gmail.com", "test123");

        // Step 5: Click 'Login' button
        loginPage.clickLoginButton();

        // Step 6: Verify 'Logged in as username' is visible
        Assert.assertTrue(loggedInPage.isLoggedInAsVisible());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}