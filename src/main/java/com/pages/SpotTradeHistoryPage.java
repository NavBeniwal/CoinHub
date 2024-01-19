package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SpotTradeHistoryPage {
    WebDriver driver;
    BasePage basePage;

    public SpotTradeHistoryPage(WebDriver driver){
        this.driver=driver;
        basePage=new BasePage(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='Trade']")
    private WebElement tradeBtn;
    @FindBy(xpath = "//div[@class='style_selectMarket__currency__RS+if']")
    private WebElement dropDownButton;
    @FindBy(xpath = "(//h4)[15]")
    private WebElement availableBalanceOfUSDT;
    @FindBy(xpath = "(//h4)[13]")
    private WebElement availableBalanceOfCurrency;
    @FindBy(xpath = "(//input[@placeholder='Enter Amount'])[1]")
    private WebElement marketCoinAmountTextField;
    @FindBy(xpath = "(//input[@placeholder='Total'])[1]")
    private WebElement marketTotalTextField;
    @FindBy(xpath = "(//span[text()='PLACE BUY ORDER'])[1]")
    private WebElement placeBuyOrderButton;
    @FindBy(xpath = "//span[text()='Order created successfully ']")
    private WebElement orderCreatedSuccessfullyPopUpMsg;
    @FindBy(xpath = "//p[text()='Trade History']")
    private WebElement tradeHistory;
    @FindBy(xpath = "//p[text()='Market']")
    private WebElement orderType;
    @FindBy(xpath = "(//div[@class='flexCenter'])[1]")
    private WebElement sideBuyAndFull;
    @FindBy(xpath = "//div[text()='Market']")
    private WebElement priceType;
    @FindBy(xpath = "(//td[@class='ant-table-cell']/div)[4]")
    private WebElement filledAmount;
    @FindBy(xpath = "(//div[@class='flexCenter']/p)[1]")
    private WebElement remainingAmount;
    @FindBy(xpath = "(//td[@class='ant-table-cell']/p)[24]")
    private WebElement totalAmount;
    @FindBy(xpath = "//span[text()='New']")
    private WebElement statusNew;
    @FindBy(xpath = "(//span[text()='Done'])[1]")
    private WebElement statusDone;
}
