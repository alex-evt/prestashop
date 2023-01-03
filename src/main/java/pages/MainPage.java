package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.PageElementService.getElementPositionByName;


@Log4j2
public class MainPage extends Header {

    @FindBy(xpath = "//a[@class='blockbestsellers']")
    private WebElement bestSellersTab;

    @FindBy(xpath = "//ul[@id='blockbestsellers']/li")
    private List<WebElement> bestSellersProducts;

    @FindBy(xpath = "//ul[@id='blockbestsellers']//h5")
    private List<WebElement> bestSellersProductsNames;

    @FindBy(xpath = "//ul[@id='homefeatured']//h5")
    private List<WebElement> popularProductsNames;


    @Step("Click {productName} product in Popular")
    public ProductPage clickOnPopularProduct(String productName) {
        log.info("Click {} product in Popular", productName);
        popularProductsNames.get(getElementPositionByName(popularProductsNames, productName)).click();
        return new ProductPage();
    }

    @Step("Click Best sellers tab")
    public MainPage clickBestSellersTab() {
        log.info("Click Best sellers tab");
        bestSellersTab.click();
        return this;
    }

    @Step("Click {productName} product in Best sellers")
    public ProductPage clickOnBestsellerProduct(String productName) {
        log.info("Click '{}' product in Best sellers", productName);
        bestSellersProducts.get(getElementPositionByName(bestSellersProductsNames, productName)).click();
        return new ProductPage();
    }


    @Step("Open {url} page")
    public MainPage openPage(String url) {
        log.info("Open '{}' page", url);
        driver.get(url);
        return this;
    }


    public String getTextBestSellersTab() {
        return bestSellersTab.getText();
    }
}
