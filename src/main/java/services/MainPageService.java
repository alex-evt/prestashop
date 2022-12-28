package services;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.Header;
import pages.MainPage;
import pages.SearchResultsPage;

@Log4j2
public class MainPageService {

    private static final String MAIN_PAGE_URL = "http://prestashop.qatestlab.com.ua/en/";

    MainPage mainPage = new MainPage();

    @Step("Search for {searchText}")
    public SearchResultsPage search(String searchText) {
        log.info("Search for '{}'", searchText);
        mainPage
                .openPage(MAIN_PAGE_URL)
                .fillInSearchField(searchText)
                .clickSearchButton();
        return new SearchResultsPage();
    }

    @Step("Change language to English")
    public Header changeLanguageToEnglish() {
        log.info("Change language to English");
        mainPage
                .openPage(MAIN_PAGE_URL)
                .clickLanguageDropdown()
                .clickEnglishLanguage();
        return new Header();
    }

    @Step("Click {productName} in Best sellers tab")
    public ProductPageService clickOnProductInBestsellers(String productName) {
        log.info("Click '{}' in Best sellers tab", productName);
        mainPage
                .openPage(MAIN_PAGE_URL)
                .clickBestSellersTab()
                .clickOnBestsellerProduct(productName);
        return new ProductPageService();
    }


    public ProductPageService clickOnProduct(String productName) {
        mainPage.openPage(MAIN_PAGE_URL)
                .clickOnPopularProduct(productName);
        return new ProductPageService();
    }

    public MainPage changeLanguageToRussian(){
        mainPage
                .openPage(MAIN_PAGE_URL)
                .clickLanguageDropdown()
                .clickRussianLanguage();
        return new MainPage();
    }
}
