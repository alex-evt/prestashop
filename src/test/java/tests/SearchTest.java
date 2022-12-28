package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import services.MainPageService;

public class SearchTest extends BaseTest {

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
