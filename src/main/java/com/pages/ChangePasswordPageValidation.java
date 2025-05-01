package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;

public class ChangePasswordPageValidation {

    WebDriver driver;
    BasePage basePage;

    // Locators
    private final By settingDropDown = By.xpath("(//span[@class='ant-avatar-string'])[1]");
    private final By settingsBtn = By.xpath("//a[text()='Settings']");
    private final By securitySettings = By.xpath("(//div[@class='ant-tabs-tab-btn'])[2]");
    private final By changeBtn = By.xpath("(//button[@class='verifyBtn'])[1]");
    private final By changeButton = By.xpath("(//span[text()='Change'])[3]");
    private final By oldPasswordTextField = By.xpath("//input[@placeholder='Please enter old password']");
    private final By newPasswordTextField = By.xpath("//input[@placeholder='Please enter new password']");
    private final By confirmPasswordTextField = By.xpath("//input[@placeholder='Please enter confirm password']");
    private final By emailOtpTextField = By.xpath("//input[@placeholder='Please enter email OTP']");
    private final By getCodeBtn = By.xpath("//p[text()='Get Code']");

    // Validation Messages
    private final By oldPasswordTextFieldValidationMsg = By.xpath("//span[text()='Please enter old password']");
    private final By newPasswordTextFieldValidationMsg = By.xpath("//span[text()='Please enter new password']");
    private final By confirmPasswordTextFieldValidationMsg = By.xpath("//span[text()='Please enter confirm password']");
    private final By otpRequiredValidationMsg = By.xpath("//span[text()='OTP is required']");
    private final By newPasswordContainsValidationMsg = By.xpath("//span[contains(text(),'Password must be a')]");
    private final By confirmPasswordShouldBeSameValidationMsg = By.xpath("//span[text()='Confirm password should be same']");
    private final By oldPasswordNotCorrectErrorPopUpMsg = By.xpath("//span[text()='Old password is not correct']");
    private final By newPasswordCannotBeSameAsOldOneErrorPopUpMsg = By.xpath("//span[@class='anticon anticon-close-circle']");
    private final By getOtpErrorPopUpMsg = By.xpath("//span[text()='Please get a verification code first.']");
    private final By invalidOtpErrorPopUpMsg = By.xpath("//span[text()='Invalid OTP ']");
    private final By otpMaxLimitValidationMsg = By.xpath("//span[text()='Max OTP limit should be 5 digits.']");

    public ChangePasswordPageValidation(WebDriver driver) {
        this.driver = driver;
        this.basePage = new BasePage(driver);
        PageFactory.initElements(driver, this);
    }

