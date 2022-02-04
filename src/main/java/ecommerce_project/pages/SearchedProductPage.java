package ecommerce_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static ecommerce_project.DriverFactory.getChromeDriver;


public final class SearchedProductPage {
    private final WebDriver driver = getChromeDriver();
    private final String productId;

    public SearchedProductPage(String productId) {
        this.productId = productId;
    }

    public boolean isTitleVisible() {
        return isVisible("//h2[@class='title text-center']");
    }

    public boolean isSearchedProductVisible() {
        String productIdPath = "//a[@data-product-id=" + productId + "]";
        try {
            return isVisible(productIdPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean isVisible(String path) {
        return driver.findElement(By.xpath(path)).isDisplayed();
    }

    public WebDriver driver() {
        return driver;
    }

    public String productId() {
        return productId;
    }



}
