package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public record HomePage(WebDriver driver) {

    public RegisterPage clickOnRegisterPage() {
        clickOnLink("//a[@href='/login']");
        return new RegisterPage(driver);
    }

    public ContactUsPage clickOnContactUsPage(){
        clickOnLink("//a[@href='/contact_us']");
        return new ContactUsPage(driver);
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    private void clickOnLink(String path){
        driver.findElement(By.xpath(path)).click();
    }
}
