package services;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.ProductComparisonPage;
import pages.WomenCategoryPage;

@Log4j2
public class WomenCategoryPageService {

    String url = "http://prestashop.qatestlab.com.ua/ru/3-women";

    WomenCategoryPage womenCategoryPage = new WomenCategoryPage();

    @Step("Select Sort by {valueSortBy} and click In stock in filters")
    public WomenCategoryPage sortInStockProductsBy(String valueSortBy) {
        log.info("Select Sort by {} and click In stock in filters", valueSortBy);
        womenCategoryPage
                .openPage(url)
                .sortBy(valueSortBy)
                .clickInStock();
        return new WomenCategoryPage();
    }

    @Step("Click Jackets and In Stock in filters")
    public WomenCategoryPage filterByJacketsInStock() {
        log.info("Click Jackets and In Stock in filters");
        womenCategoryPage.
                openPage(url)
                .clickOnJacketsFilter()
                .clickInStock();
        return new WomenCategoryPage();
    }

    @Step("Compare two products: {firstProduct} and {secondProduct}")
    public ProductComparisonPage compareTwoProducts(String firstProduct, String secondProduct) {
        log.info("Compare two products: {} and {}", firstProduct, secondProduct);
        womenCategoryPage
                .openPage(url)
                .hoverProduct(firstProduct)
                .clickAddToCompare()
                .hoverProduct(secondProduct)
                .clickAddToCompare()
                .clickCompare();
        return new ProductComparisonPage();
    }

}
