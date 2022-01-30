package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private final WebDriver driver;
    private final By productListPath = By.xpath("//div[@class='features_items']");
    private final By viewFirstProductButtonPath = By.xpath("//a[@href='/product_details/1']");
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductListVisible(){
        return driver.findElement(productListPath).isDisplayed();
    }

    public DetailsPage viewProduct(){
        driver.findElement(viewFirstProductButtonPath).click();
        return new DetailsPage(driver);
    }

}
