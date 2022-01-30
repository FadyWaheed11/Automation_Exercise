package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public record DetailsPage(WebDriver driver) {

    public boolean isProductNameVisible() {
        return isVisible("//h2[contains(.,'Blue Top')]");
    }

    public boolean isCategoryNameVisible() {
        return isVisible("//p[contains(.,'Category: Women > Tops')]");
    }

    public boolean isPriceVisible() {
        return isVisible("//span[contains(.,'Rs. 500')]");
    }

    public boolean isAvailabilityVisible() {
        return isVisible("//p[contains(.,'Availability:')]");
    }

    public boolean isConditionVisible() {
        return isVisible("//p[contains(.,'Condition:')]");
    }

    public boolean isBrandVisible() {
        return isVisible("//p[contains(.,'Brand:')]");
    }

    private boolean isVisible(String path) {
        return driver.findElement(By.xpath(path)).isDisplayed();
    }
}
