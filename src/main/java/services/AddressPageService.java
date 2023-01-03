package services;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.UserAddress;
import pages.AddressPage;
import pages.MyAddresses;

@Log4j2
public class AddressPageService {

    private final AddressPage addressPage = new AddressPage();

    @Step("Fill out all required fields in Your addresses and click Save button")
    public MyAddresses fillOutAddressRequiredFields(UserAddress userAddress) {
        log.info("Fill out all required fields in Your addresses and click Save button");
        addressPage
                .fillInFirstName(userAddress.getFirstName())
                .fillInLastName(userAddress.getLastName())
                .fillInAddress(userAddress.getAddress())
                .fillInZipPostalCode(userAddress.getPostalCode())
                .fillInCity(userAddress.getCity())
                .fillInHomePhone(userAddress.getHomePhone())
                .fillInMobilePhone(userAddress.getMobilePhone())
                .fillInTitleForReference(userAddress.getTitleForReference())
                .selectState(userAddress.getState())
                .selectCountry(userAddress.getCountry())
                .clickSave();
        return new MyAddresses();
    }

}
