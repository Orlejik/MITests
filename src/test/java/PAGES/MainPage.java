package PAGES;

import Helpers.Helpers;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Core.BaseSeleniumPage;
import ReadProperties.ConfigProvider;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[@id=\"tab-1\"]")
    private WebElement userDataForCreditBlock;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[1]/div[2]/div/input")
    private WebElement userName;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[1]/div[3]/div/input")
    private WebElement phoneNumber;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[2]/div[2]/div/div/div/p")
    private WebElement creditPurpose;
    //    ------------------ Credit Purpose DropDown list elements-------------------------
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[2]/div[2]/div/div/div/div/ul/li[1]")
    private WebElement lessThan50K;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[2]/div[2]/div/div/div/div/ul/li[2]")
    private WebElement moreThan50K;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[2]/div[2]/div/div/div/div/ul/li[3]")
    private WebElement carOrder;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[2]/div[2]/div/div/div/div/ul/li[4]")
    private WebElement appartmentNeeds;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[2]/div[2]/div/div/div/div/ul/li[5]")
    private WebElement ownNeeds;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[2]/div[2]/div/div/div/div/ul/li[6]")
    private WebElement lessTan20K;
    //    ------------------ Credit Purpose DropDown list elements-------------------------
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[2]/div[3]/div/div/div/p")
    private WebElement currency;
    //    ------------------ Currency DropDown list elements-------------------------
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[2]/div[3]/div/div/div/div/ul/li[1]")
    private WebElement currencyMLD;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[2]/div[3]/div/div/div/div/ul/li[2]")
    private WebElement currencyEUR;
    //    ------------------ Currency DropDown list elements-------------------------
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[3]/div[1]/label/span")
    private WebElement personRequirenmentsCeckbox;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[3]/div[2]/label/span")
    private WebElement businessRequirenmenstsCheckbox;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[4]/div[1]/div/input")
    private WebElement creaditAmonut;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[4]/div[2]/div/input")
    private WebElement creaditTerm;
    //    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[5]/label[1]/span")
