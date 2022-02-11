package ecommerce_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ecommerce_project.DriverFactory.getChromeDriver;

public class ContactUsPage {
    private final WebDriver driver = getChromeDriver();
    private final By titlePath = By.xpath("//h2[contains(.,'Get In Touch')]");
    private final By uploadFilePath = By.name("upload_file");
    private final By submitButtonPath = By.name("submit");
    private final By successMessagePath = By.xpath("//div[@class='status alert alert-success']");
    private final By homeButtonPath = By.xpath("//a[@class='btn btn-success']");

    public boolean isTitleVisible() {
        return driver.findElement(titlePath).isDisplayed();
    }

    public ContactUsPage enterName(String name) {
        sendData("name", name);
        return this;
    }

    public ContactUsPage enterEmail(String email) {
        sendData("email", email);
        return this;
    }

    public ContactUsPage enterSubject(String subject) {
        sendData("subject", subject);
        return this;
    }

    public ContactUsPage enterMessage(String message) {
        sendData("message", message);
        return this;
    }

    public ContactUsPage uploadFile(String absoluteFilePath) {
        driver.findElement(uploadFilePath).sendKeys(absoluteFilePath);
        return this;
    }

    public void submit() {
        driver.findElement(submitButtonPath).click();
        driver.switchTo().alert().accept();
    }

    public boolean isSuccessMessageVisible() {
        return driver.findElement(successMessagePath).isDisplayed();
    }

    public void goHome(){
        driver.findElement(homeButtonPath).click();
    }

    private void sendData(String path, String data) {
        driver.findElement(By.name(path)).sendKeys(data);
    }
}
