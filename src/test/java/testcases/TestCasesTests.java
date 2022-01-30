package testcases;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.TestCasesPage;

import static org.testng.Assert.assertTrue;

public class TestCasesTests extends BaseTests {

    @Test
    public void testTestCases(){
        TestCasesPage testCasesPage = homePage.clickOnTestCasesPage();
        assertTrue(homePage.getCurrentPageUrl().endsWith("/test_cases"),"Incorrect Page Navigation");
    }
}
