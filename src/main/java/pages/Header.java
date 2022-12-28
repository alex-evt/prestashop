package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiter;

@Log4j2
public class Header extends BasePage {

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement searchButton;

    //header elements
    @FindBy(xpath = "//div[contains(@id, 'languages-block-top')]")
    private WebElement languageDropdown;

    @FindBy(xpath = "//ul[@id='first-languages']//span[text()='English']")
    private WebElement englishLanguage;

    @FindBy(xpath = "//ul[@id='first-languages']//span[text()='Русский']")
    private WebElement russianLanguage;

    @FindBy(xpath = "//form[@id='setCurrency']")
    private WebElement currencyDropdown;

    @FindBy(xpath = "//a[@title='Доллар']")
    private WebElement currencyUSD;

    @FindBy(xpath = "//a[@title='Евро']")
    private WebElement currencyEUR;

    @FindBy(xpath = "//div[@class='shopping_cart']")
    private WebElement cart;

    @Step("Click on language dropdown")
    public Header clickLanguageDropdown() {
        log.info("Click on language dropdown");
        languageDropdown.click();
        Waiter.waitVisibilityOfElement(englishLanguage);
        return this;
    }

    @Step("Click English in language dropdown")
    public Header clickEnglishLanguage() {
        log.info("Click English in language dropdown");
        englishLanguage.click();
        return this;
    }

    public Header clickRussianLanguage() {
        russianLanguage.click();
        return this;
    }

    public Header clickCurrencyDropdown() {
        currencyDropdown.click();
        return this;
    }

    public Header clickCurrencyUSD() {
        currencyUSD.click();
        return this;
    }

    public Header clickCurrencyEUR() {
        currencyUSD.click();
        return this;
    }

    @Step("Fill {searchText} in search field")
    public Header fillInSearchField(String searchText) {
        log.info("Fill '{}' in search field", searchText);
        searchField.sendKeys(searchText);
        return this;
    }

    @Step("Click search button")
    public void clickSearchButton() {
        log.info("Click search button");
        searchButton.click();
    }

    @Step("Get current language")
    public String getCurrentLanguage() {
        log.info("Get current language");
        return languageDropdown.getText();
    }
}
