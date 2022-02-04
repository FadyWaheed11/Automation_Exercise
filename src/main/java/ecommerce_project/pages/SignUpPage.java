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

    public void sendName(String name) {
        sendData("name", name);
    }

    public void sendPassword(String password) {
        sendData("password", password);
    }

    public void sendFirstName(String firstName) {
        sendData("first_name", firstName);
    }

    public void sendLastName(String lastName){
        sendData("last_name",lastName);
    }

    public void sendCompanyName(String companyName){
        sendData("company",companyName);
    }

    public void sendAddress1(String address1){
        sendData("address1",address1);
    }

    public void sendAddress2(String address2){
        sendData("address2",address2);
    }

    public void sendState(String state){
        sendData("state",state);
    }

    public void sendCity(String city){
        sendData("city",city);
    }

    public void sendZipCode(String zipCode){
        sendData("zipcode",zipCode);
    }

    public void sendMobileNumber(String mobileNumber){
        sendData("mobile_number",mobileNumber);
    }

    /**
     * @param day starts from 1 to 31
     */
    public void selectDay(int day) {
        findSelect("days").selectByIndex(day);
    }

    /**
     * @param month starts from 1 to 12
     */
    public void selectMonth(int month) {
        findSelect("months").selectByIndex(month);
    }

    /**
     * @param year starts from 1900 to 2021
     */
    public void selectYear(int year) {
        String years = Integer.toString(year);
        findSelect("years").selectByVisibleText(years);
    }

    /**
     *
     * @param countryName from this list [India,United States,Canada,
     *                    Australia,Israel,New Zealand,Singapore]
     */
    public void selectCountry(String countryName){
        findSelect("country").selectByVisibleText(countryName);
    }

    public void pressSignUpCheckBox() {
        checkBox("newsletter");
    }

    public void pressOffersCheckBox() {
        checkBox("optin");
    }

    public AccountCreated createAccount(){
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
