package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WomenCategoryPageService;
import utils.Retry;


public class WomenCategoryPageTest extends BaseTest {

    WomenCategoryPageService womenCategoryPageService;

    @Description("Verify product sorting in women category") //catalog
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

    @Description("Verify product filtering by jackets")
    @Test(priority = 2)
    public void verifyJacketFilterTest() {
        womenCategoryPageService = new WomenCategoryPageService();
        String expectedProductName = "Red Jacket";
        String actualProductName = womenCategoryPageService
                .filterByJacketsInStock()
                .getNameOfFirstProduct();
        Assert.assertEquals(actualProductName, expectedProductName);
    }

    @Description("Verify comparison of two products in women category")
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
