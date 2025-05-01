package CoinHubModule.tests.web;

import CoinHubModule.base.TestBase;
import com.pages.ChangePasswordPageValidation;
import com.pages.LoginWithEmailPage;
import com.relevantcodes.extentreports.LogStatus;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class ChangePasswordPageValidationScript extends TestBase {
    ChangePasswordPageValidation changePasswordPageValidation;
    LoginWithEmailPage loginWithEmailPage;
    SoftAssert softAssert;

    public ChangePasswordPageValidationScript(){
        changePasswordPageValidation=new ChangePasswordPageValidation(driver);
        loginWithEmailPage=new LoginWithEmailPage(driver);
        softAssert=new SoftAssert();
    }

    @Test(priority = 1)
    public void verifyLoginWithEmailPageOTPSentPopUpMsgFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPage.validateLoginWithEmailPageOTPSentPopUpMsg(PropertyReaderOptimized.getExcelSheetValue(4,4),test),true);
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
            softAssert.assertEquals(loginWithEmailPage.validateLoginWithEmailPageLoginSuccessfullyPopUpMsg(PropertyReaderOptimized.getExcelSheetValue(1,4),test),true);
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
            softAssert.assertEquals(loginWithEmailPage.validateAfterLoginUserShouldBeOnTheDashboardPage(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 4)
    public void verifyOldPasswordTextFieldValidationFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(changePasswordPageValidation.validateOldPasswordTextFieldValidation(PropertyReaderOptimized.getExcelSheetValue(32,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
    @Test(priority = 5)
    public void verifyNewPasswordTextFieldValidationFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(changePasswordPageValidation.validateNewPasswordTextFieldValidation(PropertyReaderOptimized.getExcelSheetValue(33,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 6)
    public void verifyConfirmPasswordTextFieldValidationFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(changePasswordPageValidation.validateConfirmPasswordTextFieldValidation(PropertyReaderOptimized.getExcelSheetValue(34,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 7)
    public void verifyOtpTextFieldValidationFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(changePasswordPageValidation.validateOtpTextFieldValidation(PropertyReaderOptimized.getExcelSheetValue(35,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 8)
    public void verifyNewPasswordMustContainValidationMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(changePasswordPageValidation.validateNewPasswordMustContainValidationMessage(PropertyReaderOptimized.getExcelSheetValue(36,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 9)
    public void verifyConfirmPasswordShouldBeSameValidationMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(changePasswordPageValidation.validateConfirmPasswordShouldBeSameValidationMessage(PropertyReaderOptimized.getExcelSheetValue(37,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 10)
    public void verifyGetOtpErrorPopUpMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(changePasswordPageValidation.validateGetOtpErrorPopUpMessage(PropertyReaderOptimized.getExcelSheetValue(38,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 11)
    public void verifyInvalidOtpErrorPopUpMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(changePasswordPageValidation.validateInvalidOtpErrorPopUpMessage(PropertyReaderOptimized.getExcelSheetValue(39,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 12)
    public void verifyOldPasswordNotCorrectErrorPopUpMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(changePasswordPageValidation.validateOldPasswordNotCorrectErrorPopUpMessage(PropertyReaderOptimized.getExcelSheetValue(40,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 13)
    public void verifyNewPasswordCannotBeSameErrorPopUpMessageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(changePasswordPageValidation.validateNewPasswordCannotBeSameErrorPopUpMessage(PropertyReaderOptimized.getExcelSheetValue(41,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

//    @Test(priority = 14)
//    public void verifyIfTheUserChangeConfirmPasswordAndKeepSameNewPasswordThenValidationShouldBeShownFunctionality() throws IOException, InterruptedException {
//        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
//        try {
//            softAssert.assertEquals(changePasswordPageValidation.validateConfirmPasswordChangeKeepingSameNewPassword(PropertyReaderOptimized.getExcelSheetValue(42,1),test),true);
//            test.log(LogStatus.PASS,"All conditions are verified.");
//        } catch (Error | Exception e) {
//            test.log(LogStatus.FAIL,"All conditions aren't verified.");
//            Assert.fail(String.valueOf(e.getStackTrace()));
//            softAssert.assertAll();
//        }
//    }

//    @Test(priority = 15)
//    public void verifyChangePasswordPageOtpMaxLimitValidationMessageFunctionality() throws IOException, InterruptedException {
//        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
//        try {
//            softAssert.assertEquals(changePasswordPageValidation.validateOtpMaxLimitValidationMessage(PropertyReaderOptimized.getExcelSheetValue(42,1),test),true);
//            test.log(LogStatus.PASS,"All conditions are verified.");
//        } catch (Error | Exception e) {
//            test.log(LogStatus.FAIL,"All conditions aren't verified.");
//            Assert.fail(String.valueOf(e.getStackTrace()));
//            softAssert.assertAll();
//        }
//    }
}