package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ChangePasswordPage {
    private WebDriver driver;
    private BasePage basePage;

    // Locators
    private By settingDropDownBtn = By.xpath("(//span[@class='ant-avatar-string'])[1]");
    private By settingsBtn = By.xpath("//a[text()='Settings']");
    private By securitySettings = By.xpath("(//div[@class='ant-tabs-tab-btn'])[2]");
    private By changeBtn = By.xpath("(//span[text()='Change'])[1]");
    private By oldPasswordTextField = By.xpath("//input[@placeholder='Please enter old password']");
    private By newPasswordTextField = By.xpath("//input[@placeholder='Please enter new password']");
    private By confirmPasswordTextField = By.xpath("//input[@placeholder='Please enter confirm password']");
    private By emailOtpTextField = By.xpath("//input[@placeholder='Please enter email OTP']");
    private By getCodeBtn = By.xpath("//p[text()='Get Code']");
    private By otpSentPopUpMsg = By.xpath("//span[text()='OTP sent successfully']");
    private By passwordChangePopUpMsg = By.xpath("//span[text()='Password changed successfully']");
    private By changeButton = By.xpath("(//span[text()='Change'])[3]");

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
        this.basePage = new BasePage(driver);
    }

    // Helper method to perform actions with logging
    private void clickAndLog(By element, String action, ExtentTest test) throws IOException {
        basePage.waitForElementToBeVisible(element);
        basePage.click(element);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), action);
    }

    // Helper method to enter text with logging
    private void enterTextAndLog(By element, String text, String action, ExtentTest test) throws IOException {
        basePage.waitForElementToBeVisible(element);
        basePage.enterText(element, text);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), action);
    }

    // Validate OTP sent pop-up message
    public boolean validateGetCodePopUpMsg(String expectedMessage, ExtentTest test) throws IOException, InterruptedException {
        String oldPassword = PropertyReaderOptimized.getKeyValue("oldPassword");
        String newPassword = PropertyReaderOptimized.getKeyValue("newPassword");
        String confirmPassword = PropertyReaderOptimized.getKeyValue("confirmPassword");

        // Click profile, settings, security, and change password steps
        clickAndLog(settingDropDownBtn, "Verified clicked on the profile icon.", test);
        clickAndLog(settingsBtn, "Verified clicked on the settings button.", test);
        clickAndLog(securitySettings, "Verified clicked on the security settings button.", test);
        clickAndLog(changeBtn, "Verified clicked on the change button.", test);

        // Enter password fields
        enterTextAndLog(oldPasswordTextField, oldPassword, "Verified entered the value in the old password text field.", test);
        enterTextAndLog(newPasswordTextField, newPassword, "Verified entered the value in the new password text field.", test);
        enterTextAndLog(confirmPasswordTextField, confirmPassword, "Verified entered the value in the confirm password text field.", test);

        // Click 'Get Code' and validate OTP sent message
        clickAndLog(getCodeBtn, "Verified clicked on the get code button.", test);
        basePage.waitForElementToBeVisible(otpSentPopUpMsg);
        String actualMessage = basePage.doGetElementText(otpSentPopUpMsg);

        boolean isSuccess = actualMessage.equals(expectedMessage);
        String logStatus = isSuccess ? "PASS" : "FAIL";
        test.log(LogStatus.valueOf(logStatus), test.addScreenCapture(BasePage.getScreenCapture(driver)),
                isSuccess ? "Verified OTP sent successfully pop-up message is matched." : "Verified OTP sent successfully pop-up message isn't matched.");

        return isSuccess;
    }

    // Validate password change pop-up message
    public boolean validatePasswordChangePopUpMsg(String expectedMessage, ExtentTest test) throws IOException, IOException, InterruptedException {
        String mailinatorEmail = PropertyReaderOptimized.getKeyValue("changePasswordMailinatorEmail");

        // Enter OTP and click change
        Thread.sleep(2000);
        enterTextAndLog(emailOtpTextField, "12345", "Verified entered the value in the email otp text field.", test);
        clickAndLog(changeButton, "Verified clicked on the change button.", test);

        // Validate password change message
        basePage.waitForElementToBeVisible(passwordChangePopUpMsg);
        String actualMessage = basePage.doGetElementText(passwordChangePopUpMsg);

        boolean isSuccess = actualMessage.equals(expectedMessage);
        String logStatus = isSuccess ? "PASS" : "FAIL";
        test.log(LogStatus.valueOf(logStatus), test.addScreenCapture(BasePage.getScreenCapture(driver)),
                isSuccess ? "Verified Password changed successfully pop-up message is matched." : "Verified Password changed successfully pop-up message isn't matched.");

        return isSuccess;
    }
}