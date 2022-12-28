package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.AddressPageService;

@Log4j2
public class MyAccountPage extends BasePage {


    @FindBy(xpath = "//p[contains(text(), 'created')]")
    private WebElement successfulAlert;

    @FindBy(xpath = "//a[contains(@title,'first address')]")
    private WebElement addAddressButton;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOutButton;

    @Step("Click Add my first address button")
    public AddressPageService clickAddAddress() {
        log.info("Click Add my first address button");
        addAddressButton.click();
        return new AddressPageService();
    }

    @Step("Get successful alert text")
    public String getAlertText() {
        log.info("Get successful alert text");
        return successfulAlert.getText();
    }

    @Step("Click Sign out button")
    public void clickLogout() {
        log.info("Click Sign out button");
        signOutButton.click();
    }

    @Step("Is Sign in button displayed")
    public boolean isSignInButtonDisplayed() {
        log.info("Is Sign in button displayed");
        return signInButton.isDisplayed();
    }
}
