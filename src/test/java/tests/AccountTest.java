package tests;

import io.qameta.allure.Description;
import models.User;
import models.UserAddress;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.AuthenticationPageService;
import services.MyAccountPageService;

public class AccountTest extends BaseTest {

    private final String email = System.getenv("EMAIL");
    private final String password = System.getenv("PASSWORD");

    AuthenticationPageService authenticationPageService;

    @Description("Verify successful account creation")
    @Test(priority = 1)
    public void verifySuccessfulAccountCreationTest() {
        String firstName = "Drake";
        String lastName = "Smith";
        String dayOfBirth = "4";
        String monthOfBirth = "June ";
        String yearOfBirth = "2000";

        User user = User.builder().firstName(firstName)
                .lastName(lastName).email(email).password(password)
                .dayOfBirth(dayOfBirth).monthOfBirth(monthOfBirth).yearOfBirth(yearOfBirth).build();

        authenticationPageService = new AuthenticationPageService();

        String expectedAlertText = "Your account has been created.";
        String actualAlertText = authenticationPageService
                .userCreation(user)
                .getAlertText();
        Assert.assertEquals(actualAlertText, expectedAlertText);
    }

    @Description("Verify logout from account")
    @Test(priority = 2)
    public void verifyLogoutFromAccountTest() {
        MyAccountPageService myAccountPageService = new MyAccountPageService();
        boolean isButtonDisplayed = myAccountPageService.
                logout()
                .isSignInButtonDisplayed();
        Assert.assertTrue(isButtonDisplayed);
    }

    @Description("Verify filling out of the first address. Language of the site: English")
    @Test(priority = 3)
    public void verifyFillOutFirstAddressTest() {

        UserAddress userAddress = UserAddress.builder()
                .firstName("Mike")
                .lastName("Richardson")
                .address("Waller Street")
                .postalCode("73301")
                .city("Austen")
                .country("США")
                .state("Texas")
                .homePhone("9792307045")
                .mobilePhone("214-276-2365")
                .titleForReference("My address")
                .build();

        authenticationPageService = new AuthenticationPageService();

        String expectedTitle = userAddress.getTitleForReference();
        boolean isAddressTitleOnPage = authenticationPageService
                .changeLanguageToEnglish()
                .userLogin(email, password)
                .clickAddAddress()
                .fillOutAddressRequiredFields(userAddress)
                .isAddressTitleOnPage(expectedTitle);
        Assert.assertTrue(isAddressTitleOnPage);
    }
}
