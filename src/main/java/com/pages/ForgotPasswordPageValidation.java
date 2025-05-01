package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ForgotPasswordPageValidation {
    WebDriver driver;
    BasePage basePage;

    // Locators
    private final By languageIcon = By.xpath("//img[@alt='Language']");
    private final By englishLanguageOption = By.xpath("//ul/li[contains(text(),'English')]");
    private final By loginBtn = By.xpath("//button[@title='Log In']");
    private final By forgotPasswordBtn = By.xpath("//a[text()='Forgot password ?']");
    private final By emailTextField = By.xpath("//input[@name='email']");
    private final By resetPasswordBtn = By.xpath("//button[@id='resetPasswordBtn']");
    private final By emailRequiredValidationMsg = By.xpath("//span[text()='Email is required']");
    private final By enterValidEmailValidationMsg = By.xpath("//span[text()='Please enter valid email']");
    private final By mailinatorLoginTextField = By.xpath("//input[@id='search']");
    private final By goButton = By.xpath("//button[text()='GO']");
    private final By emailVerification = By.xpath("//tr[td[@class='ng-binding']]/td[2]");
    private final By iframe = By.xpath("//iframe[@id='html_msg_body']");
    private final By resetBtn = By.xpath("//a[text()='Reset']");
    private final By updateBtn = By.xpath("//span[text()='Update']");
    private final By newPasswordTextField = By.xpath("(//input[@type='password'])[1]");
    private final By confirmPasswordTextField = By.xpath("(//input[@type='password'])[2]");
    private final By confirmPasswordTextFieldEyeIcon = By.xpath("(//span[@class='ant-input-suffix'])[2]");
    private final By enterNewPasswordValidationMsg = By.xpath("//span[text()='Please enter new password']");
    private final By passwordMustContainsValidationMsg = By.xpath("//span[contains(text(),'Password must be')]");
    private final By enterConfirmPasswordValidationMsg = By.xpath("//span[text()='Please enter confirm password']");
    private final By confirmPasswordShouldBeSameValidationMsg = By.xpath("//span[text()='Confirm password should be same']");

    // Constructor
    public ForgotPasswordPageValidation(WebDriver driver) {
        this.driver = driver;
        this.basePage = new BasePage(driver);
        PageFactory.initElements(driver, this);
    }

    // Reusable Methods
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

    // Test Cases
    public boolean validateEmailRequiredValidation(String expectedMessage, ExtentTest test) throws IOException {
        // Language selection
        clickAndLog(languageIcon, test, "Clicked on language icon");
        clickAndLog(englishLanguageOption, test, "Selected English language");
        clickAndLog(loginBtn, test, "Clicked on the Login button.");
        clickAndLog(forgotPasswordBtn, test, "Clicked on the Forgot Password button.");
        clickAndLog(resetPasswordBtn, test, "Clicked on the Reset Password button.");
        return validateMessage(emailRequiredValidationMsg, expectedMessage, test,
                "Verified 'Email is required' validation message is matched.",
                "Verified 'Email is required' validation message isn't displayed.");
    }

    public boolean validateForgotPasswordPageEmailTextFieldWithInvalidEmailAddress(String expectedMessage, ExtentTest test) throws IOException {
        enterTextAndLog(emailTextField, "aabb", test, "Entered an invalid email address in the email text field.");
        return validateMessage(enterValidEmailValidationMsg, expectedMessage, test,
                "Verified 'Please enter valid email' validation message is matched.",
                "Verified 'Please enter valid email' validation message isn't matched.");
    }

    public boolean validateMailinatorPage(ExtentTest test) throws IOException, InterruptedException {
        String mailinatorEmail = PropertyReaderOptimized.getKeyValue("forgotPasswordMailinatorEmail");
        String forgotPasswordEmail = PropertyReaderOptimized.getKeyValue("forgotPasswordEmail");

        enterTextAndLog(emailTextField, forgotPasswordEmail, test, "Entered the email address in the email text field.");
        clickAndLog(resetPasswordBtn, test, "Clicked on the Reset Password button.");

        driver.switchTo().newWindow(WindowType.WINDOW).navigate().to(PropertyReaderOptimized.getKeyValue("mailinatorUrl"));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Switched to the Mailinator page.");

        enterTextAndLog(mailinatorLoginTextField, mailinatorEmail, test, "Entered the email address in the Mailinator search field.");
        clickAndLog(goButton, test, "Clicked on the Go button.");
        clickAndLog(emailVerification, test, "Clicked on the Email Verification link.");


        // Locate and switch to iframe
        WebElement iframeElement = driver.findElement(iframe);
        basePage.switchToFrameWebElement(iframeElement);
//        basePage.waitForElementToBeVisible(iframe);
//        driver.switchTo().frame(basePage.findElement(iframe));

        clickAndLog(resetBtn, test, "Clicked on the Reset button.");
        basePage.switchToWindow();

        return true;
    }

    public boolean validateEnterNewPasswordValidation(String expectedMessage, ExtentTest test) throws IOException {
        clickAndLog(updateBtn, test, "Clicked on the Update button without entering a new password.");
        return validateMessage(enterNewPasswordValidationMsg, expectedMessage, test,
                "Verified 'Please enter new password' validation message is matched.",
                "Verified 'Please enter new password' validation message isn't matched.");
    }

    public boolean validateEnterConfirmPasswordValidation(String expectedMessage, ExtentTest test) throws IOException {
        return validateMessage(enterConfirmPasswordValidationMsg, expectedMessage, test,
                "Verified 'Please enter confirm password' validation message is matched.",
                "Verified 'Please enter confirm password' validation message isn't matched.");
    }

    public boolean validatePasswordMustContainCriteria(String password, String expectedMessage, ExtentTest test) throws IOException {
        enterTextAndLog(newPasswordTextField, password, test, "Entered a password that doesn't meet the criteria.");
        return validateMessage(passwordMustContainsValidationMsg, expectedMessage, test,
                "Verified password criteria validation message is matched.",
                "Verified password criteria validation message isn't matched.");
    }

    public boolean validateForgotPasswordPagePasswordTextFieldWithMissingAlphabet(String expectedMessage, ExtentTest test) throws IOException {
        String password = "!@1234";
        return validatePasswordMustContainCriteria(password, expectedMessage, test);
    }

    public boolean validateForgotPasswordPagePasswordTextFieldWithLessThanEightCharacters(String expectedMessage, ExtentTest test) throws IOException {
        String password = "Pass@12";
        return validatePasswordMustContainCriteria(password, expectedMessage, test);
    }

    public boolean validateForgotPasswordPagePasswordTextFieldWithMissingNumber(String expectedMessage, ExtentTest test) throws IOException {
        String password = "Password@";
        return validatePasswordMustContainCriteria(password, expectedMessage, test);
    }

    public boolean validateForgotPasswordPagePasswordTextFieldWithMissingUpperCaseLetter(String expectedMessage, ExtentTest test) throws IOException {
        String password = "password@123";
        return validatePasswordMustContainCriteria(password, expectedMessage, test);
    }

    public boolean validateForgotPasswordPagePasswordTextFieldWithMissingLowercaseLetter(String expectedMessage, ExtentTest test) throws IOException {
        String password = "PASSWORD@123";
        return validatePasswordMustContainCriteria(password, expectedMessage, test);
    }

    public boolean validateForgotPasswordPagePasswordTextFieldWithMissingSpecialCharacter(String expectedMessage, ExtentTest test) throws IOException {
        String password = "Password123";
        return validatePasswordMustContainCriteria(password, expectedMessage, test);
    }

    public boolean validateConfirmPasswordShouldBeSameValidationMsg(String expectedMessage, ExtentTest test) throws IOException {
        enterTextAndLog(confirmPasswordTextField, "Test@1234", test, "Entered mismatched confirm password.");
        clickAndLog(confirmPasswordTextFieldEyeIcon, test, "Clicked on the confirm password eye icon.");
        return validateMessage(confirmPasswordShouldBeSameValidationMsg, expectedMessage, test,
                "Verified 'Confirm password should be same' validation message is matched.",
                "Verified 'Confirm password should be same' validation message isn't matched.");
    }

    public boolean validateIfTheUserChangeConfirmPasswordAndKeepSameNewPasswordThenValidationShouldNotBeShown(ExtentTest test) throws IOException {
        enterTextAndLog(confirmPasswordTextField, "Test@123", test, "Entered a matching confirm password.");
        if (!basePage.checkElementIsDisplayed(confirmPasswordShouldBeSameValidationMsg)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified no validation message is displayed.");
            return true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified validation message is displayed.");
            return false;
        }
    }
}