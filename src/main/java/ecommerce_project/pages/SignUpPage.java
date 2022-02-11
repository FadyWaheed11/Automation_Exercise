package ecommerce_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static ecommerce_project.DriverFactory.getChromeDriver;

public class SignUpPage {
    private final WebDriver driver = getChromeDriver();
    private final By bPath = By.xpath("//b[contains(.,'Enter Account Information')]");
    private final By createAccountButtonPath = By.xpath("//button[@data-qa='create-account']");


    public boolean isBTextVisible() {
        return driver.findElement(bPath).isDisplayed();
    }

    public SignUpPage sendName(String name) {
        sendData("name", name);
        return this;
    }

    public SignUpPage sendPassword(String password) {
        sendData("password", password);
        return this;
    }

    public SignUpPage sendFirstName(String firstName) {
        sendData("first_name", firstName);
        return this;
    }

    public SignUpPage sendLastName(String lastName) {
        sendData("last_name", lastName);
        return this;
    }

    public SignUpPage sendCompanyName(String companyName) {
        sendData("company", companyName);
        return this;
    }

    public SignUpPage sendAddress1(String address1) {
        sendData("address1", address1);
        return this;
    }

    public SignUpPage sendAddress2(String address2) {
        sendData("address2", address2);
        return this;
    }

    public SignUpPage sendState(String state) {
        sendData("state", state);
        return this;
    }

    public SignUpPage sendCity(String city) {
        sendData("city", city);
        return this;
    }

    public SignUpPage sendZipCode(String zipCode) {
        sendData("zipcode", zipCode);
        return this;
    }

    public SignUpPage sendMobileNumber(String mobileNumber) {
        sendData("mobile_number", mobileNumber);
        return this;
    }

    /**
     * @param day starts from 1 to 31
     */
    public SignUpPage selectDay(int day) {
        findSelect("days").selectByIndex(day);
        return this;
    }

    /**
     * @param month starts from 1 to 12
     */
    public SignUpPage selectMonth(int month) {
        findSelect("months").selectByIndex(month);
        return this;
    }

    /**
     * @param year starts from 1900 to 2021
     */
    public SignUpPage selectYear(int year) {
        String years = Integer.toString(year);
        findSelect("years").selectByVisibleText(years);
        return this;
    }

    /**
     * @param countryName from this list [India,United States,Canada,
     *                    Australia,Israel,New Zealand,Singapore]
     */
    public SignUpPage selectCountry(String countryName) {
        findSelect("country").selectByVisibleText(countryName);
        return this;
    }

    public SignUpPage pressSignUpCheckBox() {
        checkBox("newsletter");
        return this;
    }

    public SignUpPage pressOffersCheckBox() {
        checkBox("optin");
        return this;
    }

    public AccountCreated createAccount() {
        driver.findElement(createAccountButtonPath).click();
        return new AccountCreated();
    }


    private Select findSelect(String path) {
        return new Select(driver.findElement(By.id(path)));
    }

    private void sendData(String path, String data) {
        WebElement element = driver.findElement(By.id(path));
        if (element.getAttribute("value").isEmpty())
            element.sendKeys(data);
    }

    private void checkBox(String checkBoxId) {
        driver.findElement(By.id(checkBoxId)).click();
    }
}
