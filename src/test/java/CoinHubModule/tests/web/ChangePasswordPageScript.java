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
    private ChangePasswordPage changePasswordPage;
    private LoginChangePasswordPage loginChangePasswordPage;
    private SoftAssert softAssert;

    public ChangePasswordPageScript() {
        changePasswordPage = new ChangePasswordPage(driver);
        loginChangePasswordPage = new LoginChangePasswordPage(driver);
        softAssert = new SoftAssert();
    }

    private void runTest(String testName, Runnable testMethod) throws IOException {
        test = Reports.createTest(testName, reports);
        try {
            testMethod.run();
            test.log(LogStatus.PASS, "All conditions are verified.");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "All conditions aren't verified: " + e.getMessage());
            Assert.fail(e.getMessage());
            softAssert.assertAll();
        }
    }

    @Test(priority = 1)
    public void verifyLoginWithEmailPageOTPSentPopUpMsgFunctionality() throws IOException, InterruptedException {
        runTest("verifyLoginWithEmailPageOTPSentPopUpMsgFunctionality", () -> {
            try {
                softAssert.assertEquals(loginChangePasswordPage.validateLoginWithEmailPageOTPSentPopUpMsg(
                        PropertyReaderOptimized.getExcelSheetValue(4, 4), test), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test(priority = 2)
    public void verifyLoginWithEmailPageLoginSuccessfullyPopUpMsgFunctionality() throws IOException, InterruptedException {
        runTest("verifyLoginWithEmailPageLoginSuccessfullyPopUpMsgFunctionality", () -> {
            try {
                softAssert.assertEquals(loginChangePasswordPage.validateLoginWithEmailPageLoginSuccessfullyPopUpMsg(
                        PropertyReaderOptimized.getExcelSheetValue(1, 4), test), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test(priority = 3)
    public void verifyAfterLoginUserShouldBeOnTheDashboardPageFunctionality() throws IOException, InterruptedException {
        runTest("verifyAfterLoginUserShouldBeOnTheDashboardPageFunctionality", () -> {
            try {
                softAssert.assertEquals(loginChangePasswordPage.validateAfterLoginUserShouldBeOnTheDashboardPage(test), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test(priority = 4)
    public void verifyGetCodePopUpMsgFunctionality() throws IOException, InterruptedException {
        runTest("verifyGetCodePopUpMsgFunctionality", () -> {
            try {
                softAssert.assertEquals(changePasswordPage.validateGetCodePopUpMsg(
                        PropertyReaderOptimized.getExcelSheetValue(32, 4), test), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test(priority = 5)
    public void verifyPasswordChangePopUpMsgFunctionality() throws IOException, InterruptedException {
        runTest("verifyPasswordChangePopUpMsgFunctionality", () -> {
            try {
                softAssert.assertEquals(changePasswordPage.validatePasswordChangePopUpMsg(
                        PropertyReaderOptimized.getExcelSheetValue(34, 4), test), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
