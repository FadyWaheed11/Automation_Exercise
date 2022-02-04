package ecommerce_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static ecommerce_project.DriverFactory.getChromeDriver;

public class HomePage {
    private final WebDriver driver = getChromeDriver();


    public RegisterPage clickOnRegisterPage() {
        clickOnLink("//a[@href='/login']");
        return new RegisterPage();
    }

    public ContactUsPage clickOnContactUsPage() {
        clickOnLink("//a[@href='/contact_us']");
        return new ContactUsPage();
    }

    public TestCasesPage clickOnTestCasesPage() {
        clickOnLink("//button[@class='btn btn-success' and contains(.,'Test Cases')]");
        return new TestCasesPage();
    }

    public ProductsPage clickOnProductsPage() {
        clickOnLink("//a[@href='/products']");
        return new ProductsPage();
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    private void clickOnLink(String path) {
        driver.findElement(By.xpath(path)).click();
    }

}
