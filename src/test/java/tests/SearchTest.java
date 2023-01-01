package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.MainPageService;

public class SearchTest extends BaseTest {

    @Description("Verify searched product is on the search results") //Verify search of the product which present on the website catalog
    @Test
    public void verifySearchTest() {
        String searchRequest = "Light Grey T-Shirt";
        MainPageService mainPageService = new MainPageService();
        boolean isProductOnPage = mainPageService
                .search(searchRequest)
                .isProductOnPage(searchRequest);
        Assert.assertTrue(isProductOnPage);
    }
}
