package elements;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownForYear {

    private static final String DROP_DOWN_XPATH_YEAR_SELECTING = "//div[@id='cusel-scroll-years']/span[@val='%s']";
    private final String year;

    private final WebDriver driver = DriverSingleton.getInstance().getDriver();

    public DropDownForYear(String year) {
        this.year = year;
    }

    public WebElement yearElement() {
        String xpath = String.format(DROP_DOWN_XPATH_YEAR_SELECTING, year);
        return driver.findElement(By.xpath(xpath));
    }
}
