package pages;

import elements.InputField;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.UserAddress;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Selector;

@Log4j2
public class AddressPage extends BasePage {

    private static final String FIRST_NAME_LABEL = "firstname";
    private static final String LAST_NAME_LABEL = "lastname";
    private static final String COMPANY_LABEL = "company"; //необяз
    private static final String ADDRESS_LABEL = "address1";
    private static final String SECOND_ADDRESS_LABEL = "address1"; //необ
    private static final String ZIP_POSTCODE_LABEL = "postcode";
    private static final String CITY_LABEL = "city";
    private static final String HOME_PHONE_LABEL = "phone";
    private static final String MOBILE_PHONE_LABEL = "phone_mobile";
    private static final String TITLE_FOR_REFERENCE_LABEL = "alias";

    @FindBy(xpath = "//select[@id='id_country']")
    private WebElement countrySelector;

    @FindBy(xpath = "//select[@id='id_state']")
    private WebElement stateSelector;

    @FindBy(xpath = "//button[@id='submitAddress']")
    private WebElement saveButton;


    @Step("Select {country} in Country selector")
    public AddressPage selectCountry(String country) {
        log.info("Select '{}' in Country selector", country);
        Selector.selectByVisibleText(countrySelector, country);
        return this;
    }

    @Step("Select {state} in State selector")
    public AddressPage selectState(String state) {
        log.info("Select '{}' in State selector", state);
        Selector.selectByVisibleText(stateSelector, state);
        return this;
    }

    @Step("Click Save button")
    public MyAddresses clickSave() {
        log.info("Click Save button");
        saveButton.click();
        return new MyAddresses();
    }

    @Step("Fill {firstName} in First name field")
    public AddressPage fillInFirstName(String firstName) {
        log.info("Fill '{}' in First name field", firstName);
        new InputField(FIRST_NAME_LABEL).writeText(firstName);
        return this;
    }

    @Step("Fill {firstName} in First name field")
    public AddressPage fillInLastName(String lastName) {
        log.info("Fill '{}' in First name field", lastName);
        new InputField(LAST_NAME_LABEL).writeText(lastName);
        return this;
    }

    public AddressPage fillInCompany(UserAddress.Optional userAddress) {
        new InputField(COMPANY_LABEL).writeText(userAddress.getCompany());
        return this;
    }

    @Step("Fill {address} in Address field")
    public AddressPage fillInAddress(String address) {
        log.info("Fill '{}' in Address field", address);
        new InputField(ADDRESS_LABEL).writeText(address);
        return this;
    }

    public AddressPage fillInSecondAddress(UserAddress.Optional userAddress) {
        new InputField(SECOND_ADDRESS_LABEL).writeText(userAddress.getSecondAddress());
        return this;
    }

    @Step("Fill {postalCode} in Zip/Postal Code field")
    public AddressPage fillInZipPostalCode(String postalCode) {
        log.info("Fill '{}' in Zip/Postal Code field", postalCode);
        new InputField(ZIP_POSTCODE_LABEL).writeText(postalCode);
        return this;
    }

    @Step("Fill {city} in City field")
    public AddressPage fillInCity(String city) {
        log.info("Fill '{}' in City field", city);
        new InputField(CITY_LABEL).writeText(city);
        return this;
    }

    @Step("Fill {homePhone} in Home phone field")
    public AddressPage fillInHomePhone(String homePhone) {
        log.info("Fill '{}' in Home phone field", homePhone);
        new InputField(HOME_PHONE_LABEL).writeText(homePhone);
        return this;
    }

    @Step("Fill {mobilePhone} in Mobile phone field")
    public AddressPage fillInMobilePhone(String mobilePhone) {
        log.info("Fill '{}' in Mobile phone field", mobilePhone);
        new InputField(MOBILE_PHONE_LABEL).writeText(mobilePhone);
        return this;
    }

    @Step("Fill {titleForReference} in Please assign an address title for future reference field")
    //другое название??
    public AddressPage fillInTitleForReference(String titleForReference) {
        log.info("Fill '{}' in Please assign an address title for future reference field", titleForReference);
        new InputField(TITLE_FOR_REFERENCE_LABEL).writeText(titleForReference);
        return this;
    }

}
