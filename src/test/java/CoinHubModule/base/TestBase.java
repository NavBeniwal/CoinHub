package CoinHubModule.base;

import com.base.BasePage;
import com.driver.DriverManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class TestBase {
    public WebDriver driver;
    public ExtentReports reports;
    public ExtentTest test;
    DriverManager driverManager;
    BasePage basePage;
    public TestBase(){
        driverManager=new DriverManager();
        driver=driverManager.initializeChromeBrowser();
        basePage=new BasePage(driver);
        reports= Reports.getReportObject();
    }

    @BeforeClass
    public void beforeClassConfig() throws IOException {
        driver.manage().window().maximize();
        basePage.navigateTo(PropertyReaderOptimized.getKeyValue("url"));
    }
    @AfterClass
    public void afterClassConfig() throws InterruptedException {
        Thread.sleep(2000);
        reports.endTest(test);
        reports.flush();
        driver.quit();
    }
}