//    private WebElement persDataUsageAccesption;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[5]/label[2]/span")
    private WebElement siteConditionAccesption;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[6]/div[1]/div")
    private WebElement calculateBtn;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[6]/div[2]/div/span")
    private WebElement cintinueBtn;

    //    --------------------- NEXT STEPS -------------------------------------
    @FindBy(xpath = "//*[@id=\"tab-2\"]")
    private WebElement calcualtionBlock;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public MainPage() throws InterruptedException {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    private static String getElemDisplayCssValue(WebElement elem, String attribute) {
        return elem.getAttribute(attribute);
    }

    /***
     * This test will check if WebSite conditions are applied.
     * The normal behaviour :
     *                         1. We fill the user's Name and Surname;
     *                         2. We fill the Phone number
     *                         3. We choose the purpose of credit
     *                         4. We choose the currency
     *                         5. Radiobutton "Personal needs" is checked
     *                         6. we fill the amount
     *                         7. We fill the term with credit
     *                         8. We uncheck the checkbox "Applied personal data processing"
     *                         9. We check the checkbox "WebSite conditions"
     *                        10. We press "Calculate button"
     * The website should not pass to next step and highlight the empty inputs (all types) by red color.
     *

     */

    public void checkBoxUserDataUnchecks(String username, String phoneNumberValue, int amount, int term) throws InterruptedException {
        userName.sendKeys(username);
        phoneNumber.sendKeys(phoneNumberValue);
        creditPurpose.click();
        Helpers.wait(1);
        carOrder.click();
        currency.click();
        Helpers.wait(1);
        currencyMLD.click();
        String emptyEmountInput = "let amountInp = document.evaluate(\"//*[@id='tab-1']/div[4]/div[1]/div/input\",document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; amountInp.value = '';";
        js.executeScript(emptyEmountInput);
        creaditAmonut.sendKeys(String.valueOf(amount));
        String emptyTermIninput = "let termInp = document.evaluate(\"//*[@id='tab-1']/div[4]/div[2]/div/input\",document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; termInp.value = '';";
        js.executeScript((emptyTermIninput));
        creaditTerm.sendKeys(String.valueOf(term));
        Helpers.wait(1);
        String clickCheckBox1 = "let elem = document.evaluate(\"//*[@id='tab-1']/div[5]/label[1]/span\",document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;elem.click();";
        js.executeScript(clickCheckBox1);
        Helpers.wait(1);
        String clickCheckBox2 = "let elem2 = document.evaluate(\"//*[@id='tab-1']/div[5]/label[2]/span\",document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;elem2.click();";
        js.executeScript(clickCheckBox2);
        Helpers.wait(1);
        calculateBtn.click();
        String mainBlock = getElemDisplayCssValue(userDataForCreditBlock, "aria-hidden");
        String calculateBlock = getElemDisplayCssValue(calcualtionBlock, "aria-hidden");

        if (calculateBlock.equals("false") && mainBlock.equals("true")) {
            Assert.fail("Personal Data Processing check box should be checked!");
        }

        System.out.printf("MainBlock = %s\n", mainBlock);
        System.out.printf("calculateBlock = %s\n", calculateBlock);
    }

    /***
     * This test will check if WebSite conditions are applied.
     * The normal behaviour :
     *                         1. We fill the user's Name and Surname;
     *                         2. We fill the Phone number
     *                         3. We choose the purpose of credit
     *                         4. We choose the currency
     *                         5. Radiobutton "Personal needs" is checked
     *                         6. we fill the amount
     *                         7. We fill the term with credit
     *                         8. We leave the checkbox "Applied personal data processing" checked
     *                         9. We don't check the checkbox "WebSite conditions"
     *                        10. We press "Calculate button"
     * The website should not pass to next step and paint the empty inputs (all types) by red color.
     *
     */

    public void checkBoxSiteConditionsUnchecks(String username, String phoneNumberValue, int amount, int term) throws InterruptedException {
        userName.sendKeys(username);
        phoneNumber.sendKeys(phoneNumberValue);
        creditPurpose.click();
        Helpers.wait(1);
        moreThan50K.click();
        currency.click();
        Helpers.wait(1);
        currencyMLD.click();
        creaditAmonut.sendKeys(String.valueOf(amount));
        creaditTerm.sendKeys(String.valueOf(term));

        String emptyEmountInput = "let amountInp = document.evaluate(\"//*[@id='tab-1']/div[4]/div[1]/div/input\",document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; amountInp.value = '';";
        js.executeScript(emptyEmountInput);
        Helpers.wait(2);
        creaditAmonut.sendKeys(String.valueOf(amount));
        String emptyTermIninput = "let termInp = document.evaluate(\"//*[@id='tab-1']/div[4]/div[2]/div/input\",document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; termInp.value = '';";
        js.executeScript((emptyTermIninput));
        creaditTerm.sendKeys(String.valueOf(term));
        Helpers.wait(1);
        calculateBtn.click();
        String mainBlock = getElemDisplayCssValue(userDataForCreditBlock, "aria-hidden");
        String calculateBlock = getElemDisplayCssValue(calcualtionBlock, "aria-hidden");

        if (calculateBlock.equals("false") && mainBlock.equals("true")) {
            Assert.fail("Applying WebSite Conditions check box should be checked!");
        }

        System.out.printf("MainBlock = %s\n", mainBlock);
        System.out.printf("calculateBlock = %s\n", calculateBlock);
    }


    /***
     * This test will check if WebSite conditions are applied.
     * The normal behaviour :
     *                         1. We fill the user's Name and Surname;
     *                         2. We fill the Phone number
     *                         3. We choose the purpose of credit
     *                         4. We choose the currency
     *                         5. Radiobutton "Personal needs" is checked
     *                         6. we fill the amount
     *                         7. We fill the term with credit
     *                         8. We uncheck the checkbox "Applied personal data processing"
     *                         9. We don't check the checkbox "WebSite conditions"
     *                        10. We press "Calculate button"
     * The website should not pass to next step and highlight the empty inputs (all types) by red color.
     *
     */


    public void checkBoxBothUnchecks(String username, String phoneNumberValue, int amount, int term) throws InterruptedException {
        userName.sendKeys(username);
        phoneNumber.sendKeys(phoneNumberValue);
        Helpers.wait(1);
        creditPurpose.click();
        Helpers.wait(1);
        appartmentNeeds.click();
        currency.click();
        Helpers.wait(1);
        currencyMLD.click();
        creaditAmonut.sendKeys(String.valueOf(amount));
        creaditTerm.sendKeys(String.valueOf(term));
        String emptyEmountInput = "let amountInp = document.evaluate(\"//*[@id='tab-1']/div[4]/div[1]/div/input\",document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; amountInp.value = '';";
        js.executeScript(emptyEmountInput);
        creaditAmonut.sendKeys(String.valueOf(amount));
        String emptyTermIninput = "let termInp = document.evaluate(\"//*[@id='tab-1']/div[4]/div[2]/div/input\",document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; termInp.value = '';";
        js.executeScript((emptyTermIninput));
        creaditTerm.sendKeys(String.valueOf(term));
        Helpers.wait(1);
        String clickCheckBox1 = "let elem = document.evaluate(\"//*[@id='tab-1']/div[5]/label[1]/span\",document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;elem.click();";
        js.executeScript(clickCheckBox1);
        Helpers.wait(1);
        calculateBtn.click();
        String mainBlock = getElemDisplayCssValue(userDataForCreditBlock, "aria-hidden");
        String calculateBlock = getElemDisplayCssValue(calcualtionBlock, "aria-hidden");

        if (calculateBlock.equals("false") && mainBlock.equals("true")) {
            Assert.fail("Both check boxes should be checked!");
        }

        System.out.printf("MainBlock = %s \n", mainBlock);
        System.out.printf("calculateBlock = %s \n", calculateBlock);

    }

    /***
     * This test will check if WebSite conditions are applied.
     * The normal behaviour :
     *                         1. We fill the user's Name and Surname;
     *                         2. We fill the Phone number
     *                         3. We choose the purpose of credit
     *                         4. We choose the currency
     *                         5. Radiobutton "Personal needs" is checked
     *                         6. we fill the amount
     *                         7. We fill the term with credit
     *                         8. We check the checkbox "Applied personal data processing"
     *                         9. We check the checkbox "WebSite conditions"
     *                        10. We press "Calculate button"
     * The website should pass to next step and highlight the empty inputs (all types) by red color.
     *
     */
    public void checkBoxBothChecked(String username, String phoneNumberValue, int amount, int term) throws InterruptedException {
        userName.sendKeys(username);
        phoneNumber.sendKeys(phoneNumberValue);
        creditPurpose.click();
        Helpers.wait(1);
        carOrder.click();
        currency.click();
        Helpers.wait(1);
        currencyMLD.click();
        String emptyEmountInput = "let amountInp = document.evaluate(\"//*[@id='tab-1']/div[4]/div[1]/div/input\",document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; amountInp.value = '';";
        js.executeScript(emptyEmountInput);
        Helpers.wait(2);
        creaditAmonut.sendKeys(String.valueOf(amount));
        String emptyTermIninput = "let termInp = document.evaluate(\"//*[@id='tab-1']/div[4]/div[2]/div/input\",document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; termInp.value = '';";
        js.executeScript((emptyTermIninput));
        Helpers.wait(2);
        creaditTerm.sendKeys(String.valueOf(term));
        Helpers.wait(1);
        String clickCheckBox2 = "let elem2 = document.evaluate(\"//*[@id='tab-1']/div[5]/label[2]/span\",document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;elem2.click();";
        js.executeScript(clickCheckBox2);
        Helpers.wait(1);
        calculateBtn.click();
        String mainBlock = getElemDisplayCssValue(userDataForCreditBlock, "aria-hidden");
        String calculateBlock = getElemDisplayCssValue(calcualtionBlock, "aria-hidden");

        if (calculateBlock.equals("true") && mainBlock.equals("false")) {
            Assert.fail("The website should pass to the next step if both checkboxes are checked");
        }

        System.out.printf("MainBlock = %s \n", mainBlock);
        System.out.printf("calculateBlock = %s \n", calculateBlock);
    }
}
