package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.MainPageService;

public class MainPageTest extends BaseTest {


    @Description("Verify language switch to English")
    @Test
    public void verifyLanguageSwitchToEnglish() {
        MainPageService mainPageService = new MainPageService();
        String expectedLanguage = "English";
        String actualLanguage = mainPageService
                .changeLanguageToEnglish()
                .getCurrentLanguage();
        Assert.assertEquals(actualLanguage, expectedLanguage);
    }
}
