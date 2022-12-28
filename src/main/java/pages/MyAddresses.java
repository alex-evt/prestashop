package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.IsElementOnThePage.isElementPresentOnPage;

@Log4j2
public class MyAddresses extends BasePage {

    @FindBy(xpath = "//h3")
    private List<WebElement> addressTitle;

    @Step("Check is created address title on page")
    public boolean isAddressTitleOnPage(String addressTitleName) {
        log.info("Check is created address title on page");
        return isElementPresentOnPage(addressTitle, addressTitleName.toUpperCase());
    }
}
