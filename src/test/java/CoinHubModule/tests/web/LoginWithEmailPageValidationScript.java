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
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingSymbolFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingSymbol(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 4)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressWithMissingDomainFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressWithMissingDomain(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 5)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressWithMissingTopLevelDomainFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressWithMissingTopLevelDomain(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 6)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressWithTopLevelDomainWithTrailingDotFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressWithTopLevelDomainWithTrailingDot(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 7)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithDoubleDotInDomainFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithDoubleDotInDomain(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 8)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithInvalidTopLevelDomainFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithInvalidTopLevelDomain(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 9)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithInvalidCharacterHasTagFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithInvalidCharacterHasTag(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 10)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithSemicolonInsteadOfDotFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithSemicolonInsteadOfDot(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 11)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingUserNameFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingUserName(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 12)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingDomainNameFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingDomainName(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 13)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithConsecutiveDotsInDomainFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithConsecutiveDotsInDomain(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 14)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingDotBetweenDomainAndTopLevelDomainFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingDotBetweenDomainAndTopLevelDomain(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 15)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithMultipleConsecutiveDotsFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMultipleConsecutiveDots(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 16)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithUnderScoreInDomainFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithUnderScoreInDomain(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 17)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingDotBeforeTopLevelDomainFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingDotBeforeTopLevelDomain(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 18)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithExclamationMarkInDomainFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithExclamationMarkInDomain(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 19)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithHyphenAtTheBeginningOfDomainFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithHyphenAtTheBeginningOfDomain(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 20)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithHyphenAtTheEndOfDomainFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithHyphenAtTheEndOfDomain(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 21)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithTrailingDotAfterTopLevelDomainFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithTrailingDotAfterTopLevelDomain(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 22)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingTopLevelDomainFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingTopLevelDomain(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 23)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithCommaInsteadOfDotFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithCommaInsteadOfDot(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 24)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithSlashInsteadOfDotFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithSlashInsteadOfDot(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 25)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithBackSlashInsteadOfDotFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithBackSlashInsteadOfDot(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 26)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithHashSymbolInsteadOfDotFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithHashSymbolInsteadOfDot(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 27)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithOpeningParenthesisInsteadOfDotFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithOpeningParenthesisInsteadOfDot(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 28)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithClosingParenthesisInsteadOfDotFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithClosingParenthesisInsteadOfDot(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 29)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithApostropheInsteadOfDotFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithApostropheInsteadOfDot(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 30)
    public void verifyLoginPageEmailTextFieldInvalidEmailAddressValidationWithQuotationMarkInsteadOfDotFunctionality() throws IOException, InterruptedException {
        test=Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(loginWithEmailPageValidation.validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithQuotationMarkInsteadOfDot(PropertyReaderOptimized.getExcelSheetValue(1,1),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 31)
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

    @Test(priority = 32)
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

    @Test(priority = 33)
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

    @Test(priority = 34)
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

    @Test(priority = 35)
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
