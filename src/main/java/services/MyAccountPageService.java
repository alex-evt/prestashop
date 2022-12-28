package services;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.MyAccountPage;


@Log4j2
public class MyAccountPageService {

    MyAccountPage myAccountPage = new MyAccountPage();

    @Step("Logout from account")
    public MyAccountPage logout() {
        log.info("Logout from account");
        myAccountPage
                .clickLogout();
        return new MyAccountPage();
    }
}
