package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPage {
    private final WebDriver driver;
    private final By userNamePath = By.xpath("//a[contains(.,'Logged in')]");
    private final By deleteButtonPath = By.xpath("//a[@href='/delete_account']");

    public UserMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName() {
        return driver.findElement(userNamePath).getText();
    }

    public void deleteAccount(){
        driver.findElement(deleteButtonPath).click();
    }
}
