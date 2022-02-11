package register;

import base.BaseTests;
import ecommerce_project.pages.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RegisterTests extends BaseTests {

    HomePage homePage = new HomePage();

    @Test(priority = 1)
    public void testSignUp() {
        RegisterPage registerPage = homePage.clickOnRegisterPage();
        assertTrue(registerPage.isSignUpHeadLineVisible(), "New user signup is invisible");
        SignUpPage signUpPage = registerPage.enterUserName("Fady Waheed")
                .enterEmailAddressSignUp("fady177@gmail.com")
                .signUp();
        assertTrue(signUpPage.isBTextVisible(), "ENTER ACCOUNT INFORMATION is invisible");
        AccountCreated accountCreated = signUpPage.sendName("Fady")
                .sendPassword("12543680")
                .selectDay(24)
                .selectMonth(11)
                .selectYear(1997)
                .pressSignUpCheckBox()
                .pressOffersCheckBox()
                .sendFirstName("Fady")
                .sendLastName("Waheed")
                .sendCompanyName("Software AI")
                .sendAddress1("54 louxer st")
                .sendAddress2("non")
                .selectCountry("Canada")
                .sendState("Eg")
                .sendCity("Giza")
                .sendZipCode("12651")
                .sendMobileNumber("01286359784")
                .createAccount();
        assertTrue(accountCreated.isAccountCreatedVisible(), "Account created is invisible");
        UserMainPage userMainPage = accountCreated.pressContinue();
        assertTrue(userMainPage.getUserName().contains("Fady Waheed"), "UserName is not found");
        userMainPage.logout();
    }

    @Test(priority = 2)
    public void testLoginWithValidEmailAndPassword() {
        RegisterPage registerPage = homePage.clickOnRegisterPage();
        registerPage.enterEmailAddressLogin("fady177@gmail.com")
                .enterPassword("12543680");
        assertTrue(registerPage.isLoginHeadLineVisible(), "Login to your account is invisible");
        UserMainPage userMainPage = registerPage.login();
        assertTrue(userMainPage.getUserName().contains("Fady Waheed"), "UserName is not found");
        userMainPage.deleteAccount();
    }

    @Test
    public void testLoginWithIncorrectEmailAndPassword() {
        RegisterPage registerPage = homePage.clickOnRegisterPage();
        assertTrue(registerPage.isLoginHeadLineVisible(), "Login to your account is invisible");
        registerPage.enterEmailAddressLogin("foh10@gmail.com")
                .enterPassword("44587522")
                .login();
        assertTrue(registerPage.isLoginErrorMessageVisible(), "Error message is invisible");
    }

    @Test
    public void testLogOut() {
        RegisterPage registerPage = homePage.clickOnRegisterPage();
        assertTrue(registerPage.isLoginHeadLineVisible(), "Login to your account is invisible");
        UserMainPage userMainPage = registerPage.enterEmailAddressLogin("fadywaheed10@gmail.com")
                .enterPassword("12543680")
                .login();
        assertTrue(userMainPage.getUserName().contains("Fady Waheed"), "UserName is not found");
        userMainPage.logout();
        assertTrue(homePage.getCurrentPageUrl().endsWith("/login"), "Incorrect url page");
    }

    @Test
    public void testRegisterUserWithExistingEmail() {
        RegisterPage registerPage = homePage.clickOnRegisterPage();
        assertTrue(registerPage.isSignUpHeadLineVisible(), "New user signup is invisible");
        registerPage.enterUserName("Fady Waheed")
                .enterEmailAddressSignUp("fadywaheed10@gmail.com")
                .signUp();
        assertTrue(registerPage.isRegisterErrorMessageVisible(), "Error message is invisible");
    }
}
