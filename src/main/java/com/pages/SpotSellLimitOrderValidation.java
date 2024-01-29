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

public class SpotSellLimitOrderValidation {
    WebDriver driver;
    BasePage basePage;

    public SpotSellLimitOrderValidation(WebDriver driver) {
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
    @FindBy(xpath = "//button[text()='Sell']")
    private WebElement sellBtn;
    @FindBy(xpath = "//div[text()='LIMIT']")
    private WebElement limitBtn;
    @FindBy(xpath = "//input[@placeholder='Enter Price']")
    private WebElement limitPriceTextField;
    @FindBy(xpath = "(//input[@placeholder='Total'])[2]")
    private WebElement limitTotalTextField;
    @FindBy(xpath = "(//span[text()='PLACE SELL ORDER'])[2]")
    private WebElement placeSellOrderButton;
    @FindBy(xpath = "(//span[text()='PLACE BUY ORDER'])[2]")
    private WebElement placeBuyOrderButton;
    @FindBy(xpath = "//span[text()='Price is required']")
    private WebElement priceIsRequiredValidationMsg;
    @FindBy(xpath = "//span[text()='Amount is required']")
    private WebElement amountIsRequiredValidationMsg;
    @FindBy(xpath = "//span[text()='Total is required']")
    private WebElement totalIsRequiredValidationMsg;
    @FindBy(xpath = "(//span[@class='errorCls'])[5]")
    private WebElement totalAmountMustBeAboveValidationMsg;
    @FindBy(xpath = "//span[text()='Order not as per trading rules.']")
    private WebElement orderNotAsPerTradingRulesErrorMsg;
    @FindBy(xpath = "(//span[@class='errorCls'])[3]")
    private WebElement priceShouldBeLessOrEqualToValidationMsg;
    @FindBy(xpath = "//span[text()='Insufficient balance']")
    private WebElement insufficientBalanceValidationMsg;

    public boolean validatePriceIsRequiredValidationMessage(String priceRequired, ExtentTest test) throws IOException, InterruptedException {
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

        //Click on the sell button
        basePage.waitForElementToBeVisible(sellBtn);
        basePage.click(sellBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the sell button.");

        //Click on the limit button
        basePage.waitForElementToBeVisible(limitBtn);
        basePage.click(limitBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the limit button.");

        //Remove the value from price text field
        basePage.click(limitPriceTextField);
        basePage.clearValue(limitPriceTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified remove the value from the price text field.");

        //Compare the values
        basePage.waitForElementToBeVisible(priceIsRequiredValidationMsg);
        String priceIsRequired = priceIsRequiredValidationMsg.getText();
        if (priceIsRequired.equals(priceRequired)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Price is required validation message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Price is required validation message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateAmountIsRequiredValidationMessage(String amountRequired, ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Click on the sell button
        basePage.waitForElementToBeVisible(placeSellOrderButton);
        basePage.click(placeSellOrderButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the place sell order button.");

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

    public boolean validateOrderNotAsPerTradingRulesWithHighPriceValidationMessage(String orderNotAsPerTradingRules, ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Remove the value from the price text field
        basePage.click(limitPriceTextField);
        basePage.clearValue(limitPriceTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified remove the value from the price text field.");

        //Enter the value in the price text field
        basePage.waitForElementToBeVisible(limitPriceTextField);
        basePage.enterText(limitPriceTextField, "10000");
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified enter the value in the price text field.");

        //Remove the value from the amount text field
        basePage.click(limitTotalTextField);
        basePage.clearValue(limitTotalTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified remove the value from the amount text field.");

        //Enter the value in the amount text field
        basePage.waitForElementToBeVisible(limitTotalTextField);
        basePage.enterText(limitTotalTextField, "25");
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified enter the value in the amount text field.");

        //Click on the sell button
        basePage.waitForElementToBeVisible(placeSellOrderButton);
        basePage.click(placeSellOrderButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the place sell order button.");

        //Compare the values
        basePage.waitForElementToBeVisible(orderNotAsPerTradingRulesErrorMsg);
        String orderNotAsPerTradingRulesValidation = orderNotAsPerTradingRulesErrorMsg.getText();
        if (orderNotAsPerTradingRulesValidation.equals(orderNotAsPerTradingRules)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Order not as per trading rules. pop-up message is matched.");
        } else {
            isTrue = true;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Order not as per trading rules. pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validatePriceShouldBeLessThanOrEqualToValidationMessage(String priceShouldBeLessOrEqualTo, ExtentTest test) throws IOException {
        boolean isTrue = false;

        String price = PropertyReaderOptimized.getKeyValue("priceValidation");

        //Remove the value from the price text field
        basePage.click(limitPriceTextField);
        basePage.clearValue(limitPriceTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified remove the value from the price text field.");

        //Enter the value in the price text field
        basePage.waitForElementToBeVisible(limitPriceTextField);
        basePage.enterText(limitPriceTextField, price);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified enter the value in the price text field.");

        //Compare the values
        basePage.waitForElementToBeVisible(priceShouldBeLessOrEqualToValidationMsg);
        String priceShouldBeLessThanOrEqualTo = priceShouldBeLessOrEqualToValidationMsg.getText();
        if (priceShouldBeLessThanOrEqualTo.equals(priceShouldBeLessOrEqualTo)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Price should be less than or equal to 100000000.0 validation message is matched.");
        } else {
            isTrue = true;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Price should be less than or equal to 100000000.0 validation message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateInsufficientBalanceValidationMessage(String insufficientBalance, ExtentTest test) throws IOException {
        boolean isTrue = false;

        String sellPrice = PropertyReaderOptimized.getKeyValue("sellPrice");
        String sellUSDTAmount = PropertyReaderOptimized.getKeyValue("sellUSDTAmountValidation");

        //Remove the value from the price text field
        basePage.click(limitPriceTextField);
        basePage.clearValue(limitPriceTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified remove the value from the buy price text field.");

        //Enter the value in the text field
        basePage.waitForElementToBeVisible(limitPriceTextField);
        basePage.enterText(limitPriceTextField, sellPrice);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified enter the value in the buy price text field.");

        //Remove the value from the amount text field
        basePage.click(limitTotalTextField);
        basePage.clearValue(limitTotalTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified remove the value from the amount text field.");

        //Enter the value in the amount text field
        basePage.waitForElementToBeVisible(limitTotalTextField);
        basePage.enterText(limitTotalTextField, sellUSDTAmount);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified enter the value in the amount text field.");

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

        //Remove the value from the text field
        basePage.click(limitTotalTextField);
        basePage.clearValue(limitTotalTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified remove the value from the total text field.");

        //Enter the value in the amount text field
        basePage.waitForElementToBeVisible(limitTotalTextField);
        basePage.enterText(limitTotalTextField, "2");
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Enter the value in the amount text field.");

        //Click on the sell button
        basePage.waitForElementToBeVisible(placeSellOrderButton);
        basePage.click(placeSellOrderButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the place sell order button.");

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
