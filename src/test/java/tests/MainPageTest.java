package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import services.MainPageService;

public class MainPageTest extends BaseTest {


    @Test
    public void verifySwitchingLanguageToEnglish() {
        MainPageService mainPageService = new MainPageService();
        String expectedLanguage = "English";
        String actualLanguage = mainPageService
                .changeLanguageToEnglish()
                .getCurrentLanguage();
        Assert.assertEquals(actualLanguage, expectedLanguage);
    }
}
