package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginWithEmailPageValidation {
    WebDriver driver;
    BasePage basePage;

    public LoginWithEmailPageValidation(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
    }
    private By image= By.xpath("//img[@alt='Language']");
    private By liEnglish= By.xpath("/html/body/div[1]/div/header/div/div/div/div[4]/div/div/div/ul/li[1]");
    private By loginBtn= By.xpath("//button[@title='Log In']");
    private By continueButton= By.xpath("//span[text()='Continue']");
    private By emailTextFieldInvalidValidation= By.xpath("//span[text()='Please enter valid email']");
    private By passwordTextFieldRequiredValidation= By.xpath("//span[text()='Password is required']");
    private By emailTextField= By.xpath("//input[@name='email']");
    private By invalidCredentialsErrorPopUpMsg= By.xpath("//div[@class='ant-message-notice-content']");
    private By passwordTextField= By.xpath("//input[@type='password']");
    private By eyeBtn= By.xpath("//span[@class='ant-input-suffix']");
    private By continueBtn= By.xpath("//span[text()='Continue']");
    private By otpRequiredValidation= By.xpath("//span[text()='OTP is required']");
    private By getCodeBtn= By.xpath("//p[text()='Get Code']");
    private By enterCodeTextField= By.xpath("//input[@name='otp']");
    private By getVerificationCodeErrorPopUpMsg= By.xpath("//span[text()='Please get a verification code first.']");
    private By maxOTPdDigitLimitValidation= By.xpath("//span[text()='Max OTP limit should be 5 digits.']");
    private By invalidOTPErrorPopUpMsg= By.xpath("//div[@class='ant-message-notice-content']");

    public boolean validateLoginEmailRequiredValidation(String email,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Click on the image button
        basePage.waitForElementToBeVisible(image);
        basePage.click(image);

        //Click on the language
        basePage.waitForElementToBeVisible(liEnglish);
        basePage.click(liEnglish);

        //Click on the login button
        basePage.threadSleep();
        basePage.click(loginBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Login button.");

        //Click on the continue
        basePage.waitForElementToBeVisible(continueButton);
        basePage.click(continueButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Clicked on the continue button.");

        //Invalid email validation
        basePage.waitForElementToBeVisible(emailTextField);
        String emailValidation = basePage.doGetElementText(emailTextField);
        if (emailValidation.equals(email)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Email is required validation matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Email is required validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateLoginPasswordRequiredValidation(String password,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        //Required password validation
        basePage.waitForElementToBeVisible(passwordTextFieldRequiredValidation);
        String passwordValidation=basePage.doGetElementText(passwordTextFieldRequiredValidation);
        if (passwordValidation.equals(password)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password is required validation is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password is required validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingSymbol(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail.com";

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressWithMissingDomain(String invalidEmail,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        String email="myemail@com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressWithMissingTopLevelDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressWithTopLevelDomainWithTrailingDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain.";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithDoubleDotInDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain..com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithInvalidTopLevelDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain.c";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithInvalidCharacterHasTag(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain#com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithSemicolonInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain.com;";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingUserName(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="@domain.com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingDomainName(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@.com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithConsecutiveDotsInDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain..com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingDotBetweenDomainAndTopLevelDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domaincom";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }
    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMultipleConsecutiveDots(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain..com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithUnderScoreInDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain_com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingDotBeforeTopLevelDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domaincom";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithExclamationMarkInDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain!.com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithHyphenAtTheBeginningOfDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@-domain.com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithHyphenAtTheEndOfDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain-.com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithTrailingDotAfterTopLevelDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain.com.";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithMissingTopLevelDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain.c";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithCommaInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain,com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithSlashInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain/com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithBackSlashInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain\\com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithHashSymbolInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain#com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithOpeningParenthesisInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain(com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithClosingParenthesisInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain)com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithApostropheInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain'com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateLoginPageEmailTextFieldInvalidEmailAddressValidationWithQuotationMarkInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain\"com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");

        //Validation message
        basePage.waitForElementToBeVisible(emailTextFieldInvalidValidation);
        String invalidEmailValidation=basePage.doGetElementText(emailTextFieldInvalidValidation);
        if (invalidEmailValidation.equals(invalidEmail)) {
            isTrue=true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Please enter valid email validation isn't matched.");
        }
        return isTrue;
    }

    public boolean validateInvalidCredentialErrorPopUpMsg(String invalidCredentials,ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the email text field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,"nav@mailinator.com");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the email text field.");

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,"Test");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the password text field.");

        //Click on the eye button
        basePage.waitForElementToBeVisible(eyeBtn);
        basePage.click(eyeBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the eye button.");

        //Click on the continue button
        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the continue button.");

        //Invalid credentials error pop-up message
        basePage.waitForElementToBeVisible(invalidCredentialsErrorPopUpMsg);
        String invalidCredentialsValidation=basePage.doGetElementText(invalidCredentialsErrorPopUpMsg);
        if(invalidCredentialsValidation.equals(invalidCredentials)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Invalid credentials. You are left with 4 more attempts pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Invalid credentials. You are left with 4 more attempts pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateOtpRequiredValidationMsg(String OTP,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        //Click on the eye button
        basePage.waitForElementToBeVisible(eyeBtn);
        basePage.click(eyeBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the eye button.");

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,"@123");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the password text field.");

        //Click on the continue button
        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the continue button.");

        //Click on the continue button
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the continue button.");

        //OTP required validation message
        basePage.waitForElementToBeVisible(otpRequiredValidation);
        String otpValidation=basePage.doGetElementText(otpRequiredValidation);
        if(otpValidation.equals(OTP)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified OTP is required validation message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified OTP is required validation message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateGetCodeErrorPopUpMsg(String getOTPCode,ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Enter the value in the enter code text field
        basePage.waitForElementToBeVisible(enterCodeTextField);
        basePage.enterText(enterCodeTextField,"11111");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the enter code text field.");

        //Click on the continue button
        basePage.waitForElementToBeVisible(continueBtn);
        basePage.click(continueButton);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the continue button.");


        //Get verification error pop-up message
        basePage.waitForElementToBeVisible(getVerificationCodeErrorPopUpMsg);
        String getOTPCodeMessage=basePage.doGetElementText(getVerificationCodeErrorPopUpMsg);
        if(getOTPCodeMessage.equals(getOTPCode)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please get a verification code first. pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please get a verification code first. pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateMaxOtpLimitValidation(String otpLimit,ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Enter the value in the enter code text field
        basePage.waitForElementToBeVisible(enterCodeTextField);
        basePage.enterText(enterCodeTextField,"12");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the enter code text field.");

        //Max otp limit validation message
        basePage.waitForElementToBeVisible(maxOTPdDigitLimitValidation);
        String otpLimitValidation=basePage.doGetElementText(maxOTPdDigitLimitValidation);
        if(otpLimitValidation.equals(otpLimit)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Max OTP limit should be 5 digits. validation message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Max OTP limit should be 5 digits. validation message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateInvalidOtpErrorPopUpMsg(String invalidOTP,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;


        //Enter the value in the enter code text field
        basePage.threadSleep();
        basePage.enterText(enterCodeTextField,"34");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the enter code text field.");

        //Clear the value from the enter code text field
        basePage.waitForElementToBeVisible(enterCodeTextField);
        basePage.doClear(enterCodeTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the enter code text field.");

        //Click on the get code button
        basePage.waitForElementToBeVisible(getCodeBtn);
        basePage.click(getCodeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the get code button.");

        //Enter the value in the enter code text field
        basePage.enterText(enterCodeTextField,"11111");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the enter code text field.");

        //Click on the continue button
        basePage.threadSleep();
        basePage.click(continueButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the continue button.");

        //Invalid otp error pop-up message
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(invalidOTPErrorPopUpMsg);
        String invalidOTPMessage=basePage.doGetElementText(invalidOTPErrorPopUpMsg);
        if (invalidOTPMessage.equals(invalidOTP)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Invalid OTP pop-up message is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Invalid OTP pop-up message isn't matched");
        }

        return isTrue;
    }
}
