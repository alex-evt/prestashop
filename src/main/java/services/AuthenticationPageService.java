package services;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.User;
import pages.AuthenticationPage;
import pages.MyAccountPage;

@Log4j2
public class AuthenticationPageService {

    private static final String AUTHENTICATION_PAGE_URL = "http://prestashop.qatestlab.com.ua/ru/authentication";

    AuthenticationPage authenticationPage = new AuthenticationPage();


    @Step("Create account as {user}")
    public MyAccountPage userCreation(User user) {
        log.info("Create account as '{}'", user);
        authenticationPage
                .openPage(AUTHENTICATION_PAGE_URL)
                .fillInEmailForAccountCreation(user.getEmail())
                .clickCreateAccount()
                .checkedMaleGenderButton()
                .fillInFirstName(user.getFirstName())
                .fillInLastName(user.getLastName())
                .fillInPassword(user.getPassword())
                .selectDay(user.getDayOfBirth())
                .selectMonth(user.getMonthOfBirth())
                .selectYear(user.getYearOfBirth())
                .clickRegister();
        return new MyAccountPage();
    }

    @Step("Log in as {user}")
    public MyAccountPage userLogin(String email, String password) {
        log.info("Login to site");
        authenticationPage
                .openPage(AUTHENTICATION_PAGE_URL)
                .fillInEmailLogin(email)
                .fillInPasswordLogin(password)
                .clickSignIn();
        return new MyAccountPage();
    }

    @Step("Change language to English")
    public AuthenticationPageService changeLanguageToEnglish() {
        log.info("Change language to English");
        authenticationPage
                .openPage(AUTHENTICATION_PAGE_URL)
                .clickLanguageDropdown()
                .clickEnglishLanguage();
        return new AuthenticationPageService();
    }
}
