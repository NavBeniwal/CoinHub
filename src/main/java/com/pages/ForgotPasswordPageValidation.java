package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ForgotPasswordPageValidation {
    WebDriver driver;
    BasePage basePage;

    public ForgotPasswordPageValidation(WebDriver driver){
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
    @FindBy(xpath = "//span[text()='Email is required']")
    private WebElement emailRequiredValidationMsg;
    @FindBy(xpath = "//span[text()='Please enter valid email']")
    private WebElement enterValidEmailValiationMsg;
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
    @FindBy(xpath = "(//span[@class='ant-input-suffix'])[1]")
    private WebElement newPasswordTextFieldEyeIcon;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPasswordTextField;
    @FindBy(xpath = "(//span[@class='ant-input-suffix'])[2]")
    private WebElement confirmPasswordTextFieldEyeIcon;
    @FindBy(xpath = "//span[text()='Please enter new password']")
    private WebElement enterNewPasswordValidationMsg;
    @FindBy(xpath = "//span[contains(text(),'Password must be')]")
    private WebElement passwordMustContainsValidationMsg;
    @FindBy(xpath = "//span[text()='Please enter confirm password']")
    private WebElement enterConfirmPasswordValidationMsg;
    @FindBy(xpath = "//span[text()='Confirm password should be same']")
    private WebElement confirmPasswordShouldBeSameValidationMsg;

    public boolean validateEmailRequiredValidation(String email,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        //Click on the login button
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(loginBtn);
        basePage.click(loginBtn);
        basePage.threadSleep();
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Login button.");


        //Click on the forgot password button
        basePage.waitForElementToBeVisible(forgotPasswordBtn);
        basePage.click(forgotPasswordBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the forgot password button.");

        //Click on the reset password button
        basePage.waitForElementToBeVisible(resetPasswordBtn);
        basePage.click(resetPasswordBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the reset password button.");

        //Email required validation message
        basePage.waitForElementToBeVisible(emailRequiredValidationMsg);
        String emailValidation=emailRequiredValidationMsg.getText();
        if(emailValidation.equals(email)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified email is required validation message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified email is required validation message isn't displayed.");
        }

        return isTrue;
    }
    public boolean validateForgotPasswordPageEmailTextFieldWithInvalidEmailAddress(String invalidEmailAddress,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField, "aabb");
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the email text field.");

        //Validation message
        basePage.waitForElementToBeVisible(enterValidEmailValiationMsg);
        String invalidEmailValidation = enterValidEmailValiationMsg.getText();
        if (invalidEmailValidation.equals(invalidEmailAddress)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateMailinatorPage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        String mailinatorEmail = PropertyReaderOptimized.getKeyValue("forgotPasswordMailinatorEmail");
        String forgotPasswordEmail=PropertyReaderOptimized.getKeyValue("forgotPasswordEmail");

        //Clear the value in the email name text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.clearValue(emailTextField);

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,forgotPasswordEmail);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the email text field.");

        //Click on the reset password button
        basePage.waitForElementToBeVisible(resetPasswordBtn);
        basePage.click(resetPasswordBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the reset password button.");

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
        basePage.click(emailVerification);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clicked on the Email Verification Link.");

        //Switch to the frame
        basePage.waitForElementToBeVisible(iframe);
        basePage.switchToFrameWebElement(iframe);

        //Click on the reset button
        basePage.waitForElementToBeVisible(resetBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the reset button.");
        basePage.click(resetBtn);

        //Switch the window
        Thread.sleep(2000);
        basePage.switchToWindow();

        return isTrue;
    }

    public boolean validateEnterNewPasswordValidation(String newPassword,ExtentTest test) throws IOException {
        boolean isTrue = false;

        //Click on the update button
        basePage.waitForElementToBeVisible(updateBtn);
        basePage.click(updateBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the update button.");

        //Enter password validation message
        basePage.waitForElementToBeVisible(enterNewPasswordValidationMsg);
        String newPasswordValidation=enterNewPasswordValidationMsg.getText();
        if (newPasswordValidation.equals(newPassword)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter new password validation message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter new password validation message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateEnterConfirmPasswordValidation(String confirmPassword,ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Enter confirm password validation message
        basePage.waitForElementToBeVisible(enterConfirmPasswordValidationMsg);
        String confirmPasswordValidation=enterConfirmPasswordValidationMsg.getText();
        if(confirmPasswordValidation.equals(confirmPassword)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please enter confirm password validation message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please enter confirm password validation message isn't matched.");
        }
        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldValidationWithLessThanEightCharacters(String passwordValidation,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String randomAlphanumeric=RandomStringUtils.randomAlphanumeric(1,4);
        String password=randomAlphanumeric+"A@";

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,"1");

        //Clear the value from the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.clearValue(newPasswordTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clear the value from the new password text field.");

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Keep the less than 8 characters in the password text field.");

        //Password must contains validation message
        basePage.waitForElementToBeVisible(passwordMustContainsValidationMsg);
        String passwordValidationMessage=passwordMustContainsValidationMsg.getText();
        if (passwordValidationMessage.equals(passwordValidation)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message isn't matched.");
            isTrue = false;
        }
        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithOnlyNumericValue(String passwordValidation,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String password=RandomStringUtils.randomNumeric(1,10);

        //Clear the value from the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.clearValue(newPasswordTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clear the value from the new password text field.");

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Keep only Numeric value in the password text field.");

        //Password must contains validation message
        basePage.waitForElementToBeVisible(passwordMustContainsValidationMsg);
        String passwordValidationMessage=passwordMustContainsValidationMsg.getText();
        if (passwordValidationMessage.equals(passwordValidation)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message isn't matched.");
            isTrue = false;
        }
        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithOnlySpecialCharacterValue(String passwordValidation,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String password="!@#$%#$@@";

        //Clear the value from the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.clearValue(newPasswordTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clear the value from the new password text field.");

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Keep only Special Character value in the password text field.");

        //Password must contains validation message
        basePage.waitForElementToBeVisible(passwordMustContainsValidationMsg);
        String passwordValidationMessage=passwordMustContainsValidationMsg.getText();
        if (passwordValidationMessage.equals(passwordValidation)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message isn't matched.");
            isTrue = false;
        }
        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithOnlyAlphabeticValue(String passwordValidation,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String password=RandomStringUtils.randomAlphabetic(1,20);

        //Clear the value from the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.clearValue(newPasswordTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Clear the value from the new password text field.");

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,password);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Keep only Alphabetic value in the password text field.");

        //Password must contains validation message
        basePage.waitForElementToBeVisible(passwordMustContainsValidationMsg);
        String passwordValidationMessage=passwordMustContainsValidationMsg.getText();
        if (passwordValidationMessage.equals(passwordValidation)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message isn't matched.");
            isTrue = false;
        }
        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithAlphaNumericValue(String passwordValidation,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String password=RandomStringUtils.randomAlphanumeric(1,20);

        //Clear the value from the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.clearValue(newPasswordTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Clear the value from the new password text field.");

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,password);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Keep Numeric and Alphabetic value in the password text field.");

        //Password must contains validation message
        basePage.waitForElementToBeVisible(passwordMustContainsValidationMsg);
        String passwordValidationMessage=passwordMustContainsValidationMsg.getText();
        if (passwordValidationMessage.equals(passwordValidation)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message isn't matched.");
            isTrue = false;
        }
        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithSpecialAndNumericValue(String passwordValidation,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String numericValue=RandomStringUtils.randomNumeric(1,10);
        String password=numericValue+"@#!$";

        //Clear the value from the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.clearValue(newPasswordTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clear the value from the new password text field.");

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Keep Special Character and Numeric value in the password text field.");

        //Password must contains validation message
        basePage.waitForElementToBeVisible(passwordMustContainsValidationMsg);
        String passwordValidationMessage=passwordMustContainsValidationMsg.getText();
        if (passwordValidationMessage.equals(passwordValidation)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message isn't matched.");
            isTrue = false;
        }
        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithSpecialAndAlphabeticValue(String passwordValidation,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String randomAlphabetic=RandomStringUtils.randomAlphabetic(1,10);
        String password=randomAlphabetic+"@#!$";

        //Clear the value from the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.clearValue(newPasswordTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clear the value from the new password text field.");

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Keep Special Character and Alphabetic value in the password text field.");

        //Password must contains validation message
        basePage.waitForElementToBeVisible(passwordMustContainsValidationMsg);
        String passwordValidationMessage=passwordMustContainsValidationMsg.getText();
        if (passwordValidationMessage.equals(passwordValidation)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message isn't matched.");
            isTrue = false;
        }
        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithoutUpperCaseValue(String passwordValidation,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String password="admin@123";

        //Clear the value from the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.clearValue(newPasswordTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clear the value from the new password text field.");

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Keep 1 Lower Case, 1 Number, 1 Special, and At least 8 Characters in the password text field.");


        //Password must contains validation message
        basePage.waitForElementToBeVisible(passwordMustContainsValidationMsg);
        String passwordValidationMessage=passwordMustContainsValidationMsg.getText();
        if (passwordValidationMessage.equals(passwordValidation)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message isn't matched.");
            isTrue = false;
        }
        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithoutLowerCaseValue(String passwordValidation,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String password="ADMIN@123";

        //Clear the value from the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.clearValue(newPasswordTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clear the value from the new password text field.");

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Keep 1 Upper Case, 1 Number, 1 Special, and At least 8 Characters in the password text field.");

        //Password must contains validation message
        basePage.waitForElementToBeVisible(passwordMustContainsValidationMsg);
        String passwordValidationMessage=passwordMustContainsValidationMsg.getText();
        if (passwordValidationMessage.equals(passwordValidation)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message isn't matched.");
            isTrue = false;
        }
        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithoutNumericValue(String passwordValidation,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String randomAlphabetic=RandomStringUtils.randomAlphabetic(1,10);
        String password=randomAlphabetic+"!@#$";

        //Clear the value from the password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.clearValue(newPasswordTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clear the value from the new password text field.");

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Keep 1 Upper Case, 1 Lower Case, 1 Special, and At least 8 Characters in the password text field.");

        //Password must contains validation message
        basePage.waitForElementToBeVisible(passwordMustContainsValidationMsg);
        String passwordValidationMessage=passwordMustContainsValidationMsg.getText();
        if (passwordValidationMessage.equals(passwordValidation)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message isn't matched.");
            isTrue = false;
        }
        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithoutSpecialCharacterValue(String passwordValidation,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String password=RandomStringUtils.randomAlphanumeric(1,15);

        //Clear the value from the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.clearValue(newPasswordTextField);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clear the value from the new password text field.");

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Keep 1 Upper Case, 1 Lower Case, 1 Number, and At least 8 Characters in the password text field.");

        //Password must contains validation message
        basePage.waitForElementToBeVisible(passwordMustContainsValidationMsg);
        String passwordValidationMessage=passwordMustContainsValidationMsg.getText();
        if (passwordValidationMessage.equals(passwordValidation)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation message isn't matched.");
            isTrue = false;
        }

        //Clear the value from the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.clearValue(newPasswordTextField);

        //Enter the value in the new password text field
        basePage.waitForElementToBeVisible(newPasswordTextField);
        basePage.enterText(newPasswordTextField,"Test@123");

        return isTrue;
    }

    public boolean validateConfirmPasswordShouldBeSameValidationMsg(String confirmPasswordValidation,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        //Enter the value in the confirm-password text field
        basePage.waitForElementToBeVisible(confirmPasswordTextField);
        basePage.enterText(confirmPasswordTextField,"a");

        //Click on the eye button
        basePage.waitForElementToBeVisible(confirmPasswordTextFieldEyeIcon);
        basePage.click(confirmPasswordTextFieldEyeIcon);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the confirm password eye icon.");

        //Confirm password should be same validation message
        basePage.waitForElementToBeVisible(confirmPasswordShouldBeSameValidationMsg);
        String confirmPasswordValidationMessage=confirmPasswordShouldBeSameValidationMsg.getText();
        if(confirmPasswordValidationMessage.equals(confirmPasswordValidation)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Confirm password should be same validation message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Confirm password should be same validation message isn't matched.");
        }
        return isTrue;
    }
}
