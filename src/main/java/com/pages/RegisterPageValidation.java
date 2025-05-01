package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class RegisterPageValidation {
    WebDriver driver;
    BasePage basePage;

    public RegisterPageValidation(WebDriver driver){
        this.driver=driver;
        basePage=new BasePage(driver);
    }
    private By image= By.xpath("//img[@alt='Language']");
    private By liEnglish= By.xpath("/html/body/div[1]/div/header/div/div/div/div[4]/div/div/div/ul/li[1]");
    private By registerBtn= By.xpath("//button[text()='Register']");
    private By emailRequiredValidation= By.xpath("//span[text()='Email is required']");
    private By passwordRequiredValidation= By.xpath("//span[text()='Password is required']");
    private By checkBoxValidation= By.xpath("//span[text()='Please accept terms and conditions']");
    private By emailTextFieldInvalidValidation= By.xpath("//span[text()='Please enter valid email']");
    private By alreadyExistEmailAddressErrorPopUpMsg= By.xpath("alreadyExistEmailAddressErrorPopUpMsg");
    private By invalidPasswordValidation= By.xpath("//span[contains(text(),'Password must ')]");
    private By emailTextField= By.xpath("//input[@placeholder='Email']");
    private By passwordTextField= By.xpath("//input[@placeholder='Password']");
    private By eyeBtn= By.xpath("//span[@class='anticon anticon-eye-invisible ant-input-password-icon']");
    private By checkBoxBtn= By.xpath("//span[@class='ant-checkbox']");
    private By createAccountBtn= By.xpath("//span[text()='Create Account']");
    private By mailinatorLoginTextField= By.xpath("//input[@id='search']");
    private By goButton= By.xpath("//button[text()='GO']");
    private By emailVerification= By.xpath("//tr[td[@class='ng-binding']]/td[2]");
    private By iframe= By.xpath("//iframe[@id='html_msg_body']");
    private By confirmBtn= By.xpath("//a[text()='Confirm']");
    private By dropDownBtn= By.xpath("//div[@class='flag mn']");
    private By searchBox= By.xpath("//input[@class='search-box']");
    private By countryName= By.xpath("//span[text()='India']");
    private By phoneNoTextField= By.xpath("//input[@class='form-control ant-input']");
    private By sendCodeBtn= By.xpath("//span[text()='Код авах']");
    private By phoneNumberRequiredValidation= By.xpath("phoneNumberRequiredValidation");
    private By phoneNumberAlreadyExistErrorPopUpMsg= By.xpath("phoneNumberAlreadyExistErrorPopUpMsg");
    private By enterValidPhoneNumberValidation= By.xpath("//span[text()='Please enter valid phone number']");
    private By invalidNumberErrorPopUpMsg=By.xpath("//span[@class='anticon anticon-close-circle']");
    private By otpRequiredValidation= By.xpath("otpRequiredValidation");
    private By invalidOtpErrorPopUPMsg=By.xpath("invalidOtpErrorPopUPMsg");
    private By enterCodeTextField= By.xpath("//input[@placeholder='Enter Code']");
    private By submitBtn= By.xpath("//span[text()='Submit']");

    public boolean validateRegisterPageEmailRequiredValidation(String email,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        basePage.waitForElementToBeVisible(image);
        basePage.click(image);

        //Click on the language
        basePage.waitForElementToBeVisible(liEnglish);
        basePage.click(liEnglish);

        //Click on the register button
        basePage.threadSleep();
        basePage.click(registerBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the register button.");

        //Click on the signup button
        basePage.waitForElementToBeVisible(createAccountBtn);
        basePage.click(createAccountBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the create account button.");

        //Required validation
        basePage.waitForElementToBeVisible(emailRequiredValidation);
        String emailValidation=basePage.doGetElementText(emailRequiredValidation);

        //Compare the values
        basePage.waitForElementToBeVisible(emailRequiredValidation);
        if (emailValidation.equals(email)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Email is required validation is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Email is required validation isn't matched.");
        }
        return isTrue;
    }
    public boolean validateRegisterPagePasswordRequiredValidation(String password,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        //Required validation
        String passwordValidation=basePage.doGetElementText(passwordRequiredValidation);
        if (passwordValidation.equals(password)) {
            isTrue = true;
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password is required validation is matched.");
        } else {
            isTrue = false;
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password is required validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateRegisterPageTermsAndConditionsRequiredValidation(String termsAndConditions,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        //Required validation
        String termsAndConditionsValidation=basePage.doGetElementText(checkBoxValidation);
        if(termsAndConditionsValidation.equals(termsAndConditions)) {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please accept terms and conditions validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please accept terms and conditions validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateEmailTextFieldValidationWithAlreadyExistEmailAddress(String emailAlreadyTaken,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="nav@mailinator.com";
        String password= "Test@123";

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,email);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");
        //Enter the value in the password text field

        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the Password text field.");

        //Click on the eye button
        basePage.waitForElementToBeVisible(eyeBtn);
        basePage.click(eyeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the eye button.");

        //Check box button
        basePage.waitForElementToBeVisible(checkBoxBtn);
        basePage.click(checkBoxBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the check box.");

        //Click on the signup button
        basePage.waitForElementToBeVisible(createAccountBtn);
        basePage.click(createAccountBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the create account button.");

        //Error pop-up message
        basePage.waitForElementToBeVisible(alreadyExistEmailAddressErrorPopUpMsg);
        String errorMessage=basePage.doGetElementText(alreadyExistEmailAddressErrorPopUpMsg);
        if(errorMessage.equals(emailAlreadyTaken)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Email is already taken pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Email is already taken pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithMissingSymbol(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail.com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressWithMissingDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressWithMissingTopLevelDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressWithTopLevelDomainWithTrailingDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain.";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithDoubleDotInDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain..com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithInvalidTopLevelDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain.c";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithInvalidCharacterHasTag(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain#com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithSemicolonInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain.com;";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithMissingUserName(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="@domain.com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithMissingDomainName(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@.com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithConsecutiveDotsInDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain..com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithMissingDotBetweenDomainAndTopLevelDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domaincom";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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
    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithMultipleConsecutiveDots(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain..com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithUnderScoreInDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain_com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithMissingDotBeforeTopLevelDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domaincom";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithExclamationMarkInDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain!.com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithHyphenAtTheBeginningOfDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@-domain.com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithHyphenAtTheEndOfDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain-.com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithTrailingDotAfterTopLevelDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain.com.";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithMissingTopLevelDomain(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain.c";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithCommaInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain,com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithSlashInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain/com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithBackSlashInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain\\com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithHashSymbolInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain#com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithOpeningParenthesisInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain(com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithClosingParenthesisInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain)com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithApostropheInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain'com";

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

    public boolean validateRegisterPageEmailTextFieldInvalidEmailAddressValidationWithQuotationMarkInsteadOfDot(String invalidEmail,ExtentTest test) throws IOException {
        boolean isTrue=false;

        String email="myemail@domain\"com";
        String registerEmail=PropertyReaderOptimized.getKeyValue("registerPageValidationEmail");

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

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

        //Clear the value from the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.doClear(emailTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Email Text Field.");

        //Enter the value in the email text field
        basePage.waitForElementToBeVisible(emailTextField);
        basePage.enterText(emailTextField,registerEmail);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the Email Text Field.");


        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldValidationWithMissingAlphabet(String passwordContains,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String password="!@1234";

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,"1");

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Keep the less than 8 characters in the password text field.");

        //Validation message
        basePage.waitForElementToBeVisible(invalidPasswordValidation);
        String invalidPassword=basePage.doGetElementText(invalidPasswordValidation);
        if (invalidPassword.equals(passwordContains)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation isn't matched.");
            isTrue = false;
        }

        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithLessThanEightCharacters(String passwordContains,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String password="Pass@12";

        //Clear the value from the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.doClear(passwordTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Password Text Field.");

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Keep only Numeric value in the password text field.");

        //Validation message
        basePage.waitForElementToBeVisible(invalidPasswordValidation);
        String invalidPassword=basePage.doGetElementText(invalidPasswordValidation);
        if (invalidPassword.equals(passwordContains)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation isn't matched.");
            isTrue = false;
        }

        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithMissingNumber(String passwordContains,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String password="Password@";

        //Clear the value from the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.doClear(passwordTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Password Text Field.");

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Keep only Special Character value in the password text field.");

        //Validation message
        basePage.waitForElementToBeVisible(invalidPasswordValidation);
        String invalidPassword=basePage.doGetElementText(invalidPasswordValidation);
        if(invalidPassword.equals(passwordContains)) {
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation is matched.");
            isTrue=true;
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation isn't matched.");
            isTrue=false;
        }

        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithMissingUpperCaseLetter(String passwordContains,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String password="password@123";

        //Clear the value from the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.doClear(passwordTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Password Text Field.");

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,password);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Keep only Alphabetic value in the password text field.");

        //Validation message
        basePage.waitForElementToBeVisible(invalidPasswordValidation);
        String invalidPassword=basePage.doGetElementText(invalidPasswordValidation);
        if(invalidPassword.equals(passwordContains)) {
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation is matched.");
            isTrue=true;
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation isn't matched.");
            isTrue=false;
        }

        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithMissingLowercaseLetter(String passwordContains,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String password="PASSWORD@123";

        //Clear the value from the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.doClear(passwordTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Password Text Field.");

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,password);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Keep Numeric and Alphabetic value in the password text field.");

        //Validation message
        basePage.waitForElementToBeVisible(invalidPasswordValidation);
        String invalidPassword=basePage.doGetElementText(invalidPasswordValidation);
        if(invalidPassword.equals(passwordContains)) {
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation is matched.");
            isTrue=true;
        }else {
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation isn't matched.");
            isTrue=false;
        }

        return isTrue;
    }

    public boolean validateRegisterPagePasswordTextFieldWithMissingSpecialCharacter(String passwordContains,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String mailinatorEmail=PropertyReaderOptimized.getKeyValue("registerPageValidationMailinatorEmail");
        String password="Password123";
        String correctPassword="Test@123";

        //Clear the value from the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.doClear(passwordTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Password Text Field.");

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Keep Special Character and Numeric value in the password text field.");

        //Validation message
        basePage.waitForElementToBeVisible(invalidPasswordValidation);
        String invalidPassword=basePage.doGetElementText(invalidPasswordValidation);
        if (invalidPassword.equals(passwordContains)) {
            test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation is matched.");
            isTrue = true;
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified Password must be a minimum of 8 characters including number, upper, lower and one special character validation isn't matched.");
            isTrue = false;
        }

        //Clear the value from the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.doClear(passwordTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Password Text Field.");

        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,correctPassword);

        //Click on the create account button
        basePage.waitForElementToBeVisible(createAccountBtn);
        basePage.click(createAccountBtn);

        //Switch to the new window
        basePage.threadSleep();
        driver.switchTo().newWindow(WindowType.WINDOW).navigate().to(PropertyReaderOptimized.getKeyValue("mailinatorUrl"));

        //Enter the value in the mailinator login text field
        basePage.waitForElementToBeVisible(mailinatorLoginTextField);
        basePage.enterText(mailinatorLoginTextField, mailinatorEmail);

        //Click on the go button
        basePage.waitForElementToBeVisible(goButton);
        basePage.click(goButton);

        //Click on the email verification link
        basePage.threadSleep();
        basePage.waitForElementToBeVisible(emailVerification);
        basePage.click(emailVerification);

        //Switch to the frame
        basePage.waitForElementToBeVisible(iframe);
        basePage.switchToFrameWebElement((WebElement) iframe);

        //Click on the confirm button
        basePage.waitForElementToBeVisible(confirmBtn);
        basePage.click(confirmBtn);

        //Switch the window
        Thread.sleep(2000);
        basePage.switchToWindow();

        return isTrue;
    }

    public boolean validateRegisterPagePhoneNumberRequiredValidation(String phoneNumber,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        //Click on the send code button
        basePage.waitForElementToBeVisible(sendCodeBtn);
        basePage.click(sendCodeBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the send code button.");

        //Validation message
        basePage.waitForElementToBeVisible(phoneNumberRequiredValidation);
        String phoneNumberValidation=basePage.doGetElementText(phoneNumberRequiredValidation);
        if(phoneNumberValidation.equals(phoneNumber)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Phone number is required validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Phone number is required validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateRegisterPageExistPhoneNumberErrorMsg(String phoneNumberAlreadyExists,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String country=PropertyReaderOptimized.getKeyValue("registerValidationCountry");
        String existPhoneNumber=PropertyReaderOptimized.getKeyValue("registerExistPhoneNumber");

        //Click on the drop-down button
        basePage.waitForElementToBeVisible(dropDownBtn);
        basePage.click(dropDownBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the drop-down button.");

        //Search box
        basePage.waitForElementToBeVisible(searchBox);
        basePage.enterText(searchBox,country);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the search box text field.");

        //Select country
        basePage.waitForElementToBeVisible(countryName);
        basePage.click(countryName);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the country name.");

        //Enter the value in the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.enterText(phoneNoTextField,existPhoneNumber);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the phone number text field.");

        //Click on the send code button
        basePage.waitForElementToBeVisible(sendCodeBtn);
        basePage.click(sendCodeBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the send code button.");

        //Error pop-up message
        basePage.waitForElementToBeVisible(phoneNumberAlreadyExistErrorPopUpMsg);
        String phoneNumberAlreadyExistsMessage=basePage.doGetElementText(phoneNumberAlreadyExistErrorPopUpMsg);
        if(phoneNumberAlreadyExistsMessage.equals(phoneNumberAlreadyExists)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Phone number already exists pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Phone number already exists pop-up message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateRegisterPageInvalidPhoneNumberValidation(String phoneNumberValidation,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String invalidPhoneNumber=PropertyReaderOptimized.getKeyValue("registerInvalidPhoneNumber");

        //Clear the value from the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.doClearValue(phoneNoTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Phone Number Text Field.");

        //Enter the value in the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.enterText(phoneNoTextField,invalidPhoneNumber);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the phone number text field.");

        //Validation message
        basePage.waitForElementToBeVisible(enterValidPhoneNumberValidation);
        String phoneNumber=basePage.doGetElementText(enterValidPhoneNumberValidation);
        if(phoneNumber.equals(phoneNumberValidation)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please enter valid phone number validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified Please enter valid phone number validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateRegisterPageInvalidPhoneNumberErrorPopUpMsg(String invalidNumber,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        //Enter the value in the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.enterText(phoneNoTextField,"11111");
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the phone number text field.");

        //Click on the send code button
        basePage.waitForElementToBeVisible(sendCodeBtn);
        basePage.click(sendCodeBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the send code button.");

        //Error pop up message
        basePage.waitForElementToBeVisible(invalidNumberErrorPopUpMsg);
        String phoneNumber=basePage.doGetElementText(invalidNumberErrorPopUpMsg);
        if(phoneNumber.equals(invalidNumber)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified invalid phone number error popup message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified invalid phone number error popup message isn't matched.");
        }

        return isTrue;
    }

    public boolean validateRegisterPageOtpRequiredValidation(String OTP,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String phoneNumber=PropertyReaderOptimized.getKeyValue("registerValidationPhoneNumber");

        //Clear the value from the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.doClear(phoneNoTextField);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified cleared the value from the Phone Number Text Field.");

        //Enter the value in the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.enterText(phoneNoTextField,phoneNumber);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the phone number text field.");

        //Click on the send code button
        basePage.waitForElementToBeVisible(sendCodeBtn);
        basePage.click(sendCodeBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the send code button.");

        //Click on the submit button
        basePage.waitForElementToBeVisible(submitBtn);
        basePage.click(submitBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the submit button.");

        //Validation message
        basePage.waitForElementToBeVisible(otpRequiredValidation);
        String otpValidation=basePage.doGetElementText(otpRequiredValidation);
        if(otpValidation.equals(OTP)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified OTP is required validation is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified OTP is required validation isn't matched.");
        }

        return isTrue;
    }

    public boolean validateRegisterPageInvalidOtpValidation(String invalidOTP,ExtentTest test) throws InterruptedException, IOException {
        boolean isTrue = false;

        String invalidOtp=PropertyReaderOptimized.getKeyValue("registerInvalidOtp");

        //Enter the value in the enter code text field
        basePage.waitForElementToBeVisible(enterCodeTextField);
        basePage.enterText(enterCodeTextField,invalidOtp);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the enter code text field.");

        //Click on the submit button
        basePage.waitForElementToBeVisible(submitBtn);
        basePage.click(submitBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the submit button.");

        //Error pop-up message
        basePage.waitForElementToBeVisible(invalidOtpErrorPopUPMsg);
        String invalidOTPMessage=basePage.doGetElementText(invalidOtpErrorPopUPMsg);
        if(invalidOTPMessage.equals(invalidOTP)){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified OTP Code is Invalid pop-up message is matched.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified OTP Code is Invalid pop-up message isn't matched.");
        }

        return isTrue;
    }
}
