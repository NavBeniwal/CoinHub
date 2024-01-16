package CoinHubModule.tests.web;

import CoinHubModule.base.TestBase;
import com.pages.LoginWithEmailPageValidation;
import com.relevantcodes.extentreports.LogStatus;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoginWithEmailPageValidationScript extends TestBase {
    LoginWithEmailPageValidation loginWithEmailPageValidation;
    SoftAssert softAssert;

    public LoginWithEmailPageValidationScript() throws InterruptedException {
        loginWithEmailPageValidation=new LoginWithEmailPageValidation(driver);
        softAssert=new SoftAssert();
    }

    @Test(priority = 1)
    public void verifyLoginEmailRequiredValidationFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginEmailRequiredValidation(PropertyReaderOptimized.getExcelSheetValue(2,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 2)
    public void verifyLoginPasswordRequiredValidationFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPasswordRequiredValidation(PropertyReaderOptimized.getExcelSheetValue(3,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 3)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithOnlyNumericValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithOnlyNumericValue(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 4)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithOnlyAlphabeticValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithOnlyAlphabeticValue(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 5)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithAlphaNumericValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithAlphaNumericValue(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 6)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithMultipleAtTheRateValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMultipleAtTheRateValue(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 7)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithOnlySpecialCharacterValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithOnlySpecialCharacterValue(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 8)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithoutAtTheRateFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithoutAtTheRate(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 9)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithMultipleDotFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMultipleDot(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 10)
    public void verifyInvalidCredentialErrorPopUpMsgFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateInvalidCredentialErrorPopUpMsg(PropertyReaderOptimized.getExcelSheetValue(12,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 11)
    public void verifyOtpRequiredValidationMsgFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateOtpRequiredValidationMsg(PropertyReaderOptimized.getExcelSheetValue(7,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 12)
    public void verifyGetCodeErrorPopUpMsgFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateGetCodeErrorPopUpMsg(PropertyReaderOptimized.getExcelSheetValue(8,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 13)
    public void verifyMaxOtpLimitValidationFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateMaxOtpLimitValidation(PropertyReaderOptimized.getExcelSheetValue(9,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 14)
    public void verifyInvalidOtpErrorPopUpMsgFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateInvalidOtpErrorPopUpMsg(PropertyReaderOptimized.getExcelSheetValue(11,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
}
