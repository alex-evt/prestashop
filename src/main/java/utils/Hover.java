package utils;

import driver.DriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Hover {

    private Hover() {
    }

    public static void hoverElement(WebElement webElement) {
        new Actions(DriverSingleton.getInstance().getDriver()).moveToElement(webElement).perform();
    }
}
