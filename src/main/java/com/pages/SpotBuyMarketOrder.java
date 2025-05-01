package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SpotBuyMarketOrder {
    WebDriver driver;
    BasePage basePage;

    double beforePlaceBuyMarketOrderAvailableBalanceOfUSDT;
    double beforePlaceBuyMarketOrderAvailableBalanceOfCurrency;
    double enterUSDTAmount;
    double currencyAmount;
    double filledCurrencyAmount;
    double tradingAmountOfUSDT;

    public SpotBuyMarketOrder(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
        PageFactory.initElements(driver, this);
    }

    private By tradeBtn= By.xpath("//span[text()='Trade']");
    private By dropDownButton= By.xpath("//div[@class='style_selectMarket__currency__RS+if']");
    private By bnbUSDTPair= By.xpath("//h3[text()='BNB/USDT']");
    private By ethUSDTPair= By.xpath("//h3[text()='ETH/USDT']");
    private By btcUSDTPair= By.xpath("//h3[text()='BTC/USDT']");
    private By trxUSDTPair= By.xpath("//h3[text()='TRX/USDT']");
    private By shibUSDTPair= By.xpath("//h3[text()='SHIB/USDT']");
    private By availableBalanceOfCurrency= By.xpath("(//h4)[15]");
    private By availableBalanceOfUSDT= By.xpath("(//h4)[13]");
    private By marketCoinAmountTextField= By.xpath("(//input[@placeholder='Enter Amount'])[1]");
    private By marketButton= By.xpath("//div[text()='МARKET']");
    private By marketTotalTextField= By.xpath("(//input[@placeholder='Total'])[1]");
    private By placeBuyOrderButton= By.xpath("(//span[text()=' PLACE BUY ORDER'])[2]");
    private By orderCreatedSuccessfullyPopUpMsg= By.xpath("//span[text()='Order created successfully ']");
    private By allOrders= By.xpath("//p[text()='All Orders']");
    private By tradeHistory= By.xpath("//p[text()='Trade History']");
    private By orderType= By.xpath("//p[text()='Market']");
    private By sideBuyAndFull= By.xpath("(//div[@class='flexCenter'])[1]");
    private By priceType= By.xpath("//div[text()='Market']");
    private By filledAmount= By.xpath("(//td[@class='ant-table-cell']/div)[4]");
    private By remainingAmount= By.xpath("(//div[@class='flexCenter']/p)[1]");
    private By totalAmount= By.xpath("(//td[@class='ant-table-cell']/p)[24]");
    private By status= By.xpath("(//td[@class='ant-table-cell'])[70]");
    private By arrowButton= By.xpath("//div[@class='logo sideBarbottomlogo']/span");

    public boolean validateBuyMarketOrderCreatedSuccessfully(String createOrder, ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String amount = PropertyReaderOptimized.getKeyValue("amount");

        //Click on the arrow
        basePage.waitForElementToBeVisible(arrowButton);
        basePage.click(arrowButton);

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

        //Before place the market order total available balance of USDT
        basePage.waitForElementToBeVisible(availableBalanceOfUSDT);
        String beforePlaceBuyMarketOrderTotalAvailableBalanceOfUSDT = basePage.doGetElementText(availableBalanceOfUSDT);
        double beforePlaceMarketOrderTotalAvailableBalanceOfUSDT = Double.parseDouble(beforePlaceBuyMarketOrderTotalAvailableBalanceOfUSDT.replace(",", ""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Before place buy market order available balance of USDT is:  " + beforePlaceBuyMarketOrderTotalAvailableBalanceOfUSDT);

        //Before trade total available balance of currency
        basePage.waitForElementToBeVisible(availableBalanceOfCurrency);
        String beforePlaceBuyMarketOrderTotalAvailableBalanceOfCurrency = basePage.doGetElementText(availableBalanceOfCurrency);
        double beforePlaceMarketOrderTotalAvailableBalanceOfCurrency = Double.parseDouble(beforePlaceBuyMarketOrderTotalAvailableBalanceOfCurrency.replace(",", ""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Before place buy market order available balance of Currency is:  " + beforePlaceMarketOrderTotalAvailableBalanceOfCurrency);

        //Click on the market button
        basePage.waitForElementToBeVisible(marketButton);
        basePage.click(marketButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified click on the market button.");

//        //Scroll the page
//        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");

        //Enter the value in the amount text field
        Thread.sleep(10000);
        basePage.waitForElementToBeVisible(marketTotalTextField);
        basePage.enterText(marketTotalTextField, amount);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Enter the value in the amount text field.");

        //Total amount
        basePage.waitForElementToBeVisible(marketTotalTextField);
        String USDTAmount = basePage.getAttribute((WebElement) marketTotalTextField);
        double enterUSDTAmt = Double.parseDouble(USDTAmount.replace(",", ""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "The value of the USDT entered by the user is:  " + enterUSDTAmt + "USDT");

        //Get the value from the currency amount text field
        basePage.waitForElementToBeVisible(marketCoinAmountTextField);
        String getCurrencyAmount = basePage.getAttribute((WebElement) marketCoinAmountTextField);
        double getCurrencyAmt = Double.parseDouble(getCurrencyAmount.replace(",", ""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "After enter the USDT amount the quantity of the currency is: " + getCurrencyAmt);

        //Click on the buy button
        basePage.waitForElementToBeVisible(placeBuyOrderButton);
        basePage.click(placeBuyOrderButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the place buy order button.");

        //Compare the values
        basePage.waitForElementToBeVisible(orderCreatedSuccessfullyPopUpMsg);
        String orderCreate = basePage.doGetElementText(orderCreatedSuccessfullyPopUpMsg);
        if (createOrder.equals(orderCreate)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Order created successfully pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Order created successfully pop-up message isn't matched.");
        }

        beforePlaceBuyMarketOrderAvailableBalanceOfUSDT = beforePlaceMarketOrderTotalAvailableBalanceOfUSDT;
        beforePlaceBuyMarketOrderAvailableBalanceOfCurrency = beforePlaceMarketOrderTotalAvailableBalanceOfCurrency;
        enterUSDTAmount = enterUSDTAmt;
        currencyAmount = getCurrencyAmt;
        return isTrue;
    }

    public boolean validateAfterPlacedMarketOrderStatusShouldBeDone(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String marketOrderStatus=PropertyReaderOptimized.getKeyValue("marketOrderStatus");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Market order status on all trades page should be: "+marketOrderStatus);

        //Click on the all orders
        basePage.waitForElementToBeVisible(allOrders);
        basePage.click(allOrders);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the all orders.");

        //Get the value
        basePage.waitForElementToBeVisible(status);
        String allOrdersPageStatusIs=basePage.doGetElementText(status);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Market order status on all trades page is: "+allOrdersPageStatusIs);

        //Compare the values
        if(allOrdersPageStatusIs.equals(marketOrderStatus)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateAfterPlacedMarketOrderOnTradeHistoryPageStatusShouldBeDone(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String marketOrderStatus=PropertyReaderOptimized.getKeyValue("marketOrderStatus");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After placed market order on trade history page status should be: "+marketOrderStatus);

        //Click on the trade history
        basePage.waitForElementToBeVisible(tradeHistory);
        basePage.click(tradeHistory);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Clicked on the trade history.");

        //Get the value
        basePage.waitForElementToBeVisible(status);
        String tradeHistoryPageStatus=basePage.doGetElementText(status);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After cancelled limit order on trade history page status is: "+tradeHistoryPageStatus);

        //Compare the values
        if(tradeHistoryPageStatus.equals(marketOrderStatus)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateTypeOfOrderShouldBeMarket(ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Click on the all orders
        basePage.waitForElementToBeVisible(allOrders);
        basePage.click(allOrders);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the all orders.");

        //Type of order
        String typeOfOrderShouldBe=PropertyReaderOptimized.getKeyValue("typeOfOrder");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Type of order on all orders page should be: "+typeOfOrderShouldBe);

        //Get the value
        String typeOfOrderIs=basePage.doGetElementText(orderType);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Type of order on all orders page is: "+typeOfOrderIs);

        //Compare the values
        if(typeOfOrderIs.equals(typeOfOrderShouldBe)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified type of order is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified type of order isn't matched.");
        }

        return isTrue;
    }

    public boolean validateSideOfOrderShouldBeBuyAndFull(ExtentTest test) throws IOException {
        boolean isTrue = false;

        String orderSideShouldBe=PropertyReaderOptimized.getKeyValue("buyOrderSide");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Order side on all orders page should be: "+orderSideShouldBe);

        //Get the value
        String orderSideIs=basePage.doGetElementText(sideBuyAndFull);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Order side on all orders page status is: "+orderSideIs);

        //Compare the values
        if(orderSideIs.equals(orderSideShouldBe)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified both the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validatePriceTypeShouldBeMarket(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Price type
        String typeOfPriceShouldBe=PropertyReaderOptimized.getKeyValue("typeOfPrice");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Type of price on all orders page should be: "+typeOfPriceShouldBe);

        //Get the value
        String priceTypeIs=basePage.doGetElementText(priceType);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Type of price on all orders page is: "+priceTypeIs);

        //Compare the values
        if(priceTypeIs.equals(typeOfPriceShouldBe)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified type of price is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified type of price isn't matched.");
        }

        return isTrue;
    }

    public boolean validateFilledAmountValue(ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Currency amount
        double currencyAmountIs=currencyAmount;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Entered currency amount is: "+currencyAmountIs);

        //Split the value
        String fillAmount=basePage.doGetElementText(filledAmount);
        String[] filledAmount = fillAmount.split("\\s+");

        //Convert string values to double
        double filledAmountIs = Double.parseDouble(filledAmount[0]);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Filled amount on all orders page is: "+filledAmountIs);

        //Compare the values
        if ((filledAmountIs == currencyAmountIs)) {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified both the values are equal.");
        } else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified both the values aren't equal.");
        }

        filledCurrencyAmount=filledAmountIs;
        return isTrue;
    }

    public boolean validateRemainingAmountValue(ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Enter currency amount
        double enterCurrencyAmountIs=currencyAmount;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Entered amount is: "+enterCurrencyAmountIs);

        //Filled currency amount
        double filledCurrencyAmountIs=filledCurrencyAmount;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Filled amount on all orders page is: "+filledCurrencyAmountIs);

        //Subtract the values
        double remainingAmountShouldBe=enterCurrencyAmountIs-filledCurrencyAmountIs;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Remaining amount on all orders page should be: "+remainingAmountShouldBe);

        //Split the value
        String remainingAmt=basePage.doGetElementText(remainingAmount);
        String [] remainingAmountValue=remainingAmt.split("\\s+");

        //Convert string values to double
        double remainingAmountIs=Double.parseDouble(remainingAmountValue[0]);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Remaining amount on all orders page is: "+remainingAmountIs);

        //Compare the values
        if (remainingAmountIs==remainingAmountShouldBe) {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified both the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateOrderTotalAmountShouldBeLessOrEqualEnterUSDTAmount(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Enter amount
        double enterUSDTAmt=enterUSDTAmount;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Entered amount is: "+enterUSDTAmt);

        //Convert string values to double
        String totalTradingAmount = basePage.doGetElementText(totalAmount);
        double tradingUSDTAmount = Double.parseDouble(totalTradingAmount.replace(",", ""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"On all orders page total amount is: " + tradingUSDTAmount);

        //Compare the values
        if (tradingUSDTAmount<=enterUSDTAmt) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified totalUSDTAmount is less or equal to enterUSDTAmount.");
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified totalUSDTAmount isn't less or equal to enterUSDTAmount.");
        }

        tradingAmountOfUSDT=tradingUSDTAmount;
        return isTrue;
    }

    public boolean validateAfterPlaceBuyMarketOrderBalanceOfUSDT(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Before place market order balance of USDT
        double beforePlaceMarketOrderBalanceOfUSDT=beforePlaceBuyMarketOrderAvailableBalanceOfUSDT;

        //Subtract the values
        double afterPlaceBuyMarketOrderUSDTBalanceShouldBe=beforePlaceMarketOrderBalanceOfUSDT-tradingAmountOfUSDT;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place buy market order available balance of USDT should be:  "+afterPlaceBuyMarketOrderUSDTBalanceShouldBe);

        //After place buy the market order available balance of USDT
        String afterPlaceMarketOrderAvailableBalanceOfUSDTIs= basePage.doGetElementText(availableBalanceOfUSDT);
        double afterPlaceBuyMarketOrderAvailableBalanceOfUSDTIs=Double.parseDouble(afterPlaceMarketOrderAvailableBalanceOfUSDTIs.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place buy market order available balance of USDT is:  "+afterPlaceBuyMarketOrderAvailableBalanceOfUSDTIs);

        //Compare the values
        if(afterPlaceBuyMarketOrderAvailableBalanceOfUSDTIs==afterPlaceBuyMarketOrderUSDTBalanceShouldBe){
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceBuyMarketOrderAvailableBalanceOfUSDT) and (beforePlaceBuyMarketOrderAvailableBalanceOfUSDT-tradingAmountOfUSDT) both are equal.");
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceBuyMarketOrderAvailableBalanceOfUSDT) and (beforePlaceBuyMarketOrderAvailableBalanceOfUSDT-tradingAmountOfUSDT) both aren't equal.");
        }

        return isTrue;
    }

    public boolean validateAfterPlaceBuyMarketOrderBalanceOfCurrency(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Before place market order balance of currency
        double beforePlaceBuyMarketOrderBalanceOfCurrency=beforePlaceBuyMarketOrderAvailableBalanceOfCurrency;

        //After place market order currency balance should be
        double afterPlaceBuyMarketOrderBalanceOfCurrencyShouldBe=beforePlaceBuyMarketOrderBalanceOfCurrency+filledCurrencyAmount-(filledCurrencyAmount*0.2)/100;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place buy market order available balance of currency should be:  "+afterPlaceBuyMarketOrderBalanceOfCurrencyShouldBe);

        //After place the market order available balance of currency
        String afterPlaceMarketOrderAvailableBalanceOfCurrencyIs= basePage.doGetElementText(availableBalanceOfCurrency);
        double afterPlaceBuyMarketOrderAvailableBalanceOfCurrencyIs=Double.parseDouble(afterPlaceMarketOrderAvailableBalanceOfCurrencyIs.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place buy market order available balance of Currency is:  "+afterPlaceBuyMarketOrderAvailableBalanceOfCurrencyIs);

        //Compare the values
        if(afterPlaceBuyMarketOrderAvailableBalanceOfCurrencyIs==afterPlaceBuyMarketOrderBalanceOfCurrencyShouldBe){
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceBuyMarketOrderAvailableBalanceOfCurrency) and (beforePlaceBuyMarketOrderAvailableBalanceOfCurrency) both are equal.");
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified (afterPlaceBuyMarketOrderAvailableBalanceOfCurrency) and (beforePlaceBuyMarketOrderAvailableBalanceOfCurrency) both aren't equal.");
        }

        return isTrue;
    }

}
