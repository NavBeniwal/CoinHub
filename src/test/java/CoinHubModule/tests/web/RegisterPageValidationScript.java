package CoinHubModule.tests.web;

import CoinHubModule.base.TestBase;
import com.pages.RegisterPageValidation;
import com.relevantcodes.extentreports.LogStatus;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class RegisterPageValidationScript extends TestBase {
    RegisterPageValidation registerPageValidation;
    SoftAssert softAssert;

    public RegisterPageValidationScript() throws InterruptedException {
        registerPageValidation=new RegisterPageValidation(driver);
        softAssert=new SoftAssert();
    }

    @Test(priority = 1)
    public void verifyRegisterPageEmailRequiredValidationFunctionality() throws IOException, InterruptedException {
        test = Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            Assert.assertEquals(registerPageValidation.validateRegisterPageEmailRequiredValidation(PropertyReaderOptimized.getExcelSheetValue(19,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 2)
    public void verifyRegisterPagePasswordRequiredValidationFunctionality() throws IOException, InterruptedException {
        test = Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPagePasswordRequiredValidation(PropertyReaderOptimized.getExcelSheetValue(20, 1),test), true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 3)
    public void verifyRegisterPageTermsAndConditionsRequiredValidationFunctionality() throws IOException, InterruptedException {
        test = Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPageTermsAndConditionsRequiredValidation(PropertyReaderOptimized.getExcelSheetValue(21, 1),test), true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 4)
    public void verifyEmailTextFieldValidationWithAlreadyExistEmailAddressFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateEmailTextFieldValidationWithAlreadyExistEmailAddress(PropertyReaderOptimized.getExcelSheetValue(24,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 5)
    public void verifyRegisterPageEmailTextFieldInvalidEmailAddressValidationWithOnlyNumericValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithOnlyNumericValue(PropertyReaderOptimized.getExcelSheetValue(22,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 6)
    public void verifyRegisterPageEmailTextFieldInvalidEmailAddressValidationWithOnlyAlphabeticValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithOnlyAlphabeticValue(PropertyReaderOptimized.getExcelSheetValue(22,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 7)
    public void verifyRegisterPageEmailTextFieldInvalidEmailAddressValidationWithAlphaNumericValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithAlphaNumericValue(PropertyReaderOptimized.getExcelSheetValue(22,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 8)
    public void verifyRegisterPageEmailTextFieldInvalidEmailAddressValidationWithMultipleAtTheRateValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithMultipleAtTheRateValue(PropertyReaderOptimized.getExcelSheetValue(22,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 9)
    public void verifyRegisterPageEmailTextFieldInvalidEmailAddressValidationWithOnlySpecialCharacterValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithOnlySpecialCharacterValue(PropertyReaderOptimized.getExcelSheetValue(22,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 10)
    public void verifyRegisterPageEmailTextFieldInvalidEmailAddressValidationWithoutAtTheRateFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithoutAtTheRate(PropertyReaderOptimized.getExcelSheetValue(22,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 11)
    public void verifyRegisterPageEmailTextFieldInvalidEmailAddressValidationWithMultipleDotFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithMultipleDot(PropertyReaderOptimized.getExcelSheetValue(22,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 12)
    public void verifyRegisterPagePasswordTextFieldValidationWithLessThanEightCharactersFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPagePasswordTextFieldValidationWithLessThanEightCharacters(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 13)
    public void verifyRegisterPagePasswordTextFieldWithOnlyNumericValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPagePasswordTextFieldWithOnlyNumericValue(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 14)
    public void verifyRegisterPagePasswordTextFieldWithOnlySpecialCharacterValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPagePasswordTextFieldWithOnlySpecialCharacterValue(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 15)
    public void verifyRegisterPagePasswordTextFieldWithOnlyAlphabeticValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPagePasswordTextFieldWithOnlyAlphabeticValue(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 16)
    public void verifyRegisterPagePasswordTextFieldWithAlphaNumericValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPagePasswordTextFieldWithAlphaNumericValue(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 17)
    public void verifyRegisterPagePasswordTextFieldWithSpecialAndNumericValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPagePasswordTextFieldWithSpecialAndNumericValue(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 18)
    public void verifyRegisterPagePasswordTextFieldWithSpecialAndAlphabeticValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPagePasswordTextFieldWithSpecialAndAlphabeticValue(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 19)
    public void verifyRegisterPagePasswordTextFieldWithoutUpperCaseValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPagePasswordTextFieldWithoutUpperCaseValue(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 20)
    public void verifyRegisterPagePasswordTextFieldWithoutLowerCaseValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPagePasswordTextFieldWithoutLowerCaseValue(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 21)
    public void verifyRegisterPagePasswordTextFieldWithoutNumericValueFunctionality() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPagePasswordTextFieldWithoutNumericValue(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 22)
    public void verifyRegisterPagePasswordTextFieldWithoutSpecialCharacterValueFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPagePasswordTextFieldWithoutSpecialCharacterValue(PropertyReaderOptimized.getExcelSheetValue(23,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 23)
    public void verifyRegisterPagePhoneNumberRequiredValidationFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPagePhoneNumberRequiredValidation(PropertyReaderOptimized.getExcelSheetValue(25,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 24)
    public void verifyRegisterPageExistPhoneNumberErrorMsgFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPageExistPhoneNumberErrorMsg(PropertyReaderOptimized.getExcelSheetValue(28,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 25)
    public void verifyRegisterPageInvalidPhoneNumberValidationFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPageInvalidPhoneNumberValidation(PropertyReaderOptimized.getExcelSheetValue(29,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 26)
    public void verifyRegisterPageRequiredOtpValidationFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPageRequiredOtpValidation(PropertyReaderOptimized.getExcelSheetValue(26,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 27)
    public void verifyRegisterPageInvalidOtpValidationFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(registerPageValidation.validateRegisterPageInvalidOtpValidation(PropertyReaderOptimized.getExcelSheetValue(27,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
}
