package com.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public static String getAttribute(WebElement wb, String value){
        return wb.getAttribute("value");
    }
    public static String getAttribute(WebElement wb){
        return wb.getAttribute("value");
    }

    public void myWindowWait(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
    }

    public void waitForElementToBeVisible(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToBeInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement wb) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(wb));
    }

    public void switchToWindow(){
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }
    public void scrollInSheet(WebElement wb){
        WheelInput.ScrollOrigin scrollOrigin= WheelInput.ScrollOrigin.fromElement(wb);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin,0,200)
                .perform();
    }
    public void clearValue(WebElement wb){
        Actions action=new Actions(driver);
        for(int i=0;i<60;i++) {
            action.sendKeys(Keys.BACK_SPACE).build().perform();
        }
    }
    public void removeValue(WebElement wb){
        Actions action=new Actions(driver);
        for(int i=0;i<10;i++) {
            action.sendKeys(Keys.BACK_SPACE).build().perform();
        }
    }
    public void remove(WebElement wb){
        Actions action=new Actions(driver);
        for(int i=0;i<5;i++) {
            action.sendKeys(Keys.BACK_SPACE).build().perform();
        }
    }

    public void selectByIndex(WebElement wb,int index){
        Select sel=new Select(wb);
        sel.selectByIndex(index);
    }
    public void selectByValue(WebElement wb,String value){
        Select sel=new Select(wb);
        sel.selectByValue(value);
    }
    public void hoverToTheSubject(WebElement wb) {
        Actions act = new Actions(driver);
        act.moveToElement(wb).build().perform();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void enterText(WebElement wb, String value) {
        wb.sendKeys(value);
    }
    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).clear();
        driver.findElement(elementLocation).sendKeys(text);
    }

    public void click(WebElement wb) {
        wb.click();
    }
    public void click(By elementLocation){
        driver.findElement(elementLocation).click();
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void threadSleep() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void scrollDown() {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+4200+")");
    }

    public void scrollSheet() {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400);");
    }

    public static String getScreenCapture(WebDriver driver) throws IOException, IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("D:/AutomationReports/Images/" + System.currentTimeMillis() + ".png");
        String filePath = Dest.getAbsolutePath();
        FileUtils.copyFile(file,Dest);
        return filePath;
    }
    public String getTitle() {
        return driver.getTitle();
    }
    public String getText(WebElement wb) {
        return wb.getText();
    }
    public void switchToFrameId(String id) {
        driver.switchTo().frame(id);
    }
    public void switchToFrameWebElement(WebElement wb) {
        driver.switchTo().frame(wb);
    }
    public String getCurrentWindowId() {
        return driver.getWindowHandle();
    }
}
