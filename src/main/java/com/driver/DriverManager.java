package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    static WebDriver driver;

    public DriverManager(){
        this.driver=driver;
    }

    public WebDriver initializeChromeBrowser() {
        if(driver==null) {
            System.setProperty("WebDriver.chrome.driver", "C:\\Users\\user.LAPTOP-0UHFE9FH\\Downloads\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }

        return driver;
    }

    public WebDriver initializerFireFoxBrowser() {
        WebDriver driver=new FirefoxDriver();
        return driver;
    }
}
