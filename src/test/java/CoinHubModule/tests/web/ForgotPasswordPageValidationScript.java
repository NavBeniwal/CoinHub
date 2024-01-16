package CoinHubModule.tests.web;

import CoinHubModule.base.TestBase;
import com.pages.ForgotPasswordPageValidation;
import com.relevantcodes.extentreports.LogStatus;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class ForgotPasswordPageValidationScript extends TestBase {
    ForgotPasswordPageValidation forgotPasswordPageValidation;
    SoftAssert softAssert;

    public ForgotPasswordPageValidationScript(){
        forgotPasswordPageValidation=new ForgotPasswordPageValidation(driver);
        softAssert=new SoftAssert();
    }

    @Test(priority = 1)
    public void verifyEmailRequiredValidationFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateEmailRequiredValidation(PropertyReaderOptimized.getExcelSheetValue(45,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
    @Test(priority = 2)
    public void verifyForgotPasswordPageEmailTextFieldWithInvalidEmailAddressFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateForgotPasswordPageEmailTextFieldWithInvalidEmailAddress(PropertyReaderOptimized.getExcelSheetValue(47,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 3)
    public void verifyMailinatorPageFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateMailinatorPage(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 4)
    public void verifyEnterNewPasswordValidationFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateEnterNewPasswordValidation(PropertyReaderOptimized.getExcelSheetValue(49,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 5)
    public void verifyEnterConfirmPasswordValidationFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateEnterConfirmPasswordValidation(PropertyReaderOptimized.getExcelSheetValue(50,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 6)
    public void verifyRegisterPagePasswordTextFieldValidationWithLessThanEightCharactersFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateRegisterPagePasswordTextFieldValidationWithLessThanEightCharacters(PropertyReaderOptimized.getExcelSheetValue(52,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 7)
    public void verifyRegisterPagePasswordTextFieldWithOnlyNumericValueFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateRegisterPagePasswordTextFieldWithOnlyNumericValue(PropertyReaderOptimized.getExcelSheetValue(52,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 8)
    public void verifyRegisterPagePasswordTextFieldWithOnlySpecialCharacterValueFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateRegisterPagePasswordTextFieldWithOnlySpecialCharacterValue(PropertyReaderOptimized.getExcelSheetValue(52,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 9)
    public void verifyRegisterPagePasswordTextFieldWithOnlyAlphabeticValueFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateRegisterPagePasswordTextFieldWithOnlyAlphabeticValue(PropertyReaderOptimized.getExcelSheetValue(52,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 10)
    public void verifyRegisterPagePasswordTextFieldWithAlphaNumericValueFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateRegisterPagePasswordTextFieldWithAlphaNumericValue(PropertyReaderOptimized.getExcelSheetValue(52,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 11)
    public void verifyRegisterPagePasswordTextFieldWithSpecialAndNumericValueFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateRegisterPagePasswordTextFieldWithSpecialAndNumericValue(PropertyReaderOptimized.getExcelSheetValue(52,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 12)
    public void verifyRegisterPagePasswordTextFieldWithSpecialAndAlphabeticValueFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateRegisterPagePasswordTextFieldWithSpecialAndAlphabeticValue(PropertyReaderOptimized.getExcelSheetValue(52,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 13)
    public void verifyRegisterPagePasswordTextFieldWithoutUpperCaseValueFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateRegisterPagePasswordTextFieldWithoutUpperCaseValue(PropertyReaderOptimized.getExcelSheetValue(52,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 14)
    public void verifyRegisterPagePasswordTextFieldWithoutLowerCaseValueFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateRegisterPagePasswordTextFieldWithoutLowerCaseValue(PropertyReaderOptimized.getExcelSheetValue(52,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 15)
    public void verifyRegisterPagePasswordTextFieldWithoutNumericValueFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateRegisterPagePasswordTextFieldWithoutNumericValue(PropertyReaderOptimized.getExcelSheetValue(52,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 16)
    public void verifyRegisterPagePasswordTextFieldWithoutSpecialCharacterValueFunctionality() throws IOException, InterruptedException {test = Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateRegisterPagePasswordTextFieldWithoutSpecialCharacterValue(PropertyReaderOptimized.getExcelSheetValue(52,1),test), true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 17)
    public void verifyConfirmPasswordShouldBeSameValidationMsgFunctionality() throws IOException, InterruptedException {test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateConfirmPasswordShouldBeSameValidationMsg(PropertyReaderOptimized.getExcelSheetValue(51,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
}
