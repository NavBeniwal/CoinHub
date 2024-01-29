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

public class LoginChangePasswordPage {
    WebDriver driver;
    BasePage basePage;

    public LoginChangePasswordPage(WebDriver driver){
        this.driver=driver;
        basePage=new BasePage(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@title='Log In']")
    private WebElement loginBtn;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailTextField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordTextField;
    @FindBy(xpath = "//span[@class='ant-input-suffix']")
    private WebElement eyeBtn;
    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//p[text()='Get Code']")
    private WebElement getCodeBtn;
    @FindBy(xpath = "//div[@class='ant-message-notice-content']")
    private WebElement otpSentPopUpMsg;
    @FindBy(xpath = "//div[@class='ant-message-notice-content']")
    private WebElement otpPopUpMsg;
    @FindBy(xpath = "//input[@name='otp']")
    private WebElement codeTextField;
    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueBtn;
    @FindBy(xpath = "//div[@class='ant-message-notice-content']")
    private WebElement loginPopUpMsg;
    @FindBy(xpath = "//h3[text()='Home']")
    private WebElement dashboardPage;
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
    public boolean validateLoginWithEmailPageOTPSentPopUpMsg(String OTP,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String email = PropertyReaderOptimized.getKeyValue("changePasswordEmail");
        String password = PropertyReaderOptimized.getKeyValue("changePassword");

        //Click on the login button
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(loginBtn);
        basePage.click(loginBtn);
        basePage.threadSleep();
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Login button.");

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
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Eye button.");

        //Click on the login button
        basePage.waitForElementToBeVisible(continueButton);
        basePage.click(continueButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Continue button.");

        //Click on the get OTP button
        basePage.waitForElementToBeVisible(getCodeBtn);
        basePage.click(getCodeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Get Code button.");

        //OTP pop up message
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(otpSentPopUpMsg);
        String otpMessage = otpSentPopUpMsg.getText();
        if (otpMessage.equals(OTP)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified OTP sent successfully pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified OTP sent successfully pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateLoginWithEmailPageLoginSuccessfullyPopUpMsg(String loginMessage,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String mailinatorEmail = PropertyReaderOptimized.getKeyValue("loginMailinatorEmail");

        //Get current window id
        String windowId = basePage.getCurrentWindowId();
        Thread.sleep(2000);

        //Switch to the mailinator page
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

        //Enter the value in the OTP text field
        basePage.waitForElementToBeVisible(codeTextField);
        basePage.enterText(codeTextField, OTP);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the Code text field.");

        //Click on the verify button
        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Continue button.");

        //Login pop up message
        basePage.threadSleep();
        String loginSuccessfullyMessage = loginPopUpMsg.getText();
        if (loginSuccessfullyMessage.equals(loginMessage)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified the Login pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified the Login pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateAfterLoginUserShouldBeOnTheDashboardPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Dashboard page
        basePage.threadSleep();
        if(dashboardPage.isDisplayed()){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified after login the user is on the dashboard page.");
        }else{
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified after login the user isn't on the dashboard page.");
        }

        return isTrue;
    }
}
