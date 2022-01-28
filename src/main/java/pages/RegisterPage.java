package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver driver;
    private final By namePath = By.xpath("//input[@data-qa='signup-name']");
    private final By passwordPath = By.name("password");
    private final By signUpButtonPath = By.xpath("//button[@data-qa='signup-button']");
    private final By loginButtonPath = By.xpath("//button[@data-qa='login-button']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSignUpHeadLineVisible() {
        return isVisible("//h2[contains(text(),'New User Signup!')]");
    }

    public boolean isLoginHeadLineVisible() {
        return isVisible("//h2[contains(.,'Login to your account')]");
    }

    public boolean isLoginErrorMessageVisible() {
        return isVisible("//p[contains(.,'Your email or password is incorrect!')]");
    }

    public boolean isRegisterErrorMessageVisible(){
        return isVisible("//p[contains(.,'Email Address already exist!')]");
    }

    public void enterUserName(String userName) {
        driver.findElement(namePath).sendKeys(userName);
    }

    public void enterEmailAddressSignUp(String email) {
        enterEmailAddress("//input[@data-qa='signup-email']", email);
    }

    public void enterEmailAddressLogin(String email) {
        enterEmailAddress("//input[@data-qa='login-email']", email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordPath).sendKeys(password);
    }

    public SignUpPage signUp() {
        driver.findElement(signUpButtonPath).click();
        return new SignUpPage(driver);
    }

    public UserMainPage login() {
        driver.findElement(loginButtonPath).click();
        return new UserMainPage(driver);
    }

    private boolean isVisible(String path) {
        return driver.findElement(By.xpath(path)).isDisplayed();
    }

    private void enterEmailAddress(String path, String email) {
        driver.findElement(By.xpath(path)).sendKeys(email);
    }
}
