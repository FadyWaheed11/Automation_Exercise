package ecommerce_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static ecommerce_project.DriverFactory.getChromeDriver;

public final class DetailsPage {
    private final WebDriver driver = getChromeDriver();

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

    public WebDriver driver() {
        return driver;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (DetailsPage) obj;
        return Objects.equals(this.driver, that.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver);
    }

    @Override
    public String toString() {
        return "DetailsPage[" +
                "driver=" + driver + ']';
    }

}
