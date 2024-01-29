package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SpotBuyMarketOrderValidation {
    WebDriver driver;
    BasePage basePage;

    public SpotBuyMarketOrderValidation(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Trade']")
    private WebElement tradeBtn;
    @FindBy(xpath = "//div[@class='style_selectMarket__currency__RS+if']")
    private WebElement dropDownButton;
    @FindBy(xpath = "//h3[text()='BNB/USDT']")
    private WebElement bnbUSDTPair;
    @FindBy(xpath = "//h3[text()='ETH/USDT']")
    private WebElement ethUSDTPair;
    @FindBy(xpath = "//h3[text()='BTC/USDT']")
    private WebElement btcUSDTPair;
    @FindBy(xpath = "//h3[text()='TRX/USDT']")
    private WebElement trxUSDTPair;
    @FindBy(xpath = "//h3[text()='SHIB/USDT']")
    private WebElement shibUSDTPair;
    @FindBy(xpath = "(//input[@placeholder='Total'])[1]")
    private WebElement marketTotalTextField;
    @FindBy(xpath = "(//span[text()='PLACE BUY ORDER'])[1]")
    private WebElement placeBuyOrderButton;
    @FindBy(xpath = "//span[text()='Amount is required']")
    private WebElement amountIsRequiredValidationMsg;
    @FindBy(xpath = "//span[text()='Total is required']")
    private WebElement totalIsRequiredValidationMsg;
    @FindBy(xpath = "(//span[@class='errorCls'])[2]")
    private WebElement totalAmountMustBeAboveValidationMsg;
    @FindBy(xpath = "//span[text()='Insufficient balance']")
    private WebElement insufficientBalanceValidationMsg;
    @FindBy(xpath = "//span[text()='This pair is not available for trading at the moment. Please try again later']")
    private WebElement pairIsNotAvailable;

    public boolean validateAmountIsRequiredValidationMessage(String amountRequired, ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Click on the trade button
        basePage.waitForElementToBeVisible(tradeBtn);
        basePage.click(tradeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the trade button.");

        //Click on the drop-down
        basePage.waitForElementToBeVisible(dropDownButton);
        basePage.click(dropDownButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the drop-down.");

        //Click on the BNB/USDT pair
        basePage.waitForElementToBeVisible(bnbUSDTPair);
        basePage.click(bnbUSDTPair);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the currency pair.");

        //Click on the buy button
        basePage.waitForElementToBeVisible(placeBuyOrderButton);
        basePage.click(placeBuyOrderButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the place buy order button.");

        //Compare the values
        basePage.waitForElementToBeVisible(amountIsRequiredValidationMsg);
        String amountIsRequired = amountIsRequiredValidationMsg.getText();
        if (amountIsRequired.equals(amountRequired)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Amount is required validation message is matched.");
        } else {
            isTrue = true;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Amount is required validation message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateTotalIsRequiredValidationMessage(String totalRequired, ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Compare the values
        basePage.waitForElementToBeVisible(totalIsRequiredValidationMsg);
        String totalIsRequired = totalIsRequiredValidationMsg.getText();
        if (totalIsRequired.equals(totalRequired)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Total is required validation message is matched.");
        } else {
            isTrue = true;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Total is required validation message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateInsufficientBalanceValidationMessage(String insufficientBalance, ExtentTest test) throws IOException {
        boolean isTrue = false;

        String buyMarketUSDTAmountValidation = PropertyReaderOptimized.getKeyValue("buyMarketUSDTAmountValidation");

        //Enter the value in the amount text field
        basePage.waitForElementToBeVisible(marketTotalTextField);
        basePage.enterText(marketTotalTextField, buyMarketUSDTAmountValidation);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified enter the value in the amount text field.");

        //Click on the buy button
        basePage.waitForElementToBeVisible(placeBuyOrderButton);
        basePage.click(placeBuyOrderButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the place buy order button.");

        //Compare the values
        basePage.waitForElementToBeVisible(insufficientBalanceValidationMsg);
        String insufficientBalanceValidation = insufficientBalanceValidationMsg.getText();
        if (insufficientBalanceValidation.equals(insufficientBalance)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Insufficient balance validation message is matched.");
        } else {
            isTrue = true;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Insufficient balance validation message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateTotalAmountMustBeAboveValidationMessage(String totalAmountMustBeAbove, ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Remove the value from the total text field
        basePage.click(marketTotalTextField);
        basePage.clearValue(marketTotalTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified remove the value from the total text field.");

        //Enter the value in the amount text field
        basePage.waitForElementToBeVisible(marketTotalTextField);
        basePage.enterText(marketTotalTextField, "2");
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Enter the value in the amount text field.");

        //Click on the buy button
        basePage.waitForElementToBeVisible(placeBuyOrderButton);
        basePage.click(placeBuyOrderButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the place buy order button.");

        //Compare the values
        basePage.waitForElementToBeVisible(totalAmountMustBeAboveValidationMsg);
        String totalAmountMustBeAboveValidation = totalAmountMustBeAboveValidationMsg.getText();
        if (totalAmountMustBeAboveValidation.equals(totalAmountMustBeAbove)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Total must be above 6.0 USDT validation message is matched.");
        } else {
            isTrue = true;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Total must be above 6.0 USDT validation message isn't matched.");
        }

        return isTrue;
    }
}
