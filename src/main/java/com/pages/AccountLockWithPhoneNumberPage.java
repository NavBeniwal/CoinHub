package com.pages;

import com.base.BasePage;
import com.qa.opencart.utils.ElementUtil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AccountLockWithPhoneNumberPage {
    WebDriver driver;
    BasePage basePage;
    public AccountLockWithPhoneNumberPage(WebDriver driver){
        this.driver=driver;
        basePage=new BasePage(driver);
    }
    private By image= By.xpath("//img[@alt='Language']");
    private By liEnglish=By.xpath("/html/body/div[1]/div/header/div/div/div/div[4]/div/div/div/ul/li[1]");
    private By loginBtn=By.xpath("//button[@title='Log In']");
    private By phoneNumberBtn=By.xpath("//div[@id='rc-tabs-0-tab-phone']");
    private By dropDownBtn=By.xpath("//div[@class='selected-flag']");
    private By searchBox=By.xpath("//input[@class='search-box']");
    private By countryName=By.xpath("//span[text()='India']");
    private By phoneNoTextField=By.xpath("//input[@class='form-control ant-input']");
    private By passwordTextField=By.xpath("//input[@type='password']");
    private By eyeBtn=By.xpath("//span[@class='ant-input-suffix']");
    private By continueButton=By.xpath("//span[text()='Continue']");
    private By invalidCredentialsErrorPopUpMsg=By.xpath("//div[@class='ant-message-notice-content']");
    private By accountLockPopUpMsg=By.xpath("//span[text()='Your account is locked due to multiple failed login attempts']");

    public boolean validateInvalidCredentialsMessage(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        String country = PropertyReaderOptimized.getKeyValue("lockAccountCountry");
        String loginPhoneNumber = PropertyReaderOptimized.getKeyValue("lockAccountPhoneNumber");
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
        basePage.enterText(searchBox,country);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the search box text field.");

        //Select country
        basePage.waitForElementToBeVisible(countryName);
        basePage.click(countryName);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the country name.");

        //Enter the value in the phone number text field
        basePage.waitForElementToBeVisible(phoneNoTextField);
        basePage.enterText(phoneNoTextField,loginPhoneNumber);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the phone number text field.");


        //Enter the value in the password text field
        basePage.waitForElementToBeVisible(passwordTextField);
        basePage.enterText(passwordTextField,password);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified entered the value in the Password text field.");

        //Click on the eye button
        basePage.waitForElementToBeVisible(eyeBtn);
        basePage.click(eyeBtn);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Eye button.");

        //Click on the login button
        for (int i = 0; i < 5; i++) {
            basePage.waitForElementToBeVisible(continueButton);
            basePage.click(continueButton);
            test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Continue button.");

            //Invalid credentials error pop-up message
            basePage.waitForElementToBeVisible(invalidCredentialsErrorPopUpMsg);
            if (basePage.checkElementIsDisplayed(invalidCredentialsErrorPopUpMsg)) {
                isTrue = true;
                test.log(LogStatus.PASS, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified invalid credentials error pop-up message is displayed.");
            } else {
                isTrue = false;
                test.log(LogStatus.FAIL, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified invalid credentials error pop-up message isn't displayed");
            }
        }

        return isTrue;
    }

    public boolean validateAccountLock(String accountLock,ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue = false;

        basePage.waitForElementToBeVisible(continueButton);
        basePage.click(continueButton);
        test.log(LogStatus.INFO, test.addScreenCapture(BasePage.getScreenCapture(driver)), "Verified clicked on the Continue button.");

        //Account lock pop-up message
        basePage.waitForElementToBeVisible(accountLockPopUpMsg);
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