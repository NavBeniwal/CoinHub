package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.io.IOException;
import java.sql.SQLOutput;

public class LoginWithEmailPage {
    private WebDriver driver;
    private BasePage basePage;

    // Element Locators
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
    private By dashboardPage = By.xpath("//div[@class='style_logoMob__DPUZa']");
    private By profileIcon = By.xpath("(//span[@class='ant-avatar-string'])[1]");
    private By signOut = By.xpath("//a[text()='Sign Out']");
    private By signOutPopUpMsg = By.xpath("//span[text()='Logged Out Successfully']");
    private By homePage = By.xpath("//div[@class='ant-col style_euroMultiCurrency__Everything__left__-MP+3 ant-col-lg-12']");

    public LoginWithEmailPage(WebDriver driver) {
        this.driver = driver;
        this.basePage = new BasePage(driver);
    }

    private void clickAndLog(By locator,String message,ExtentTest test) throws IOException {
        basePage.waitForElementToBeClickable(locator);
        basePage.click(locator);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),message);
    }

    private void enterTextAndLog(By locator,String text,String message,ExtentTest test) throws IOException, IOException {
        basePage.waitForElementToBeVisible(locator);
        basePage.enterText(locator,text);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),message);
    }

    public boolean validateLoginWithEmailPageOTPSentPopUpMsg(String OTP, ExtentTest test) throws IOException, InterruptedException {
        String email = PropertyReaderOptimized.getKeyValue("loginEmail");
        String password = PropertyReaderOptimized.getKeyValue("loginPassword");

        // Language Selection
        clickAndLog(image, "Clicked on the language image", test);
        clickAndLog(liEnglish, "Selected English language", test);

        // Login Steps
        clickAndLog(loginBtn, "Clicked on the Login button", test);
        enterTextAndLog(emailTextField, email, "Entered email in the email field", test);
        enterTextAndLog(passwordTextField, password, "Entered password in the password field", test);
        clickAndLog(eyeBtn, "Clicked on the eye button", test);
        clickAndLog(continueButton, "Clicked on the Continue button", test);

        // OTP Request
        clickAndLog(getCodeBtn, "Clicked on the Get Code button", test);

        // Validate OTP Sent Popup
        basePage.waitForElementToBeVisible(otpSentPopUpMsg);
        String otpMessage = basePage.doGetElementText(otpSentPopUpMsg);
        boolean isSuccess = otpMessage.equals(OTP);
        String status = isSuccess ? "matched" : "not matched";
        test.log(isSuccess ? LogStatus.PASS : LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "OTP Sent Popup message is " + status);

        return isSuccess;
    }

    public boolean validateLoginWithEmailPageLoginSuccessfullyPopUpMsg(String loginMessage, ExtentTest test) throws IOException, InterruptedException {
        // Enter OTP
        enterTextAndLog(codeTextField, "12345", "Entered OTP in the Code field", test);
        clickAndLog(continueBtn, "Clicked on the Continue button", test);

        // Validate Login Success Popup
        Thread.sleep(2000);
        basePage.waitForElementToBeVisible(loginPopUpMsg);
        String loginMessageText = basePage.doGetElementText(loginPopUpMsg);
        boolean isLoginSuccessful = loginMessageText.equals(loginMessage);
        String status = isLoginSuccessful ? "matched" : "not matched";
        test.log(isLoginSuccessful ? LogStatus.PASS : LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Login Success Popup message is " + status);
        System.out.println(loginMessage);
        System.out.println(loginPopUpMsg);

        return isLoginSuccessful;
    }

    public boolean validateAfterLoginUserShouldBeOnTheDashboardPage(ExtentTest test) throws IOException {
        basePage.waitForElementToBeVisible(dashboardPage);
        boolean isOnDashboard = basePage.checkElementIsDisplayed(dashboardPage);
        test.log(isOnDashboard ? LogStatus.PASS : LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)),
                "User is " + (isOnDashboard ? "on" : "not on") + " the dashboard page.");
        return isOnDashboard;
    }

    public boolean validateSignOutPage(String logoutMessage, ExtentTest test) throws IOException {
        // Sign Out Process
        clickAndLog(profileIcon, "Clicked on the profile icon", test);
        clickAndLog(signOut, "Clicked on the Sign Out button", test);

        // Validate Sign Out Popup
        basePage.waitForElementToBeVisible(signOutPopUpMsg);
        String signOutMessage = basePage.doGetElementText(signOutPopUpMsg);
        boolean isLoggedOut = signOutMessage.equals(logoutMessage);
        test.log(isLoggedOut ? LogStatus.PASS : LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)),
                "Logout message is " + (isLoggedOut ? "matched" : "not matched"));

        return isLoggedOut;
    }

    public boolean validateAfterSignOutUserShouldBeOnTheHomePage(ExtentTest test) throws IOException {
        basePage.waitForElementToBeVisible(homePage);
        boolean isOnHomePage = basePage.checkElementIsDisplayed(homePage);
        test.log(isOnHomePage ? LogStatus.PASS : LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)),
                "User is " + (isOnHomePage ? "on" : "not on") + " the home page.");
        return isOnHomePage;
    }
}
