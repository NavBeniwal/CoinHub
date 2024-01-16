package CoinHubModule.tests.web;

import CoinHubModule.base.TestBase;
import com.pages.AccountLockWithEmailPage;
import com.relevantcodes.extentreports.LogStatus;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class AccountLockWithEmailPageScript extends TestBase {

    AccountLockWithEmailPage accountLockWithEmailPage;
    SoftAssert softAssert;

    public AccountLockWithEmailPageScript(){
        accountLockWithEmailPage=new AccountLockWithEmailPage(driver);
        softAssert=new SoftAssert();
    }

    @Test(priority = 1)
    public void verifyInvalidCredentialsMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(accountLockWithEmailPage.validateInvalidCredentialsMessage(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 2)
    public void verifyAccountLockFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(accountLockWithEmailPage.validateAccountLock(PropertyReaderOptimized.getExcelSheetValue(13,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
}
