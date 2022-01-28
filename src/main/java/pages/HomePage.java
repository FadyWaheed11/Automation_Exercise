package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public record HomePage(WebDriver driver) {

    private static final By signUpLink = By.xpath("//a[@href='/login']");

    public RegisterPage clickOnRegisterPage() {
        driver.findElement(signUpLink).click();
        return new RegisterPage(driver);
    }
}
