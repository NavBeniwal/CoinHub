package CoinHubModule.tests.web;

import CoinHubModule.base.TestBase;
import com.pages.LoginPage;
import com.pages.SpotSellLimitOrder;
import com.relevantcodes.extentreports.LogStatus;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class SpotSellLimitOrderScript extends TestBase {
    SpotSellLimitOrder sellLimitOrder;
    LoginPage loginPage;
    SoftAssert softAssert;

    public SpotSellLimitOrderScript(){
        sellLimitOrder=new SpotSellLimitOrder(driver);
        loginPage=new LoginPage(driver);
        softAssert=new SoftAssert();
    }

    @Test(priority = 1)
    public void verifyLoginPageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginPage.validateLoginPage(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 2)
    public void verifySellLimitOrderCreatedSuccessfullyFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateSellLimitOrderCreatedSuccessfully(PropertyReaderOptimized.getExcelSheetValue(1,7),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 3)
    public void verifyOpenOrderTotalSellAmountShouldBeLessOrEqualEnterUSDTAmountFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateOpenOrderTotalSellAmountShouldBeLessOrEqualEnterUSDTAmount(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 4)
    public void verifyAfterPlaceSellLimitOrderBalanceOfUSDTFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateAfterPlaceSellLimitOrderBalanceOfUSDT(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 5)
    public void verifyAfterPlaceSellLimitOrderBalanceOfCurrencyFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateAfterPlaceSellLimitOrderBalanceOfCurrency(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 6)
    public void verifyEnterAmountAndOpenOrderAmountValueShouldBeEqualFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateEnterAmountAndOpenOrderAmountValueShouldBeEqual(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 7)
    public void verifyOpenOrderAmountAndRemainingAmountShouldBeEqualFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateOpenOrderAmountAndRemainingAmountShouldBeEqual(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 8)
    public void verifyFilledAmountValueFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateFilledAmountValue(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 9)
    public void verifyPriceCurrencyValueFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateCurrencyPriceValue(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 10)
    public void verifyOrderTypeFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateOrderType(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 11)
    public void verifyAfterPlacedLimitOrderStatusShouldBeNewFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateAfterPlacedLimitOrderStatusShouldBeNew(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 12)
    public void verifyCancelSellLimitOrderMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateCancelSellLimitOrderMessage(PropertyReaderOptimized.getExcelSheetValue(2,7),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 13)
    public void verifyAfterPlacedLimitOrderStatusShouldBeCancelledFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateAfterPlacedLimitOrderStatusShouldBeCancelled(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 14)
    public void verifyAfterCancelSellLimitOrderBalanceOfUSDTFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateAfterCancelSellLimitOrderBalanceOfUSDT(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 15)
    public void verifyAfterCancelSellLimitOrderBalanceOfCurrencyFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(sellLimitOrder.validateAfterCancelSellLimitOrderBalanceOfCurrency(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
}
