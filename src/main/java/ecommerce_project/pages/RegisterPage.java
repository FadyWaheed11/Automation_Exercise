package ecommerce_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ecommerce_project.DriverFactory.getChromeDriver;

public class RegisterPage {
    private final WebDriver driver = getChromeDriver();
    private final By namePath = By.xpath("//input[@data-qa='signup-name']");
    private final By passwordPath = By.name("password");
    private final By signUpButtonPath = By.xpath("//button[@data-qa='signup-button']");
    private final By loginButtonPath = By.xpath("//button[@data-qa='login-button']");


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

    public RegisterPage enterUserName(String userName) {
        driver.findElement(namePath).sendKeys(userName);
        return this;
    }

    public RegisterPage enterEmailAddressSignUp(String email) {
        enterEmailAddress("//input[@data-qa='signup-email']", email);
        return this;
    }

    public RegisterPage enterEmailAddressLogin(String email) {
        enterEmailAddress("//input[@data-qa='login-email']", email);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        driver.findElement(passwordPath).sendKeys(password);
        return this;
    }

    public SignUpPage signUp() {
        driver.findElement(signUpButtonPath).click();
        return new SignUpPage();
    }

    public UserMainPage login() {
        driver.findElement(loginButtonPath).click();
        return new UserMainPage();
    }

    private boolean isVisible(String path) {
        return driver.findElement(By.xpath(path)).isDisplayed();
    }

    private void enterEmailAddress(String path, String email) {
        driver.findElement(By.xpath(path)).sendKeys(email);
    }
}
