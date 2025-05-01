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

public class LoginChangePasswordPage {
    private WebDriver driver;
    private BasePage basePage;

    // Constants
    private static final String OTP = "12345";

    // Locators
    private By image = By.xpath("//img[@alt='Language']");
    private By liEnglish = By.xpath("/html/body/div[1]/div/header/div/div/div/div[4]/div/div/div/ul/li[1]");
    private By loginBtn = By.xpath("//button[@type='button']");
    private By emailTextField = By.xpath("//input[@name='email']");
    private By passwordTextField = By.xpath("//input[@type='password']");
    private By eyeBtn = By.xpath("//span[@class='ant-input-suffix']");
    private By continueButton = By.xpath("//button[@type='submit']");
    private By getCodeBtn = By.xpath("//p[text()='Get Code']");
    private By otpSentPopUpMsg = By.xpath("//div[@class='ant-message-notice-content']");
    private By codeTextField = By.xpath("//input[@name='otp']");
    private By continueBtn = By.xpath("//span[text()='Continue']");
    private By loginPopUpMsg = By.xpath("//div[@class='ant-message-notice-content']");
    private By dashboardPage = By.xpath("//h3[text()='Home']");

    // Constructor
    public LoginChangePasswordPage(WebDriver driver) {
        this.driver = driver;
        this.basePage = new BasePage(driver);
    }

    // Helper method to log actions
    private void logAction(String message, ExtentTest test) throws IOException {
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), message);
    }

    // Method to validate OTP sent pop-up message
    public boolean validateLoginWithEmailPageOTPSentPopUpMsg(String OTP, ExtentTest test) throws IOException, InterruptedException {
        boolean isSuccess = false;
        String email = PropertyReaderOptimized.getKeyValue("changePasswordEmail");
        String password = PropertyReaderOptimized.getKeyValue("changePassword");

        // Perform actions in sequence with proper waits and logs
        basePage.waitForElementToBeVisible(image);
        basePage.click(image);
        logAction("Verified clicked on the Language image.", test);

        basePage.waitForElementToBeVisible(liEnglish);
        basePage.click(liEnglish);
        logAction("Verified clicked on the English language.", test);

        basePage.waitForElementToBeVisible(loginBtn);
        basePage.click(loginBtn);
        logAction("Verified clicked on the Login button.", test);

        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField, email);
        logAction("Verified entered the value in the Email text field.", test);

        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField, password);
        logAction("Verified entered the value in the Password text field.", test);

        basePage.waitForElementToBeVisible(eyeBtn);
        basePage.click(eyeBtn);
        logAction("Verified clicked on the Eye button.", test);

        basePage.waitForElementToBeVisible(continueButton);
        basePage.click(continueButton);
        logAction("Verified clicked on the Continue button.", test);

        Thread.sleep(2000);
        basePage.waitForElementToBeVisible(getCodeBtn);
        basePage.click(getCodeBtn);
        logAction("Verified clicked on the Get Code button.", test);

        basePage.waitForElementToBeVisible(otpSentPopUpMsg);
        String otpMessage = basePage.doGetElementText(otpSentPopUpMsg);
        if (otpMessage.equals(OTP)) {
            isSuccess = true;
            logAction("Verified OTP sent successfully, pop-up message matched.", test);
        } else {
            isSuccess = false;
            logAction("Verified OTP sent successfully, pop-up message did not match.", test);
        }

        return isSuccess;
    }

    // Method to validate successful login pop-up message
    public boolean validateLoginWithEmailPageLoginSuccessfullyPopUpMsg(String loginMessage, ExtentTest test) throws IOException, InterruptedException {
        boolean isSuccess = false;

        Thread.sleep(2000);
        basePage.waitForElementToBeVisible(codeTextField);
        basePage.enterText(codeTextField, OTP);
        logAction("Verified entered OTP in the Code text field.", test);

        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueBtn);
        logAction("Verified clicked on the Continue button.", test);

        basePage.waitForElementToBeVisible(loginPopUpMsg);
        String loginSuccessfullyMessage = basePage.doGetElementText(loginPopUpMsg);
        if (loginSuccessfullyMessage.equals(loginMessage)) {
            isSuccess = true;
            logAction("Verified Login pop-up message matched.", test);
        } else {
            isSuccess = false;
            logAction("Verified Login pop-up message did not match.", test);
        }

        return isSuccess;
    }

    // Method to validate user is redirected to the dashboard page after login
    public boolean validateAfterLoginUserShouldBeOnTheDashboardPage(ExtentTest test) throws IOException {
        boolean isSuccess = false;

        if (basePage.checkElementIsDisplayed(dashboardPage)) {
            isSuccess = true;
            logAction("Verified after login, the user is on the dashboard page.", test);
        } else {
            isSuccess = false;
            logAction("Verified after login, the user is not on the dashboard page.", test);
        }

        return isSuccess;
    }
}