package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static ecommerce_project.DriverFactory.getChromeDriver;

public class BaseTests {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = getChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://www.automationexercise.com/");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
