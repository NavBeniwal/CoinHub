package CoinHubModule.tests.web;

import CoinHubModule.base.TestBase;
import com.pages.LoginWithEmailPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoginWithEmailPageScript extends TestBase {
    LoginWithEmailPage loginWithEmailPage;
    SoftAssert softAssert;

    public LoginWithEmailPageScript() throws InterruptedException {
        loginWithEmailPage = new LoginWithEmailPage(driver);
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
                softAssert.assertEquals(loginWithEmailPage.validateLoginWithEmailPageOTPSentPopUpMsg(PropertyReaderOptimized.getExcelSheetValue(4, 4), test), true);
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
                softAssert.assertEquals(loginWithEmailPage.validateLoginWithEmailPageLoginSuccessfullyPopUpMsg(PropertyReaderOptimized.getExcelSheetValue(1, 4), test), true);
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
                softAssert.assertEquals(loginWithEmailPage.validateAfterLoginUserShouldBeOnTheDashboardPage(test), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test(priority = 4)
    public void verifySignOutPageFunctionality() throws IOException, InterruptedException {
        runTest("verifySignOutPageFunctionality", () -> {
            try {
                softAssert.assertEquals(loginWithEmailPage.validateSignOutPage(PropertyReaderOptimized.getExcelSheetValue(3, 4), test), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test(priority = 5)
    public void verifyAfterSignOutUserShouldBeOnTheHomePageFunctionality() throws IOException, InterruptedException {
        runTest("verifyAfterSignOutUserShouldBeOnTheHomePageFunctionality", () -> {
            try {
                softAssert.assertEquals(loginWithEmailPage.validateAfterSignOutUserShouldBeOnTheHomePage(test), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
