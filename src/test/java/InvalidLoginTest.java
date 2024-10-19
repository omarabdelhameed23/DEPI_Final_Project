
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class InvalidLoginTest {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithIncorrectCredentials() {
        // Step 1: Verify home page is visible
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");

        // Step 2: Click on 'Signup / Login' button
        homePage.clickOnSignupLogin();

        // Step 3: Verify 'Login to your account' is visible
        Assert.assertTrue(loginPage.isLoginToYourAccountVisible());

        // Step 4: Enter incorrect email and password
        loginPage.enterEmailAndPassword("second203@gmail.com", "test123");

        // Step 5: Click 'Login' button
        loginPage.clickLoginButton();

        // Step 6: Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue(loginPage.isErrorVisible());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}