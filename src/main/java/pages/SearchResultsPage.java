package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.IsElementOnThePage.isElementPresentOnPage;

@Log4j2
public class SearchResultsPage extends Header {

    @FindBy(xpath = "//div[@class='right-block']//a[@class='product-name']")
    private List<WebElement> productNames;

    @Step("Check is {name} product on page")
    public boolean isProductOnPage(String name) {
        log.info("Check is {} product on page", name);
        return isElementPresentOnPage(productNames, name);
    }
}
