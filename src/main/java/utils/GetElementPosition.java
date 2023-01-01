package utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class GetElementPosition {
    private GetElementPosition() {
    }

    public static int getElementPositionByName(List<WebElement> webElementList, String name) {
        for (WebElement element : webElementList) {
            String product = element.getText();
            if (product.equals(name)) {
                return webElementList.indexOf(element);
            }
        }
        return 0;
    }
}
