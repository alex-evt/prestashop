package utils;

import driver.DriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    private static final int WAIT_TIMEOUT_SECONDS = 5;

    public static WebElement waitVisibilityOfElement(WebElement element) {
        return new WebDriverWait(DriverSingleton.getInstance().getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)) //маг число
                .until(ExpectedConditions.visibilityOf(element));
    }
}
