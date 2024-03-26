package TESTS;

import Helpers.Helpers;
import ReadProperties.ConfigProvider;
import org.junit.Test;

import Core.BaseSeleniumTest;
import PAGES.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


public class CheckBoxesCalculationTests extends BaseSeleniumTest {

    @DisplayName("Prelucrare Datelor Checkbox Requirement")
    @Test
    public void dataCheckBoxUncehcked() throws InterruptedException {
        MainPage mainPage = new MainPage();

        String username = ConfigProvider.USER_NAME_SURNAME_1;
        String phonenumber = ConfigProvider.PHONE_NUMBER_1;
        int amount = ConfigProvider.NEEDED_SUM_1;
        int term = ConfigProvider.PAYMENT_TERM_1;
        try {
            mainPage.checkBoxUserDataUnchecks(username, phonenumber, amount, term);
            Helpers.wait(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Site Conditions Checkbox Requirement")
    @Test
    public void conditionsCheckBoxUnchecked() throws InterruptedException {
        MainPage mainPage = new MainPage();

        String username = ConfigProvider.USER_NAME_SURNAME_2;
        String phonenumber = ConfigProvider.PHONE_NUMBER_2;
        int amount = ConfigProvider.NEEDED_SUM_2;
        int term = ConfigProvider.PAYMENT_TERM_2;
        try {
            mainPage.checkBoxSiteConditionsUnchecks(username, phonenumber, amount, term);
            Helpers.wait(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @DisplayName("Both Checkbox Requirement")
    @Test
    public void bothCheckBoxUnchecked() throws InterruptedException {
        MainPage mainPage = new MainPage();

        String username = ConfigProvider.USER_NAME_SURNAME_3;
        String phonenumber = ConfigProvider.PHONE_NUMBER_3;
        int amount = ConfigProvider.NEEDED_SUM_3;
        int term = ConfigProvider.PAYMENT_TERM_3;
        try {
            mainPage.checkBoxBothUnchecks(username, phonenumber, amount, term);
            Helpers.wait(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Both Checkbox Checked")
    @Test
    public void bothCheckBoxChecked() throws InterruptedException {
        MainPage mainPage = new MainPage();

        String username = ConfigProvider.USER_NAME_SURNAME_4;
        String phonenumber = ConfigProvider.PHONE_NUMBER_4;
        int amount = ConfigProvider.NEEDED_SUM_4;
        int term = ConfigProvider.PAYMENT_TERM_4;
        try {
            mainPage.checkBoxBothChecked(username, phonenumber, amount, term);
            Helpers.wait(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
