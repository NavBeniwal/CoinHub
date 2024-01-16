package CoinHubModule.tests.web;

import CoinHubModule.base.TestBase;
import com.pages.ForgotPasswordPage;
import com.relevantcodes.extentreports.LogStatus;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class ForgotPasswordPageScript extends TestBase {
    ForgotPasswordPage forgotPasswordPage;
    SoftAssert softAssert;

    public ForgotPasswordPageScript(){
        forgotPasswordPage=new ForgotPasswordPage(driver);
        softAssert=new SoftAssert();
    }

    @Test(priority = 1)
    public void verifyForgotPasswordEmailSentMsgFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPage.validateForgotPasswordEmailSentMsg(PropertyReaderOptimized.getExcelSheetValue(45,4),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 2)
    public void verifyForgotPasswordPasswordChangeFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPage.validateForgotPasswordPasswordChange(PropertyReaderOptimized.getExcelSheetValue(46,4),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 3)
    public void verifyAfterForgetPasswordUserShouldBeOnRegisterPageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPage.validateAfterForgetPasswordUserShouldBeOnRegisterPage(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
}
