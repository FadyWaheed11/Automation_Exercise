package ecommerce_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ecommerce_project.DriverFactory.getChromeDriver;

public class AccountCreated {
    private final WebDriver driver = getChromeDriver();
    private final By bAccountCreatedTextPath = By.xpath("//b[contains(.,'Account Created!')]");
    private final By continueButtonPath = By.linkText("Continue");

    public boolean isAccountCreatedVisible() {
        return driver.findElement(bAccountCreatedTextPath).isDisplayed();
    }

    public UserMainPage pressContinue(){
        driver.findElement(continueButtonPath).click();
        return new UserMainPage();
    }
}
