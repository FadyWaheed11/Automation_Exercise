package ecommerce_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ecommerce_project.DriverFactory.getChromeDriver;

public class UserMainPage {
    private final WebDriver driver = getChromeDriver();
    private final By userNamePath = By.xpath("//a[contains(.,'Logged in')]");
    private final By deleteButtonPath = By.xpath("//a[@href='/delete_account']");
    private final By logoutButtonPath = By.xpath("//a[@href='/logout']");

    public String getUserName() {
        return driver.findElement(userNamePath).getText();
    }

    public void deleteAccount(){
        driver.findElement(deleteButtonPath).click();
    }

    public void logout() {
        driver.findElement(logoutButtonPath).click();
    }
}
