package search_product;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.SearchedProductPage;

import static org.testng.Assert.assertTrue;

public class SearchProductTests extends BaseTests {

    @Test
    public void testSearchProduct(){
        ProductsPage productsPage = homePage.clickOnProductsPage();
        SearchedProductPage searchedProductPage = productsPage.searchProduct("Blue Top","1");
        assertTrue(searchedProductPage.isTitleVisible());
        assertTrue(searchedProductPage.isSearchedProductVisible(),"Product is not found");
    }
}
