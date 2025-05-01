package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ForgotPasswordPage {
    private WebDriver driver;
    private BasePage basePage;

    // Locators
    private final By image = By.xpath("//img[@alt='Language']");
    private final By liEnglish = By.xpath("/html/body/div[1]/div/header/div/div/div/div[4]/div/div/div/ul/li[1]");
    private final By loginBtn = By.xpath("//button[@title='Log In']");
    private final By forgotPasswordBtn = By.xpath("//a[text()='Forgot password ?']");
    private final By emailTextField = By.xpath("//input[@name='email']");
    private final By resetPasswordBtn = By.xpath("//span[text()='Reset Password']");
    private final By emailSentPopUpMsg = By.xpath("//span[text()='Email sent successfully']");
    private final By mailinatorLoginTextField = By.xpath("//input[@id='search']");
    private final By goButton = By.xpath("//button[text()='GO']");
    private final By emailVerification = By.xpath("//tr[td[@class='ng-binding']]/td[2]");
    private final By iframe = By.xpath("//iframe[@id='html_msg_body']");
    private final By resetBtn = By.xpath("//a[text()='Reset']");
    private final By updateBtn = By.xpath("//span[text()='Update']");
    private final By newPasswordTextField = By.xpath("(//input[@type='password'])[1]");
    private final By confirmPasswordTextField = By.xpath("(//input[@type='password'])[2]");
    private final By passwordChangePopUpMsg = By.xpath("//span[text()='Password changed successfully']");
    private final By signInPage = By.xpath("//h2[text()='Sign in to Coinhub']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.basePage = new BasePage(driver);
    }

    /**
     * Validates the email sent message during forgot password flow.
     */
    public boolean validateForgotPasswordEmailSentMsg(String emailMessage, ExtentTest test) throws IOException {
        String email = PropertyReaderOptimized.getKeyValue("forgotPasswordEmail");

        clickAndLog(image, "Language Image", test);
        clickAndLog(liEnglish, "English Language", test);
        clickAndLog(loginBtn, "Login Button", test);
        clickAndLog(forgotPasswordBtn, "Forgot Password Button", test);

        enterValueAndLog(emailTextField, email, "Email Field", test);
        clickAndLog(resetPasswordBtn, "Reset Password Button", test);

        // Validate email sent popup message
        String emailSentMessage = basePage.doGetElementText(emailSentPopUpMsg);
        return logValidationResult(emailSentMessage.equals(emailMessage), "Email sent successfully pop-up message", test);
    }

    /**
     * Validates the password change process during forgot password flow.
     */
    public boolean validateForgotPasswordPasswordChange(String passwordChangeMessage, ExtentTest test) throws IOException {
        String mailinatorEmail = PropertyReaderOptimized.getKeyValue("forgotPasswordMailinatorEmail");
        String newPassword = PropertyReaderOptimized.getKeyValue("forgotNewPassword");
        String confirmPassword = PropertyReaderOptimized.getKeyValue("forgotConfirmPassword");

        driver.switchTo().newWindow(WindowType.WINDOW).navigate().to(PropertyReaderOptimized.getKeyValue("mailinatorUrl"));
        test.log(LogStatus.INFO, "Switched to Mailinator Page.");

        enterValueAndLog(mailinatorLoginTextField, mailinatorEmail, "Mailinator Email Field", test);
        clickAndLog(goButton, "Go Button", test);
        clickAndLog(emailVerification, "Email Verification Link", test);

        // Locate and switch to iframe
        WebElement iframeElement = driver.findElement(iframe);
        basePage.switchToFrameWebElement(iframeElement);
        clickAndLog(resetBtn, "Reset Button", test);

        // Switch back to main window
        basePage.switchToWindow();

        enterValueAndLog(newPasswordTextField, newPassword, "New Password Field", test);
        enterValueAndLog(confirmPasswordTextField, confirmPassword, "Confirm Password Field", test);
        clickAndLog(updateBtn, "Update Button", test);

        // Validate password change popup message
        String passwordChange = basePage.doGetElementText(passwordChangePopUpMsg);
        return logValidationResult(passwordChange.equals(passwordChangeMessage), "Password changed successfully pop-up message", test);
    }

    /**
     * Validates if the user is redirected to the Sign In page after Forgot Password flow.
     */
    public boolean validateAfterForgetPasswordUserShouldBeOnRegisterPage(ExtentTest test) throws IOException {
        return logValidationResult(basePage.checkElementIsDisplayed(signInPage), "Sign In to Coinhub page", test);
    }

    /**
     * Clears a field value, logs the action, and captures a screenshot.
     */

    /**
     * Clicks on an element, logs the action, and captures a screenshot.
     */
    private void clickAndLog(By locator, String elementName, ExtentTest test) throws IOException {
        basePage.waitForElementToBeVisible(locator);
        basePage.click(locator);
        test.log(LogStatus.INFO, "Clicked on " + elementName + ".", test.addScreenCapture(BasePage.getScreenCapture(driver)));
    }

    /**
     * Enters a value into a field, logs the action, and captures a screenshot.
     */
    private void enterValueAndLog(By locator, String value, String elementName, ExtentTest test) throws IOException {
        basePage.waitForElementToBeVisible(locator);
        basePage.enterText(locator, value);
        test.log(LogStatus.INFO, "Entered value into " + elementName + ".", test.addScreenCapture(BasePage.getScreenCapture(driver)));
    }

    /**
     * Logs validation results and captures a screenshot.
     */
    private boolean logValidationResult(boolean condition, String validationMessage, ExtentTest test) throws IOException {
        if (condition) {
            test.log(LogStatus.PASS, validationMessage + " is matched.", test.addScreenCapture(BasePage.getScreenCapture(driver)));
        } else {
            test.log(LogStatus.FAIL, validationMessage + " is not matched.", test.addScreenCapture(BasePage.getScreenCapture(driver)));
        }
        return condition;
    }
}