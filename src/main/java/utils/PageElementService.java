package utils;

import driver.DriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageElementService {

    public static int getElementPositionByName(List<WebElement> webElementList, String name) {
        for (WebElement element : webElementList) {
            String product = element.getText();
            if (product.equals(name)) {
                return webElementList.indexOf(element);
            }
        }
        return 0;
    }

    public static WebElement getTitleOfElementFromWebElementsList(List<WebElement> elementList, String wantedColor) {
        for (WebElement element : elementList) {
            String elementText = element.getAttribute("Title");
            if (elementText.equals(wantedColor)) {
                return element;
            }
        }
        return null;
    }

    public static boolean isElementPresentOnPage(List<WebElement> listOfElements, String nameOfElement) {
        for (WebElement element : listOfElements) {
            String elementText = element.getText();
            if (elementText.equals(nameOfElement)) {
                return true;
            }
        }
        return false;
    }

    public static void hoverElement(WebElement webElement) {
        new Actions(DriverSingleton.getInstance().getDriver()).moveToElement(webElement).perform();
    }

    public static void selectByValue(WebElement webElement, String value) {
        new Select(webElement).selectByValue(value);
    }

    public static void selectByVisibleText(WebElement webElement, String text) {
        new Select(webElement).selectByVisibleText(text);
    }

    public static void selectYear(WebElement yearDropdown, WebElement yearValue) {
        new Actions(DriverSingleton.getInstance().getDriver()).click(yearDropdown).scrollToElement(yearValue).click(yearValue).perform();
    }
}
