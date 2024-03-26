package PAGES;

import Core.BaseSeleniumPage;
import ReadProperties.ConfigProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import org.openqa.selenium.support.ui.Select;

public class CreditCalculatorPage extends BaseSeleniumPage {
//    Select Block Credit type----------------------
    @FindBy(xpath = "//*[@id=\"content-hidden\"]/div/div[3]/div/div/div[2]/div[1]/form/div/div[1]/div/div[2]/div/select")
    private WebElement creditTypeSelect;
    @FindBy(xpath = "//*[@id=\"content-hidden\"]/div/div[3]/div/div/div[2]/div[1]/form/div/div[1]/div/div[2]/div/select/option[2]")
    private WebElement lessTan50KMDL;
    @FindBy(xpath = "//*[@id=\"content-hidden\"]/div/div[3]/div/div/div[2]/div[1]/form/div/div[1]/div/div[2]/div/select/option[3]")
    private WebElement moreThan50KMDL;
    @FindBy(xpath = "//*[@id=\"content-hidden\"]/div/div[3]/div/div/div[2]/div[1]/form/div/div[1]/div/div[2]/div/select/option[4]")
    private WebElement carOrderCredit;
    @FindBy(xpath = "//*[@id=\"content-hidden\"]/div/div[3]/div/div/div[2]/div[1]/form/div/div[1]/div/div[2]/div/select/option[5]")
    private WebElement apptOrderCredit;
    @FindBy(xpath = "//*[@id=\"content-hidden\"]/div/div[3]/div/div/div[2]/div[1]/form/div/div[1]/div/div[2]/div/select/option[6]")
    private WebElement ownNeedsCredit;
    @FindBy(xpath = "//*[@id=\"content-hidden\"]/div/div[3]/div/div/div[2]/div[1]/form/div/div[1]/div/div[2]/div/select/option[7]")
    private WebElement businessDevCredit;
//    Select Currency for Credit ----------------------
    @FindBy(xpath = "//*[@id=\"content-hidden\"]/div/div[3]/div/div/div[2]/div[1]/form/div/div[2]/div/div[2]/div/select")
    private WebElement currencyForCredit;
    @FindBy(xpath = "//*[@id=\"content-hidden\"]/div/div[3]/div/div/div[2]/div[1]/form/div/div[2]/div/div[2]/div/div/ul")
    private WebElement listOfactiveCurrency;
    @FindBy(xpath = "//*[@id=\"content-hidden\"]/div/div[3]/div/div/div[2]/div[1]/form/div/div[2]/div/div[2]/div/div/ul/li[1]")
    private WebElement disabledCurrencyOption;
    @FindBy(xpath = "//*[@id=\"content-hidden\"]/div/div[3]/div/div/div[2]/div[1]/form/div/div[2]/div/div[2]/div/div/ul/li[2]")
    private WebElement activeCurrencyOption;
    @FindBys({@FindBy(xpath = "//*[@id=\"content-hidden\"]/div/div[3]/div/div/div[2]/div[1]/form/div/div[2]/div/div[2]/div/div/ul/li[2]"),
            @FindBy(xpath = "//*[@id=\"content-hidden\"]/div/div[3]/div/div/div[2]/div[1]/form/div/div[2]/div/div[2]/div/div/ul/li[1]")})
    private List<WebElement> listOfAvailableOptions;
    public CreditCalculatorPage() throws InterruptedException{
        driver.get(ConfigProvider.CREDIT_CALC_URL);
        PageFactory.initElements(driver, this);
    }
}


/***
 * TODO :
 *      I. Credit Calculation tests:
     *      1. To create the tests of changing the Credit scope for ensure that currency is changed dynamically.
     *      2. To test the range titles after credit scope changed
     *      3. To test the input of credit amount value <b>in</b> and <b>out</b> of ranges
     *      4. To test the input of term value <b>in</b> and <b>out</b> of ranges
     *      5. To test the credit calculation
 *      II. Language tests:
 *          1. To test languages changes
 *          2. To test the "Calculation and Information about credit" link
 *
 */