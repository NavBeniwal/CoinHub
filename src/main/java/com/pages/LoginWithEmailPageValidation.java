package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginWithEmailPageValidation {
    WebDriver driver;
    BasePage basePage;

    public LoginWithEmailPageValidation(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@title='Log In']")
    private WebElement loginBtn;
    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//span[text()='Please enter valid email']")
    private WebElement emailTextFieldInvalidValidation;
    @FindBy(xpath = "//span[text()='Password is required']")
    private WebElement passwordTextFieldRequiredValidation;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailTextField;
    @FindBy(xpath = "//div[@class='ant-message-notice-content']")
    private WebElement invalidCredentialsErrorPopUpMsg;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordTextField;
    @FindBy(xpath = "//span[@class='ant-input-suffix']")
    private WebElement eyeBtn;
    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueBtn;
    @FindBy(xpath = "//span[text()='OTP is required']")
    private WebElement otpRequiredValidation;
    @FindBy(xpath = "//p[text()='Get Code']")
    private WebElement getCodeBtn;
    @FindBy(xpath = "//input[@name='otp']")
    private WebElement enterCodeTextField;
    @FindBy(xpath = "//span[text()='Please get a verification code first.']")
    private WebElement getVerificationCodeErrorPopUpMsg;
    @FindBy(xpath = "//span[text()='Max OTP limit should be 5 digits.']")
    private WebElement maxOTPdDigitLimitValidation;
    @FindBy(xpath = "//div[@class='ant-message-notice-content']")
    private WebElement invalidOTPErrorPopUpMsg;

    public boolean validateLoginEmailRequiredValidation(String email,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Click on the login button
        basePage.threadSleep();
        basePage.click(loginBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Login button.");

        //Click on the continue
        basePage.waitForElementToBeVisible(continueButton);
        basePage.click(continueButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clicked on the continue button.");

        //Invalid email validation
        basePage.waitForElementToBeVisible(emailTextField);
        String emailValidation = emailTextField.getText();
        if (emailValidation.equals(email)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Email is required validation matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Email is required validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateLoginPasswordRequiredValidation(String password,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Required password validation
        basePage.waitForElementToBeVisible(passwordTextFieldRequiredValidation);
        String passwordValidation=passwordTextFieldRequiredValidation.getText();
        if (passwordValidation.equals(password)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password is required validation is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password is required validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithOnlyNumericValue(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String numeric= RandomStringUtils.randomNumeric(5,10);
        String email=numeric+".com";

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=emailTextFieldInvalidValidation.getText();
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithOnlyAlphabeticValue(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String alphabetic= RandomStringUtils.randomAlphabetic(5,10);
        String email=alphabetic+".com";

        //Clear the value in the email name text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.clearValue(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value in the Email Text Field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=emailTextFieldInvalidValidation.getText();
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithAlphaNumericValue(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String alphanumeric= RandomStringUtils.randomAlphanumeric(5,10);
        String email=alphanumeric+".com";

        //Clear the value in the email name text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.clearValue(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value in the Email Text Field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=emailTextFieldInvalidValidation.getText();
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMultipleAtTheRateValue(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String randomAlphanumeric= RandomStringUtils.randomAlphanumeric(5,10);
        String email=randomAlphanumeric+"@jd@.com";

        //Clear the value in the email name text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.clearValue(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value in the Email Text Field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=emailTextFieldInvalidValidation.getText();
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithOnlySpecialCharacterValue(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Clear the value in the email name text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.clearValue(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value in the Email Text Field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,"!@#$.com");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=emailTextFieldInvalidValidation.getText();
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithoutAtTheRate(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String randomAlphanumeric=RandomStringUtils.randomAlphanumeric(5,10);
        String email=randomAlphanumeric+".com";

        //Clear the value in the email name text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.clearValue(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value in the Email Text Field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=emailTextFieldInvalidValidation.getText();
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMultipleDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String randomAlphanumeric=RandomStringUtils.randomAlphanumeric(5,10);
        String email=randomAlphanumeric+"in.a.com";

        //Clear the value in the email name text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.clearValue(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value in the Email Text Field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=emailTextFieldInvalidValidation.getText();
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateInvalidCredentialErrorPopUpMsg(String invalidCredentials,ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Clear the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.clearValue(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value in the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,"nav1@mailinator.com");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the email text field.");

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,"Test");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the password text field.");

        //Click on the eye button
        basePage.waitForElementToBeVisible(eyeBtn);
        basePage.click(eyeBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the eye button.");

        //Click on the continue button
        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the continue button.");

        //Invalid credentials error pop-up message
        basePage.waitForElementToBeVisible(invalidCredentialsErrorPopUpMsg);
        String invalidCredentialsValidation=invalidCredentialsErrorPopUpMsg.getText();
        if(invalidCredentialsValidation.equals(invalidCredentials)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Invalid credentials. You are left with 4 more attempts pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Invalid credentials. You are left with 4 more attempts pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateOtpRequiredValidationMsg(String OTP,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        //Click on the eye button
        basePage.waitForElementToBeVisible(eyeBtn);
        basePage.click(eyeBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the eye button.");

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,"@123");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the password text field.");

        //Click on the continue button
        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the continue button.");

        //Click on the continue button
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the continue button.");

        //OTP required validation message
        basePage.waitForElementToBeVisible(otpRequiredValidation);
        String otpValidation=otpRequiredValidation.getText();
        if(otpValidation.equals(OTP)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified OTP is required validation message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified OTP is required validation message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateGetCodeErrorPopUpMsg(String getOTPCode,ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Enter the value in the enter code text field
        basePage.waitForElementToBeVisible(enterCodeTextField);
        basePage.enterText(enterCodeTextField,"11111");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the enter code text field.");

        //Click on the continue button
        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the continue button.");


        //Get verification error pop-up message
        basePage.waitForElementToBeVisible(getVerificationCodeErrorPopUpMsg);
        String getOTPCodeMessage=getVerificationCodeErrorPopUpMsg.getText();
        if(getOTPCodeMessage.equals(getOTPCode)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please get a verification code first. pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please get a verification code first. pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateMaxOtpLimitValidation(String otpLimit,ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Enter the value in the enter code text field
        basePage.waitForElementToBeVisible(enterCodeTextField);
        basePage.enterText(enterCodeTextField,"12");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the enter code text field.");

        //Max otp limit validation message
        basePage.waitForElementToBeVisible(maxOTPdDigitLimitValidation);
        String otpLimitValidation=maxOTPdDigitLimitValidation.getText();
        if(otpLimitValidation.equals(otpLimit)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Max OTP limit should be 5 digits. validation message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Max OTP limit should be 5 digits. validation message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateInvalidOtpErrorPopUpMsg(String invalidOTP,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Enter the value in the enter code text field
        basePage.threadSleep();
        basePage.enterText(enterCodeTextField,"11111");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the enter code text field.");

        //Clear the value in the enter code text field
        basePage.threadSleep();
        basePage.clearValue(enterCodeTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value in the enter code text field.");

        //Click on the get code button
        basePage.waitForElementToBeVisible(getCodeBtn);
        basePage.click(getCodeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the get code button.");

        //Enter the value in the enter code text field
        basePage.enterText(enterCodeTextField,"11111");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the enter code text field.");

        //Click on the continue button
        basePage.threadSleep();
        basePage.click(continueButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the continue button.");

        //Invalid otp error pop-up message
        basePage.waitForElementToBeVisible(invalidOTPErrorPopUpMsg);
        String invalidOTPMessage=invalidOTPErrorPopUpMsg.getText();
        if (invalidOTPMessage.equals(invalidOTP)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Invalid OTP pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Invalid OTP pop-up message isn't matched");
        }

        //Enter the value in the enter code text field
        basePage.waitForElementToBeVisible(enterCodeTextField);
        basePage.enterText(enterCodeTextField,"12345");

        //Enter the value in the enter code text field
        basePage.threadSleep();
        basePage.removeValue(enterCodeTextField);

        //Enter the value in the enter code text field
        basePage.threadSleep();
        basePage.enterText(enterCodeTextField,"12345");

        //Click on the continue button
        basePage.threadSleep();
        basePage.click(continueButton);

        return isTrue;
    }
}
