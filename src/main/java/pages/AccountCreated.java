package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreated {
    private final WebDriver driver;
    private final By bAccountCreatedTextPath = By.xpath("//b[contains(.,'Account Created!')]");
    private final By continueButtonPath = By.linkText("Continue");
    public AccountCreated(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountCreatedVisible() {
        return driver.findElement(bAccountCreatedTextPath).isDisplayed();
    }

    public UserMainPage pressContinue(){
        driver.findElement(continueButtonPath).click();
        return new UserMainPage(driver);
    }
}
