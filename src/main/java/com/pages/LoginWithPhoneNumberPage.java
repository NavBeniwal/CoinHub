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

public class LoginWithPhoneNumberPage {
    WebDriver driver;
    BasePage basePage;

    public LoginWithPhoneNumberPage(WebDriver driver){
        this.driver=driver;
        basePage=new BasePage(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@title='Log In']")
    private WebElement loginBtn;
    @FindBy(xpath = "//div[@id='rc-tabs-0-tab-phone']")
    private WebElement phoneNumberBtn;
    @FindBy(xpath = "//div[@class='flag mn']")
    private WebElement dropDownBtn;
    @FindBy(xpath = "//input[@class='search-box']")
    private WebElement searchBox;
    @FindBy(xpath = "//span[text()='India']")
    private WebElement countryName;
    @FindBy(xpath = "//input[@class='form-control ant-input']")
    private WebElement phoneNoTextField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordTextField;
    @FindBy(xpath = "//span[@class='ant-input-suffix']")
    private WebElement eyeBtn;
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

    public boolean validateCodeSentOnPhoneMessage(String OTP,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String country = PropertyReaderOptimized.getKeyValue("loginCountry");
        String loginPhoneNumber = PropertyReaderOptimized.getKeyValue("loginPhoneNumber");
        String password = PropertyReaderOptimized.getKeyValue("loginPassword");

        //Click on the login button
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(loginBtn);
        basePage.click(loginBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Login button.");

        //Click on the phone number button
        basePage.waitForElementToBeVisible(phoneNumberBtn);
        basePage.click(phoneNumberBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the phone number button.");

        //Click on the drop-down button
        basePage.waitForElementToBeVisible(dropDownBtn);
        basePage.click(dropDownBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the drop-down button.");

        //Search box
        basePage.waitForElementToBeVisible(searchBox);
        basePage.enterText(searchBox, country);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the search box text field.");

        //Select country
        basePage.waitForElementToBeVisible(countryName);
        basePage.click(countryName);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the country name.");

        //Enter the value in the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.enterText(phoneNoTextField, loginPhoneNumber);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the phone number text field.");

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
        basePage.waitForElementToBeVisible(otpPopUpMsg);
        String otpMessage = otpPopUpMsg.getText();
        if (otpMessage.equals(OTP)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified OTP sent successfully pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified OTP sent successfully pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateLoginMessage(String loginMessage,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //String OTP = PropertyReaderOptimized.getKeyValue("loginOTP");
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
        basePage.threadSleep();
        basePage.enterText(codeTextField, OTP);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the Code text field.");

        //Click on the verify button
        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Continue button.");

        //Login pop up message
        basePage.waitForElementToBeVisible(loginPopUpMsg);
        String login = loginPopUpMsg.getText();
        if (login.equals(loginMessage)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Login Successfully pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Login Successfully pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateAfterRegisterUserShouldBeOnTheDashboardPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Home page
        basePage.waitForElementToBeVisible(dashboardPage);
        if(dashboardPage.isDisplayed()){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After login the user is on the dashboard page.");
        }else{
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"After login the user isn't on the dashboard page.");
        }

        return isTrue;
    }
}
