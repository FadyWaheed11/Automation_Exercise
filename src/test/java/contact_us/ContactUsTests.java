package contact_us;

import base.BaseTests;
import ecommerce_project.pages.HomePage;
import org.testng.annotations.Test;
import ecommerce_project.pages.ContactUsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactUsTests extends BaseTests {

    HomePage homePage = new HomePage();

    @Test
    public void testContactUsForm() {
        ContactUsPage contactUsPage = homePage.clickOnContactUsPage();
        assertTrue(contactUsPage.isTitleVisible(), "Get In Touch title is invisible");
        contactUsPage.enterName("Fady Waheed")
                .enterEmail("fadywaheed10@gmail.com")
                .enterSubject("Testing")
                .enterMessage("Learn automation testing")
                .uploadFile("C:\\Users\\Fady Waheed\\Downloads")
                .submit();
        assertTrue(contactUsPage.isSuccessMessageVisible(), "Success message is invisible");
        contactUsPage.goHome();
        assertEquals(homePage.getCurrentPageUrl(), "https://www.automationexercise.com/",
                "Navigation to home page is incorrect");
    }
}
