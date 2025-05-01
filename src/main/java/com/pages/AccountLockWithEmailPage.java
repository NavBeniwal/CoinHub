package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class AccountLockWithEmailPage {
    WebDriver driver;
    BasePage basePage;

    public AccountLockWithEmailPage(WebDriver driver){
        this.driver=driver;
        basePage=new BasePage(driver);
    }
    private By image= By.xpath("//img[@alt='Language']");
    private By liEnglish= By.xpath("/html/body/div[1]/div/header/div/div/div/div[4]/div/div/div/ul/li[1]");
    private By loginBtn= By.xpath("//button[@title='Log In']");
    private By emailTextField= By.xpath("//input[@name='email']");
    private By passwordTextField= By.xpath("//input[@type='password']");
    private By eyeBtn= By.xpath("//span[@class='ant-input-suffix']");
    private By continueButton= By.xpath("//span[text()='Continue']");
    private By invalidCredentialsErrorPopUpMsg= By.xpath("//div[@class='ant-message-notice-content']");
    private By accountLockPopUpMsg= By.xpath("//span[text()='Your account is locked due to multiple failed login attempts']");//    @FindBy(xpath = "//img[@alt='Language']")

    public boolean validateInvalidCredentialsMessage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String email = PropertyReaderOptimized.getKeyValue("lockAccountEmail");
        String password = PropertyReaderOptimized.getKeyValue("lockAccountPassword");

        //Click on the image button
        basePage.waitForElementToBeVisible(image);
        basePage.click(image);

        //Click on the language
        basePage.waitForElementToBeVisible(liEnglish);
        basePage.click(liEnglish);

        //Click on the login button
        basePage.waitForElementToBeVisible(loginBtn);
        basePage.click(loginBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Login button.");

        //Enter the value in the email text field
        basePage.enterText(emailTextField, email);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the Email text field.");

        //Enter the value in the password text field
        basePage.enterText(passwordTextField, password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the Password text field.");

        //Click on the eye button
        basePage.click(eyeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Eye button.");

        //Click on the continue button
        basePage.waitForElementToBeVisible(continueButton);
        for (int i = 0; i < 4; i++) {
            basePage.waitForElementToBeVisible(continueButton);
            basePage.click(continueButton);
            test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Continue button.");

            //Invalid credentials error pop-up message
            if (basePage.checkElementIsDisplayed(invalidCredentialsErrorPopUpMsg)) {
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

        //basePage.threadSleep();
        basePage.waitForElementToBeVisible(continueButton);
        basePage.click(continueButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Continue button.");

        //Account lock pop-up message
        basePage.waitForElementToBeVisible(image);
        String accountLockMessage=basePage.doGetElementText(accountLockPopUpMsg);
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
