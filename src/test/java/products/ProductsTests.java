package products;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DetailsPage;
import pages.ProductsPage;

import static org.testng.Assert.assertTrue;

public class ProductsTests extends BaseTests {

    @Test
    public void testProducts() {
        ProductsPage productsPage = homePage.clickOnProductsPage();
        assertTrue(productsPage.isProductListVisible(),"Product list is invisible");
        DetailsPage detailsPage = productsPage.viewProduct();
        assertTrue(homePage.getCurrentPageUrl().contains("/product_details"),
                "Navigation to product details is incorrect");
        assertTrue(detailsPage.isProductNameVisible(),"Product name is invisible");
        assertTrue(detailsPage.isCategoryNameVisible(),"Product category is invisible");
        assertTrue(detailsPage.isAvailabilityVisible(),"Product availability is invisible");
        assertTrue(detailsPage.isConditionVisible(),"Product condition is invisible");
        assertTrue(detailsPage.isBrandVisible(),"Product brand is invisible");
    }
}
