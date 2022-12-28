package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Log4j2
public class ProductComparisonPage extends BasePage {

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement pageName;

    @Step("Get title name of the page")
    public String getPageName() {
        log.info("Get title name of the page");
        return pageName.getText();
    }
}
