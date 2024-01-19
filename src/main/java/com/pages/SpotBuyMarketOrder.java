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
    @FindBy(xpath = "//p[text()='All Orders']")
    private WebElement allOrders;
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

    public boolean validateBuyMarketOrderCreatedSuccessfully(String createOrder, ExtentTest test) throws IOException {
        boolean isTrue = false;

        String amount = PropertyReaderOptimized.getKeyValue("amount");

        //Click on the trade button
        basePage.waitForElementToBeVisible(tradeBtn);
        basePage.click(tradeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the trade button.");

        //Before place the market order total available balance of USDT
        basePage.waitForElementToBeVisible(availableBalanceOfUSDT);
        String beforePlaceBuyMarketOrderTotalAvailableBalanceOfUSDT = basePage.getText(availableBalanceOfUSDT);
        double beforePlaceMarketOrderTotalAvailableBalanceOfUSDT = Double.parseDouble(beforePlaceBuyMarketOrderTotalAvailableBalanceOfUSDT.replace(",", ""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Before place buy market order available balance of USDT is:  " + beforePlaceBuyMarketOrderTotalAvailableBalanceOfUSDT);

        //Before trade total available balance of currency
        basePage.waitForElementToBeVisible(availableBalanceOfCurrency);
        String beforePlaceBuyMarketOrderTotalAvailableBalanceOfCurrency = basePage.getText(availableBalanceOfCurrency);
        double beforePlaceMarketOrderTotalAvailableBalanceOfCurrency = Double.parseDouble(beforePlaceBuyMarketOrderTotalAvailableBalanceOfCurrency.replace(",", ""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Before place buy market order available balance of Currency is:  " + beforePlaceMarketOrderTotalAvailableBalanceOfCurrency);

        //Enter the value in the amount text field
        basePage.waitForElementToBeVisible(marketTotalTextField);
        basePage.enterText(marketTotalTextField, amount);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Enter the value in the amount text field.");

        //Total amount
        basePage.waitForElementToBeVisible(marketTotalTextField);
        String USDTAmount = basePage.getAttribute(marketTotalTextField);
        double enterUSDTAmt = Double.parseDouble(USDTAmount.replace(",", ""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "The value of the USDT entered by the user is:  " + enterUSDTAmt + "USDT");

        //Get the value from the currency amount text field
        basePage.waitForElementToBeVisible(marketCoinAmountTextField);
        String getCurrencyAmount = basePage.getAttribute(marketCoinAmountTextField);
        double getCurrencyAmt = Double.parseDouble(getCurrencyAmount.replace(",", ""));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "After enter the USDT amount the quantity of the currency is: " + getCurrencyAmt);

        //Click on the buy button
        basePage.waitForElementToBeVisible(placeBuyOrderButton);
        basePage.click(placeBuyOrderButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the place buy order button.");

        //Compare the values
        basePage.waitForElementToBeVisible(orderCreatedSuccessfullyPopUpMsg);
        String orderCreate = orderCreatedSuccessfullyPopUpMsg.getText();
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
        test.log(LogStatus.INFO,"Market order status should be: "+marketOrderStatus);

        //Click on the all orders
        basePage.waitForElementToBeVisible(allOrders);
        basePage.click(allOrders);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the all orders.");

        //Get the value
        basePage.waitForElementToBeVisible(statusDone);
        String status=statusDone.getText();
        test.log(LogStatus.INFO,"Market order status is: "+status);

        //Compare the values
        if(status.equals(marketOrderStatus)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified order status should be done and it is Done.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified order status should be done but it is New.");
        }

        return isTrue;
    }

    public boolean validateTypeOfOrderShouldBeMarket(ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Type of order
        String typeOfOrderShouldBe=PropertyReaderOptimized.getKeyValue("typeOfOrder");
        test.log(LogStatus.INFO,"Type of order should be: "+typeOfOrderShouldBe);

        //Get the value
        String typeOfOrderIs=basePage.getText(orderType);
        test.log(LogStatus.INFO,"Type of order is: "+typeOfOrderIs);

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
        test.log(LogStatus.INFO,"Order side should be: "+orderSideShouldBe);

        //Get the value
        String orderSideIs=sideBuyAndFull.getText();
        test.log(LogStatus.INFO,"Market order status should be: "+orderSideIs);

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
        test.log(LogStatus.INFO,"Type of price should be: "+typeOfPriceShouldBe);

        //Get the value
        String priceTypeIs=basePage.getText(priceType);
        test.log(LogStatus.INFO,"Type of price is: "+priceTypeIs);

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
        test.log(LogStatus.INFO,"Enter currency amount is: "+currencyAmountIs);

        //Split the value
        String fillAmount=filledAmount.getText();
        String[] filledAmount = fillAmount.split("\\s+");

        //Convert string values to double
        double filledAmountIs = Double.parseDouble(filledAmount[0]);
        test.log(LogStatus.INFO,"Filled amount is: "+filledAmountIs);

        //Compare the values
        if ((filledAmountIs == currencyAmountIs)) {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified both the values are equal.");
        } else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateRemainingAmountValue(ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Enter currency amount
        double enterCurrencyAmountIs=currencyAmount;
        test.log(LogStatus.INFO,"Enter amount is: "+enterCurrencyAmountIs);

        //Filled currency amount
        double filledCurrencyAmountIs=filledCurrencyAmount;
        test.log(LogStatus.INFO,"Filled amount is: "+filledCurrencyAmountIs);

        //Subtract the values
        double remainingAmountShouldBe=enterCurrencyAmountIs-filledCurrencyAmountIs;
        test.log(LogStatus.INFO,"Remaining amount should be: "+remainingAmountShouldBe);

        //Split the value
        String remainingAmt=remainingAmount.getText();
        String [] remainingAmountValue=remainingAmt.split("\\s+");

        //Convert string values to double
        double remainingAmountIs=Double.parseDouble(remainingAmountValue[0]);
        test.log(LogStatus.INFO,"Remaining amount is: "+remainingAmountIs);

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
        test.log(LogStatus.INFO,"Enter amount is: "+enterUSDTAmt);

        //Convert string values to double
        String totalTradingAmount = totalAmount.getText();
        double tradingUSDTAmount = Double.parseDouble(totalTradingAmount.replace(",", ""));
        test.log(LogStatus.INFO, "Order history trading amount is: " + tradingUSDTAmount);

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
        double afterPlaceBuyMarketOrderUSDTBalanceShouldBe=beforePlaceMarketOrderBalanceOfUSDT-(tradingAmountOfUSDT+(tradingAmountOfUSDT*0.2)/100);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place buy market order available balance of USDT should be:  "+afterPlaceBuyMarketOrderUSDTBalanceShouldBe);

        //After place buy the market order available balance of USDT
        String afterPlaceMarketOrderAvailableBalanceOfUSDTIs= basePage.getText(availableBalanceOfUSDT);
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
        double afterPlaceBuyMarketOrderBalanceOfCurrencyShouldBe=beforePlaceBuyMarketOrderBalanceOfCurrency+filledCurrencyAmount;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After place buy market order available balance of currency should be:  "+afterPlaceBuyMarketOrderBalanceOfCurrencyShouldBe);

        //After place the market order available balance of currency
        String afterPlaceMarketOrderAvailableBalanceOfCurrencyIs= basePage.getText(availableBalanceOfCurrency);
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