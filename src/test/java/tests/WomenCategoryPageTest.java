package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import services.WomenCategoryPageService;
import utils.Retry;


public class WomenCategoryPageTest extends BaseTest {

    WomenCategoryPageService womenCategoryPageService;

    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void verifyProductSortingTest() {
        womenCategoryPageService = new WomenCategoryPageService();
        String sortByOption = "Price: Lowest first";
        String expectedPrice = "36,60 ₴";
        String actualPrice = womenCategoryPageService
                .sortInStockProductsBy(sortByOption)
                .getPriceOfFirstProduct();
        Assert.assertEquals(actualPrice, expectedPrice);
    }

    @Test(priority = 2)
    public void verifyJacketFilterTest() {
        womenCategoryPageService = new WomenCategoryPageService();
        String expectedProductName = "Red Jacket";
        String actualProductName = womenCategoryPageService
                .filterByJacketsInStock()
                .getNameOfFirstProduct();
        Assert.assertEquals(actualProductName, expectedProductName);
    }

    @Test(priority = 3)
    public void verifyCompareProducts() {
        womenCategoryPageService = new WomenCategoryPageService();
        String firstProduct = "Blouse";
        String secondProduct = "Printed Dress";
        String expectedPageHeading = "PRODUCT COMPARISON";
        String actualPageHeading = womenCategoryPageService
                .compareTwoProducts(firstProduct, secondProduct)
                .getPageName();
        Assert.assertEquals(actualPageHeading, expectedPageHeading);
    }
}
