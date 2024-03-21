package TESTS;

import Helpers.Helpers;
import ReadProperties.ConfigProvider;
import org.junit.Test;

import Core.BaseSeleniumTest;
import PAGES.MainPage;

public class MITest extends BaseSeleniumTest {

    @Test
    public void testMISite(){
        MainPage mainPage = new MainPage();

        String username = ConfigProvider.USER_NAME_SURNAME;
        String phonenumber = ConfigProvider.PHONE_NUMBER;
        int amount = ConfigProvider.NEEDED_SUM;
        int term = ConfigProvider.PAYMENT_TERM;
        try {
            mainPage.calculateCredit(username, phonenumber, amount, term);

            Helpers.wait(7);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
