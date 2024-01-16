package CoinHubModule.tests.web;

import CoinHubModule.base.TestBase;
import com.pages.ChangePasswordPage;
import com.pages.LoginChangePasswordPage;
import com.relevantcodes.extentreports.LogStatus;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class ChangePasswordPageScript extends TestBase {
    ChangePasswordPage changePasswordPage;
    LoginChangePasswordPage loginChangePasswordPage;
    SoftAssert softAssert;

    public ChangePasswordPageScript(){
        changePasswordPage=new ChangePasswordPage(driver);
        loginChangePasswordPage=new LoginChangePasswordPage(driver);
        softAssert=new SoftAssert();
    }

    @Test(priority = 1)
    public void verifyLoginWithEmailPageOTPSentPopUpMsgFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginChangePasswordPage.validateLoginWithEmailPageOTPSentPopUpMsg(PropertyReaderOptimized.getExcelSheetValue(4,4),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
    @Test(priority = 2)
    public void verifyLoginWithEmailPageLoginSuccessfullyPopUpMsgFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginChangePasswordPage.validateLoginWithEmailPageLoginSuccessfullyPopUpMsg(PropertyReaderOptimized.getExcelSheetValue(1,4),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 3)
    public void verifyAfterLoginUserShouldBeOnTheDashboardPageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginChangePasswordPage.validateAfterLoginUserShouldBeOnTheDashboardPage(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 4)
    public void verifyGetCodePopUpMsgFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(changePasswordPage.validateGetCodePopUpMsg(PropertyReaderOptimized.getExcelSheetValue(32,4),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 5)
    public void verifyChangePasswordPageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(changePasswordPage.validateChangePasswordPage(PropertyReaderOptimized.getExcelSheetValue(34,4),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
}
