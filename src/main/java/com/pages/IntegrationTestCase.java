package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class IntegrationTestCase {
    WebDriver driver;
    BasePage basePage;

    public IntegrationTestCase(WebDriver driver){
        this.driver=driver;
        basePage=new BasePage(driver);
    }
    private By image= By.xpath("//img[@alt='Language']");
    private By liEnglish= By.xpath("/html/body/div[1]/div/header/div/div/div/div[4]/div/div/div/ul/li[1]");
    private By registerBtn= By.xpath("//button[text()='Register']");
    private By emailTextField= By.xpath("//input[@placeholder='Email']");
    private By passwordTextField= By.xpath("//input[@placeholder='Password']");
    private By eyeBtn= By.xpath("//span[@class='anticon anticon-eye-invisible ant-input-password-icon']");
    private By referralTextField= By.xpath("//input[@placeholder='Referral']");
    private By checkBoxBtn= By.xpath("//span[@class='ant-checkbox']");
    private By createAccountBtn= By.xpath("//span[text()='Create Account']");
    private By verifyYourEmailPage= By.xpath("//h4[text()='Verify your email']");
    private By mailinatorLoginTextField= By.xpath("//input[@id='search']");
    private By goButton= By.xpath("//button[text()='GO']");
    private By emailVerification= By.xpath("//tr[td[@class='ng-binding']]/td[2]");
    private By iframe= By.xpath("//iframe[@id='html_msg_body']");
    private By confirmBtn= By.xpath("//a[text()='Confirm']");
    private By emailVerifyPopUpMsg= By.xpath("//span[text()='Email Verified successfully']");
    private By dropDownBtn= By.xpath("//div[@class='flag mn']");
    private By searchBox= By.xpath("//input[@class='search-box']");
    private By countryName= By.xpath("//span[text()='India']");
    private By phoneNoTextField= By.xpath("//input[@class='form-control ant-input']");
    private By sendCodeBtn= By.xpath("//span[text()='Send Code']");
    private By sendCodePopUpMsg= By.xpath("//span[text()='Code sent on phone successfully']");
    private By resendCodeBtn= By.xpath("//span[text()='Resend code']");
    private By resendCodePopUpMsg= By.xpath("//span[text()='Code resent successfully']");
    private By enterCodeTextField= By.xpath("//input[@placeholder='Enter Code']");
    private By submitBtn= By.xpath("//span[text()='Submit']");
    private By phnNoPopUpMsg= By.xpath("//span[text()='Phone number verified']");
    private By homePage= By.xpath("//h3[text()='Home']");
    private By nameBtn= By.xpath("(//span[@class='ant-avatar-string'])[1]");
    private By signOutBtn= By.xpath("//a[text()='Sign Out']");
    private By loggedOutPopUpMsg= By.xpath("//span[text()='Logged Out Successfully']");
    private By emailField= By.xpath("//input[@name='email']");
    private By passwordField= By.xpath("//input[@type='password']");
    private By continueButton= By.xpath("//button[@type='submit']");
    private By getCodeBtn= By.xpath("//p[text()='Get Code']");
    private By otpSentPopUpMsg= By.xpath("//div[@class='ant-message-notice-content']");
    private By codeTextField= By.xpath("//input[@name='otp']");
    private By continueBtn= By.xpath("//span[text()='Continue']");
    private By loginPopUpMsg= By.xpath("//div[@class='ant-message-notice-content']");

    public boolean validateSignUpPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String email= PropertyReaderOptimized.getKeyValue("registerIntegrationEmail");
        String password=PropertyReaderOptimized.getKeyValue("registerIntegrationPassword");

        //Click on the image button
        basePage.waitForElementToBeVisible(image);
        basePage.click(image);

        //Click on the language
        basePage.waitForElementToBeVisible(liEnglish);
        basePage.click(liEnglish);

        //Click on the register button
        basePage.threadSleep();
        basePage.click(registerBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Register button.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField, email);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the Email text field.");

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField, password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the Password text field.");

        //Click on the eye button
        basePage.waitForElementToBeVisible(eyeBtn);
        basePage.click(eyeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the eye button.");

        //Check box button
        basePage.waitForElementToBeVisible(checkBoxBtn);
        basePage.click(checkBoxBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the check box.");

        //Click on the signup button
        basePage.waitForElementToBeVisible(createAccountBtn);
        basePage.click(createAccountBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the create account button.");

        //Verify your email page
        basePage.waitForElementToBeVisible(verifyYourEmailPage);
        if(basePage.checkElementIsDisplayed(verifyYourEmailPage)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified the user is on the verify your email page.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified the user isn't on the verify your email page.");
        }

        return isTrue;
    }

    public boolean validateEmailPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String mailinatorEmail=PropertyReaderOptimized.getKeyValue("registerIntegrationMailinatorEmail");

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
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(emailVerification);
        basePage.click(emailVerification);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clicked on the Email Verification Link.");

        //Switch to the frame
        basePage.waitForElementToBeVisible(iframe);
        basePage.switchToFrameWebElement((WebElement) iframe);

        //Click on the confirm button
        basePage.waitForElementToBeVisible(confirmBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the confirm button.");
        basePage.click(confirmBtn);

        //Switch the window
        Thread.sleep(2000);
        basePage.switchToWindow();

        //Email verification pop-up message
        basePage.waitForElementToBeVisible(emailVerifyPopUpMsg);
        if(basePage.checkElementIsDisplayed(emailVerifyPopUpMsg)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified email verify pop-up message displayed.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified email verify pop-up message isn't displayed.");
        }

        return isTrue;
    }

    public boolean validateAccountCreate(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String country=PropertyReaderOptimized.getKeyValue("registerIntegrationCountry");
        String phoneNumber=PropertyReaderOptimized.getKeyValue("registerIntegrationPhoneNumber");
        String otp=PropertyReaderOptimized.getKeyValue("registerIntegrationOtp");

        //Click on the drop-down button
        basePage.waitForElementToBeVisible(dropDownBtn);
        basePage.click(dropDownBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the drop-down button.");

        //Search box
        basePage.waitForElementToBeVisible(searchBox);
        basePage.enterText(searchBox,country);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the country name.");

        //Select country
        basePage.waitForElementToBeVisible(countryName);
        basePage.click(countryName);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the country name.");


        //Enter the value in the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.enterText(phoneNoTextField,phoneNumber);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the phone number text field.");

        //Click on the send code button
        basePage.waitForElementToBeVisible(sendCodeBtn);
        basePage.click(sendCodeBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the send code button.");

        //Send code pop-up message
        basePage.waitForElementToBeVisible(sendCodePopUpMsg);
        if(basePage.checkElementIsDisplayed(sendCodePopUpMsg)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified send code pop-up message displayed.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified send code pop-up message isn't displayed.");
        }

        //Click on the resend code button
        basePage.waitForElementToBeVisible(resendCodeBtn);
        basePage.click(resendCodeBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the resend code button.");

        //Resend code pop-up message
        basePage.waitForElementToBeVisible(resendCodePopUpMsg);
        if(basePage.checkElementIsDisplayed(resendCodePopUpMsg)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified code resent pop-up message displayed.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified code resent pop-up message isn't displayed.");
        }

        //Enter the value in the enter code text field
        basePage.waitForElementToBeVisible(enterCodeTextField);
        basePage.enterText(enterCodeTextField,otp);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the enter code text field.");

        //Click on the submit button
        basePage.waitForElementToBeVisible(submitBtn);
        basePage.click(submitBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the submit button.");

        //Phone number pop-up message
        basePage.waitForElementToBeVisible(phnNoPopUpMsg);
        if(basePage.checkElementIsDisplayed(phnNoPopUpMsg)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified phone number verified pop-up message displayed.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified phone number verified pop-up message isn't displayed.");
        }

        //After register home page
        basePage.waitForElementToBeVisible(homePage);
        if(basePage.checkElementIsDisplayed(homePage)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified after register the user is on the home page.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified after register the user isn't on the home page.");
        }

        return isTrue;
    }

    public boolean validateLoggedOutSuccessfully(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Click on the name button
        basePage.waitForElementToBeVisible(nameBtn);
        basePage.click(nameBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the name button.");

        //Click on the sign-out button
        basePage.waitForElementToBeVisible(signOutBtn);
        basePage.click(signOutBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the sign out button.");

        //Logged-out pop-up message
        basePage.waitForElementToBeVisible(loggedOutPopUpMsg);
        if(basePage.checkElementIsDisplayed(loggedOutPopUpMsg)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified logged out pop-up message is displayed.");
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified logged out pop-up message isn't displayed.");
        }

        return isTrue;
    }

    public boolean validateLoginWithEmailPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String email = PropertyReaderOptimized.getKeyValue("loginIntegrationEmail");
        String password = PropertyReaderOptimized.getKeyValue("loginIntegrationPassword");
        String OTP = PropertyReaderOptimized.getKeyValue("loginIntegrationOTP");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailField);
        basePage.enterText(emailField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email text field.");

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordField);
        basePage.enterText(passwordField,password);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Password text field.");

        //Click on the login button
        basePage.waitForElementToBeVisible(continueButton);
        basePage.click(continueButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the Continue button.");

        //Click on the get OTP button
        basePage.waitForElementToBeVisible(getCodeBtn);
        basePage.click(getCodeBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the Get Code button.");

        //OTP pop up message
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(otpSentPopUpMsg);
        if(basePage.checkElementIsDisplayed(otpSentPopUpMsg)) {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified otp sent Pop Up message is displayed.");
        }else
        {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Pop Up message isn't displayed.");
        }

        //Enter the value in the OTP text field
        basePage.waitForElementToBeVisible(codeTextField);
        basePage.enterText(codeTextField,OTP);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Code text field.");

        //Click on the verify button
        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the Continue button.");

        //Login pop up message
        basePage.waitForElementToBeVisible(loginPopUpMsg);
        if(basePage.checkElementIsDisplayed(loginPopUpMsg)) {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified the Login Pop Up message is displayed.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified the Login Pop Up message isn't displayed.");
        }

        //Home page
        basePage.waitForElementToBeVisible(homePage);
        if(basePage.checkElementIsDisplayed(homePage)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After login the user is on the Home Page.");
        }else{
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After login the user isn't on the Home Page.");
        }

        return isTrue;
    }
}
