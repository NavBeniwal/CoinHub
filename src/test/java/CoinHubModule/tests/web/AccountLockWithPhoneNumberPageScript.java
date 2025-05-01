package CoinHubModule.tests.web;

import CoinHubModule.base.TestBase;
import com.pages.AccountLockWithPhoneNumberPage;
import com.relevantcodes.extentreports.LogStatus;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class AccountLockWithPhoneNumberPageScript extends TestBase {
    AccountLockWithPhoneNumberPage accountLockWithPhoneNumberPage;
    SoftAssert softAssert;

    public AccountLockWithPhoneNumberPageScript(){
        accountLockWithPhoneNumberPage=new AccountLockWithPhoneNumberPage(driver);
        softAssert=new SoftAssert();
    }

    @Test(priority = 1)
    public void verifyInvalidCredentialsMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(accountLockWithPhoneNumberPage.validateInvalidCredentialsMessage(test),true);
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
            softAssert.assertEquals(accountLockWithPhoneNumberPage.validateAccountLock(PropertyReaderOptimized.getExcelSheetValue(13,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
}
