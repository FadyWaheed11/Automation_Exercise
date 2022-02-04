package testcases;

import base.BaseTests;
import ecommerce_project.pages.HomePage;
import org.testng.annotations.Test;
import ecommerce_project.pages.TestCasesPage;

import static org.testng.Assert.assertTrue;

public class TestCasesTests extends BaseTests {

    HomePage homePage = new HomePage();
    @Test
    public void testTestCases(){
        TestCasesPage testCasesPage = homePage.clickOnTestCasesPage();
        assertTrue(homePage.getCurrentPageUrl().endsWith("/test_cases"),"Incorrect Page Navigation");
    }
}
