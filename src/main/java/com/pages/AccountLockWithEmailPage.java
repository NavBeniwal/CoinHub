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
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class AccountLockWithEmailPage {
    WebDriver driver;
    BasePage basePage;

    public AccountLockWithEmailPage(WebDriver driver){
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
    @FindBy(xpath = "//div[@class='ant-message-notice-content']")
    private WebElement invalidCredentialsErrorPopUpMsg;
    @FindBy(xpath = "//span[text()='Your account is locked due to multiple failed login attempts']")
    private WebElement accountLockPopUpMsg;

    public boolean validateInvalidCredentialsMessage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String email = PropertyReaderOptimized.getKeyValue("lockAccountEmail");
        String password = PropertyReaderOptimized.getKeyValue("lockAccountPassword");

        //Click on the login button
        basePage.waitForElementToBeVisible(loginBtn);
        basePage.click(loginBtn);
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

        //Click on the continue button
        basePage.waitForElementToBeVisible(continueButton);
        for (int i = 0; i < 4; i++) {
            basePage.threadSleep();
            basePage.click(continueButton);
            test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Continue button.");

            //Invalid credentials error pop-up message
            basePage.waitForElementToBeVisible(invalidCredentialsErrorPopUpMsg);
            if (invalidCredentialsErrorPopUpMsg.isDisplayed()) {
                isTrue = true;
                test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Invalid credentials pop-up message is displayed.");
            } else {
                isTrue = false;
                test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Invalid credentials pop-up message isn't displayed");
            }
        }

        return isTrue;
    }

    public boolean validateAccountLock(String accountLock,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        basePage.threadSleep();
        basePage.click(continueButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Continue button.");

        //Account lock pop-up message
        basePage.waitForElementToBeVisible(accountLockPopUpMsg);
        String accountLockMessage=accountLockPopUpMsg.getText();
        if(accountLockMessage.equals(accountLock)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Your account is locked due to multiple failed login attempts pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Your account is locked due to multiple failed login attempts pop-up message isn't matched");
        }

        return isTrue;
    }
}
