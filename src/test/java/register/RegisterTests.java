package register;
import base.BaseTests;
import org.testng.annotations.Test;
import pages.AccountCreated;
import pages.RegisterPage;
import pages.SignUpPage;
import pages.UserMainPage;

import static org.testng.Assert.assertTrue;

public class RegisterTests extends BaseTests {

    @Test(priority = 1)
    public void testSignUp() throws InterruptedException {
        RegisterPage registerPage = homePage.clickOnRegisterPage();
        assertTrue(registerPage.isSignUpHeadLineVisible(),"New user signup is invisible");
        registerPage.enterUserName("Fady Waheed");
        registerPage.enterEmailAddressSignUp("fa30@gmail.com");
        SignUpPage signUpPage = registerPage.signUp();
        assertTrue(signUpPage.isBTextVisible(),"ENTER ACCOUNT INFORMATION is invisible");
        signUpPage.sendName("Fady");
        signUpPage.sendPassword("12543680");
        signUpPage.selectDay(24);
        signUpPage.selectMonth(11);
        signUpPage.selectYear(1997);
        Thread.sleep(3000);
        signUpPage.pressSignUpCheckBox();
        signUpPage.pressOffersCheckBox();
        signUpPage.sendFirstName("Fady");
        signUpPage.sendLastName("Waheed");
        signUpPage.sendCompanyName("Software AI");
        signUpPage.sendAddress1("54 louxer st");
        signUpPage.sendAddress2("non");
        signUpPage.selectCountry("Canada");
        signUpPage.sendState("Eg");
        signUpPage.sendCity("Giza");
        signUpPage.sendZipCode("12651");
        signUpPage.sendMobileNumber("01286359784");
        AccountCreated accountCreated = signUpPage.createAccount();
        assertTrue(accountCreated.isAccountCreatedVisible(),"Account created is invisible");
        UserMainPage userMainPage = accountCreated.pressContinue();
        assertTrue(userMainPage.getUserName().contains("Fady Waheed"),"UserName is not found");
        registerPage.logout();
    }

    @Test(priority = 2)
    public void testLoginWithValidEmailAndPassword(){
        RegisterPage registerPage = homePage.clickOnRegisterPage();
        registerPage.enterEmailAddressLogin("fa30@gmail.com");
        registerPage.enterPassword("12543680");
        assertTrue(registerPage.isLoginHeadLineVisible(),"Login to your account is invisible");
        UserMainPage userMainPage = registerPage.login();
        assertTrue(userMainPage.getUserName().contains("Fady Waheed"),"UserName is not found");
        userMainPage.deleteAccount();
    }
}