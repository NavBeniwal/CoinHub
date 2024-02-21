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
    public void verifyForgotPasswordPagePasswordTextFieldValidationWithMissingAlphabetFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateForgotPasswordPagePasswordTextFieldValidationWithMissingAlphabet(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 7)
    public void verifyForgotPasswordPagePasswordTextFieldWithLessThanEightCharactersFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateForgotPasswordPagePasswordTextFieldWithLessThanEightCharacters(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 8)
    public void verifyForgotPasswordPagePasswordTextFieldWithMissingNumberFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateForgotPasswordPagePasswordTextFieldWithMissingNumber(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 9)
    public void verifyForgotPasswordPagePasswordTextFieldWithMissingUpperCaseLettereFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateForgotPasswordPagePasswordTextFieldWithMissingUpperCaseLetter(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 10)
    public void verifyForgotPasswordPagePasswordTextFieldWithMissingLowercaseLetterFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateForgotPasswordPagePasswordTextFieldWithMissingLowercaseLetter(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 11)
    public void verifyForgotPasswordPagePasswordTextFieldWithMissingSpecialCharacterFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateForgotPasswordPagePasswordTextFieldWithMissingSpecialCharacter(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 12)
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

    @Test(priority = 13)
    public void verifyIfTheUserChangeConfirmPasswordAndKeepSameNewPasswordThenValidationShouldNotBeShownFunctionality() throws IOException, InterruptedException {test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(forgotPasswordPageValidation.validateIfTheUserChangeConfirmPasswordAndKeepSameNewPasswordThenValidationShouldNotBeShown(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
}
