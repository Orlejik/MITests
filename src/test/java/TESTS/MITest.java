package TESTS;

import Helpers.Helpers;
import ReadProperties.ConfigProvider;
import org.junit.Test;

import Core.BaseSeleniumTest;
import PAGES.MainPage;
import org.junit.jupiter.api.DisplayName;

public class MITest extends BaseSeleniumTest {

    @DisplayName("Prelucrare Datelor Checkbox Requirement")
    @Test
    public void dataCheckBox() throws InterruptedException {
        MainPage mainPage = new MainPage();

        String username = ConfigProvider.USER_NAME_SURNAME;
        String phonenumber = ConfigProvider.PHONE_NUMBER;
        int amount = ConfigProvider.NEEDED_SUM;
        int term = ConfigProvider.PAYMENT_TERM;
        try {
            mainPage.checkBoxUserDataChecks(username, phonenumber, amount, term);

            Helpers.wait(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    @DisplayName("Site Conditions Checkbox Requirement")
//    @Test
//    public void conditionsCheckBox(){
//        MainPage mainPage = new MainPage();
//
//        String username = ConfigProvider.USER_NAME_SURNAME;
//        String phonenumber = ConfigProvider.PHONE_NUMBER;
//        int amount = ConfigProvider.NEEDED_SUM;
//        int term = ConfigProvider.PAYMENT_TERM;
//        try {
//            mainPage.checkBoxSiteConditionsChecks(username, phonenumber, amount, term);
//
//            Helpers.wait(3);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @DisplayName("Both Checkbox Requirement")
//    @Test
//    public void bothCheckBox(){
//        MainPage mainPage = new MainPage();
//
//        String username = ConfigProvider.USER_NAME_SURNAME;
//        String phonenumber = ConfigProvider.PHONE_NUMBER;
//        int amount = ConfigProvider.NEEDED_SUM;
//        int term = ConfigProvider.PAYMENT_TERM;
//        try {
//            mainPage.checkBoxSiteConditionsChecks(username, phonenumber, amount, term);
//
//            Helpers.wait(7);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

}
