package utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class GetTitleOfWebElementFromElementsList {

    //getColorFromColorsList??
    public static WebElement getTitleOfElementFromWebElementsList(List<WebElement> elementList, String wantedColor) {
        for (WebElement element : elementList) {
            String elementText = element.getAttribute("Title");
            if (elementText.equals(wantedColor)) {
                return element;
            }
        }
        return null;
    }
}
