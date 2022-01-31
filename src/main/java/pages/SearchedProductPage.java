package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public record SearchedProductPage(WebDriver driver, String productId) {

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

}
