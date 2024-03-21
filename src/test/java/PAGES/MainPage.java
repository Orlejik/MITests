package PAGES;

import Helpers.Helpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Core.BaseSeleniumPage;
import ReadProperties.ConfigProvider;

public class MainPage extends BaseSeleniumPage {
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
    @FindBy(xpath="//*[@id=\"tab-1\"]/div[2]/div[3]/div/div/div/div/ul/li[1]")
    private WebElement currencyMLD;
    @FindBy(xpath="//*[@id=\"tab-1\"]/div[2]/div[3]/div/div/div/div/ul/li[2]")
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
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[5]/label[1]/span")
    private WebElement persDataUsageAccesption;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[5]/label[2]/span")
    private WebElement siteConditionAccesption;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[6]/div[1]/div")
    private WebElement calculateBtn;
    @FindBy(xpath = "//*[@id=\"tab-1\"]/div[6]/div[2]/div/span")
    private WebElement cintinueBtn;



    public MainPage(){
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public MainPage calculateCredit(String username, String phoneNumner, int amount, int term) throws InterruptedException {

        userName.sendKeys(username);
        Helpers.wait(2);
        phoneNumber.sendKeys(phoneNumner);
        Helpers.wait(2);
        creditPurpose.click();
        Helpers.wait(2);
        lessTan20K.click();
        Helpers.wait(2);
        currency.click();
        Helpers.wait(2);
        currencyMLD.click();
        creaditAmonut.sendKeys(String.valueOf(amount));
        creaditTerm.sendKeys(String.valueOf(term));



        return this;
    }





}
