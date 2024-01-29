package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ChangePasswordPage {
    WebDriver driver;
    BasePage basePage;

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[@class='ant-avatar-string'])[1]")
    private WebElement settingDropDownBtn;
    @FindBy(xpath = "//a[text()='Settings']")
    private WebElement settingsBtn;
    @FindBy(xpath = "(//div[@class='ant-tabs-tab-btn'])[2]")
    private WebElement securitySettings;
    @FindBy(xpath = "(//button[@class='verifyBtn'])[1]")
    private WebElement changeBtn;
    @FindBy(xpath = "//input[@placeholder='Please enter old password']")
    private WebElement oldPasswordTextField;
    @FindBy(xpath = "//input[@placeholder='Please enter new password']")
    private WebElement newPasswordTextField;
    @FindBy(xpath = "//input[@placeholder='Please enter confirm password']")
    private WebElement confirmPasswordTextField;
    @FindBy(xpath = "//input[@placeholder='Please enter email OTP']")
    private WebElement emailOtpTextField;
    @FindBy(xpath = "//p[text()='Get Code']")
    private WebElement getCodeBtn;
    @FindBy(xpath = "//p[text()='Get Code'//span[text()='OTP resent successfully']]")
    private WebElement otpResentPopUpMsg;
    @FindBy(xpath = "(//span[text()='Change'])[2]")
    private WebElement changeButton;
    @FindBy(xpath = "//span[text()='OTP sent successfully']")
    private WebElement otpSentPopUpMsg;
    @FindBy(xpath = "//span[text()='Password changed successfully']")
    private WebElement passwordChangePopUpMsg;
    @FindBy(xpath = "//input[@id='search']")
    private WebElement mailinatorLoginTextField;
    @FindBy(xpath = "//button[text()='GO']")
    private WebElement goButton;
    @FindBy(xpath = "//tr[td[@class='ng-binding']]/td[2]")
    private WebElement emailVerification;
    @FindBy(xpath = "//iframe[@id='html_msg_body']")
    private WebElement iframe;
    @FindBy(xpath = "(//td[text()=' '])[3]")
    private WebElement otp;

    public boolean validateGetCodePopUpMsg(String getCode,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String oldPassword = PropertyReaderOptimized.getKeyValue("oldPassword");
        String newPassword = PropertyReaderOptimized.getKeyValue("newPassword");
        String confirmPassword = PropertyReaderOptimized.getKeyValue("confirmPassword");

        //Click on the profile
        basePage.waitForElementToBeVisible(settingDropDownBtn);
        basePage.click(settingDropDownBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the profile icon.");

        //Click on the settings button
        basePage.waitForElementToBeVisible(settingsBtn);
        basePage.click(settingsBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the settings button.");

        //Click on the security settings button
        basePage.waitForElementToBeVisible(securitySettings);
        basePage.click(securitySettings);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the security settings button.");

        //Click on the change button
        basePage.waitForElementToBeVisible(changeBtn);
        basePage.click(changeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the change button.");

        //Enter the value in the old password text field
        basePage.waitForElementToBeVisible(oldPasswordTextField);
        basePage.enterText(oldPasswordTextField, oldPassword);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the old password text field.");

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField, newPassword);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the new password text field.");

        //Enter the value in the confirm-password text field
        basePage.waitForElementToBeVisible(confirmPasswordTextField);
        basePage.enterText(confirmPasswordTextField, confirmPassword);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the confirm password text field.");

        //Click on the get code button
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(getCodeBtn);
        basePage.click(getCodeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the get code button.");

        // OTP sent pop-up message
        basePage.waitForElementToBeVisible(otpSentPopUpMsg);
        String getCodeMessage = otpSentPopUpMsg.getText();
        if (getCodeMessage.equals(getCode)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified OTP sent successfully pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified OTP sent successfully pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validatePasswordChangePopUpMsg(String passwordChange,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String mailinatorEmail = PropertyReaderOptimized.getKeyValue("changePasswordMailinatorEmail");

        //Get current window id
        String windowId = basePage.getCurrentWindowId();
        Thread.sleep(2000);

        //Switch to the new window
        driver.switchTo().newWindow(WindowType.WINDOW).navigate().to(PropertyReaderOptimized.getKeyValue("mailinatorUrl"));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Switch to the Mailinator Page.");

        //Enter the value in the mailinator login text field
        basePage.waitForElementToBeVisible(mailinatorLoginTextField);
        basePage.enterText(mailinatorLoginTextField, mailinatorEmail);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Enter the value in the Mailinator TextField.");

        //Click on the go button
        basePage.waitForElementToBeVisible(goButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clicked on the Go Button.");
        basePage.click(goButton);

        //Click on the email verification link
        basePage.waitForElementToBeVisible(emailVerification);
        basePage.click(emailVerification);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clicked on the Email Verification Link.");

        //Switch to the frame
        basePage.switchToFrameWebElement(iframe);
        Thread.sleep(2000);

        //Get otp
        basePage.waitForElementToBeVisible(otp);
        String OTP = basePage.getText(otp);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Get Otp.");

        //Switch to the window
        Thread.sleep(2000);
        driver.switchTo().window(windowId);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Switch to the Current Window.");

        //Enter the value in the email otp text field
        basePage.waitForElementToBeVisible(emailOtpTextField);
        basePage.enterText(emailOtpTextField,OTP);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the email otp text field.");

        //Click on the change button
        basePage.waitForElementToBeVisible(changeButton);
        basePage.click(changeButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the change button.");

        //Password change pop-up message
        basePage.waitForElementToBeVisible(passwordChangePopUpMsg);
        String passwordChangeMessage=passwordChangePopUpMsg.getText();
        if(passwordChangeMessage.equals(passwordChange)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Password changed successfully pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Password changed successfully pop-up message isn't matched.");
        }

        return isTrue;
    }
}
