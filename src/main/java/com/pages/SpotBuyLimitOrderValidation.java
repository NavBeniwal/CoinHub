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

public class SpotBuyLimitOrderValidation {
    WebDriver driver;
    BasePage basePage;

    public SpotBuyLimitOrderValidation(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Trade']")
    private WebElement tradeBtn;
    @FindBy(xpath = "//div[text()='LIMIT']")
    private WebElement limitBtn;
    @FindBy(xpath = "//input[@placeholder='Enter Price']")
    private WebElement limitPriceTextField;
    @FindBy(xpath = "(//input[@placeholder='Total'])[2]")
    private WebElement limitTotalTextField;
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

        //Click on the limit button
        basePage.waitForElementToBeInvisible(limitBtn);
        basePage.waitForElementToBeVisible(limitBtn);
        basePage.click(limitBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the limit button.");

        //Remove the value from the price text field
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

    public boolean validateOrderNotAsPerTradingRulesWithLowPriceValidationMessage(String orderNotAsPerTradingRules, ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Enter the value in the price text field
        basePage.waitForElementToBeVisible(limitPriceTextField);
        basePage.enterText(limitPriceTextField, "10");
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified enter the value in the price text field.");

        //Enter the value in the amount text field
        basePage.waitForElementToBeVisible(limitTotalTextField);
        basePage.enterText(limitTotalTextField, "25");
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified enter the value in the amount text field.");

        //Click on the buy button
        basePage.waitForElementToBeVisible(placeBuyOrderButton);
        basePage.click(placeBuyOrderButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the place buy order button.");

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

    public boolean validateOrderNotAsPerTradingRulesWithHighPriceValidationMessage(String orderNotAsPerTradingRules, ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Remove the value from limit price text field
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

        //Click on the buy button
        basePage.waitForElementToBeVisible(placeBuyOrderButton);
        basePage.click(placeBuyOrderButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the place buy order button.");

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

        String buyPrice = PropertyReaderOptimized.getKeyValue("buyPrice");
        String buyUSDTAmount = PropertyReaderOptimized.getKeyValue("buyUSDTAmountValidation");

        //Remove the value from price text field
        basePage.click(limitPriceTextField);
        basePage.clearValue(limitPriceTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified remove the value from the price text field.");

        //Enter the value in the price text field
        basePage.waitForElementToBeVisible(limitPriceTextField);
        basePage.enterText(limitPriceTextField, buyPrice);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified enter the value in the price text field.");

        //Remove the value from the amount text field
        basePage.click(limitTotalTextField);
        basePage.clearValue(limitTotalTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified remove the value from the amount text field.");

        //Enter the value in the amount text field
        basePage.waitForElementToBeVisible(limitTotalTextField);
        basePage.enterText(limitTotalTextField, buyUSDTAmount);
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

        //Remove the value from total text field
        basePage.click(limitTotalTextField);
        basePage.clearValue(limitTotalTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified remove the value from the total text field.");

        //Enter the value in the amount text field
        basePage.waitForElementToBeVisible(limitTotalTextField);
        basePage.enterText(limitTotalTextField, "2");
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