    // Common reusable methods
    private void clickAndLog(By locator, ExtentTest test, String message) throws IOException {
        basePage.waitForElementToBeClickable(locator);
        basePage.click(locator);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), message);
    }

    private void enterTextAndLog(By locator, String text, ExtentTest test, String message) throws IOException {
        basePage.waitForElementToBeVisible(locator);
        basePage.enterText(locator, text);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), message);
    }

    private void clearValueAndLog(By locator, ExtentTest test, String message) throws IOException {
        basePage.waitForElementToBeVisible(locator);
        basePage.clearValue(locator);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), message);
    }

    private boolean validateMessage(By locator, String expectedMessage, ExtentTest test, String successLog, String failureLog) throws IOException {
        basePage.waitForElementToBeVisible(locator);
        String actualMessage = basePage.doGetElementText(locator);
        if (actualMessage.equals(expectedMessage)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), successLog);
            return true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), failureLog);
            return false;
        }
    }

    // Page navigation
    private void navigateToChangePasswordPage(ExtentTest test) throws IOException {
        clickAndLog(settingDropDown, test, "Clicked on profile icon.");
        clickAndLog(settingsBtn, test, "Navigated to Settings.");
        clickAndLog(securitySettings, test, "Navigated to Security Settings.");
        clickAndLog(changeBtn, test, "Clicked on Change Password.");
    }

    // Test Cases

    public boolean validateOldPasswordTextFieldValidation(String expectedMessage, ExtentTest test) throws IOException {
        navigateToChangePasswordPage(test);
        clickAndLog(changeButton, test, "Clicked on Change Button without entering Old Password.");
        return validateMessage(oldPasswordTextFieldValidationMsg, expectedMessage, test,
                "Validated Old Password field error message.",
                "Failed to validate Old Password field error message.");
    }

    public boolean validateNewPasswordTextFieldValidation(String expectedMessage, ExtentTest test) throws IOException {
        return validateMessage(newPasswordTextFieldValidationMsg, expectedMessage, test,
                "Validated New Password field error message.",
                "Failed to validate New Password field error message.");
    }

    public boolean validateConfirmPasswordTextFieldValidation(String expectedMessage, ExtentTest test) throws IOException {
        //navigateToChangePasswordPage(test);
        //clickAndLog(changeButton, test, "Clicked on Change Button without entering Confirm Password.");
        return validateMessage(confirmPasswordTextFieldValidationMsg, expectedMessage, test,
                "Validated Confirm Password field error message.",
                "Failed to validate Confirm Password field error message.");
    }

    public boolean validateOtpTextFieldValidation(String expectedMessage, ExtentTest test) throws IOException {
        return validateMessage(otpRequiredValidationMsg, expectedMessage, test,
                "Validated OTP required validation message.",
                "Failed to validate OTP required validation message.");
    }

    public boolean validateNewPasswordMustContainValidationMessage(String expectedMessage, ExtentTest test) throws IOException {
        enterTextAndLog(newPasswordTextField, "abc", test, "Entered weak password.");
        return validateMessage(newPasswordContainsValidationMsg, expectedMessage, test,
                "Validated New Password must contain specific characters.",
                "Failed to validate New Password must contain specific characters.");

    }

    public boolean validateConfirmPasswordShouldBeSameValidationMessage(String expectedMessage, ExtentTest test) throws IOException {
        clearValueAndLog(newPasswordTextField, test, "Cleared New Password field.");
        enterTextAndLog(newPasswordTextField, "Test@123", test, "Entered New Password.");
        enterTextAndLog(confirmPasswordTextField, "Test@321", test, "Entered mismatched Confirm Password.");
        clickAndLog(changeButton, test, "Clicked on Change Button.");
        return validateMessage(confirmPasswordShouldBeSameValidationMsg, expectedMessage, test,
                "Validated Confirm Password should match New Password.",
                "Failed to validate Confirm Password should match New Password.");

    }

    public boolean validateGetOtpErrorPopUpMessage(String expectedMessage, ExtentTest test) throws IOException, InterruptedException {
        enterTextAndLog(confirmPasswordTextField, "3", test, "Entered mismatched Confirm Password.");
        clearValueAndLog(confirmPasswordTextField, test, "Cleared Confirm Password field.");
        enterTextAndLog(confirmPasswordTextField, "Test@123", test, "Entered mismatched Confirm Password.");
        enterTextAndLog(oldPasswordTextField,"Test@1234",test,"Entered Old Password.");
        enterTextAndLog(emailOtpTextField, "12344", test, "Entered OTP.");
        clickAndLog(changeButton, test, "Clicked on Change Button without fetching OTP.");
        return validateMessage(getOtpErrorPopUpMsg, expectedMessage, test,
                "Validated Get OTP error pop-up message.",
                "Failed to validate Get OTP error pop-up message.");
    }

    public boolean validateInvalidOtpErrorPopUpMessage(String expectedMessage, ExtentTest test) throws IOException, InterruptedException {
        clickAndLog(getCodeBtn, test, "Clicked on Get Code Button.");
        Thread.sleep(2000);
        clickAndLog(changeButton, test, "Clicked on Change Button.");
        return validateMessage(invalidOtpErrorPopUpMsg, expectedMessage, test,
                "Validated Invalid OTP error pop-up message.",
                "Failed to validate Invalid OTP error pop-up message.");
    }

    public boolean validateOldPasswordNotCorrectErrorPopUpMessage(String expectedMessage, ExtentTest test) throws IOException {
        enterTextAndLog(emailOtpTextField, "1", test, "Entered invalid OTP.");
        clearValueAndLog(emailOtpTextField, test, "Cleared OTP field.");
        enterTextAndLog(emailOtpTextField, "12345", test, "Entered invalid OTP.");
        clickAndLog(changeButton, test, "Clicked on Change Button.");
        return validateMessage(oldPasswordNotCorrectErrorPopUpMsg, expectedMessage, test,
                "Validated Old Password not correct error pop-up message.",
                "Failed to validate Old Password not correct error pop-up message.");
    }

    public boolean validateNewPasswordCannotBeSameErrorPopUpMessage(String expectedMessage, ExtentTest test) throws IOException {
        enterTextAndLog(oldPasswordTextField, "1", test, "Entered Old Password.");
        clearValueAndLog(oldPasswordTextField, test, "Cleared Old Password field.");
        enterTextAndLog(oldPasswordTextField, "Test@123", test, "Entered Old Password.");
        clickAndLog(changeButton, test, "Clicked on Change Button.");
        return validateMessage(newPasswordCannotBeSameAsOldOneErrorPopUpMsg, expectedMessage, test,
                "Validated New Password cannot be the same as Old Password error pop-up.",
                "Failed to validate New Password cannot be the same as Old Password error pop-up.");
    }

//    public boolean validateConfirmPasswordChangeKeepingSameNewPassword(String expectedMessage, ExtentTest test) throws IOException {
//        //navigateToChangePasswordPage(test);
//        //enterTextAndLog(newPasswordTextField, "Test@123", test, "Entered New Password.");
//        enterTextAndLog(confirmPasswordTextField, "4", test, "Entered Confirm Password matching New Password.");
//        //clickAndLog(confirmPasswordTextField, test, "Changed Confirm Password while keeping New Password the same.");
//        return validateMessage(confirmPasswordShouldBeSameValidationMsg, expectedMessage, test,
//                "Validated Confirm Password change while keeping New Password the same.",
//                "Failed to validate Confirm Password change while keeping New Password the same.");
//    }

//    public boolean validateChangeWithoutClickingGetCode(String expectedMessage, ExtentTest test) throws IOException {
//        //navigateToChangePasswordPage(test);
//        enterTextAndLog(oldPasswordTextField, "Test@123", test, "Entered Old Password.");
//        enterTextAndLog(newPasswordTextField, "NewPass@123", test, "Entered New Password.");
//        enterTextAndLog(confirmPasswordTextField, "NewPass@123", test, "Entered Confirm Password.");
//        clickAndLog(changeButton, test, "Clicked on Change Button without clicking Get Code.");
//        return validateMessage(getOtpErrorPopUpMsg, expectedMessage, test,
//                "Validated error message when clicking Change without clicking Get Code.",
//                "Failed to validate error message when clicking Change without clicking Get Code.");
//    }

//    public boolean validateOtpMaxLimitValidationMessage(String expectedMessage, ExtentTest test) throws IOException {
//        //navigateToChangePasswordPage(test);
//        for (int i = 0; i < 6; i++) {
//            clickAndLog(getCodeBtn, test, "Clicked on Get Code Button (Attempt " + (i + 1) + ").");
//        }
//        return validateMessage(otpMaxLimitValidationMsg, expectedMessage, test,
//                "Validated OTP max limit validation message.",
//                "Failed to validate OTP max limit validation message.");
//    }
}