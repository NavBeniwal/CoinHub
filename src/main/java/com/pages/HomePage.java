package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class HomePage {
    WebDriver driver;
    BasePage basePage;

    public HomePage(WebDriver driver){
        this.driver=driver;
        basePage=new BasePage(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[@class='logo-white']")
    private WebElement logo;
    @FindBy(xpath = "//a[text()='Why COINHUB']")
    private WebElement whyCoinHubBtn;
    @FindBy(xpath = "//a[text()='Our Token']")
    private WebElement ourTokenBtn;
    @FindBy(xpath = "(//a[text()='Ecosystem'])[1]")
    private WebElement ecosystemBtn;
    @FindBy(xpath = "//a[text()='Market Updates']")
    private WebElement marketUpdatesBtn;
    @FindBy(xpath = "(//a[text()='Exchange'])[1]")
    private WebElement exchangeBtn;
    @FindBy(xpath = "//a[text()='Demo Trading']")
    private WebElement demoTradingBtn;
    @FindBy(xpath = "//button[@title='Log In']")
    private WebElement loginBtn;
    @FindBy(xpath = "//button[text()='Register']")
    private WebElement registerButton;
    @FindBy(xpath = "//div[@class='style_copyRight__inner_links__T10CL']")
    private WebElement socialMediaLinks;
    @FindBy(xpath = "(//p)[27]")
    private WebElement footerText;

    public boolean validateIsTitlePresent(String title, ExtentTest test){
        boolean isTrue=false;

        //Match the title
        if(basePage.getTitle().equals(title)) {
            isTrue=true;
            test.log(LogStatus.PASS,"Verified title matched with the home page title.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,"Verified title isn't match with the home page title.");
        }

        return isTrue;
    }

    public boolean validateIsHomePageHeaderLogoPresent(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Logo
        basePage.waitForElementToBeVisible(logo);
        if(logo.isDisplayed()) {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified logo present on the home page header.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified logo isn't present on the home page header.");
        }

        return isTrue;
    }

    public boolean validateIsHomeHeaderCoinHubButtonPresent(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Why coinhub button
        basePage.waitForElementToBeVisible(whyCoinHubBtn);
        if(whyCoinHubBtn.isDisplayed()){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified why coinhub button is present on the home page header.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified why coinhub button isn't present on the home page header.");
        }

        return isTrue;
    }

    public boolean validateIsHomePageHeaderOutTokenButtonPresent(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Our token button
        basePage.waitForElementToBeVisible(ourTokenBtn);
        if(ourTokenBtn.isDisplayed()){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified our token button is present on the home page header.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified our token button isn't present on the home page header.");
        }

        return isTrue;
    }

    public boolean validateIsHomePageHeaderEcosystemButtonPresent(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Ecosystem button
        basePage.waitForElementToBeVisible(ecosystemBtn);
        if(ecosystemBtn.isDisplayed()){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified ecosystem button is present on the home page header.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified ecosystem button isn't present on the home page header.");
        }

        return isTrue;
    }

    public boolean validateIsHomePageHeaderMarketUpdatesButtonPresent(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Market updates button
        basePage.waitForElementToBeVisible(marketUpdatesBtn);
        if(marketUpdatesBtn.isDisplayed()){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified market updates button is present on the home page header.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified market updates button isn't present on the home page header.");
        }

        return isTrue;
    }

    public boolean validateIsHomePageHeaderExchangeButtonPresent(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Exchange button
        basePage.waitForElementToBeVisible(exchangeBtn);
        if(exchangeBtn.isDisplayed())
        {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified exchange button is present present on the header.");
        }else
        {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified exchange button isn't present present on the header.");
        }

        return isTrue;
    }

//    public boolean validateIsHomePageHeaderDemoTradingButtonPresent(ExtentTest test) throws IOException {
//        boolean isTrue=false;
//
//        //Demo trading button
//        basePage.waitForElementToBeVisible(demoTradingBtn);
//        if(demoTradingBtn.isDisplayed()){
//            isTrue=true;
//            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified demo trading button is present on the home page header.");
//        }else {
//            isTrue=false;
//            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified demo trading button isn't present on the home page header.");
//        }
//        return isTrue;
//    }

    public boolean validateIsHomePageHeaderLoginButtonPresent(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Login button
        basePage.waitForElementToBeVisible(loginBtn);
        if(loginBtn.isDisplayed())
        {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified login button is present on the header.");
        }else
        {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified login button isn't present on the header.");
        }

        return isTrue;
    }

    public boolean validateIsHomePageHeaderRegisterButtonPresent(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Register button
        basePage.waitForElementToBeVisible(registerButton);
        if(registerButton.isDisplayed())
        {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified register button is present on the header.");
        }else
        {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified register button isn't present on the header.");
        }

        return isTrue;
    }

    public boolean validateIsSocialMediaLinksPresent(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Scroll the sheet
        basePage.scrollDown();

        //Social media links
        basePage.waitForElementToBeVisible(socialMediaLinks);
        if(socialMediaLinks.isDisplayed()) {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified social media links are present on the home page footer.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified social media links aren't present on the home page footer.");
        }

        return isTrue;
    }

    public boolean isFooterComponentsPresent(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Footer text
        if(footerText.isDisplayed())
        {
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified © 2023 Coinhub | All rights reserved. text is present on the home page footer.");
        }else
        {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified © 2023 Coinhub | All rights reserved. text isn't present on the home page footer.");
        }

        return isTrue;
    }
}
