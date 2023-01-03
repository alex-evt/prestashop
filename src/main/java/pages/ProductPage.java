package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiter;

import java.util.List;
import java.util.Objects;

import static utils.PageElementService.getTitleOfElementFromWebElementsList;
import static utils.PageElementService.selectByVisibleText;

@Log4j2
public class ProductPage extends BasePage {


    @FindBy(xpath = "//div[contains(@class, 'fancybox-overlay')]")
    private WebElement quantityError;

    @FindBy(xpath = "//div[@id='layer_cart']")
    private WebElement layerCart;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    private WebElement quantityField;

    @FindBy(xpath = "//select[@id='group_1']")
    private WebElement sizeSelector;

    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//ul[@id='color_to_pick_list']//a")
    private List<WebElement> colorList;

    @FindBy(xpath = "//span[@id='layer_cart_product_attributes']")
    private WebElement colorAndSizeLayerCart;

    @Step("Click {color} color")
    public ProductPage clickOnColor(String color) {
        log.info("Click '{}' color", color);
        Objects.requireNonNull(getTitleOfElementFromWebElementsList(colorList, color)).click(); //что?
        return this;
    }


    @Step("Fill {quantity} in quantity")
    public ProductPage fillInQuantity(String quantity) {
        log.info("Fill '{}' in quantity", quantity);
        Waiter.waitVisibilityOfElement(quantityField);
        quantityField.clear();
        quantityField.sendKeys(quantity);
        return this;
    }

    @Step("Select {size} size selector")
    public ProductPage selectSize(String size) {
        log.info("Select '{}' size selector", size);
        selectByVisibleText(sizeSelector, size);
        return this;
    }

    @Step("Click Add to cart")
    public ProductPage clickAddToCart() {
        log.info("Click Add to cart");
        addToCartButton.click();
        return this;
    }

    public ProductPage waitLayerCart() {
        Waiter.waitVisibilityOfElement(layerCart);
        return this;
    }

    @Step("Get color and size in layer cart")
    public String getColorAndSizeLayerCart() {
        log.info("Get color and size in layer cart");
        return colorAndSizeLayerCart.getText();
    }

    @Step("Get quantity error message")
    public String getQuantityErrorMessage() {
        log.info("Get quantity error message");
        return Waiter.waitVisibilityOfElement(quantityError).getText();
    }
}
