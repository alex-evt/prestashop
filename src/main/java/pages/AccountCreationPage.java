package pages;

import elements.DropDownForYear;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Selector;
import utils.Waiter;

@Log4j2
public class AccountCreationPage extends BasePage {

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement maleGenderRadioButton;

    @FindBy(xpath = "//input[@id='id_gender2']")
    private WebElement femaleGenderRadioButton;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement daysBirthdaySelector;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement monthsBirthdaySelector;

    @FindBy(xpath = "//div[@id='cuselFrame-years']")
    private WebElement yearsBirthday;

    @FindBy(xpath = "//button[@id='submitAccount']")
    private WebElement registerButton;

    @Step("Toggle male gender radio button ")
    public AccountCreationPage checkedMaleGenderButton() {
        log.info("Toggle male gender radio button");
        Waiter.waitVisibilityOfElement(maleGenderRadioButton);
        maleGenderRadioButton.click();
        return this;
    }

    @Step("Toggle female  gender radio button ")
    public AccountCreationPage checkedFemaleGenderButton() {
        log.info("Toggle female gender radio button");
        Waiter.waitVisibilityOfElement(femaleGenderRadioButton);
        femaleGenderRadioButton.click();
        return this;
    }

    @Step("Fill {firstName} in First name field")
    public AccountCreationPage fillInFirstName(String firstName) {
        log.info("Fill '{}' in First name field", firstName);
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        return this;
    }

    @Step("Fill {lastName} in Last name field")
    public AccountCreationPage fillInLastName(String lastName) {
        log.info("Fill '{}' in Last name field", lastName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        return this;
    }

    @Step("Fill {password} in Password filed")
    public AccountCreationPage fillInPassword(String password) {
        log.info("Fill '{}' in Password filed", password);
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Select {dayValue} day in Date of Birth")
    public AccountCreationPage selectDay(String dayValue) {
        log.info("Select '{}' day in Date of Birth", dayValue);
        Selector.selectByValue(daysBirthdaySelector, dayValue);
        return this;
    }

    @Step("Select {monthValue} month in Date of Birth")
    public AccountCreationPage selectMonth(String monthValue) {
        log.info("Select '{}' month in Date of Birth", monthValue);
        Selector.selectByVisibleText(monthsBirthdaySelector, monthValue);
        return this;
    }

    @Step("Select {yearValue} year in Date of Birth")
    public AccountCreationPage selectYear(String yearValue) {
        log.info("Select '{}' year in Date of Birth", yearValue);
        WebElement year = new DropDownForYear(yearValue).yearElement();
        Selector.selectYear(yearsBirthday, year);
        return this;
    }

    @Step("Click Register button")
    public void clickRegister() {
        log.info("Click Register button");
        registerButton.click();
    }


}
