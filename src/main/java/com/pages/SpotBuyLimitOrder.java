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

public class SpotBuyLimitOrder {
    WebDriver driver;
    BasePage basePage;
    double beforePlaceBuyLimitOrderAvailableBalanceOfUSDT;
    double beforePlaceBuyLimitOrderAvailableBalanceOfCurrency;
    double enterUSDTAmount;
    double limitPriceTextFieldVal;
    double currencyAmount;
    double amountValue;
    double remainingAmountVal;
    double afterPlaceBuyLimitOrderAvailableBalanceOfUSDT;
    double afterPlaceBuyLimitOrderAvailableBalanceOfCurrency;
    double tradingAmountOfUSDT;

    public SpotBuyLimitOrder(WebDriver driver){
        this.driver=driver;
        basePage=new BasePage(driver);
        PageFactory.initElements(driver,this);
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
    @FindBy(xpath = "(//h4)[13]")
    private WebElement availableBalanceOfUSDT;
    @FindBy(xpath = "(//h4)[15]")
    private WebElement availableBalanceOfCurrency;
    @FindBy(xpath = "//div[text()='LIMIT']")
    private WebElement limitBtn;
    @FindBy(xpath = "//td[@class='ant-table-cell']/span")
    private WebElement amount;
    @FindBy(xpath = "//div[@class='flexCenter']/p")
    private WebElement remainingAmount;
    @FindBy(xpath = "(//div[@class='flexCenter'])[3]")
    private WebElement filledAmount;
    @FindBy(xpath = "(//td[@class='ant-table-cell']/div)[2]")
    private WebElement currencyPrice;
    @FindBy(xpath = "//p[text()='Limit']")
    private WebElement orderType;
    @FindBy(xpath = "//input[@placeholder='Enter Price']")
    private WebElement limitPriceTextField;
    @FindBy(xpath = "(//input[@placeholder='Total'])[2]")
    private WebElement limitTotalTextField;
    @FindBy(xpath = "(//input[@placeholder='Enter Amount'])[2]")
    private WebElement limitEnterAmountTextField;
    @FindBy(xpath = "(//span[text()='PLACE BUY ORDER'])[2]")
    private WebElement placeBuyOrderButton;
    @FindBy(xpath = "//span[text()='Order created successfully ']")
    private WebElement orderCreatedSuccessfullyPopUpMsg;
    @FindBy(xpath = "(//div[text()='Cancel'])[1]")
    private WebElement clickOnCancelBtn;
    @FindBy(xpath = "//span[text()='Order cancelled successfully']")
    private WebElement orderCancelledSuccessfullyPopUpMsg;
    @FindBy(xpath = "(//td[@class='ant-table-cell']/p)[24]")
    private WebElement totalAmount;
    @FindBy(xpath = "//p[text()='Open Orders']")
    private WebElement openOrders;
    @FindBy(xpath = "//p[text()='All Orders']")
    private WebElement allOrders;
    @FindBy(xpath = "//p[text()='Trade History']")
    private WebElement tradeHistory;
    @FindBy(xpath = "(//td[@class='ant-table-cell'])[70]")
    private WebElement status;

    public boolean validateBuyLimitOrderCreatedSuccessfully(String createOrder,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String buyLimitPrice = PropertyReaderOptimized.getKeyValue("buyLimitPrice");
        String usdtAmount = PropertyReaderOptimized.getKeyValue("usdtAmount");

        //Click on the trade button
        basePage.waitForElementToBeVisible(tradeBtn);
        basePage.click(tradeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the trade button.");

        //Click on the drop-down
        basePage.waitForElementToBeVisible(dropDownButton);
        basePage.click(dropDownButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the drop-down.");

        //Click on the currency pair
        basePage.waitForElementToBeVisible(ethUSDTPair);
        basePage.click(ethUSDTPair);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the currency pair.");

        //Before place the limit order total available balance of USDT
        basePage.waitForElementToBeVisible(availableBalanceOfUSDT);
        String beforePlaceBuyLimitOrderTotalAvailableBalanceOfUSDT = basePage.getText(availableBalanceOfUSDT);
        double beforePlaceLimitOrderTotalAvailableBalanceOfUSDT=Double.parseDouble(beforePlaceBuyLimitOrderTotalAvailableBalanceOfUSDT.replace(",",""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Before place buy limit order available balance of USDT is:  " + beforePlaceLimitOrderTotalAvailableBalanceOfUSDT);

        //Before trade total available balance of currency
        basePage.waitForElementToBeVisible(availableBalanceOfCurrency);
        String beforePlaceBuyLimitOrderTotalAvailableBalanceOfCurrency = basePage.getText(availableBalanceOfCurrency);
        double beforePlaceLimitOrderTotalAvailableBalanceOfCurrency=Double.parseDouble(beforePlaceBuyLimitOrderTotalAvailableBalanceOfCurrency.replace(",",""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Before place buy limit order available balance of Currency is:  " + beforePlaceLimitOrderTotalAvailableBalanceOfCurrency);

        //Click on the limit button
        basePage.waitForElementToBeVisible(limitBtn);
        basePage.click(limitBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the limit button.");

        //Remove the value from the buy limit price text field
        basePage.click(limitPriceTextField);
        basePage.clearValue(limitPriceTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified remove the value from the buy currency limit price text field.");

        //Enter the value in the buy limit price text field
        basePage.waitForElementToBeVisible(limitPriceTextField);
        basePage.enterText(limitPriceTextField, buyLimitPrice);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Enter the value in the buy currency limit price text field.");

        //Limit price text field value
        basePage.waitForElementToBeVisible(limitPriceTextField);
        String limitPriceTextFieldValue=basePage.getAttribute(limitPriceTextField);
        double limitPriceFieldValue=Double.parseDouble(limitPriceTextFieldValue.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"The price of the currency entered by the user is:  "+limitPriceFieldValue);

        //Enter the value in the amount text field
        basePage.waitForElementToBeVisible(limitTotalTextField);
        basePage.enterText(limitTotalTextField, usdtAmount);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Enter the value in the amount text field.");

        //Total amount
        basePage.waitForElementToBeVisible(limitTotalTextField);
        String USDTAmount = basePage.getAttribute(limitTotalTextField);
        double enterUSDTAmt=Double.parseDouble(USDTAmount.replace(",",""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "The value of the USDT entered by the user is:  " + enterUSDTAmt+"USDT");

        //Get the value from the currency amount text field
        basePage.waitForElementToBeVisible(limitEnterAmountTextField);
        String getCurrencyAmount = basePage.getAttribute(limitEnterAmountTextField);
        double getCurrencyAmt=Double.parseDouble(getCurrencyAmount.replace(",",""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "After enter the USDT amount the quantity of the currency is: " + getCurrencyAmt);

        //Click on the buy button
        basePage.waitForElementToBeVisible(placeBuyOrderButton);
        basePage.click(placeBuyOrderButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the place buy order button.");

        //Compare the values
        basePage.waitForElementToBeVisible(orderCreatedSuccessfullyPopUpMsg);
        String orderCreate=orderCreatedSuccessfullyPopUpMsg.getText();
        if (createOrder.equals(orderCreate)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Order created successfully pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Order created successfully pop-up message isn't matched.");
        }

        beforePlaceBuyLimitOrderAvailableBalanceOfUSDT=beforePlaceLimitOrderTotalAvailableBalanceOfUSDT;
        beforePlaceBuyLimitOrderAvailableBalanceOfCurrency=beforePlaceLimitOrderTotalAvailableBalanceOfCurrency;
        limitPriceTextFieldVal=limitPriceFieldValue;
        enterUSDTAmount=enterUSDTAmt;
        currencyAmount=getCurrencyAmt;
        return isTrue;
    }

    public boolean validateOpenOrderTotalBuyAmountShouldBeLessOrEqualEnterUSDTAmount(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Enter amount
        double enterUSDTAmt=enterUSDTAmount;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Enter amount is: "+enterUSDTAmt);

        //Convert string values to double
        String totalTradingAmount = totalAmount.getText();
        double tradingUSDTAmount = Double.parseDouble(totalTradingAmount.replace(",", ""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Open order history trading amount is: " + tradingUSDTAmount);

        //Compare the values
        if (tradingUSDTAmount<=enterUSDTAmt) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified tradingUSDTAmount is less or equal to enterUSDTAmount.");
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified tradingUSDTAmount isn't less or equal to enterUSDTAmount.");
        }

        tradingAmountOfUSDT=tradingUSDTAmount;
        return isTrue;
    }

    public boolean validateAfterPlaceBuyLimitOrderBalanceOfUSDT(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Before place limit order balance of USDT
        double beforePlaceLimitOrderBalanceOfUSDT=beforePlaceBuyLimitOrderAvailableBalanceOfUSDT;

        //Subtract the values
        double afterPlaceBuyLimitOrderUSDTBalanceShouldBe=beforePlaceLimitOrderBalanceOfUSDT-tradingAmountOfUSDT;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place buy limit order available balance of USDT should be:  "+afterPlaceBuyLimitOrderUSDTBalanceShouldBe+"USDT");

        //After place buy the limit order total available balance of USDT
        String afterPlaceLimitOrderAvailableBalanceOfUSDTIs= basePage.getText(availableBalanceOfUSDT);
        double afterPlaceBuyLimitOrderAvailableBalanceOfUSDTIs=Double.parseDouble(afterPlaceLimitOrderAvailableBalanceOfUSDTIs.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place buy limit order available balance of USDT is:  "+afterPlaceBuyLimitOrderAvailableBalanceOfUSDTIs+"USDT");

        //Compare the values
        if(afterPlaceBuyLimitOrderAvailableBalanceOfUSDTIs==afterPlaceBuyLimitOrderUSDTBalanceShouldBe){
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceBuyLimitOrderAvailableBalanceOfUSDT) and (beforePlaceBuyLimitOrderAvailableBalanceOfUSDT-tradingAmountOfUSDT) both are equal.");
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceBuyLimitOrderAvailableBalanceOfUSDT) and (beforePlaceBuyLimitOrderAvailableBalanceOfUSDT-tradingAmountOfUSDT) both aren't equal.");
        }

        afterPlaceBuyLimitOrderAvailableBalanceOfUSDT=afterPlaceBuyLimitOrderAvailableBalanceOfUSDTIs;
        return isTrue;
    }

    public boolean validateAfterPlaceBuyLimitOrderBalanceOfCurrency(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //After place limit order balance of currency
        double afterPlaceBuyLimitOrderBalanceOfCurrencyShouldBe=beforePlaceBuyLimitOrderAvailableBalanceOfCurrency;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place buy limit order available balance of currency should be:  "+afterPlaceBuyLimitOrderBalanceOfCurrencyShouldBe);

        //After place the limit order total available balance of USDT
        String afterPlaceLimitOrderAvailableBalanceOfCurrencyIs= basePage.getText(availableBalanceOfCurrency);
        double afterPlaceBuyLimitOrderAvailableBalanceOfCurrencyIs=Double.parseDouble(afterPlaceLimitOrderAvailableBalanceOfCurrencyIs.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place buy limit order available balance of Currency is:  "+afterPlaceBuyLimitOrderAvailableBalanceOfCurrencyIs);

        //Compare the values
        if(afterPlaceBuyLimitOrderAvailableBalanceOfCurrencyIs==afterPlaceBuyLimitOrderBalanceOfCurrencyShouldBe){
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceBuyLimitOrderAvailableBalanceOfCurrency) and (beforePlaceBuyLimitOrderAvailableBalanceOfCurrency) both are equal.");
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceBuyLimitOrderAvailableBalanceOfCurrency) and (beforePlaceBuyLimitOrderAvailableBalanceOfCurrency) both aren't equal.");
        }

        afterPlaceBuyLimitOrderAvailableBalanceOfCurrency=afterPlaceBuyLimitOrderAvailableBalanceOfCurrencyIs;
        return isTrue;
    }

    public boolean validateEnterAmountAndOpenOrderAmountValueShouldBeEqual(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Open order amount value
        double  currencyAmountShouldBe=currencyAmount;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Currency amount should be: "+currencyAmountShouldBe);

        //Convert string values to double
        String amountVal=amount.getText();
        double amountValueIs=Double.parseDouble(amountVal.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Currency amount is: "+amountValueIs);

        //Compare the values
        if(amountValueIs==currencyAmountShouldBe){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified the values aren't equal.");
        }

        amountValue=amountValueIs;
        return isTrue;
    }

    public boolean validateOpenOrderAmountAndRemainingAmountShouldBeEqual(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Open order amount value
        double  amountVal=amountValue;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Currency amount is: "+amountVal);

        //Convert string values to double
        String remainingAmt=remainingAmount.getText();
        double remainingAmountValue=Double.parseDouble(remainingAmt.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Remaining amount is: "+remainingAmountValue);

        //Compare the values
        if(amountVal==remainingAmountValue){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified amount and remaining amount are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified amount and remaining amount aren't equal.");
        }

        remainingAmountVal=remainingAmountValue;
        return isTrue;
    }

    public boolean validateFilledAmountValue(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Open order amount value
        double  amountVal=amountValue;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Currency amount is: "+amountVal);

        //Open order remaining amount value
        double remainingAmountValue=remainingAmountVal;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Remaining amount is: "+remainingAmountValue);

        //Subtracts the values
        double filledAmountShouldBe=amountVal-remainingAmountValue;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Filled amount should be: "+filledAmountShouldBe);

        //Convert string values to double
        String filledAmt=filledAmount.getText();
        double filledAmountValueIs=Double.parseDouble(filledAmt.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Filled amount is: "+filledAmountValueIs);

        //Compare the values
        if(filledAmountValueIs==filledAmountShouldBe){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateEnterCurrencyPriceAndOpenOrdersPriceShouldBeEqual(ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Currency amount
        double limitPriceTextFieldValueIs=limitPriceTextFieldVal;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Enter currency amount is: "+limitPriceTextFieldValueIs);

        //Split the value
        String priceValue=currencyPrice.getText();
        String[] priceValueOnOpenOrdersPage = priceValue.split("\\s+");

        //Convert string values to double
        double priceValueOnOpenOrdersPageIs = Double.parseDouble(priceValueOnOpenOrdersPage[0]);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Price value on open orders page is: "+priceValueOnOpenOrdersPageIs);

        //Compare the values
        if ((priceValueOnOpenOrdersPageIs == limitPriceTextFieldValueIs)) {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified both the values are equal.");
        } else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateOrderTypeShouldBeLimit(ExtentTest test) throws IOException {
        boolean isTrue = false;

        String limitOrderType=PropertyReaderOptimized.getKeyValue("limitOrderType");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Order type should be: "+limitOrderType);

        //Get the value
        String limitOrderTypeIs=orderType.getText();
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Order type is: "+limitOrderTypeIs);

        //Compare the values
        if ((limitOrderTypeIs.equals(limitOrderType))) {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified both the values are equal.");
        } else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateAfterPlacedLimitOrderStatusShouldBeNewOnAllOrdersPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String limitOpenOrderStatus=PropertyReaderOptimized.getKeyValue("limitOpenOrderStatus");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After placed limit order on all orders page status should be: "+limitOpenOrderStatus);

        //Click on the all orders
        basePage.waitForElementToBeVisible(allOrders);
        basePage.click(allOrders);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the all orders.");

        //Get the value
        basePage.waitForElementToBeVisible(status);
        String allOrdersPageStatus=status.getText();
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After placed limit order on all orders page status is: "+allOrdersPageStatus);

        //Compare the values
        if(allOrdersPageStatus.equals(limitOpenOrderStatus)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateCancelBuyLimitOrderMessage(String cancelOrder,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Click on the open orders
        basePage.waitForElementToBeVisible(openOrders);
        basePage.click(openOrders);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the open orders.");

        //Click on the cancel button
        basePage.waitForElementToBeVisible(clickOnCancelBtn);
        basePage.click(clickOnCancelBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the cancel button.");

        //Get the value
        basePage.waitForElementToBeVisible(orderCancelledSuccessfullyPopUpMsg);
        String orderCancel=orderCancelledSuccessfullyPopUpMsg.getText();

        //Compare the values
        if (orderCancel.equals(cancelOrder)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Order cancelled successfully pop-up message is matched.");
        }else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Order cancelled successfully pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateAfterCancelLimitOrderStatusShouldBeCancelledOnAllOrdersPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String limitCancelOrderStatus=PropertyReaderOptimized.getKeyValue("limitCancelOrderStatus");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After cancelled limit order on all orders page status should be: "+limitCancelOrderStatus);

        //Click on the all orders
        basePage.waitForElementToBeVisible(allOrders);
        basePage.click(allOrders);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the all orders.");

        //Get the value
        basePage.waitForElementToBeVisible(status);
        String allOrdersPageStatus=status.getText();
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After cancelled limit order on all orders page status is: "+allOrdersPageStatus);

        //Compare the values
        if(allOrdersPageStatus.equals(limitCancelOrderStatus)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateAfterCancelLimitOrderStatusShouldBeCancelledOnTradeHistoryPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String limitCancelOrderStatus=PropertyReaderOptimized.getKeyValue("limitCancelOrderStatus");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After cancelled limit order on trade history page status should be: "+limitCancelOrderStatus);

        //Click on the trade history
        basePage.waitForElementToBeVisible(tradeHistory);
        basePage.click(tradeHistory);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Clicked on the trade history.");

        //Get the value
        basePage.waitForElementToBeVisible(status);
        String tradeHistoryPageStatus=status.getText();
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After cancelled limit order on trade history page status is: "+tradeHistoryPageStatus);

        //Compare the values
        if(tradeHistoryPageStatus.equals(limitCancelOrderStatus)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateAfterCancelBuyLimitOrderBalanceOfUSDT(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //After cancel buy limit order available balance of USDT
        double afterCancelBuyLimitOrderAvailableBalanceOfUSDTShouldBe=beforePlaceBuyLimitOrderAvailableBalanceOfUSDT;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After cancel buy limit order available balance of USDT should be: "+afterCancelBuyLimitOrderAvailableBalanceOfUSDTShouldBe);

        //Convert string values to double
        double afterPlaceLimitOrderBalanceOfUSDT=afterPlaceBuyLimitOrderAvailableBalanceOfUSDT;

        //Add the values
        double afterCancelBuyLimitOrderAvailableBalanceOfUSDTIs=afterPlaceLimitOrderBalanceOfUSDT+tradingAmountOfUSDT;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After cancel buy limit order available balance of USDT is:  "+afterCancelBuyLimitOrderAvailableBalanceOfUSDTIs);

        //Compare the values
        if(afterCancelBuyLimitOrderAvailableBalanceOfUSDTIs==afterCancelBuyLimitOrderAvailableBalanceOfUSDTShouldBe){
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (beforePlaceBuyLimitOrderAvailableBalanceOfUSDT) and (afterPlaceBuyLimitOrderBalanceOfUSDT+tradingAmountOfUSDT) both are equal.");
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceBuyLimitOrderBalanceOfUSDT) and (beforePlaceBuyLimitOrderAvailableBalanceOfUSDT+tradingAmountOfUSDT) both aren't equal.");
        }

        return isTrue;
    }

    public boolean validateAfterCancelBuyLimitOrderBalanceOfCurrency(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //After cancel buy limit order available balance of Currency
        double afterCancelBuyLimitOrderAvailableBalanceOfCurrencyShouldBe=beforePlaceBuyLimitOrderAvailableBalanceOfCurrency;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After cancel buy limit order available balance of currency should be: "+afterCancelBuyLimitOrderAvailableBalanceOfCurrencyShouldBe);

        //Convert string values to double
        double afterCancelBuyLimitOrderAvailableBalanceOfCurrencyIs=afterPlaceBuyLimitOrderAvailableBalanceOfCurrency;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After cancel buy limit order available balance of currency is:  "+afterCancelBuyLimitOrderAvailableBalanceOfCurrencyIs);

        //Compare the values
        if(afterCancelBuyLimitOrderAvailableBalanceOfCurrencyIs==afterCancelBuyLimitOrderAvailableBalanceOfCurrencyShouldBe){
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (beforePlaceLimitOrderAvailableBalanceOfCurrency) and (afterCancelLimitOrderAvailableBalanceOfCurrency) both are equal.");
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceLimitOrderBalanceOfCurrency) and (beforeCancelLimitOrderAvailableBalanceOfCurrency) both aren't equal.");
        }

        return isTrue;
    }
}
