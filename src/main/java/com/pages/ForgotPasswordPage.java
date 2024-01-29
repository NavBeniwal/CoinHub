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

public class ForgotPasswordPage {
    WebDriver driver;
    BasePage basePage;

    public ForgotPasswordPage(WebDriver driver){
        this.driver=driver;
        basePage=new BasePage(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@title='Log In']")
    private WebElement loginBtn;
    @FindBy(xpath = "//a[text()='Forgot password?']")
    private WebElement forgotPasswordBtn;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailTextField;
    @FindBy(xpath = "//span[text()='Reset Password']")
    private WebElement resetPasswordBtn;
    @FindBy(xpath = "//span[text()='Email sent successfully']")
    private WebElement emailSentPopUpMsg;
    @FindBy(xpath = "//input[@id='search']")
    private WebElement mailinatorLoginTextField;
    @FindBy(xpath = "//button[text()='GO']")
    private WebElement goButton;
    @FindBy(xpath = "//tr[td[@class='ng-binding']]/td[2]")
    private WebElement emailVerification;
    @FindBy(xpath = "//iframe[@id='html_msg_body']")
    private WebElement iframe;
    @FindBy(xpath = "//a[text()='Reset']")
    private WebElement resetBtn;
    @FindBy(xpath = "//span[text()='Update']")
    private WebElement updateBtn;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement newPasswordTextField;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPasswordTextField;
    @FindBy(xpath = "//span[text()='Password changed successfully']")
    private WebElement passwordChangePopUpMsg;
    @FindBy(xpath = "//h2[text()='Sign in to Coinhub']")
    private WebElement signInPage;

    public boolean validateForgotPasswordEmailSentMsg(String emailMessage,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String email = PropertyReaderOptimized.getKeyValue("forgotPasswordEmail");

        //Click on the login button
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(loginBtn);
        basePage.click(loginBtn);
        basePage.threadSleep();
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Login button.");

        //Click on the forgot password button
        basePage.waitForElementToBeVisible(forgotPasswordBtn);
        basePage.click(forgotPasswordBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the forgot password button.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField, email);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the email text field.");

        //Click on the reset password button
        basePage.waitForElementToBeVisible(resetPasswordBtn);
        basePage.click(resetPasswordBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the reset password button.");

        //Email sent pop-up message
        basePage.waitForElementToBeVisible(emailSentPopUpMsg);
        String emailSentMessage = emailSentPopUpMsg.getText();
        if (emailSentMessage.equals(emailMessage)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Email sent successfully pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Email sent successfully pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateForgotPasswordPasswordChange(String passwordChangeMessage,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String mailinatorEmail = PropertyReaderOptimized.getKeyValue("forgotPasswordMailinatorEmail");
        String newPassword=PropertyReaderOptimized.getKeyValue("forgotNewPassword");
        String confirmPassword=PropertyReaderOptimized.getKeyValue("forgotConfirmPassword");

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
        if(emailVerification.isDisplayed()){
            basePage.click(emailVerification);
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clicked on the Email Verification Link.");
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified email doesn't receive.");
        }

        //Switch to the frame
        basePage.waitForElementToBeVisible(iframe);
        basePage.switchToFrameWebElement(iframe);

        //Click on the reset button
        basePage.waitForElementToBeVisible(resetBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the reset button.");
        basePage.click(resetBtn);

        //Switch the window
        Thread.sleep(2000);
        basePage.switchToWindow();

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,newPassword);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the new password text field.");

        //Enter the value in the confirm-password text field
        basePage.waitForElementToBeVisible(confirmPasswordTextField);
        basePage.enterText(confirmPasswordTextField,confirmPassword);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the confirm password text field.");

        //Click on the update button
        basePage.waitForElementToBeVisible(updateBtn);
        basePage.click(updateBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the update button.");

        //Password change pop-up message
        basePage.waitForElementToBeVisible(passwordChangePopUpMsg);
        String passwordChange=passwordChangePopUpMsg.getText();
        if (passwordChange.equals(passwordChangeMessage)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password changed successfully pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password changed successfully pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateAfterForgetPasswordUserShouldBeOnRegisterPage(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //After register sign in page
        basePage.waitForElementToBeVisible(signInPage);
        if(signInPage.isDisplayed()){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified after forgot password the user is on the sign in to coinhub page.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified after forgot password the user isn't on the sign in to coinhub page.");
        }

        return isTrue;
    }

}
