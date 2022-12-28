package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import services.MainPageService;

public class ProductPageTest extends BaseTest {


    MainPageService mainPageService;

    @Test(priority = 1)
    public void verifyProductInLayerCartTest() {
        mainPageService = new MainPageService();

        String productName = "Printed Dress";
        String quantity = "1";
        String productColor = "Orange";
        String productSize = "M";
        String expectedColorAndSize = String.format(productColor + ", " + productSize);

        String actualColorAndSize = mainPageService
                .clickOnProductInBestsellers(productName)
                .addProductToCart(quantity, productColor, productSize)
                .getColorAndSizeLayerCart();
        Assert.assertEquals(actualColorAndSize, expectedColorAndSize);
    }


    @Test(priority = 2)
    public void verifyNullQuantityErrorMessageTest() {
        mainPageService = new MainPageService();

        String productName = "Printed Dress";
        String quantity = "0";
        String expectedErrorMessage = "Null quantity.";
        String actualErrorMessage = mainPageService
                .clickOnProductInBestsellers(productName)
                .addProductToCartWithNullQuantity(quantity)
                .getQuantityErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

}
