package services;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.ProductPage;

@Log4j2
public class ProductPageService {

    private final ProductPage productPage = new ProductPage();

    @Step("Add product with {quantity} quantity, {color} color and {size} size")
    public ProductPage addProductToCart(String quantity, String color, String size) {
        log.info("Add product with '{}' quantity, '{}' color and '{}' size", quantity, color, size);
        productPage
                .fillInQuantity(quantity)
                .clickOnColor(color)
                .selectSize(size)
                .clickAddToCart()
                .waitLayerCart();
        return new ProductPage();
    }

    @Step("Add product with {quantity} quantity")
    public ProductPage addProductToCartWithNullQuantity(String quantity) {
        log.info("Add product with '{}' quantity", quantity);
        productPage
                .fillInQuantity(quantity)
                .clickAddToCart();
        return new ProductPage();
    }
}
