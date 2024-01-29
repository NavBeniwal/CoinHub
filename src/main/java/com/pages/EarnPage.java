package com.pages;

import com.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class EarnPage {
    WebDriver driver;
    BasePage basePage;
    double amount;

    public EarnPage(WebDriver driver){
        this.driver=driver;
        basePage=new BasePage(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='Earn']")
    private WebElement earnBtn;
    @FindBy(xpath = "//h4[text()='USDT']")
    private WebElement usdtCurrency;
    @FindBy(xpath = "(//span[text()='Stake'])[1]")
    private WebElement usdtStakeBtn;
    @FindBy(xpath = "//input[@placeholder='Amount']")
    private WebElement amountTextField;
    @FindBy(xpath = "//span[text()='30D']")
    private WebElement thirtyDays;
    @FindBy(xpath = "//span[text()='90D']")
    private WebElement ninetyDays;
    @FindBy(xpath = "//span[text()='120D']")
    private WebElement oneTwentyDays;
    @FindBy(xpath = "//span[text()='180D']")
    private WebElement oneEightyDays;
    @FindBy(xpath = "//span[text()='270D']")
    private WebElement twoSeventyDays;
    @FindBy(xpath = "//span[text()='365D']")
    private WebElement threeSixtyFiveDays;
    @FindBy(xpath = "(//span)[42]")
    private WebElement earnPercentage;
    @FindBy(xpath = "//p[text()='0.2']")
    private WebElement minLimit;
    @FindBy(xpath = "//span[text()='0']")
    private WebElement youWillEarn;
    @FindBy(xpath = "//span[@class='anticon anticon-close-circle']")
    private WebElement minStakeAmountErrorPopUpMsg;

    public boolean validateAfterClickingOnTheStakeButtonUserShouldBeOnUSDTStakingPage(ExtentTest test) throws IOException {
        boolean isTrue=false;

        //Click on the earn
        basePage.waitForElementToBeVisible(earnBtn);
        basePage.click(earnBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the earn.");

        //Click on the stake button
        basePage.waitForElementToBeVisible(usdtStakeBtn);
        basePage.click(usdtStakeBtn);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified click on the stake button.");

        //Compare the values
        basePage.waitForElementToBeVisible(usdtCurrency);
        if(usdtCurrency.isDisplayed()){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified user is on the USDT staking page.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified user isn't on the USDT staking page.");
        }

        return isTrue;
    }

    public boolean validateYouWillEarnAmountInThirtyDays(ExtentTest test) throws IOException {
        boolean isTrue=false;

        String enterUSDTAmount="1";

        //Enter the value in the amount text field
        basePage.waitForElementToBeVisible(amountTextField);
        basePage.enterText(amountTextField,enterUSDTAmount);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified entered the value in the amount text field.");

        //Convert string value into double
        basePage.waitForElementToBeVisible(amountTextField);
        String amountOfUSDT=basePage.getAttribute(amountTextField);
        double amountIs=Double.parseDouble(amountOfUSDT.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"The value of the USDT entered by the user is:  " +amountIs);
        System.out.println("Amount is: "+amountIs);

        //Convert string value into double
        basePage.waitForElementToBeVisible(earnPercentage);
        String earn=basePage.getText(earnPercentage);
        String earnPercentage=earn.replaceAll("[^\\d.]", "");
        double earnPercentageIs=Double.parseDouble(earnPercentage);
        System.out.println("earn percentage is: "+earnPercentageIs);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Earn percentage is: "+earnPercentageIs);

        //You will earn should be
        double youWillEarnValueShouldBe=amountIs*(earnPercentageIs)/100;
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Earn value should be: "+youWillEarnValueShouldBe);
        System.out.println("you will earn should be: "+youWillEarnValueShouldBe);


        //Convert string value into double
        String youWillEarnValue=youWillEarn.getText();
        System.out.println("You will earn: "+youWillEarnValue);
        double youWillEarnValueIs=Double.parseDouble(youWillEarnValue.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Earn value is: "+youWillEarnValueIs);
        System.out.println("You will earn is: "+youWillEarnValueIs);


        //Compare the values
        if(youWillEarnValueIs==youWillEarnValueShouldBe){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values aren't equal.");
        }

        amount=amountIs;
        return isTrue;
    }

    public boolean validateYouWillEarnAmountInNinetyDays(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        double amountOfUSDTIs=amount;

        //Click on the ninety days
        basePage.threadSleep();
        basePage.click(ninetyDays);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the ninety days tab.");

        //Convert string value into double
        basePage.waitForElementToBeVisible(earnPercentage);
        String earn=basePage.getText(earnPercentage);
        String earnPercentage=earn.replaceAll("[^\\d.]", "");
        double earnPercentageIs=Double.parseDouble(earnPercentage);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Earn percentage is: "+earnPercentageIs);

        //You will earn should be
        double youWillEarnValueShouldBe=amountOfUSDTIs*(earnPercentageIs)/100;

        //Convert string value into double
        String youWillEarnValue=youWillEarn.getText();
        double youWillEarnValueIs=Double.parseDouble(youWillEarnValue.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Earn value is: "+youWillEarnValueIs);

        //Compare the values
        if(youWillEarnValueIs==youWillEarnValueShouldBe){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateYouWillEarnAmountInOneTwentyDays(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        double amountOfUSDTIs=amount;

        //Click on the ninety days
        basePage.threadSleep();
        basePage.click(oneTwentyDays);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the one twenty days tab.");

        //Convert string value into double
        basePage.waitForElementToBeVisible(earnPercentage);
        String earn=basePage.getText(earnPercentage);
        String earnPercentage=earn.replaceAll("[^\\d.]", "");
        double earnPercentageIs=Double.parseDouble(earnPercentage);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Earn percentage is: "+earnPercentageIs);

        //You will earn should be
        double youWillEarnValueShouldBe=amountOfUSDTIs*(earnPercentageIs)/100;

        //Convert string value into double
        String youWillEarnValue=youWillEarn.getText();
        double youWillEarnValueIs=Double.parseDouble(youWillEarnValue.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Earn value is: "+youWillEarnValueIs);

        //Compare the values
        if(youWillEarnValueIs==youWillEarnValueShouldBe){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateYouWillEarnAmountInOneEightyDays(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        double amountOfUSDTIs=amount;

        //Click on the ninety days
        basePage.threadSleep();
        basePage.click(oneEightyDays);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the one eighty days tab.");

        //Convert string value into double
        basePage.waitForElementToBeVisible(earnPercentage);
        String earn=basePage.getText(earnPercentage);
        String earnPercentage=earn.replaceAll("[^\\d.]", "");
        double earnPercentageIs=Double.parseDouble(earnPercentage);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Earn percentage is: "+earnPercentageIs);

        //You will earn should be
        double youWillEarnValueShouldBe=amountOfUSDTIs*(earnPercentageIs)/100;

        //Convert string value into double
        String youWillEarnValue=youWillEarn.getText();
        double youWillEarnValueIs=Double.parseDouble(youWillEarnValue.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Earn value is: "+youWillEarnValueIs);

        //Compare the values
        if(youWillEarnValueIs==youWillEarnValueShouldBe){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateYouWillEarnAmountInTwoSeventyDays(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        double amountOfUSDTIs=amount;

        //Click on the ninety days
        basePage.threadSleep();
        basePage.click(twoSeventyDays);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the two seventy days tab.");

        //Convert string value into double
        basePage.waitForElementToBeVisible(earnPercentage);
        String earn=basePage.getText(earnPercentage);
        String earnPercentage=earn.replaceAll("[^\\d.]", "");
        double earnPercentageIs=Double.parseDouble(earnPercentage);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Earn percentage is: "+earnPercentageIs);

        //You will earn should be
        double youWillEarnValueShouldBe=amountOfUSDTIs*(earnPercentageIs)/100;

        //Convert string value into double
        String youWillEarnValue=youWillEarn.getText();
        double youWillEarnValueIs=Double.parseDouble(youWillEarnValue.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Earn value is: "+youWillEarnValueIs);

        //Compare the values
        if(youWillEarnValueIs==youWillEarnValueShouldBe){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values aren't equal.");
        }

        return isTrue;
    }

    public boolean validateYouWillEarnAmountInThreeSixtyFiveDays(ExtentTest test) throws IOException, InterruptedException {
        boolean isTrue=false;

        double amountOfUSDTIs=amount;

        //Click on the ninety days
        basePage.threadSleep();
        basePage.click(oneEightyDays);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Verified clicked on the three sixty five days tab.");

        //Convert string value into double
        basePage.waitForElementToBeVisible(earnPercentage);
        String earn=basePage.getText(earnPercentage);
        String earnPercentage=earn.replaceAll("[^\\d.]", "");
        double earnPercentageIs=Double.parseDouble(earnPercentage);
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Earn percentage is: "+earnPercentageIs);

        //You will earn should be
        double youWillEarnValueShouldBe=amountOfUSDTIs*(earnPercentageIs)/100;

        //Convert string value into double
        String youWillEarnValue=youWillEarn.getText();
        double youWillEarnValueIs=Double.parseDouble(youWillEarnValue.replace(",",""));
        test.log(LogStatus.INFO,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Earn value is: "+youWillEarnValueIs);

        //Compare the values
        if(youWillEarnValueIs==youWillEarnValueShouldBe){
            isTrue=true;
            test.log(LogStatus.PASS,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values are equal.");
        }else {
            isTrue=false;
            test.log(LogStatus.FAIL,test.addScreenCapture(BasePage.getScreenCapture(driver)),"Both the values aren't equal.");
        }

        return isTrue;
    }

}
