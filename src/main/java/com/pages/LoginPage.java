package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage {

    private WebDriver driver;
    private BasePage basePage;

    // Locators
    private final By languageIcon = By.xpath("//img[@alt='Language']");
    private final By englishLanguageOption = By.xpath("//ul/li[contains(text(),'English')]");
    private final By loginButton = By.xpath("//button[@type='button']");
    private final By emailField = By.name("email");
    private final By passwordField = By.xpath("//input[@type='password']");
    private final By continueBtn = By.xpath("//button[@type='submit']");
    private final By getCodeButton = By.xpath("//p[text()='Get Code']");
    private final By otpField = By.name("otp");
    private final By verifyButton = By.xpath("//span[text()='Continue']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.basePage = new BasePage(driver);
        PageFactory.initElements(driver, this);
    }

    private void clickAndLog(By locator, ExtentTest test, String message) throws IOException {
        basePage.waitForElementToBeClickable(locator);
        basePage.click(locator);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), message);
    }

    private void enterTextAndLog(By locator, String text, ExtentTest test, String message) throws IOException {
        basePage.waitForElementToBeVisible(locator);
        basePage.enterText(locator, text);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), message);
    }

    public boolean validateLoginPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isLoginSuccessful = false;

        Thread.sleep(2000);
        String email = PropertyReaderOptimized.getKeyValue("loginEmail");
        String password = PropertyReaderOptimized.getKeyValue("loginPassword");

        // Language selection
        clickAndLog(languageIcon, test, "Clicked on language icon");
        clickAndLog(englishLanguageOption, test, "Selected English language");

        // Login process
        clickAndLog(loginButton, test, "Clicked on Login button");
        enterTextAndLog(emailField, email, test, "Entered email");
        enterTextAndLog(passwordField, password, test, "Entered password");
        clickAndLog(continueBtn, test, "Clicked on Continue button");

        // Get OTP
        basePage.waitForElementToBeClickable(getCodeButton);
        basePage.click(getCodeButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clicked on Get Code button");

        // For now, directly entering a mock OTP
        Thread.sleep(2000);
        enterTextAndLog(otpField, "12345", test, "Entered OTP");

        // Final Continue (Verification)
        clickAndLog(verifyButton, test, "Clicked on Verify button");

        isLoginSuccessful = true;
        return isLoginSuccessful;
    }

}