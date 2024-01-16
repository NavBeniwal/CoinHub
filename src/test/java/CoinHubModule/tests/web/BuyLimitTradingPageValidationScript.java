package CoinHubModule.tests.web;

import CoinHubModule.base.TestBase;
import com.pages.BuyLimitTradingPageValidation;
import com.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class BuyLimitTradingPageValidationScript extends TestBase {
    BuyLimitTradingPageValidation buyLimitTradingPageValidation;
    LoginPage loginPage;
    SoftAssert softAssert;

    public BuyLimitTradingPageValidationScript(){
        buyLimitTradingPageValidation=new BuyLimitTradingPageValidation(driver);
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
    public void verifyPriceIsRequiredValidationMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(buyLimitTradingPageValidation.validatePriceIsRequiredValidationMessage(PropertyReaderOptimized.getExcelSheetValue(7,7),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 3)
    public void verifyAmountIsRequiredValidationMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(buyLimitTradingPageValidation.validateAmountIsRequiredValidationMessage(PropertyReaderOptimized.getExcelSheetValue(8,7),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 4)
    public void verifyTotalIsRequiredValidationMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(buyLimitTradingPageValidation.validateTotalIsRequiredValidationMessage(PropertyReaderOptimized.getExcelSheetValue(9,7),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 5)
    public void verifyOrderNotAsPerTradingRulesWithLowPriceValidationMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(buyLimitTradingPageValidation.validateOrderNotAsPerTradingRulesWithLowPriceValidationMessage(PropertyReaderOptimized.getExcelSheetValue(11,7),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 6)
    public void verifyOrderNotAsPerTradingRulesWithHighPriceValidationMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(buyLimitTradingPageValidation.validateOrderNotAsPerTradingRulesWithHighPriceValidationMessage(PropertyReaderOptimized.getExcelSheetValue(11,7),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 7)
    public void verifyPriceShouldBeLessThanOrEqualToValidationMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(buyLimitTradingPageValidation.validatePriceShouldBeLessThanOrEqualToValidationMessage(PropertyReaderOptimized.getExcelSheetValue(12,7),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 8)
    public void verifyInsufficientBalanceValidationMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(buyLimitTradingPageValidation.validateInsufficientBalanceValidationMessage(PropertyReaderOptimized.getExcelSheetValue(13,7),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 9)
    public void verifyTotalAmountMustBeAboveValidationMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(buyLimitTradingPageValidation.validateTotalAmountMustBeAboveValidationMessage(PropertyReaderOptimized.getExcelSheetValue(10,7),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
}
