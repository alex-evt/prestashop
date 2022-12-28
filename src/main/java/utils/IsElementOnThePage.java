package utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class IsElementOnThePage {

    public static boolean isElementPresentOnPage(List<WebElement> listOfElements, String nameOfElement) {
        for (WebElement element : listOfElements) {
            String elementText = element.getText();
            if (elementText.equals(nameOfElement)) {
                return true;
            }
        }
        return false;
    }
}
