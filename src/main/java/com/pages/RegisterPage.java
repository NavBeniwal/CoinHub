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
public class RegisterPage {
    WebDriver driver;
    BasePage basePage;

    public RegisterPage(WebDriver driver){
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
    private By yopMailLoginTextField= By.xpath("//input[@placeholder='Enter your inbox here']");
    private By goButton= By.xpath("//button[text()='GO']");
    private By arrowButton= By.xpath("//i[@class='material-icons-outlined f36']");
    private By emailVerification= By.xpath("//tr[td[@class='ng-binding']]/td[2]");
    private By confirmButton= By.xpath("//a[text()='Confirm']");
    private By iframe= By.xpath("//iframe[@id='html_msg_body']");
    private By yopMailIFrame= By.xpath("//iframe[@id='ifmail']");
    private By confirmBtn= By.xpath("//a[text()='Confirm']");
    private By emailVerifyPopUpMsg= By.xpath("//span[text()='Email Verified successfully']");
    private By checkBoxButton=By.xpath("//input[@class='ant-checkbox-input']");
    private By submitButton=By.xpath("//button[@class='scroll-to-bottom-button']");
    private By dropDownBtn= By.xpath("//div[@class='selected-flag open']");
    private By searchBox= By.xpath("//input[@class='search-box']");
    private By countryName= By.xpath("//span[text()='India']");
    private By phoneNoTextField= By.xpath("//input[@class='form-control ant-input']");
    private By sendCodeBtn= By.xpath("//span[text()='Send Code']");
    private By codeSentPopUpMsg= By.xpath("//span[text()='Code sent on phone successfully']");
    private By resendCodeBtn= By.xpath("//span[text()='Resend code']");
    private By resendCodePopUpMsg= By.xpath("//span[text()='Code resent successfully']");
    private By enterCodeTextField= By.xpath("//input[@placeholder='Enter Code']");
    private By submitBtn= By.xpath("//span[text()='Submit']");
    private By phnNoPopUpMsg= By.xpath("//span[text()='Phone number verified']");
    private By homePage= By.xpath("//h3[text()='Home']");

    public boolean validateRegisterPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;
        String email= PropertyReaderOptimized.getKeyValue("registerEmail");
        String password=PropertyReaderOptimized.getKeyValue("registerPassword");

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

        String yopMail=PropertyReaderOptimized.getKeyValue("registerYopMail");

        //Switch to the new window
        driver.switchTo().newWindow(WindowType.WINDOW).navigate().to(PropertyReaderOptimized.getKeyValue("YopMailUrl"));
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Switch to the YopMail Page.");

        //Enter the value in the email login text field
        basePage.waitForElementToBeVisible(yopMailLoginTextField);
        basePage.enterText(yopMailLoginTextField, yopMail);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Enter the value in the Email TextField.");

        //Click on the go button
        basePage.waitForElementToBeVisible(arrowButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clicked on the Arrow Button.");
        basePage.click(arrowButton);

//        //Click on the email verification link
//        basePage.threadSleep();
//        basePage.waitForElementToBeVisible(confirmButton);
//        basePage.click(confirmButton);
//        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clicked on the Confirm button.");

        //Switch to the frame
        basePage.waitForElementToBeVisible(yopMailIFrame);
        basePage.switchToFrameWebElement((WebElement) yopMailIFrame);

        //Click on the confirm button
        basePage.waitForElementToBeVisible(confirmBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the confirm button.");
        basePage.click(confirmBtn);

//        //Switch the window
//        Thread.sleep(2000);
//        basePage.switchToWindow();

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

    public boolean validateCodeSentOnPhone(String codeSentMessage,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String country = PropertyReaderOptimized.getKeyValue("registerCountry");
        String phoneNumber = PropertyReaderOptimized.getKeyValue("registerPhoneNumber");

        basePage.scrollDown();

        //Click on the check-box
        basePage.waitForElementToBeVisible(checkBoxButton);
        basePage.click(checkBoxButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the check-box.");

        //Click on the submit button
        basePage.waitForElementToBeVisible(submitButton);
        basePage.click(submitButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the submit button.");

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
        String codeSentOnPhoneMessage = basePage.doGetElementText(codeSentPopUpMsg);
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
        String codeResent=basePage.doGetElementText(resendCodePopUpMsg);
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
        Thread.sleep(20000);
        basePage.waitForElementToBeVisible(enterCodeTextField);
        basePage.enterText(enterCodeTextField, otp);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the enter code text field.");

        //Click on the submit button
        basePage.waitForElementToBeVisible(submitBtn);
        basePage.click(submitBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the submit button.");

        //Phone number pop-up message
        basePage.waitForElementToBeVisible(phnNoPopUpMsg);
        String phoneNumber = basePage.doGetElementText(phnNoPopUpMsg);
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
        if(basePage.checkElementIsDisplayed(homePage)){
            isTrue=false;
            test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified after register the user is on the dashboard page.");
        }else {
            isTrue=false;
            test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified after register the user isn't on the dashboard page.");
        }

        return isTrue;
    }
}
