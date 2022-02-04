package search_product;

import base.BaseTests;
import ecommerce_project.pages.HomePage;
import org.testng.annotations.Test;
import ecommerce_project.pages.ProductsPage;
import ecommerce_project.pages.SearchedProductPage;

import static org.testng.Assert.assertTrue;

public class SearchProductTests extends BaseTests {

    HomePage homePage = new HomePage();
    @Test
    public void testSearchProduct(){
        ProductsPage productsPage = homePage.clickOnProductsPage();
        SearchedProductPage searchedProductPage = productsPage.searchProduct("Blue Top","1");
        assertTrue(searchedProductPage.isTitleVisible());
        assertTrue(searchedProductPage.isSearchedProductVisible(),"Product is not found");
    }
}
