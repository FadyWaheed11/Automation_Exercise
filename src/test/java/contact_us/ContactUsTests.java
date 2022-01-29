package contact_us;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContactUsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactUsTests extends BaseTests {

    @Test
    public void testContactUsForm(){
        ContactUsPage contactUsPage = homePage.clickOnContactUsPage();
        assertTrue(contactUsPage.isTitleVisible(),"Get In Touch title is invisible");
        contactUsPage.enterName("Fady Waheed");
        contactUsPage.enterEmail("fadywaheed10@gmail.com");
        contactUsPage.enterSubject("Testing");
        contactUsPage.enterMessage("Learn automation testing");
        contactUsPage.uploadFile("C:\\Users\\Fady Waheed\\Downloads");
        contactUsPage.submit();
        assertTrue(contactUsPage.isSuccessMessageVisible(),"Success message is invisible");
        contactUsPage.goHome();
        assertEquals(homePage.getCurrentPageUrl(), "https://www.automationexercise.com/",
                "Navigation to home page is incorrect");
    }
}
