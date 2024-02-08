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

public class ChangePasswordPageValidation {
    WebDriver driver;
    BasePage basePage;

    public ChangePasswordPageValidation(WebDriver driver){
        this.driver=driver;
        basePage=new BasePage(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "(//span[@class='ant-avatar-string'])[1]")
    private WebElement settingDropDownBtn;
    @FindBy (xpath = "//a[text()='Settings']")
    private WebElement settingsBtn;
    @FindBy (xpath = "(//div[@class='ant-tabs-tab-btn'])[2]")
    private WebElement securitySettings;
    @FindBy (xpath = "(//button[@class='verifyBtn'])[1]")
    private WebElement changeBtn;
    @FindBy (xpath = "(//span[text()='Change'])[2]")
    private WebElement changeButton;
    @FindBy (xpath = "//input[@placeholder='Please enter old password']")
    private WebElement oldPasswordTextField;
    @FindBy (xpath = "//span[text()='Please enter old password']")
    private WebElement oldPasswordTextFieldValidationMsg;
    @FindBy (xpath = "//span[text()='Old password is not correct']")
    private WebElement oldPasswordNotCorrectErrorPopUpMsg;
    @FindBy (xpath = "//input[@placeholder='Please enter new password']")
    private WebElement newPasswordTextField;
    @FindBy (xpath = "//span[text()='Please enter new password']")
    private WebElement newPasswordTextFieldValidationMsg;
    @FindBy (xpath = "//span[contains(text(),'Password must be a')]")
    private WebElement newPasswordContainsValidationMsg;
    @FindBy (xpath = "//span[@class='anticon anticon-close-circle']")
    private WebElement newPasswordCannotBeSameAsOldOneErrorPopUpMsg;
    @FindBy (xpath = "//input[@placeholder='Please enter confirm password']")
    private WebElement confirmPasswordTextField;
    @FindBy (xpath = "//span[text()='Please enter confirm password']")
    private WebElement confirmPasswordTextFieldValidationMsg;
    @FindBy (xpath = "//span[text()='Confirm password should be same']")
    private WebElement confirmPasswordShouldBeSameValidationMsg;
    @FindBy (xpath = "//input[@placeholder='Please enter email OTP']")
    private WebElement emailOtpTextField;
    @FindBy (xpath = "//p[text()='Get Code']")
    private WebElement getCodeBtn;
    @FindBy (xpath = "//span[text()='OTP is required']")
    private WebElement otpRequiredValidationMsg;
    @FindBy (xpath = "//span[text()='Please get a verification code first.']")
    private WebElement getOtpErrorPopUpMsg;
    @FindBy (xpath = "//span[text()='Invalid OTP ']")
    private WebElement invalidOtpErrorPopUpMsg;
    @FindBy (xpath = "//span[text()='Max OTP limit should be 5 digits.']")
    private WebElement otpMaxLimitValidationMsg;
    @FindBy (xpath = "//p[text()='Get Code'//span[text()='OTP sent successfully']]")
    private WebElement otpSentPopUpMsg;
    @FindBy (xpath = "//span[text()=['OTP resent successfully']")
    private WebElement otpResentPopUpMsg;
    @FindBy (xpath = "//span[text()='Maximum limit reached. Please try again in a while']")
    private WebElement tryAgainInAWhileErrorPopUpMsg;
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

    public boolean validateChangePasswordPageOldPasswordTextFieldValidation(String oldPassword,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Click on the profile
        basePage.threadSleep();
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

        //Click on the change button
        basePage.waitForElementToBeVisible(changeButton);
        basePage.click(changeButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the change button.");

        //Enter old password validation message
        basePage.waitForElementToBeVisible(oldPasswordTextFieldValidationMsg);
        String oldPasswordValidation = oldPasswordTextFieldValidationMsg.getText();
        if (oldPasswordValidation.equals(oldPassword)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter old password validation is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter old password validation isn't matched.");
        }

        return isTrue = true;
    }

    public boolean validateChangePasswordPageNewPasswordTextFieldValidation(String newPassword,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Enter new password validation message
        basePage.waitForElementToBeVisible(newPasswordTextFieldValidationMsg);
        String newPasswordValidation = newPasswordTextFieldValidationMsg.getText();
        if (newPasswordValidation.equals(newPassword)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter new password validation is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter new password validation isn't matched.");
        }

        return isTrue = true;
    }

    public boolean validateChangePasswordPageConfirmPasswordTextFieldValidation(String confirmPassword,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Enter confirm-password validation message
        basePage.waitForElementToBeVisible(confirmPasswordTextFieldValidationMsg);
        String confirmPasswordValidation = confirmPasswordTextFieldValidationMsg.getText();
        if (confirmPasswordValidation.equals(confirmPassword)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter confirm password validation is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter confirm password validation isn't matched.");
        }

        return isTrue = true;
    }

    public boolean validateChangePasswordPageOTPTextFieldValidation(String OTP,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        //OTP required validation message
        basePage.waitForElementToBeVisible(otpRequiredValidationMsg);
        String otpValidation=otpRequiredValidationMsg.getText();
        if(otpValidation.equals(OTP)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified OTP is required validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified OTP is required validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateChangePasswordPageNewPasswordMustContainValidationMessage(String newPasswordContains,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        //Enter the value in the old password text field
        basePage.waitForElementToBeVisible(oldPasswordTextField);
        basePage.enterText(oldPasswordTextField,"Test");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the old password text field.");

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,"Test");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the new password text field.");

        //New password must contain validation message
        basePage.waitForElementToBeVisible(newPasswordContainsValidationMsg);
        String newPasswordContainsValidation=newPasswordContainsValidationMsg.getText();
        if(newPasswordContainsValidation.equals(newPasswordContains)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateChangePasswordPageConfirmPasswordShouldBeSameValidationMessage(String confirmPasswordValidation,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,"@123");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the new password text field.");

        //Enter the value in the confirm-password text field
        basePage.waitForElementToBeVisible(confirmPasswordTextField);
        basePage.enterText(confirmPasswordTextField,"Test");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the confirm password text field.");

        //Confirm password should be same validation message
        basePage.waitForElementToBeVisible(confirmPasswordShouldBeSameValidationMsg);
        String confirmPasswordValidationMessage=confirmPasswordShouldBeSameValidationMsg.getText();
        if(confirmPasswordValidationMessage.equals(confirmPasswordValidation)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Confirm password should be same validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Confirm password should be same validation is matched.");
        }

        return isTrue;
    }

    public boolean validateChangePasswordPageGetVerificationCodeErrorPopUpMessage(String getOTPCode,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        //Enter the value in the confirm-password text field
        basePage.waitForElementToBeVisible(confirmPasswordTextField);
        basePage.enterText(confirmPasswordTextField,"@123");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the confirm password text field.");

        //Enter the value in the email otp text field
        basePage.waitForElementToBeVisible(emailOtpTextField);
        basePage.enterText(emailOtpTextField,"1234");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the email otp text field.");

        //Click on the change button
        basePage.waitForElementToBeVisible(changeButton);
        basePage.click(changeButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the change button.");

        //Please get a verification code first error pop-up message
        basePage.waitForElementToBeVisible(getOtpErrorPopUpMsg);
        String getOTPFirstMessage=getOtpErrorPopUpMsg.getText();
        if(getOTPFirstMessage.equals(getOTPCode)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please get a verification code first. pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please get a verification code first. pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateChangePasswordPageInvalidOtpErrorPopUpMessage(String invalidOTP,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        //Click on the get code button
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(getCodeBtn);
        basePage.click(getCodeBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the get code button.");

        //Click on the change button
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(changeButton);
        basePage.click(changeButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the change button.");

        //Invalid otp error pop-up message
        basePage.waitForElementToBeVisible(invalidOtpErrorPopUpMsg);
        String invalidOTPMessage=invalidOtpErrorPopUpMsg.getText();
        if(invalidOTPMessage.equals(invalidOTP)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Invalid OTP pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Invalid OTP pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateChangePasswordPageOldPasswordNotCorrectErrorPopUpMessage(String oldPasswordMessage,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        String mailinatorEmail=PropertyReaderOptimized.getKeyValue("loginEmail");

        //Enter the value in the email otp text field
        basePage.waitForElementToBeVisible(emailOtpTextField);
        basePage.enterText(emailOtpTextField,"5");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the email otp text field.");

        //Remove the value from the email otp text field
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(emailOtpTextField);
        basePage.removeValue(emailOtpTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified removed the value from the email otp text field.");

        //Enter the value in the old password text field
        basePage.waitForElementToBeVisible(oldPasswordTextField);
        basePage.enterText(oldPasswordTextField,"@1234");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the old password text field.");

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
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(changeButton);
        basePage.click(changeButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the change button.");

        //Old password isn't correct error pop-up message
        basePage.waitForElementToBeVisible(oldPasswordNotCorrectErrorPopUpMsg);
        String oldPasswordNotCorrectMessage=oldPasswordNotCorrectErrorPopUpMsg.getText();
        if(oldPasswordNotCorrectMessage.equals(oldPasswordMessage)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Old password is not correct pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Old password is not correct pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateChangePasswordPageNewPasswordCanNotBeTheSameErrorPopUpMessage(String newPasswordMessage,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        //Enter the value in the old password text field
        basePage.waitForElementToBeVisible(oldPasswordTextField);
        basePage.enterText(oldPasswordTextField,"4");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the old password text field.");

        //Clear the value from the old password text field
        basePage.waitForElementToBeVisible(oldPasswordTextField);
        basePage.clearValue(oldPasswordTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the old password text field.");

        //Enter the value in the old password text field
        basePage.waitForElementToBeVisible(oldPasswordTextField);
        basePage.enterText(oldPasswordTextField,"Test@123");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the old password text field.");

        //Click on the change button
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(changeButton);
        basePage.click(changeButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the change button.");

        //New password cannot be same as old one error pop-up message
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(newPasswordCannotBeSameAsOldOneErrorPopUpMsg);
        String newPasswordCannotBeSameMessage=newPasswordCannotBeSameAsOldOneErrorPopUpMsg.getText();
        if(newPasswordCannotBeSameMessage.equals(newPasswordMessage)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified New password can't be the same, as old one pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified New password can't be the same, as old one pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateChangePasswordPageOtpMaxLimitValidationMessage(String otpLimit,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        //Enter the value in the email otp text field
        basePage.waitForElementToBeVisible(emailOtpTextField);
        basePage.enterText(emailOtpTextField,"1");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the email otp text field.");

        //Otp max limit validation message
        basePage.waitForElementToBeVisible(otpMaxLimitValidationMsg);
        String otpLimitValidation=otpMaxLimitValidationMsg.getText();
        if(otpLimitValidation.equals(otpLimit)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Max OTP limit should be 5 digits. validation message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Max OTP limit should be 5 digits. message isn't matched.");
        }

        return isTrue;
    }
}
