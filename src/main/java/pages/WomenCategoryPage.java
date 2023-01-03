package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiter;

import java.util.List;

import static utils.PageElementService.*;

@Log4j2
public class WomenCategoryPage extends BasePage {

    @FindBy(xpath = "//a[@rel='layered_quantity_1']")
    private WebElement inStockFilterEnabled;

    @FindBy(xpath = "//input[@id='layered_quantity_1']")
    private WebElement inStockCheckbox;
    @FindBy(xpath = "//div[@id='uniform-layered_category_14']")
    private WebElement jacketsFilterCheckbox;

    @FindBy(xpath = "//select[@id='selectProductSort']")
    private WebElement sortBy;

    @FindBy(xpath = "//div[@class='right-block']//a[@class='product-name']")
    private List<WebElement> productNames;

    @FindBy(xpath = "//div[@class='right-block']//div[@class='content_price']")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//button[contains(@class, 'bt_compare')]")
    private WebElement compareButton;

    @FindBy(xpath = "//a[contains(@class, 'add_to_compare')]")
    private List<WebElement> addToCompare;


    private static int productPosition;

    @Step("Open {url} page")
    public WomenCategoryPage openPage(String url) {
        log.info("Open {} page", url);
        driver.get(url);
        return this;
    }

    @Step("Hover over {productName}")
    public WomenCategoryPage hoverProduct(String productName) {
        log.info("Hover over {}", productName);
        productPosition = getElementPositionByName(productNames, productName);
        hoverElement(productNames.get(getElementPositionByName(productNames, productName)));
        return this;
    }

    @Step("Click Add to Compare")
    public WomenCategoryPage clickAddToCompare() {
        log.info("Click Add to Compare");
        addToCompare.get(productPosition).click();
        return this;
    }

    @Step("Click Compare button")
    public WomenCategoryPage clickCompare() {
        log.info("Click Compare button");
        compareButton.click();
        return this;
    }

    @Step("Click 'In stock' in filters")
    public WomenCategoryPage clickInStock() {
        log.info("Click 'In stock' in filters");
        inStockCheckbox.click();
        Waiter.waitVisibilityOfElement(inStockFilterEnabled);
        return this;
    }

    @Step("Click 'Jackets' in filters")
    public WomenCategoryPage clickOnJacketsFilter() {
        log.info("Click 'Jackets' in filters");
        jacketsFilterCheckbox.click();
        return this;
    }

    @Step("Get name of first product")
    public String getNameOfFirstProduct() {
        log.info("Get name of first product");
        return productNames.get(0).getText();
    }

    @Step("Select Sort by {sortValue}")
    public WomenCategoryPage sortBy(String sortValue) {
        log.info("Select Sort by {}", sortValue);
        selectByVisibleText(sortBy, sortValue);
        return this;
    }

    @Step("Get price of first product")
    public String getPriceOfFirstProduct() {
        log.info("Get price of first product");
        return productPrices.get(0).getText();
    }

}
