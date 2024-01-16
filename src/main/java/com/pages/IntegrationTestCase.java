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

public class IntegrationTestCase {
    WebDriver driver;
    BasePage basePage;

    public IntegrationTestCase(WebDriver driver){
        this.driver=driver;
        basePage=new BasePage(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[text()='Register']")
    private WebElement registerBtn;
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailTextField;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordTextField;
    @FindBy(xpath = "//span[@class='anticon anticon-eye-invisible ant-input-password-icon']")
    private WebElement eyeBtn;
    @FindBy(xpath = "//input[@placeholder='Referral']")
    private WebElement referralTextField;
    @FindBy(xpath = "//span[@class='ant-checkbox']")
    private WebElement checkBoxBtn;
    @FindBy(xpath = "//span[text()='Create Account']")
    private WebElement createAccountBtn;
    @FindBy(xpath = "//h4[text()='Verify your email']")
    private WebElement verifyYourEmailPage;
    @FindBy(xpath = "//input[@id='search']")
    private WebElement mailinatorLoginTextField;
    @FindBy(xpath = "//button[text()='GO']")
    private WebElement goButton;
    @FindBy(xpath = "//tr[td[@class='ng-binding']]/td[2]")
    private WebElement emailVerification;
    @FindBy(xpath = "//iframe[@id='html_msg_body']")
    private WebElement iframe;
    @FindBy(xpath = "//a[text()='Confirm']")
    private WebElement confirmBtn;
    @FindBy(xpath = "//span[text()='Email Verified successfully']")
    private WebElement emailVerifyPopUpMsg;
    @FindBy(xpath = "//div[@class='flag mn']")
    private WebElement dropDownBtn;
    @FindBy(xpath = "//input[@class='search-box']")
    private WebElement searchBox;
    @FindBy(xpath = "//span[text()='India']")
    private WebElement countryName;
    @FindBy(xpath = "//input[@class='form-control ant-input']")
    private WebElement phoneNoTextField;
    @FindBy(xpath = "//span[text()='Send Code']")
    private WebElement sendCodeBtn;
    @FindBy(xpath = "//span[text()='Code sent on phone successfully']")
    private WebElement sendCodePopUpMsg;
    @FindBy(xpath = "//span[text()='Resend code']")
    private WebElement resendCodeBtn;
    @FindBy(xpath = "//span[text()='Code resent successfully']")
    private WebElement resendCodePopUpMsg;
    @FindBy(xpath = "//input[@placeholder='Enter Code']")
    private WebElement enterCodeTextField;
    @FindBy(xpath = "//span[text()='Submit']")
    private WebElement submitBtn;
    @FindBy(xpath = "//span[text()='Phone number verified']")
    private WebElement phnNoPopUpMsg;
    @FindBy(xpath = "//h3[text()='Home']")
    private WebElement homePage;
    @FindBy(xpath = "(//span[@class='ant-avatar-string'])[1]")
    private WebElement nameBtn;
    @FindBy(xpath = "//a[text()='Sign Out']")
    private WebElement signOutBtn;

    @FindBy(xpath = "//span[text()='Logged Out Successfully']")
    private WebElement loggedOutPopUpMsg;
    @FindBy(xpath = "//button[@title='Log In']")
    private WebElement loginBtn;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//span[@class='ant-input-suffix']")
    private WebElement eyeIcon;
    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//p[text()='Get Code']")
    private WebElement getCodeBtn;
    @FindBy(xpath = "//div[@class='ant-message-notice-content']")
    private WebElement otpPopUpMsg;
    @FindBy(xpath = "//input[@name='otp']")
    private WebElement codeTextField;
    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueBtn;
    @FindBy(xpath = "//div[@class='ant-message-notice-content']")
    private WebElement loginPopUpMsg;

    public boolean validateSignUpPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String email= PropertyReaderOptimized.getKeyValue("registerIntegrationEmail");
        String password=PropertyReaderOptimized.getKeyValue("registerIntegrationPassword");

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
        if(verifyYourEmailPage.isDisplayed()){
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
        basePage.switchToFrameWebElement(iframe);

        //Click on the confirm button
        basePage.waitForElementToBeVisible(confirmBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the confirm button.");
        basePage.click(confirmBtn);

        //Switch the window
        Thread.sleep(2000);
        basePage.switchToWindow();

        //Email verification pop-up message
        basePage.waitForElementToBeVisible(emailVerifyPopUpMsg);
        if(emailVerifyPopUpMsg.isDisplayed()){
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
        if(sendCodePopUpMsg.isDisplayed()){
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
        if(resendCodePopUpMsg.isDisplayed()){
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
        if(phnNoPopUpMsg.isDisplayed()){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified phone number verified pop-up message displayed.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified phone number verified pop-up message isn't displayed.");
        }

        //After register home page
        basePage.waitForElementToBeVisible(homePage);
        if(homePage.isDisplayed()){
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
        if(loggedOutPopUpMsg.isDisplayed()){
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

        //Click on the eye button
        basePage.waitForElementToBeVisible(eyeBtn);
        basePage.click(eyeIcon);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the Eye button.");

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
        basePage.waitForElementToBeVisible(otpPopUpMsg);
        if(otpPopUpMsg.isDisplayed()) {
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
        if(loginPopUpMsg.isDisplayed()) {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified the Login Pop Up message is displayed.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified the Login Pop Up message isn't displayed.");
        }

        //Home page
        basePage.waitForElementToBeVisible(homePage);
        if(homePage.isDisplayed()){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After login the user is on the Home Page.");
        }else{
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After login the user isn't on the Home Page.");
        }

        return isTrue;
    }
}
