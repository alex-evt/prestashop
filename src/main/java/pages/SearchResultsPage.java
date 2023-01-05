package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.PageElementService.isElementPresentOnPage;
import static utils.Waiter.waitVisibilityOfElements;

@Log4j2
public class SearchResultsPage extends Header {

    @FindBy(xpath = "//div[@class='right-block']//a[@class='product-name']")
    private List<WebElement> productNames;

    @Step("Check is {name} product on page")
    public boolean isProductOnPage(String name) {
        log.info("Check is {} product on page", name);
        waitVisibilityOfElements(productNames);
        return isElementPresentOnPage(productNames, name);
    }
}
