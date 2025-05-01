package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginWithPhoneNumberPageValidation {
    WebDriver driver;
    BasePage basePage;

    public LoginWithPhoneNumberPageValidation(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
    }

    private By image= By.xpath("//img[@alt='Language']");
    private By liEnglish= By.xpath("/html/body/div[1]/div/header/div/div/div/div[4]/div/div/div/ul/li[1]");
    private By loginBtn= By.xpath("//button[@type='button']");
    private By phoneNumberBtn= By.xpath("//div[text()='Phone Number']");
    private By dropDownBtn= By.xpath("//div[@class='selected-flag']");
    private By searchBox= By.xpath("//input[@class='search-box']");
    private By countryName= By.xpath("//span[text()='India']");
    private By phoneNoTextField= By.xpath("//input[@class='form-control ant-input']");
    private By continueButton=By.xpath("//span[text()='Continue']");
    private By phoneNumberRequiredValidation=By.xpath("//span[text()='Phone number is required']");
    private By enterValidPhoneNumberValidation=By.xpath("//span[text()='Please enter valid phone number']");
    private By passwordTextFieldRequiredValidation=By.xpath("//span[text()='Password is required']");
    private By passwordTextField= By.xpath("//input[@type='password']");
    private By eyeBtn= By.xpath("//span[@class='ant-input-suffix']");
    private By continueBtn= By.xpath("//button[@type='submit']");
    private By getCodeBtn= By.xpath("//p[text()='Get Code']");
    private By otpRequiredValidation=By.xpath("//span[text()='OTP is required']");
    private By invalidCredentialsErrorPopUpMsg=By.xpath("//div[@class='ant-message-notice-content']");
    private By enterCodeTextField= By.xpath("//input[@name='otp']");
    private By getVerificationCodeErrorPopUpMsg=By.xpath("//div[@class='ant-message-notice-content']");
    private By maxOTPDigitLimitValidation=By.xpath("//span[text()='Max OTP limit should be 5 digits.']");
    private By invalidOTPErrorPopUpMsg=By.xpath("//div[@class='ant-message-notice-content']");

    public boolean validateLoginPagePhoneRequiredValidation(String phoneNumber,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Click on the image button
        basePage.waitForElementToBeVisible(image);
        basePage.click(image);

        //Click on the language
        basePage.waitForElementToBeVisible(liEnglish);
        basePage.click(liEnglish);

        //Click on the login button
        basePage.threadSleep();
        basePage.click(loginBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Login button.");

        //Click on the phone number button
        basePage.waitForElementToBeVisible(phoneNumberBtn);
        basePage.click(phoneNumberBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the phone number button.");

        //Click on the continue
        basePage.waitForElementToBeVisible(continueButton);
        basePage.click(continueButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clicked on the continue button.");

        //Phone number required validation
        basePage.waitForElementToBeVisible(phoneNumberRequiredValidation);
        String phoneNumberValidation = basePage.doGetElementText(phoneNumberRequiredValidation);
        if (phoneNumberValidation.equals(phoneNumber)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Phone number is required validation is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Phone number is required validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateLoginPagePasswordRequiredValidation(String password,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Password required validation
        basePage.waitForElementToBeVisible(passwordTextFieldRequiredValidation);
        String passwordValidation = basePage.doGetElementText(passwordTextFieldRequiredValidation);
        if (passwordValidation.equals(password)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password is required validation is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password is required validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateInvalidPhoneNumber(String invalidPhoneNumber,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String country= PropertyReaderOptimized.getKeyValue("loginCountry");

        //Click on the drop-down button
        basePage.waitForElementToBeVisible(dropDownBtn);
        basePage.click(dropDownBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the drop-down button.");

        //Search box
        basePage.waitForElementToBeVisible(searchBox);
        basePage.enterText(searchBox,country);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the search box text field.");

        //Select country
        basePage.waitForElementToBeVisible(countryName);
        basePage.click(countryName);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the country name.");

        //Enter the value in the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.enterText(phoneNoTextField,"12345");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified enter value in the phone number text field.");

        //Invalid phone number validation message
        basePage.waitForElementToBeVisible(enterValidPhoneNumberValidation);
        String invalidPhoneNumberValidation=basePage.doGetElementText(enterValidPhoneNumberValidation);
        if(invalidPhoneNumberValidation.equals(invalidPhoneNumber)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please enter valid phone number validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please enter valid phone number validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateInvalidPhoneAndPasswordMessage(String invalidPhoneNumberAndPassword,ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Enter the value in the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.enterText(phoneNoTextField,"12345");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified enter value in the phone number text field.");

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
        String invalidPhoneNumberAndPasswordMessage=basePage.doGetElementText(invalidCredentialsErrorPopUpMsg);
        if(invalidPhoneNumberAndPasswordMessage.equals(invalidPhoneNumberAndPassword)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Invalid phone number or password pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Invalid phone number or password pop-up message isn't matched.");
        }

        return isTrue;

    }

    public boolean validateInvalidCredentialErrorPopUpMessage(String invalidCredentials,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        String phoneNumber=PropertyReaderOptimized.getKeyValue("loginPhoneNumber");

        //Enter the value in the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.enterText(phoneNoTextField,"1");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified enter value in the phone number text field.");

        //Clear the value from the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.doClearValue(phoneNoTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clear the value from the phone number text field.");

        //Enter the value in the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.enterText(phoneNoTextField,phoneNumber);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the phone number text field.");

        //Click on the continue button
        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the continue button.");

        //Invalid credentials error pop-up message
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(invalidCredentialsErrorPopUpMsg);
        String invalidCredentialsMessage=basePage.doGetElementText(invalidCredentialsErrorPopUpMsg);
        if(invalidCredentialsMessage.equals(invalidCredentials)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Invalid credentials. You are left with 4 more attempts pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Invalid credentials. You are left with 4 more attempts pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateOTPRequiredValidation(String OTP,ExtentTest test) throws IOException, InterruptedException {
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
        String otpValidation=basePage.doGetElementText(otpRequiredValidation);
        if(otpValidation.equals(OTP)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified OTP is required validation message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified OTP is required validation message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateGetCodeMessage(String getOTPCode,ExtentTest test) throws IOException {
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
        String getOTPCodeMessage=basePage.doGetElementText(getVerificationCodeErrorPopUpMsg);
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
        basePage.enterText(enterCodeTextField,"2");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the enter code text field.");

        //Max otp limit validation message
        basePage.waitForElementToBeVisible(maxOTPDigitLimitValidation);
        String otpLimitValidation=basePage.doGetElementText(maxOTPDigitLimitValidation);
        if(otpLimitValidation.equals(otpLimit)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Max OTP limit should be 5 digits. validation message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Max OTP limit should be 5 digits. validation message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateInvalidOtpErrorPopUpMessage(String invalidOTP,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Enter the value in the enter code text field
        basePage.waitForElementToBeVisible(enterCodeTextField);
        basePage.enterText(enterCodeTextField,"2");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the enter code text field.");

        //Clear the value in the enter code text field
        basePage.waitForElementToBeVisible(enterCodeTextField);
        basePage.doClearValue(enterCodeTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clear the value from the enter code text field.");

        //Click on the get code button
        basePage.waitForElementToBeVisible(getCodeBtn);
        basePage.click(getCodeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the get code button.");

        //Enter the value in the enter code text field
        basePage.threadSleep();
        basePage.enterText(enterCodeTextField,"11111");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the enter code text field.");

        //Click on the continue button
        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the continue button.");

        //Invalid otp error pop-up message
        Thread.sleep(2000);
        basePage.waitForElementToBeVisible(invalidOTPErrorPopUpMsg);
        String invalidOTPMessage=basePage.doGetElementText(invalidOTPErrorPopUpMsg);
        if (invalidOTPMessage.equals(invalidOTP)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Invalid OTP pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Invalid OTP pop-up message isn't matched.");
        }

        return isTrue;
    }
}
