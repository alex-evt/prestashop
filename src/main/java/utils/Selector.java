package utils;

import driver.DriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selector {
    private Selector() {
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
