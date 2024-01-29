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

public class SpotSellLimitOrder {
    WebDriver driver;
    BasePage basePage;
    double tradingCurrencyAmount;
    double beforePlaceSellLimitOrderAvailableBalanceOfUSDT;
    double beforePlaceSellLimitOrderAvailableBalanceOfCurrency;
    double limitPriceTextFieldVal;
    double currencyAmount;
    double enterUSDTAmount;
    double amountValue;
    double remainingAmountVal;
    double afterPlaceSellLimitOrderAvailableBalanceOfUSDT;
    double afterPlaceSellLimitOrderAvailableBalanceOfCurrency;

    public SpotSellLimitOrder(WebDriver driver){
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
    @FindBy(xpath = "//button[text()='Sell']")
    private WebElement sellBtn;
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
    @FindBy(xpath = "(//span[text()='PLACE SELL ORDER'])[2]")
    private WebElement placeSellOrderButton;
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
    public boolean validateSellLimitOrderCreatedSuccessfully(String createOrder,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String sellLimitPrice = PropertyReaderOptimized.getKeyValue("sellLimitPrice");
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

        //Click on the sell button
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(sellBtn);
        basePage.click(sellBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the sell button.");

        //Before place the limit order total available balance of USDT
        basePage.waitForElementToBeVisible(availableBalanceOfUSDT);
        String beforePlaceSellLimitOrderTotalAvailableBalanceOfUSDT = basePage.getText(availableBalanceOfUSDT);
        double beforePlaceLimitOrderTotalAvailableBalanceOfUSDT=Double.parseDouble(beforePlaceSellLimitOrderTotalAvailableBalanceOfUSDT.replace(",",""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Before place sell limit order available balance of USDT is:  " + beforePlaceLimitOrderTotalAvailableBalanceOfUSDT);

        //Before trade total available balance of currency
        basePage.waitForElementToBeVisible(availableBalanceOfCurrency);
        String beforePlaceSellLimitOrderTotalAvailableBalanceOfCurrency = basePage.getText(availableBalanceOfCurrency);
        double beforePlaceLimitOrderTotalAvailableBalanceOfCurrency=Double.parseDouble(beforePlaceSellLimitOrderTotalAvailableBalanceOfCurrency.replace(",",""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Before place sell limit order available balance of currency is:  " + beforePlaceLimitOrderTotalAvailableBalanceOfCurrency);

        //Click on the limit button
        basePage.waitForElementToBeVisible(limitBtn);
        basePage.click(limitBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the limit button.");

        //Remove the value from the sell limit price text field
        basePage.click(limitPriceTextField);
        basePage.clearValue(limitPriceTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified remove the value from the buy Sell limit price text field.");

        //Enter the value in the limit price text field
        basePage.waitForElementToBeVisible(limitPriceTextField);
        basePage.enterText(limitPriceTextField, sellLimitPrice);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Enter the value in the Sell currency limit price text field.");

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
        String getCurrencyAmt = basePage.getAttribute(limitEnterAmountTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "After enter the USDT amount the quantity of the currency is: " + getCurrencyAmt);
        double getCurrencyAmount=Double.parseDouble(getCurrencyAmt.replace(",",""));

        //Click on the sell button
        basePage.waitForElementToBeVisible(placeSellOrderButton);
        basePage.click(placeSellOrderButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the place sell order button.");

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

        beforePlaceSellLimitOrderAvailableBalanceOfUSDT=beforePlaceLimitOrderTotalAvailableBalanceOfUSDT;
        beforePlaceSellLimitOrderAvailableBalanceOfCurrency=beforePlaceLimitOrderTotalAvailableBalanceOfCurrency;
        limitPriceTextFieldVal=limitPriceFieldValue;
        currencyAmount=getCurrencyAmount;
        enterUSDTAmount=enterUSDTAmt;
        return isTrue;
    }

    public boolean validateOpenOrderTotalSellAmountShouldBeLessOrEqualEnterUSDTAmount(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Enter amount
        double enterUSDTAmt=enterUSDTAmount;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Enter amount is: "+enterUSDTAmt);

        //Convert string values to double
        String totalTradingAmount = totalAmount.getText();
        double tradingUSDTAmount = Double.parseDouble(totalTradingAmount.replace(",", ""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Open order history trading amount is: "+tradingUSDTAmount);

        //Compare the values
        if ( tradingUSDTAmount<=enterUSDTAmt) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified tradingUSDTAmount is less or equal to enterUSDTAmount.");
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified tradingUSDTAmount isn't less or equal to enterUSDTAmount.");
        }

        return isTrue;
    }

    public boolean validateAfterPlaceSellLimitOrderBalanceOfUSDT(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Convert string values to double
        double afterPlaceSellLimitOrderUSDTBalanceShouldBe=beforePlaceSellLimitOrderAvailableBalanceOfUSDT;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place sell limit order available balance of USDT should be:  "+afterPlaceSellLimitOrderUSDTBalanceShouldBe);

        //After place sell limit order total available balance of USDT
        String afterPlaceLimitOrderAvailableBalanceOfUSDTIs= basePage.getText(availableBalanceOfUSDT);
        double afterPlaceSellLimitOrderAvailableBalanceOfUSDTIs=Double.parseDouble(afterPlaceLimitOrderAvailableBalanceOfUSDTIs.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place sell limit order available balance of USDT is:  "+afterPlaceSellLimitOrderAvailableBalanceOfUSDTIs+"USDT");

        //Compare the values
        if(afterPlaceSellLimitOrderAvailableBalanceOfUSDTIs==afterPlaceSellLimitOrderUSDTBalanceShouldBe){
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceSellLimitOrderAvailableBalanceOfUSDT) and (beforePlaceSellLimitOrderAvailableBalanceOfUSDT) both are equal.");
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceSellLimitOrderAvailableBalanceOfUSDT) and (beforePlaceSellLimitOrderAvailableBalanceOfUSDT) both aren't equal.");
        }

        afterPlaceSellLimitOrderAvailableBalanceOfUSDT=afterPlaceSellLimitOrderAvailableBalanceOfUSDTIs;
        return isTrue;
    }

    public boolean validateAfterPlaceSellLimitOrderBalanceOfCurrency(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String amountOfCurrency=amount.getText();
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "The total placed balance of currency in open order history is:  " + amountOfCurrency);

        //Convert string values to double
        double tradingAmountOfCurrency=Double.parseDouble(amountOfCurrency.replace(",",""));
        double beforePlaceSellLimitOrderBalanceOfCurrency=beforePlaceSellLimitOrderAvailableBalanceOfCurrency;

        //Subtract the values
        Double afterPlaceSellLimitOrderCurrencyBalanceShouldBe=beforePlaceSellLimitOrderBalanceOfCurrency-tradingAmountOfCurrency;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place the limit order available balance of currency should be:  "+afterPlaceSellLimitOrderCurrencyBalanceShouldBe);


        //After place the limit order total available balance of currency
        String afterPlaceLimitOrderAvailableBalanceOfCurrencyIs= basePage.getText(availableBalanceOfCurrency);
        double afterPlaceSellLimitOrderAvailableBalanceOfCurrencyIs=Double.parseDouble(afterPlaceLimitOrderAvailableBalanceOfCurrencyIs.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place the limit order available balance of Currency is:  "+afterPlaceSellLimitOrderAvailableBalanceOfCurrencyIs);

        //Compare the values
        if(afterPlaceSellLimitOrderAvailableBalanceOfCurrencyIs==afterPlaceSellLimitOrderCurrencyBalanceShouldBe){
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceSellLimitOrderAvailableBalanceOfCurrency) and (beforePlaceSellLimitOrderAvailableBalanceOfCurrency-tradingAmountOfCurrency) both are equal.");
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceSellLimitOrderAvailableBalanceOfUSDT) and (beforePlaceSellLimitOrderAvailableBalanceOfUSDT-tradingAmountOfCurrency) both aren't equal.");
        }

        afterPlaceSellLimitOrderAvailableBalanceOfCurrency=afterPlaceSellLimitOrderAvailableBalanceOfCurrencyIs;
        tradingCurrencyAmount=tradingAmountOfCurrency;
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
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Currency amount should be: "+remainingAmountValue);

        //Convert string values to double
        String filledAmt=filledAmount.getText();
        double filledAmountValueIs=Double.parseDouble(filledAmt.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Filled amount is: "+filledAmountValueIs);

        //Subtracts the values
        double filledAmountShouldBe=amountVal-remainingAmountValue;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Filled amount should be: "+filledAmountShouldBe);

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

    public boolean validateCancelSellLimitOrderMessage(String cancelOrder,ExtentTest test) throws IOException, InterruptedException {
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

    public boolean validateAfterCancelSellLimitOrderBalanceOfUSDT(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Convert string values to double
        double afterCancelSellLimitOrderBalanceOfUSDTShouldBe=beforePlaceSellLimitOrderAvailableBalanceOfUSDT;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After cancel sell limit order available balance of USDT should be:  "+afterCancelSellLimitOrderBalanceOfUSDTShouldBe);

        //After cancel sell limit order balance of USDT
        double afterCancelSellLimitOrderBalanceOfUSDTIs=afterPlaceSellLimitOrderAvailableBalanceOfUSDT;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After cancel sell limit order available balance of USDT is: "+afterCancelSellLimitOrderBalanceOfUSDTIs);

        //Compare the values
        if(afterCancelSellLimitOrderBalanceOfUSDTIs==afterCancelSellLimitOrderBalanceOfUSDTShouldBe){
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (beforeCancelSellLimitOrderAvailableBalanceOfUSDT) and (afterCancelSellLimitOrderBalanceOfUSDT) both are equal.");
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceSellLimitOrderBalanceOfUSDT) and (beforeCancelSellLimitOrderAvailableBalanceOfUSDT) both aren't equal.");
        }

        return isTrue;
    }

    public boolean validateAfterCancelSellLimitOrderBalanceOfCurrency(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //After cancel sell limit order available balance of currency
        double afterCancelSellLimitOrderAvailableBalanceOfCurrencyShouldBe=beforePlaceSellLimitOrderAvailableBalanceOfCurrency;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After cancel sell limit order available balance of currency should be: "+afterCancelSellLimitOrderAvailableBalanceOfCurrencyShouldBe);

        //Convert string values to double
        double afterPlaceSellLimitOrderBalanceOfCurrency=afterPlaceSellLimitOrderAvailableBalanceOfCurrency;

        //Add the values
        double afterCancelSellLimitOrderAvailableBalanceOfCurrencyIs=afterPlaceSellLimitOrderBalanceOfCurrency+tradingCurrencyAmount;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After cancel sell limit order available balance of currency is:  "+afterCancelSellLimitOrderAvailableBalanceOfCurrencyIs);

        //Compare the values
        if(afterCancelSellLimitOrderAvailableBalanceOfCurrencyIs==afterCancelSellLimitOrderAvailableBalanceOfCurrencyShouldBe){
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (beforePlaceSellLimitOrderAvailableBalanceOfCurrency) and (afterPlaceSellLimitOrderAvailableBalanceOfCurrency+tradingCurrencyAmount) both are equal.");
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceSellLimitOrderBalanceOfCurrency) and (beforePlaceSellLimitOrderAvailableBalanceOfCurrency+tradingCurrencyAmount) both aren't equal.");
        }

        return isTrue;
    }
}
