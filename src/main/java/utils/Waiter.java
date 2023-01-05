package utils;

import driver.DriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waiter {
    private static final int WAIT_TIMEOUT_SECONDS = 5;
    private Waiter() {
    }

    public static WebElement waitVisibilityOfElement(WebElement element) {
        return new WebDriverWait(DriverSingleton.getInstance().getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)) //маг число
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static List<WebElement> waitVisibilityOfElements(List<WebElement> element) {
        return new WebDriverWait(DriverSingleton.getInstance().getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)) //маг число
                .until(ExpectedConditions.visibilityOfAllElements(element));
    }
}
