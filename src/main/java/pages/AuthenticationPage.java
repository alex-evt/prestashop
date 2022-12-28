package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class AuthenticationPage extends Header {

    //CREATION
    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement emailFieldAccountCreate;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement createAccountButton;

    //LOGIN
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailFieldLogin;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordFieldLogin;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement signInButton;

    @Step("Fill {email} in Email address field for account creation")
    public AuthenticationPage fillInEmailForAccountCreation(String email) {
        log.info("Fill '{}' in Email address field for new account", email);
        emailFieldAccountCreate.sendKeys(email);
        return this;
    }

    @Step("Click Create an account")
    public AccountCreationPage clickCreateAccount() {
        log.info("Click Create an account");
        createAccountButton.click();
        return new AccountCreationPage();
    }

    @Step("Fill {email} in Email address field")
    public AuthenticationPage fillInEmailLogin(String email) {
        log.info("Fill '{}' in Email address field", email);
        emailFieldLogin.sendKeys(email);
        return this;
    }

    @Step("Fill {password} in Email address field")
    public AuthenticationPage fillInPasswordLogin(String password) {
        log.info("Fill '{}' in Email address field", password);
        passwordFieldLogin.sendKeys(password);
        return this;
    }

    @Step("Click Sign in")
    public void clickSignIn() {
        log.info("Click Sign in");
        signInButton.click();
    }

    @Step("Open authentication page")
    public AuthenticationPage openPage(String url) {
        log.info("Open authentication page");
        driver.get(url);
        return this;
    }
}
