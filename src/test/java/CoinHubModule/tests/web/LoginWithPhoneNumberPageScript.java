package CoinHubModule.tests.web;

import CoinHubModule.base.TestBase;
import com.pages.LoginWithPhoneNumberPage;
import com.relevantcodes.extentreports.LogStatus;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoginWithPhoneNumberPageScript extends TestBase {
    LoginWithPhoneNumberPage loginWithMobilePage;
    SoftAssert softAssert;

    public LoginWithPhoneNumberPageScript() throws InterruptedException {
        loginWithMobilePage=new LoginWithPhoneNumberPage(driver);
        softAssert=new SoftAssert();
    }

    @Test(priority = 1)
    public void verifyCodeSentOnPhoneMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithMobilePage.validateCodeSentOnPhoneMessage(PropertyReaderOptimized.getExcelSheetValue(2,4),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 2)
    public void verifyLoginMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithMobilePage.validateLoginMessage(PropertyReaderOptimized.getExcelSheetValue(1,4),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 3)
    public void verifyAfterRegisterUserShouldBeOnTheDashboardPageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithMobilePage.validateAfterRegisterUserShouldBeOnTheDashboardPage(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
}
