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
public class RegisterPage {
    WebDriver driver;
    BasePage basePage;

    public RegisterPage(WebDriver driver){
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
    private WebElement codeSentPopUpMsg;
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

    public boolean validateSignUpPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String email= PropertyReaderOptimized.getKeyValue("registerEmail");
        String password=PropertyReaderOptimized.getKeyValue("registerPassword");

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

        String mailinatorEmail=PropertyReaderOptimized.getKeyValue("registerMailinatorEmail");

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

    public boolean validateCodeSentOnPhone(String codeSentMessage,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String country = PropertyReaderOptimized.getKeyValue("registerCountry");
        String phoneNumber = PropertyReaderOptimized.getKeyValue("registerPhoneNumber");

        //Click on the drop-down button
        basePage.waitForElementToBeVisible(dropDownBtn);
        basePage.click(dropDownBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the drop-down button.");

        //Search box
        basePage.waitForElementToBeVisible(searchBox);
        basePage.enterText(searchBox, country);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the country name.");

        //Select country
        basePage.waitForElementToBeVisible(countryName);
        basePage.click(countryName);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the country name.");


        //Enter the value in the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.enterText(phoneNoTextField, phoneNumber);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the phone number text field.");

        //Click on the send code button
        basePage.waitForElementToBeVisible(sendCodeBtn);
        basePage.click(sendCodeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the send code button.");

        //Send code pop-up message
        basePage.waitForElementToBeVisible(codeSentPopUpMsg);
        String codeSentOnPhoneMessage = codeSentPopUpMsg.getText();
        if (codeSentOnPhoneMessage.equals(codeSentMessage)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Code sent on phone successfully pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Code sent on phone successfully pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateCodeResentOnPhone(String codeResentMessage,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Click on the resend code button
        basePage.waitForElementToBeVisible(resendCodeBtn);
        basePage.click(resendCodeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the resend code button.");

        //Resend code pop-up message
        basePage.waitForElementToBeVisible(resendCodePopUpMsg);
        String codeResent=resendCodePopUpMsg.getText();
        if (codeResent.equals(codeResentMessage)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Code resent successfully pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Code resent successfully pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateCdeResentOnPhone(String phoneNumberMessage,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String otp = PropertyReaderOptimized.getKeyValue("registerOtp");

        //Enter the value in the enter code text field
        basePage.waitForElementToBeVisible(enterCodeTextField);
        basePage.enterText(enterCodeTextField, otp);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the enter code text field.");

        //Click on the submit button
        basePage.waitForElementToBeVisible(submitBtn);
        basePage.click(submitBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the submit button.");

        //Phone number pop-up message
        basePage.waitForElementToBeVisible(phnNoPopUpMsg);
        String phoneNumber = phnNoPopUpMsg.getText();
        if (phoneNumber.equals(phoneNumberMessage)) {
            isTrue = true;
            test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Phone number verified pop-up message matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Phone number verified pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateAfterRegisterUserShouldBeOnTheDashboardPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //After register dashboard page
        basePage.threadSleep();
        if(homePage.isDisplayed()){
            isTrue=false;
            test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified after register the user is on the dashboard page.");
        }else {
            isTrue=false;
            test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified after register the user isn't on the dashboard page.");
        }

        return isTrue;
    }
}
